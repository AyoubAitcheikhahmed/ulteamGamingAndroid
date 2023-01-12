package com.banibegood.ulteam_gaming.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
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
    private lateinit var account: Auth0
    private lateinit var loggedInText: TextView
    private var loggedIn = false
    private lateinit var viewModel: LoginViewModel


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        account = Auth0(
            getString(R.string.auth_client_id),
            getString(R.string.auth_domain)
        )

        loggedIn?.let {
            if (it) {
                binding.loginButton.text = getString(R.string.login)
            } else {
                binding.loginButton.text = getString(R.string.logout)
            }
        }

        val button = _binding!!.loginButton
        button.setOnClickListener {
            if (!loggedIn) {
                loginWithBrowser()
            } else {
                logout()
            }
        }

        binding.frLanguageButton.setOnClickListener {
            val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags("fr")
            // Call this on the main thread as it may require Activity.restart()
            AppCompatDelegate.setApplicationLocales(appLocale)

        }
        binding.enLanguageButton.setOnClickListener {
            val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags("en")
            // Call this on the main thread as it may require Activity.restart()
            AppCompatDelegate.setApplicationLocales(appLocale)

        }

        loggedInText = _binding!!.loggedInTextview

        checkIfToken()

        //End on createView
        val root: View = binding.root
        return root
    }


    private fun checkIfToken() {
        val token = CredentialsManager.getAccessToken(requireContext())
        if (token != null) {
            //checking if the token works...
            showUserProfile(token)
        } else {
            Toast.makeText(context, "Token doesn't exist", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setLoggedInText(name: String, viewModel: LoginViewModel) {
        if (loggedIn) {
            loggedInText.text = name

            viewModel.setUsername(name)
            val result = Bundle()
            result.putString(
                "username",
                name.substringBefore(delimiter = "@", missingDelimiterValue = "Not found")
            )
            parentFragmentManager
                .setFragmentResult("requestKeyFromLogin", result)

        } else {
            loggedInText.text = getString(R.string.not_logged_in)
        }
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
                }
            })
    }

    private fun logout() {
        WebAuthProvider.logout(account)
            .withScheme("demo")
            .start(requireContext(), object : Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    Timber.tag("Logout").d("Logout successful")
                    Toast.makeText(context, "logout OK", Toast.LENGTH_SHORT).show()
                    loggedIn = false
                }

                override fun onFailure(error: AuthenticationException) {
                    Timber.tag("Logout").d("Logout Failed")
                    Toast.makeText(context, "logout NOK", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun showUserProfile(accessToken: String) {
        var client = AuthenticationAPIClient(account)

        // With the access token, call `userInfo` and get the profile from Auth0.
        client.userInfo(accessToken)
            .start(object : Callback<UserProfile, AuthenticationException> {
                override fun onFailure(exception: AuthenticationException) {
                    Timber.i(exception.stackTraceToString())
                    loggedIn = false
                }

                override fun onSuccess(profile: UserProfile) {
                    // We have the user's profile!
                    val email = profile.email
                    val name = profile.name
                    loggedIn = true
                    if (name != null) {
                        setLoggedInText(name, viewModel)
                    }
                }
            })
    }

}
