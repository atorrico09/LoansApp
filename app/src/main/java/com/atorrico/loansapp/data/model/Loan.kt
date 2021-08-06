package com.atorrico.loansapp.data.model

import com.google.gson.annotations.SerializedName

data class Loan (
	@SerializedName("status") val status : String,
	@SerializedName("level") val level : String,
	@SerializedName("approved") val approved : Long? = null,
	@SerializedName("due") val due : Int? = null,
	@SerializedName("dueDate") val dueDate : Long? = null
)