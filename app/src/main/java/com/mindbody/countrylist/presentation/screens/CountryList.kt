package com.mindbody.countrylist.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mindbody.countrylist.R
import com.mindbody.countrylist.domain.entity.CountryEntity
import com.mindbody.countrylist.presentation.navigation.AppScreens
import com.mindbody.countrylist.presentation.theme.CountryListTheme
import com.mindbody.countrylist.presentation.viewmodels.CountryListUiState
import com.mindbody.countrylist.presentation.viewmodels.CountryListViewModel

@Composable
fun CountryList(
    navController: NavController,
    viewModel: CountryListViewModel = hiltViewModel()
) {
    Column {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, backgroundColor = MaterialTheme.colors.primary)
        when (val state =
            viewModel.uiState.collectAsState(initial = CountryListUiState.Loading).value) {
            is CountryListUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                ) {
                    items(state.countries, key = { item -> item.id }) { country ->
                        CountryCard(country = country, onCountryClicked = {
                            navController.navigate(AppScreens.CountryDetailsScreen.name + "/${it.code}")
                        })
                    }

                    item {
                        Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
                    }
                }
            }
            is CountryListUiState.Loading -> {
                LoadingScreen(loadingText = stringResource(R.string.loading_countries))
            }
            is CountryListUiState.Error -> {
                ErrorScreen(state.message ?: stringResource(R.string.error_message))
            }
        }
    }
}

@Composable
fun CountryCard(
    country: CountryEntity,
    onCountryClicked: (CountryEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onCountryClicked(country) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = country.flagUrl,
                placeholder = painterResource(id = R.drawable.ic_image),
                contentDescription = "country flag",
                error = painterResource(id = R.drawable.ic_image),
                modifier = Modifier
                    .width(140.dp)
                    .height(94.dp),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = country.name,
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${stringResource(id = R.string.country_code)} : ${country.code}",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${stringResource(id = R.string.tel_code)} ${country.phoneCode}",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2,
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryCardPreview() {
    CountryListTheme {
        CountryCard(
            country = CountryEntity(
                id = 106,
                name = "India",
                code = "in",
                phoneCode = 91,
                flagUrl = "https://flagcdn.com/48x36/in.png"
            ),
            onCountryClicked = {}
        )
    }
}
