
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.exammovil.Aerolineas
import com.example.exammovil.AerolineasViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreenAerolineas(viewModel: AerolineasViewModel, navController: NavController) {
    // Variables para capturar los datos ingresados
    var id by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var pais by remember { mutableStateOf("") }
    var flota by remember { mutableStateOf("") }

    // Recolectar todos los datos de la base de datos
    val aerolineas = viewModel.getAllAerolineas().collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "ELICEO CEDEÑO LOPEZ", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = "Aerolínea", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = "7mo A", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Propiedades", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        TextField(value = id, onValueChange = { id = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(2.dp))
        TextField(value = nombre, onValueChange = { nombre = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(2.dp))
        TextField(value = codigo, onValueChange = { codigo = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(2.dp))
        TextField(value = pais, onValueChange = { pais = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(2.dp))
        TextField(value = flota, onValueChange = { flota = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                val nuevaAerolinea = Aerolineas(
                    nombre = nombre,
                    codigo = codigo,
                    pais = pais,
                    flota = flota.toIntOrNull() ?: 0
                )
                viewModel.insertAerolinea(nuevaAerolinea)
            },
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text(text = "Crear")
        }

        Button(
            onClick = {
                navController.navigate("allAerolineas")
            },
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text(text = "Mostrar todos los registros")
        }
    }
}