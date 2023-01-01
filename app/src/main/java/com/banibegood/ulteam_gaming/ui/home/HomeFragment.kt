package com.banibegood.ulteam_gaming.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.banibegood.ulteam_gaming.R
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding
import com.banibegood.ulteam_gaming.login.CredentialsManager
import timber.log.Timber

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var home_recycler: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null

    private lateinit var account : Auth0
    private lateinit var loggedInText: TextView
    private var loggedIn = false

    // This property is only valid between onCreateView and
    // onDestroyView.
    lateinit var viewModel: HomeViewModel
    lateinit var adapter: GameAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // setup the db connection
        val application = requireNotNull(this.activity).application
        val dataSource = GameDatabase.getInstance(application).gameDatabaseDao
        // filling the list: joke adapter
        adapter = GameAdapter(
            GamesListener {
                gameId ->
                Toast.makeText(context, "$gameId", Toast.LENGTH_SHORT).show()
            }
        )
        //OAUTH
        account = Auth0(
            getString(R.string.auth_client_id),
            getString(R.string.auth_domain)
        )

        val loginButton = binding.loginButton
        loginButton?.setOnClickListener {
            loginWithBrowser()
        }


        binding.gamesList.adapter = adapter
        val viewModelFactory = HomeViewModelFactory(application, adapter)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        // databinding
        binding.viewModel = viewModel
        viewModel.games.observe(
            viewLifecycleOwner,
            Observer {
                adapter.submitList(it)
            }
        )

        binding.inputSearch.visibility = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) View.GONE else View.VISIBLE
        binding.loginButton.visibility = if (loggedIn) View.GONE else View.VISIBLE

        return binding.root
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
        if(loggedIn) {
            binding.name.text = "Connected"
            binding.skill.text = "Connected"
        }
        else {
            binding.name.text = "fail"
            binding.skill.text = "FAILURE"}
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
                    Toast.makeText(context, "FAILURE", Toast.LENGTH_SHORT).show()
                    Timber.tag("FAILURE login").i("FAILURE ")
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
                Timber.tag("Success login").i("SUCCESS ")
                }
            })
    }

    private fun logout() {
        WebAuthProvider.logout(account)
            .withScheme("demo")
            .start(requireContext(), object: Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    Toast.makeText(context, "logout OK", Toast.LENGTH_SHORT).show()
                    loggedIn = false
                    setLoggedInText()
                }

                override fun onFailure(error: AuthenticationException) {
                    Toast.makeText(context, "logout NOK", Toast.LENGTH_SHORT).show()
                }
            })
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
