package com.mindbody.countrylist.data.service

import com.mindbody.countrylist.data.model.Country
import com.mindbody.countrylist.data.model.Province
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryService {
    @GET("/countries/.json")
    suspend fun fetchCountries(): Result<List<Country>>

    @GET("/provinces/{code}/.json")
    suspend fun fetchProvinces(@Path("code") code: String): Result<List<Province>>
}
