

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.androiddev.model.Address
import br.com.androiddev.model.Neighborhood
import br.com.androiddev.model.Shift
import br.com.androiddev.navigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressDetailScreen(navController: NavController, addressId: Int) {
    // Simulando dados de endereços
    val addresses = remember {
        listOf(
            Address(
                id = 1,
                state = "Ceará",
                city = "Fortaleza",
                cep = "60123-456", // Adicionando CEP
                neighborhoods = listOf(
                    Neighborhood(
                        name = "Aldeota",
                        shifts = listOf(
                            Shift(shiftType = "Diurno", time = "6h20", daysOfWeek = listOf("SEGUNDA", "QUARTA")),
                            Shift(shiftType = "Noturno", time = "18h00", daysOfWeek = listOf("TERÇA", "QUINTA"))
                        )
                    )
                )
            ),
            Address(
                id = 2,
                state = "São Paulo",
                city = "São Paulo",
                cep = "01000-000", // Adicionando CEP
                neighborhoods = listOf(
                    Neighborhood(
                        name = "Centro",
                        shifts = listOf(
                            Shift(shiftType = "Manhã", time = "8h00", daysOfWeek = listOf("SEGUNDA", "QUARTA")),
                            Shift(shiftType = "Tarde", time = "14h00", daysOfWeek = listOf("TERÇA", "QUINTA"))
                        )
                    )
                )
            )
        )
    }

    val selectedAddress = addresses.firstOrNull { it.id == addressId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detalhes do Endereço") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
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
        selectedAddress?.let { address ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Text(text = "Estado: ${address.state}")
                Text(text = "Cidade: ${address.city}")
                Text(text = "CEP: ${address.cep}") // Mostrando o CEP
                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn {
                    items(address.neighborhoods) { neighborhood ->
                        Column(modifier = Modifier.padding(vertical = 8.dp)) {
                            Text(
                                text = "Bairro: ${neighborhood.name}",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Turnos:", style = MaterialTheme.typography.titleSmall)

                            neighborhood.shifts.forEach { shift ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Column {
                                            Text(text = "Turno: ${shift.shiftType}")
                                            Text(text = "Horário: ${shift.time}")
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    } ?: run {
        Text(text = "Endereço não encontrado", modifier = Modifier.padding(16.dp))
    }
}
