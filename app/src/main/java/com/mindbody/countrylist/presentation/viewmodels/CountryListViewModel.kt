package com.mindbody.countrylist.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindbody.countrylist.domain.entity.CountryEntity
import com.mindbody.countrylist.domain.usecases.GetCountriesUseCase
import com.mindbody.countrylist.presentation.AppDispatchers
import com.mindbody.countrylist.presentation.Dispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState: MutableStateFlow<CountryListUiState> =
        MutableStateFlow(CountryListUiState.Loading)
    val uiState: StateFlow<CountryListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(ioDispatcher) {
                getCountriesUseCase.getCountries()
                    .onSuccess {
                        _uiState.emit(CountryListUiState.Success(it))
                    }.onFailure {
                        _uiState.emit(CountryListUiState.Error)
                    }
            }
        }
    }
}

sealed interface CountryListUiState {
    object Loading : CountryListUiState
    object Error : CountryListUiState
    data class Success(val countries: List<CountryEntity>) : CountryListUiState
}
