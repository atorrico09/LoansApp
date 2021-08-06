package com.atorrico.loansapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.atorrico.loansapp.data.model.LoanItem
import com.atorrico.loansapp.data.source.LoanRepository
import com.atorrico.loansapp.ui.LoanViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import com.atorrico.loansapp.data.model.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert

@ExperimentalCoroutinesApi
class LoanViewModelTests {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var loanRepository: LoanRepository
    private lateinit var loanViewModel: LoanViewModel

    @Before
    fun setUp() {
        loanRepository = mock()
        loanViewModel = LoanViewModel(loanRepository)
    }

    @Test
    fun getLoan_returnSuccess() = runBlockingTest {
        //GIVEN
        val mockLoanItem = mock<LoanItem>()
        whenever(loanRepository.getLoans()).thenReturn(mockLoanItem)

        //WHEN
        val liveDataResponse = loanViewModel.getLoan()

        //THEN
        val loading = liveDataResponse.getOrAwaitValue()
        Assert.assertTrue(loading is Result.Loading)

        val success = liveDataResponse.getOrAwaitValue()
        Assert.assertTrue(success is Result.Success)
    }

    @Test
    fun getLoan_returnError() = runBlockingTest {
        //GIVEN
        val mockError = RuntimeException()
        whenever(loanRepository.getLoans()).thenThrow(mockError)

        //WHEN
        val liveDataResponse = loanViewModel.getLoan()

        //THEN
        val loading = liveDataResponse.getOrAwaitValue()
        Assert.assertTrue(loading is Result.Loading)

        val error = liveDataResponse.getOrAwaitValue()
        Assert.assertTrue(error is Result.Error)
    }
}
