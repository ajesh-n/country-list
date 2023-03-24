package com.mindbody.countrylist.domain.usecases

import com.mindbody.countrylist.data.model.Province
import com.mindbody.countrylist.data.repository.CountryRepository
import javax.inject.Inject

class GetProvincesByCountryUseCaseImpl @Inject constructor(
    private val countryRepository: CountryRepository
) : GetProvincesByCountryUseCase {
    override suspend fun getProvinces(countryCode: String): Result<List<Province>> {
        return countryRepository.getProvincesBy(countryCode)
    }
}
