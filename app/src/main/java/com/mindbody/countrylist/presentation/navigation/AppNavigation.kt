package com.mindbody.countrylist.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mindbody.countrylist.presentation.screens.CountryDetails
import com.mindbody.countrylist.presentation.screens.CountryList

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.CountriesListScreen.name) {
        composable(AppScreens.CountriesListScreen.name) {
            CountryList(navController)
        }

        composable(
            route = AppScreens.CountryDetailsScreen.name + "/{countryCode}",
            arguments = listOf(
                navArgument(name = "countryCode") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val countryCode = it.arguments?.getString("countryCode")
            CountryDetails(navController, countryCode)
        }
    }
}
