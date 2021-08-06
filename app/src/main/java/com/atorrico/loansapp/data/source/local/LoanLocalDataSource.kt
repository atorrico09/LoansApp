package com.atorrico.loansapp.data.source.local

import android.content.Context
import com.atorrico.loansapp.data.model.LoanItem
import com.atorrico.loansapp.utils.getJsonDataFromAsset
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class LoanLocalDataSource(private val context: Context) : LoanDataSource {
    override suspend fun getLoans(): LoanItem {
        val jsonString = getJsonDataFromAsset(context, SOURCE_FILE_NAME)

        val item: List<LoanItem> = GsonBuilder().create()
            .fromJson(jsonString, object : TypeToken<List<LoanItem>>() {}.type)

        //TODO ENHANCE: randomize item with swipe refresh
        return item[5]
    }

    companion object {
        private const val SOURCE_FILE_NAME = "testData.json"
    }
}