package com.mindbody.countrylist.domain.entity

import com.mindbody.countrylist.data.model.Country

data class CountryEntity(
    val id: Int,
    val name: String,
    val phoneCode: Int,
    val code: String,
    val flagUrl: String
)

fun Country.toCountryEntity(): CountryEntity = CountryEntity(
    id = id,
    name = name,
    phoneCode = phoneCode,
    code = code,
    flagUrl = "https://flagcdn.com/48x36/$code.png"
)
