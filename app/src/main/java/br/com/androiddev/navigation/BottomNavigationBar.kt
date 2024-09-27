package br.com.androiddev.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(
        tonalElevation = 5.dp,
        containerColor = MaterialTheme.colorScheme.primary, // Cor de fundo da barra
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Início") },
            label = { Text("Início") },
            selected = currentRoute == "mainScreen",
            onClick = {
                navController.navigate("mainScreen") {
                    // Limpa a stack de navegação até a tela inicial (mainScreen)
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true // Remove todas as rotas anteriores
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Solicitar") },
            label = { Text("Solicitar") },
            selected = currentRoute == "solicitar",
            onClick = {
                navController.navigate("solicitar") {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            selected = currentRoute == "perfil",
            onClick = {
                navController.navigate("perfil") {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            )
        )
    }
}

