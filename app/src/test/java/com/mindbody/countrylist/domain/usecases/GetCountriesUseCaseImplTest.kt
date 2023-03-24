package com.mindbody.countrylist.domain.usecases

import com.mindbody.countrylist.data.model.Country
import com.mindbody.countrylist.data.repository.CountryRepository
import com.mindbody.countrylist.domain.entity.CountryEntity
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetCountriesUseCaseImplTest {

    private val countryRepository: CountryRepository = mockk()
    private lateinit var getCountriesUseCaseImpl: GetCountriesUseCaseImpl

    @Before
    fun setUp() {
        getCountriesUseCaseImpl = GetCountriesUseCaseImpl(countryRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test country entity mapped`() {
        runTest {
            // Given
            val countries = listOf(
                Country(
                    id = 106,
                    name = "India",
                    code = "in",
                    phoneCode = 91
                )
            )
            val countryEntity = CountryEntity(
                id = 106,
                name = "India",
                code = "in",
                phoneCode = 91,
                flagUrl = "https://flagcdn.com/48x36/in.png"
            )
            coEvery { countryRepository.getCountries() } returns Result.success(countries)

            // When
            val countriesResult = getCountriesUseCaseImpl.getCountries()

            // Then
            assertEquals(Result.success(listOf(countryEntity)), countriesResult)
        }
    }
}
