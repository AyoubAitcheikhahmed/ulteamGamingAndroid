package com.banibegood.ulteam_gaming.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.UserProfile
import com.banibegood.ulteam_gaming.R
import com.auth0.android.result.Credentials
import com.banibegood.ulteam_gaming.databinding.FragmentDashboardBinding
import com.banibegood.ulteam_gaming.databinding.FragmentLoginBinding
import com.banibegood.ulteam_gaming.login.CredentialsManager
import com.banibegood.ulteam_gaming.ui.dashboard.DashboardViewModel
import timber.log.Timber
import com.auth0.android.callback.Callback


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private lateinit var account : Auth0
    private lateinit var loggedInText: TextView
    private var loggedIn = false

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        account = Auth0(
            getString(R.string.auth_client_id),
            getString(R.string.auth_domain)
        )

        val button = _binding!!.loginButton
        button.setOnClickListener {
            loginWithBrowser()
        }

        loggedInText = _binding!!.loggedInTextview

        checkIfToken()
        setLoggedInText()

        //End on createView
        val root: View = binding.root
        return root
    }


    private fun checkIfToken(){
        val token = CredentialsManager.getAccessToken(requireContext())
        if(token != null){
            //checking if the token works...
            showUserProfile(token)
        }
        else {
            Toast.makeText(context, "Token doesn't exist", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setLoggedInText() {
        if(loggedIn) {loggedInText.text = "you're logged in"}
        else {loggedInText.text = "not logged in"}
    }


    private fun loginWithBrowser() {
        // Setup the WebAuthProvider, using the custom scheme and scope.
        WebAuthProvider.login(account)
            .withScheme("demo")
            .withScope("openid profile email")
            // Launch the authentication passing the callback where the results will be received
            .start(requireContext(), object : Callback<Credentials, AuthenticationException> {
                // Called when there is an authentication failure
                override fun onFailure(exception: AuthenticationException) {
                    loggedIn = false
                }

                // Called when authentication completed successfully
                override fun onSuccess(credentials: Credentials) {
                    // Get the access token from the credentials object.
                    // This can be used to call APIs
                    val accessToken = credentials.accessToken
                    Toast.makeText(context, accessToken, Toast.LENGTH_SHORT).show()

                    CredentialsManager.saveCredentials(requireContext(), credentials)
                    checkIfToken()
                    setLoggedInText()
                }
            })
    }

    private fun logout() {
//        WebAuthProvider.logout(account)
//            .withScheme("demo")
//            .start(requireContext(), object: Callback<Void?, AuthenticationException> {
//                override fun onSuccess(payload: Void?) {
//                    Toast.makeText(context, "logout OK", Toast.LENGTH_SHORT).show()
//                    loggedIn = false
//                    setLoggedInText()
//                }
//
//                override fun onFailure(error: AuthenticationException) {
//                    Toast.makeText(context, "logout NOK", Toast.LENGTH_SHORT).show()
//                }
//            })
    }

    private fun showUserProfile(accessToken: String){
        var client = AuthenticationAPIClient(account)

        // With the access token, call `userInfo` and get the profile from Auth0.
        client.userInfo(accessToken)
            .start(object : Callback<UserProfile, AuthenticationException> {
                override fun onFailure(exception: AuthenticationException) {
                    Timber.i(exception.stackTraceToString())
                    loggedIn = false
                    setLoggedInText()
                }

                override fun onSuccess(profile: UserProfile) {
                    // We have the user's profile!
                    Timber.i("SUCCESS! got the user profile")
                    val email = profile.email
                    val name = profile.name
                    loggedIn = true
                    setLoggedInText()
                }
            })
    }
}
