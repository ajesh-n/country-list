package com.mindbody.countrylist.data

import com.mindbody.countrylist.data.model.Country
import com.mindbody.countrylist.data.model.Province

interface CountryNetworkDataSource {
    suspend fun getCountries(): Result<List<Country>>
    suspend fun getProvinces(code: String): Result<List<Province>>
}
