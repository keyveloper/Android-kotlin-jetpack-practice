package com.example.jetpack_compose_practice.network

import com.example.jetpack_compose_practice.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question


}