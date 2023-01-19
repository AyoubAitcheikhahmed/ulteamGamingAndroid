package com.banibegood.ulteam_gaming.ui.home


import android.app.Application
import android.content.Context
import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.banibegood.ulteam_gaming.MainActivity
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding
import com.banibegood.ulteam_gaming.domain.GamePicture
import com.banibegood.ulteam_gaming.repository.GamesRepository
import com.banibegood.ulteam_gaming.ui.home.GameApiStatus
import com.banibegood.ulteam_gaming.ui.home.HomeViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric

@RunWith(AndroidJUnit4::class)
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var binding: FragmentHomeBinding
    private lateinit var application: Application

    private lateinit var context: Context

    @Mock
    private lateinit var gamesRepository: GamesRepository


    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        binding = FragmentHomeBinding.inflate(Robolectric.buildActivity(MainActivity::class.java).get().layoutInflater)
        application = ApplicationProvider.getApplicationContext()
        context = ApplicationProvider.getApplicationContext()
        homeViewModel = HomeViewModel(application)
    }

    @Test
    fun Test_init_block() = runBlocking {
        val picture = GamePicture("game1", "url1")
        val pictures = MutableLiveData<GamePicture>()
        pictures.value = picture

        homeViewModel.pictures = pictures
        homeViewModel.initBlock(application)

        val observer = mock(Observer::class.java) as Observer<GameApiStatus>
        homeViewModel.status.observeForever(observer)

        verify(observer).onChanged(GameApiStatus.LOADING)
        verify(observer).onChanged(GameApiStatus.DONE)
    }




    @Test
    fun Test_set_username() {
        homeViewModel.setUsername("John_Wick")
        assert(homeViewModel.username.value == "John_Wick")
    }
}
