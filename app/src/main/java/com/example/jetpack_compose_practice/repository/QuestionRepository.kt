package com.example.jetpack_compose_practice.repository

import com.example.jetpack_compose_practice.data.DataOrException
import com.example.jetpack_compose_practice.model.QuestionItem
import com.example.jetpack_compose_practice.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi) {
    private val dataOrException = DataOrException<
            ArrayList<QuestionItem>,
            Boolean,
            Exception>()

    suspend fun getAllQuestions(): DataOrException<
            ArrayList<QuestionItem>,
            Boolean,
            java.lang.Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        } catch (e: Exception) {
            dataOrException.e = e
        }
        return dataOrException
    }
}