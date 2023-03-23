package com.mindbody.countrylist.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mindbody.countrylist.presentation.navigation.AppScreens
import com.mindbody.countrylist.presentation.theme.CountryListTheme

@Composable
fun CountryList(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Text(text = "Country List")
        TextButton(onClick = { navController.navigate(AppScreens.CountryDetailsScreen.name + "/3") }) {
            Text("Click Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryListPreview() {
    CountryListTheme {
        CountryList(navController = rememberNavController())
    }
}
