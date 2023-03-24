package com.mindbody.countrylist.presentation.viewmodels

import com.mindbody.countrylist.MainDispatcherRule
import com.mindbody.countrylist.data.model.Province
import com.mindbody.countrylist.domain.usecases.GetProvincesByCountryUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CountryDetailsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val getProvincesByCountryUseCase: GetProvincesByCountryUseCase = mockk()
    private lateinit var viewModel: CountryDetailsViewModel

    @Before
    fun setUp() {
        viewModel =
            CountryDetailsViewModel(getProvincesByCountryUseCase, mainDispatcherRule.testDispatcher)
    }

    @Test
    fun `should show loading when initialized`() {
        runTest {
            // Then
            assertEquals(CountryDetailsUiState.Loading, viewModel.uiState.value)
        }
    }

    @Test
    fun `should show error when failure`() {
        runTest {
            // Given
            coEvery { getProvincesByCountryUseCase.getProvinces(any()) } returns Result.failure(
                Exception("Failed")
            )

            // When
            viewModel.fetchProvinces("in")

            // Then
            assertEquals(CountryDetailsUiState.Error("Failed"), viewModel.uiState.value)
        }
    }

    @Test
    fun `should show country provinces when success`() {
        runTest {
            // Given
            val provinces = listOf(
                Province(
                    name = "Karnataka",
                    shortCode = "ka"
                ),
                Province(
                    name = "Kerala",
                    shortCode = "kl"
                )
            )
            coEvery { getProvincesByCountryUseCase.getProvinces(any()) } returns Result.success(
                provinces
            )

            // When
            viewModel.fetchProvinces("in")

            // Then
            assertEquals(CountryDetailsUiState.Success(provinces), viewModel.uiState.value)
        }
    }
}
