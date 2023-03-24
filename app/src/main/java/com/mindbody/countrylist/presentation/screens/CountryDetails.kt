package com.mindbody.countrylist.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mindbody.countrylist.R
import com.mindbody.countrylist.data.model.Province
import com.mindbody.countrylist.presentation.theme.CountryListTheme
import com.mindbody.countrylist.presentation.viewmodels.CountryDetailsUiState
import com.mindbody.countrylist.presentation.viewmodels.CountryDetailsViewModel

@Composable
fun CountryDetails(
    navController: NavController,
    countryId: String?,
    viewModel: CountryDetailsViewModel = hiltViewModel()
) {
    countryId?.let {
        LaunchedEffect(key1 = countryId) {
            viewModel.fetchProvinces(countryId)
        }
    }
    Column {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.country_provinces))
            },
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }
        )
        when (val state = viewModel.uiState.collectAsState().value) {
            is CountryDetailsUiState.Loading -> {
                LoadingScreen(loadingText = stringResource(R.string.loading_provinces))
            }
            is CountryDetailsUiState.Error -> {
                ErrorScreen(errorMessage = state.message)
            }
            is CountryDetailsUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                ) {
                    items(state.provinces, key = { item: Province -> item.shortCode }) { province ->
                        ProvinceCard(province = province)
                    }
                    item {
                        Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
                    }
                }
            }
        }
    }
}

@Composable
fun ProvinceCard(
    province: Province,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()

    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = province.name,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${stringResource(R.string.short_code)}  ${province.shortCode}",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProvinceCardPreview() {
    CountryListTheme {
        ProvinceCard(province = Province("Karnataka", "ka"))
    }
}
