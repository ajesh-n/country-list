package com.mindbody.countrylist.domain.usecases

import com.mindbody.countrylist.data.model.Province

interface GetProvincesByCountryUseCase {
    suspend fun getProvinces(countryCode: String): Result<List<Province>>
}
