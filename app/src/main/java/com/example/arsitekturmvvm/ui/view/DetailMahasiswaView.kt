package com.example.arsitekturmvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.arsitekturmvvm.model.Datamahasiswa

@Composable
fun DetailMahasiswaView(
    modifier: Modifier,
    uiStateMahasiswa: Datamahasiswa,
    onBackButtonClicked : ( ) -> Unit
){
    val listDataMhs = listOf(
        Pair("nama", uiStateMahasiswa.nama),
        Pair("NIM", uiStateMahasiswa.NIM),
        Pair("Email", uiStateMahasiswa.email),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("alamat", uiStateMahasiswa.alamat)
    )

    Column(){
        listDataMhs.forEach{item ->
            CardSection(Judul = item.first, isi = item.second)
        }
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
}