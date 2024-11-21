package com.example.arsitekturmvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.arsitekturmvvm.model.Datamahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(Datamahasiswa())
    val uiState: StateFlow<Datamahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(lisDM: List<String>) {
        _uiState.update { dataMhs ->
            dataMhs.copy(nama= lisDM[0], NIM = lisDM[1], email = lisDM[2], gender= lisDM[3], alamat= lisDM[4])
        }
    }
}