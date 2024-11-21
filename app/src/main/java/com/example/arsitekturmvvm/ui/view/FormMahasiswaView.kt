package com.example.arsitekturmvvm.ui.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FormMahasiswa(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
){
    var nama by remember { mutableStateOf("")}
    var NIM by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var alamat by remember { mutableStateOf("")}
    var NoHP by remember { mutableStateOf("")}
    var selectedGender by remember { mutableStateOf("")}

    val jenisKelamin = listOf("lanang", "wedok")



    var namaUser by remember { mutableStateOf("")}
    var NIMUser by remember { mutableStateOf("")}
    var emailUser by remember { mutableStateOf("")}
    var alamatUser by remember { mutableStateOf("")}
    var NoHPUser by remember { mutableStateOf("")}
    var selectedGenderUser by remember { mutableStateOf("")}

    val datamahasiswa: MutableList<String> = mutableListOf(nama, selectedGender, alamat)

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            placeholder = { Text("masukkan nama") },
            label = { Text("Nama") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Row {
            listJK.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selectedGender == item, onClick = {
                        selectedGender = item
                    })
                    Text(item)
                }
            }
        }
        OutlinedTextField(
            value = NIM,
            onValueChange = { NIM = it },
            placeholder = { Text("masukkan email") },
            label = { Text("NIM") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("masukkan email") },
            label = { Text("email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            placeholder = { Text("masukkan alamat") },
            label = { Text("alamt") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = NoHP,
            onValueChange = { NoHP = it },
            placeholder = { Text("masukkan NoHP") },
            label = { Text("NoHP") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Button(onClick = { onSubmitClicked(datamahasiswa) })
        {
            Text("Simpan")
        }


}
@Composable
fun CardSection(Judul: String, isi : String) {
    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = Judul, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$isi", modifier = Modifier.weight(2f))
        }
    }
}}




