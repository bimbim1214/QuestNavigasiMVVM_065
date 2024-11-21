package com.example.arsitekturmvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.sourceInformationMarkerStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.arsitekturmvvm.ui.viewmodel.MahasiswaViewModel
import java.security.AccessController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arsitekturmvvm.model.DataJenisKelamin
import com.example.arsitekturmvvm.ui.view.DetailMahasiswaView
import com.example.arsitekturmvvm.ui.view.FormMahasiswa

enum class Halaman{
    Formulir,
    Detail,
}

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    viewModel: MahasiswaViewModel = viewModel()
) {

    val StateUI by viewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = Halaman.Formulir.name) {
        composable(route = Halaman.Formulir.name) {
            val konteks = LocalContext.current
            FormMahasiswa(
                listJK = DataJenisKelamin.listJk.map { id ->
                    konteks.resources.getString(id)
                },
                onSubmitClicked = {
                    viewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Detail.name)
                }
            )
        }
        composable(route = Halaman.Detail.name){
            DetailMahasiswaView(
                modifier = Modifier,
                uiStateMahasiswa = StateUI,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}