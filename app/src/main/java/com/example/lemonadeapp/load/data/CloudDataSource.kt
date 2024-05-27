package com.example.lemonadeapp.load.data

import com.example.lemonadeapp.core.data.IntCache
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.UnknownHostException

interface CloudDataSource {

    fun data(): Int

    class Base(
        private val service: NumberService,
    ) : CloudDataSource {

        override fun data(): Int {
            try {
                val data: Call<List<Int>> = service.data()
                return data.execute().body()!![0]
            } catch (e: Exception) {
                if (e is UnknownHostException)
                    throw IllegalStateException("No internet connection")
                else
                    throw IllegalStateException("Unknown error in CloudDataSource")
            }
        }
    }
}

interface NumberService {

    @GET("random")
    fun data(
        @Query("min") min: Int = 1,
        @Query("max") max: Int = 10,
        @Query("count") count: Int = 1,
    ): Call<List<Int>>
}

class MockService(
    private val currentIndex: IntCache
) : NumberService {

    private val mockResponse = listOf(5, 3, 7)

    private var showSuccess = false

    override fun data(min: Int, max: Int, count: Int): Call<List<Int>> {
        Thread.sleep(1000)
        if (showSuccess) {
            showSuccess = false

            return object : Call<List<Int>> {
                override fun clone(): Call<List<Int>> = this

                override fun execute(): Response<List<Int>> {
                    var index = currentIndex.read()
                    if (index == 3) index = 0
                    currentIndex.save(index + 1)
                    return Response.success(listOf(mockResponse[index]))
                }

                override fun isExecuted(): Boolean = false

                override fun cancel() {}

                override fun isCanceled(): Boolean = false

                override fun request(): Request {
                    TODO("Not yet implemented")
                }

                override fun timeout(): Timeout {
                    TODO("Not yet implemented")
                }

                override fun enqueue(callback: Callback<List<Int>>) {
                    TODO("Not yet implemented")
                }
            }
        } else {
            showSuccess = true
            throw UnknownHostException("No internet connection")
        }
    }
}
