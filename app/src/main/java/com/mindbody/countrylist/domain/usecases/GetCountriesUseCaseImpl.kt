package com.mindbody.countrylist.domain.usecases

import com.mindbody.countrylist.data.repository.CountryRepository
import com.mindbody.countrylist.domain.entity.CountryEntity
import com.mindbody.countrylist.domain.entity.toCountryEntity
import javax.inject.Inject

class GetCountriesUseCaseImpl @Inject constructor(
    private val countryRepository: CountryRepository
) : GetCountriesUseCase {
    override suspend fun getCountries(): Result<List<CountryEntity>> {
        return countryRepository.getCountries()
            .map { counties ->
                counties.map {
                    it.toCountryEntity()
                }
            }
    }
}
