package com.example.autopartspro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autopartspro.model.Joke
import com.example.autopartspro.repository.JokeRepository
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {
    private val repository = JokeRepository()
    
    private val _joke = MutableLiveData<Joke>()
    val joke: LiveData<Joke> = _joke
    
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error
    
    fun fetchJoke() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            repository.getRandomJoke().onSuccess { joke ->
                _joke.value = joke
            }.onFailure { exception ->
                _error.value = exception.message ?: "Unknown error occurred"
            }
            
            _isLoading.value = false
        }
    }
}
