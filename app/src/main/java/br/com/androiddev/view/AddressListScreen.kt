import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.androiddev.model.Address
import br.com.androiddev.navigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressListScreen(navController: NavController) {
    // Simulando dados de endereços
    val addresses = remember {
        listOf(
            Address(id = 1, state = "Ceará", city = "Fortaleza", cep = "60000-000", neighborhoods = emptyList()),
            Address(id = 2, state = "São Paulo", city = "São Paulo", cep = "01000-000", neighborhoods = emptyList())
            // Adicione mais endereços conforme necessário
        )
    }

    // Estado para o valor de busca
    var searchQuery by remember { mutableStateOf("") }

    // Filtrar endereços com base no valor de busca (CEP)
    val filteredAddresses = addresses.filter { address ->
        address.cep.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Endereços") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Campo de texto para a busca por CEP
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Buscar por CEP") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine = true
            )

            // Lista de endereços filtrada
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(filteredAddresses) { address ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                navController.navigate("addressDetail/${address.id}")
                            },
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        // Conteúdo do Card
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "${address.state}, ${address.city}", style = MaterialTheme.typography.titleMedium)
                            Text(text = "CEP: ${address.cep}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}