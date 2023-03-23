package com.mindbody.countrylist.presentation.navigation

enum class AppScreens {
    CountriesListScreen,
    CountryDetailsScreen;

    companion object {
        fun fromRoute(route: String): AppScreens =
            when (route.substringBefore("/")) {
                CountriesListScreen.name -> CountriesListScreen
                CountryDetailsScreen.name -> CountryDetailsScreen
                else -> throw IllegalArgumentException("Invalid route $route")
            }
    }
}