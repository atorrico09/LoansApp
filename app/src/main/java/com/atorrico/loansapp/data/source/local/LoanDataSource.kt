package com.atorrico.loansapp.data.source.local

import com.atorrico.loansapp.data.model.LoanItem

interface LoanDataSource {
    suspend fun getLoans(): LoanItem
}