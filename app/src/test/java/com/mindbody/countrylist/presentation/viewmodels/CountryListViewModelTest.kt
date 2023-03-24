package com.mindbody.countrylist.presentation.viewmodels

import com.mindbody.countrylist.MainDispatcherRule
import com.mindbody.countrylist.domain.entity.CountryEntity
import com.mindbody.countrylist.domain.usecases.GetCountriesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CountryListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getCountriesUseCase: GetCountriesUseCase = mockk()
    private lateinit var countryListViewModel: CountryListViewModel


    @Test
    fun `should show loading when initialized`() {
        runTest {
            // When
            countryListViewModel =
                CountryListViewModel(getCountriesUseCase, mainDispatcherRule.testDispatcher)

            // Then
            assertEquals(CountryListUiState.Loading, countryListViewModel.uiState.value)
        }
    }

    @Test
    fun `should show error when failure`() {
        runTest {
            // Given
            coEvery { getCountriesUseCase.getCountries() } returns Result.failure(Exception(""))

            // When
            countryListViewModel =
                CountryListViewModel(getCountriesUseCase, mainDispatcherRule.testDispatcher)

            // Then
            assertEquals(CountryListUiState.Error(""), countryListViewModel.uiState.value)
        }
    }

    @Test
    fun `should show country list when success`() {
        runTest {
            // Given
            val countryEntity = CountryEntity(
                id = 106,
                name = "India",
                code = "in",
                phoneCode = 91,
                flagUrl = "https://flagcdn.com/48x36/in.png"
            )
            coEvery { getCountriesUseCase.getCountries() } returns Result.success(
                listOf(
                    countryEntity
                )
            )

            // When
            countryListViewModel =
                CountryListViewModel(getCountriesUseCase, mainDispatcherRule.testDispatcher)

            // Then
            assertEquals(
                CountryListUiState.Success(listOf(countryEntity)),
                countryListViewModel.uiState.value
            )
        }
    }
}
