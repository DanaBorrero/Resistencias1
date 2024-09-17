package com.example.resistencias.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.times
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import kotlin.time.times

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(){

    val colores = listOf(" 0 - Negro ", " 1 - Marrón", " 2 - Rojo", " 3 - Naranja", " 4 - Amarillo", " 5 - Verde", " 6 - Azul", " 7 - Violeta", " 8 - Gris", " 9 - Blanco")
    val colores2 = listOf("1 ", "2", "0.5", "0.25", "0.10", "0.05", "5", "10", "0")
    val colores1 = listOf("1", "10","100", "1000", "10000", "100000", "1000000", "100000000", "1000000000", "10000000000", "0.1", "0.01")
    val valoresResistencia = mapOf(
        " 0 - Negro " to 0,
        " 1 - Marrón" to 1,
        " 2 - Rojo" to 2,
        " 3 - Naranja" to 3,
        " 4 - Amarillo" to 4,
        " 5 - Verde" to 5,
        " 6 - Azul" to 6,
        " 7 - Violeta" to 7,
        " 8 - Gris" to 8,
        " 9 - Blanco" to 9
    )
    val multiplicador = mapOf(
        "1" to 1,
        "10" to 10,
        "100" to 100,
        "1000" to 1000,
        "10000" to 10000,
        "100000" to 100000,
        "1000000" to 1000000,
        "100000000" to 10000000,
        "1000000000" to 100000000,
        "10000000000" to 1000000000,
        "0.1" to 0.1,
        "0.01" to 0.01
    )
    val resiste = mapOf(
        "1" to 1,
        "2" to 2,
        "0.5" to 0.5,
        "0.25" to 0.25,
        "0.10" to 0.10,
        "0.05" to 0.05,
        "5" to 5,
        "10" to 10,
        "0" to 20
    )
    val colorMap = mapOf(
        " 0 - Negro " to Color.Black,
        " 1 - Marrón" to Color(0xFF8B4513),  // Marrón
        " 2 - Rojo" to Color.Red,
        " 3 - Naranja" to Color(0xFFFFA500), // Naranja
        " 4 - Amarillo" to Color.Yellow,
        " 5 - Verde" to Color.Green,
        " 6 - Azul" to Color.Blue,
        " 7 - Violeta" to Color(0xFF8A2BE2), // Violeta
        " 8 - Gris" to Color.Gray,
        " 9 - Blanco" to Color.White
    )

    val colorMap1 = mapOf(
        "1" to Color.Black,
        "10" to Color(0xFF8B4513),  // Marrón
        "100" to Color.Red,
        "1000" to Color(0xFFFFA500), // Naranja
        "10000" to Color.Yellow,
        "100000" to Color.Green,
        "1000000" to Color.Blue,
        "100000000" to Color(0xFF8A2BE2), // Violeta
        "1000000000" to Color.Gray,
        "10000000000" to Color.White,
        "0.1" to Color(0xFFFFD700),
        "0.01" to Color(0xFFC0C0C0)
    )
    var banda1 by remember { mutableStateOf(colores[0]) }
    var isExpanded1 by remember { mutableStateOf(false) }
    var banda2 by remember { mutableStateOf(colores[0]) }
    var isExpanded2 by remember { mutableStateOf(false) }
    var banda3 by remember { mutableStateOf(colores[0]) }
    var isExpanded3 by remember { mutableStateOf(false) }
    var banda4 by remember { mutableStateOf(colores1[0]) }
    var isExpanded4 by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Primera banda de color
        ExposedDropdownMenuBox(
            expanded = isExpanded1,
            onExpandedChange = {isExpanded1 = !isExpanded1}) {

            TextField(
                modifier = Modifier.menuAnchor(),
                value = banda1,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded1)}
            )
            ExposedDropdownMenu(expanded = isExpanded1, onDismissRequest = { isExpanded1 = false})
            {
                colores.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            banda1 = colores[index]
                            isExpanded1 = false},
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding)

                }

            }

        }
        Text(
            text = "Banda 1: $banda1",
            color = colorMap[banda1] ?: Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorMap[banda1] ?: Color.Black)
                .padding(8.dp),
            fontWeight = FontWeight.Bold)

        // Segunda banda de color
        ExposedDropdownMenuBox(
            expanded = isExpanded2,
            onExpandedChange = {isExpanded2 = !isExpanded2}) {

            TextField(
                modifier = Modifier.menuAnchor(),
                value = banda2,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded2)}
            )
            ExposedDropdownMenu(expanded = isExpanded2, onDismissRequest = { isExpanded2 = false})
            {
                colores.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            banda2 = colores[index]
                            isExpanded2 = false},
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding)

                }

            }

        }
        Text(text = "Banda 2: $banda2",
            color = colorMap[banda2] ?: Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorMap[banda2] ?: Color.Black)
                .padding(8.dp),
            fontWeight = FontWeight.Bold)

        // Tercera banda de color
        ExposedDropdownMenuBox(
            expanded = isExpanded3,
            onExpandedChange = {isExpanded3 = !isExpanded3}) {

            TextField(
                modifier = Modifier.menuAnchor(),
                value = banda3,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded3)}
            )
            ExposedDropdownMenu(expanded = isExpanded3, onDismissRequest = { isExpanded3 = false})
            {
                colores1.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            banda3 = colores1[index]
                            isExpanded3 = false},
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding)

                }

            }

        }
        Text(
            text = "Banda 3: $banda3",
            color = colorMap[banda3] ?: Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorMap[banda3] ?: Color.Black)
                .padding(8.dp),
            fontWeight = FontWeight.Bold)

        // Cuarta banda de color
        ExposedDropdownMenuBox(
            expanded = isExpanded4,
            onExpandedChange = {isExpanded4 = !isExpanded4}) {

            TextField(
                modifier = Modifier.menuAnchor(),
                value = banda4,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded4)}
            )
            ExposedDropdownMenu(expanded = isExpanded4, onDismissRequest = { isExpanded4 = false})
            {
                colores2.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            banda4 = colores2[index]
                            isExpanded4 = false},
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding)

                }

            }

        }

        Text(
            text = "Banda 4: $banda4",
            color = colorMap1[banda4] ?: Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorMap1[banda4] ?: Color.Black)
                .padding(8.dp),
            fontWeight = FontWeight.Bold
        )

        val valor1 = valoresResistencia[banda1] ?: 0  // Obtiene el valor de la primera banda
        val valor2 = valoresResistencia[banda2] ?: 0  // Obtiene el valor de la segunda banda
        val factor = multiplicador[banda3] ?: 1       // Obtiene el multiplicador de la tercera banda
        val resistencia = resiste[banda4] ?: 1

        // Calcula el valor de la resistencia total
        val valorResistencia = (valor1 * 10 + valor2) * factor.toDouble()

        // Mostrar el valor calculado
        Text(text = "Resistencia: $valorResistencia Ω")
        Text(text = "Tolerancia: +/- $resistencia %")
    }
}