package com.atorrico.loansapp.data.model

import com.google.gson.annotations.SerializedName

data class LoanItem (
	@SerializedName("locale") val locale : String,
	@SerializedName("loan") val loan : Loan? = null,
	@SerializedName("timestamp") val timestamp : Long,
	@SerializedName("username") val username : String
)