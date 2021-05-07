package com.stegano.nationalinformation

data class NationDetailData (
        val name: String,
        val capital: String,
        val language: String
)

data class GsonData(val data: ArrayList<NationDetailData>)