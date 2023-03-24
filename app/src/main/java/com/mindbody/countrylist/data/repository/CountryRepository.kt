package com.mindbody.countrylist.data.repository

import com.mindbody.countrylist.data.model.Country
import com.mindbody.countrylist.data.model.Province

interface CountryRepository {
    suspend fun getCountries(): Result<List<Country>>
    suspend fun getProvincesBy(countryCode: String): Result<List<Province>>
}