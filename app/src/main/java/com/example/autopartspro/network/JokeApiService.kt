package com.example.autopartspro.network

import com.example.autopartspro.model.Joke
import retrofit2.http.GET

interface JokeApiService {
    @GET("random")
    suspend fun getRandomJoke(): Joke
}
