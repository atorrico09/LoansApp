package com.atorrico.loansapp.data.source

import com.atorrico.loansapp.data.model.LoanItem
import com.atorrico.loansapp.data.source.local.LoanDataSource

class LoanRepository(private val loanLocalDataSource: LoanDataSource) {

    suspend fun getLoans(): LoanItem =
        loanLocalDataSource.getLoans()
}