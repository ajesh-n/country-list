package com.mindbody.countrylist.data.repository

import com.mindbody.countrylist.data.CountryNetworkDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CountryRepositoryImplTest {

    private val countryNetworkDataSource: CountryNetworkDataSource = mockk()
    lateinit var countryRepositoryImpl: CountryRepositoryImpl

    @Before
    fun setUp() {
        countryRepositoryImpl = CountryRepositoryImpl(countryNetworkDataSource)
    }

    @Test
    fun `should fetch countries from network data source`() {
        runTest {
            // Given
            coEvery { countryNetworkDataSource.getCountries() } returns Result.success(listOf())

            // When
            countryRepositoryImpl.getCountries()

            // Then
            coVerify {
                countryNetworkDataSource.getCountries()
            }
        }
    }

    @Test
    fun `should fetch provinces from network data source for given country code`() {
        runTest {
            // Given
            coEvery { countryNetworkDataSource.getProvinces(any()) } returns Result.success(
                listOf()
            )

            // When
            countryRepositoryImpl.getProvincesBy("in")

            // Then
            coVerify {
                countryNetworkDataSource.getProvinces(eq("in"))
            }
        }

    }
}
