package com.banibegood.ulteam_gaming.ui.home

import android.app.Application
import android.content.Context
import android.widget.Toast
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class HomeViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Test
    fun test_connectivity_intercepter_should_not_be_null() {
        val application =  Mockito.mock(Application::class.java)

        val context  =  Mockito.mock(Context::class.java)
        Mockito.`when`(application.applicationContext).thenReturn(context)


        val adapter = GameAdapter(
            GamesListener { gameId -> Toast.
            makeText(application.applicationContext, "$gameId", Toast.LENGTH_SHORT).show() },
            application.applicationContext
        )
        val viewModel = HomeViewModelFactory(application, adapter).create(HomeViewModel::class.java)
        val result = viewModel.connectivityIntercepter(application.applicationContext)
        assertThat(result, `is`(not(nullValue())))
    }

    @Test
    fun pictures_should_be_null() {
        val application =  Mockito.mock(Application::class.java)

        val context  =  Mockito.mock(Context::class.java)
        Mockito.`when`(application.applicationContext).thenReturn(context)
        val adapter = GameAdapter(
            GamesListener { gameId -> Toast.
            makeText(application.applicationContext, "$gameId", Toast.LENGTH_SHORT).show() },
            application.applicationContext
        )
        val factory = HomeViewModelFactory(application,adapter)
        val viewModel = factory.create(HomeViewModel::class.java)
        val result = viewModel.pictures
        assertThat(result, `is`(nullValue()))
    }

}