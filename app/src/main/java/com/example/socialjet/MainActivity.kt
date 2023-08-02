package com.example.socialjet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialjet.auth.SignUpScreen
import com.example.socialjet.ui.theme.SocialJetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialJetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SocialJetApp()

                }
            }
        }
    }


}

sealed class AppScreens (val route:String){
    object SignUpScreen : AppScreens("signup")
}

@Composable
fun SocialJetApp() {
    val viewModel = hiltViewModel<MyViewModel>()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SignUpScreen.route){
        composable(AppScreens.SignUpScreen.route){
            SignUpScreen()
        }
    }

}
