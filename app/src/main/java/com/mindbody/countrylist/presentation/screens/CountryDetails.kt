package com.mindbody.countrylist.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mindbody.countrylist.presentation.theme.CountryListTheme

@Composable
fun CountryDetails(navController: NavController, countryId: Int?) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Text(text = "Country Details $countryId")
    }
}

@Preview(showBackground = true)
@Composable
fun CountryDetailsPreview() {
    CountryListTheme {
        CountryDetails(navController = rememberNavController(), 1)
    }
}
