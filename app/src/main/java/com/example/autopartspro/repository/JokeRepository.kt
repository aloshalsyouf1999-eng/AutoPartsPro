package com.example.autopartspro.repository

import com.example.autopartspro.model.Joke
import com.example.autopartspro.network.RetrofitClient

class JokeRepository {
    suspend fun getRandomJoke(): Result<Joke> = try {
        val joke = RetrofitClient.jokeApiService.getRandomJoke()
        Result.success(joke)
    } catch (e: Exception) {
        Result.failure(e)
    }
}
