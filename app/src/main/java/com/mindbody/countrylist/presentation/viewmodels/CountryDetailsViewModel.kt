package com.mindbody.countrylist.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindbody.countrylist.data.model.Province
import com.mindbody.countrylist.domain.usecases.GetProvincesByCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class CountryDetailsViewModel @Inject constructor(
    private val getProvincesByCountryUseCase: GetProvincesByCountryUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<CountryDetailsUiState> =
        MutableStateFlow(CountryDetailsUiState.Loading)
    val uiState: StateFlow<CountryDetailsUiState> = _uiState.asStateFlow()

    fun fetchProvinces(countryCode: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getProvincesByCountryUseCase.getProvinces(countryCode)
                    .onSuccess {
                        _uiState.emit(CountryDetailsUiState.Success(it))
                    }.onFailure {
                        if (it is NullPointerException) {
                            _uiState.emit(
                                CountryDetailsUiState.Error(
                                    "Province data for country not available"
                                )
                            )
                        } else {
                            _uiState.emit(
                                CountryDetailsUiState.Error(
                                    it.localizedMessage ?: "Something went wrong"
                                )
                            )
                        }
                    }
            }
        }
    }
}

sealed interface CountryDetailsUiState {
    object Loading : CountryDetailsUiState
    data class Error(val message: String) : CountryDetailsUiState
    data class Success(val provinces: List<Province>) : CountryDetailsUiState
}