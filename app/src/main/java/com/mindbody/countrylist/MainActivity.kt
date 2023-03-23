package com.mindbody.countrylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mindbody.countrylist.presentation.navigation.AppNavigation
import com.mindbody.countrylist.presentation.theme.CountryListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryListTheme {
                AppNavigation()
            }
        }
    }
}
