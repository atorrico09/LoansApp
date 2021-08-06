package com.atorrico.loansapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.atorrico.loansapp.data.source.LoanRepository
import com.atorrico.loansapp.data.model.Result

class LoanViewModel(
    private val loanRepository: LoanRepository
) : ViewModel() {

    fun getLoan() = liveData {
        emit(Result.Loading())

        runCatching {
            loanRepository.getLoans()
        }.onSuccess {
            emit(Result.Success(it))
        }.onFailure {
            emit(Result.Error(it))
        }
    }

    class Factory(
        private val loanRepository: LoanRepository,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(
            modelClass: Class<T>,
        ): T {
            return modelClass.getConstructor(LoanRepository::class.java)
                .newInstance(loanRepository)
        }
    }
}