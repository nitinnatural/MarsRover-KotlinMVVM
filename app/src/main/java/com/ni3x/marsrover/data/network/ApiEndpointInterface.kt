package com.ni3x.marsrover.data.network

import ResultSet
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpointInterface {
    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    fun fetchPhotoOfCuriosity(@Query("earth_date") earthDate: String,
                              @Query("page") page: Int,
                              @Query("api_key") apiKey: String): Deferred<ResultSet>

    @GET("/mars-photos/api/v1/rovers/spirit/photos")
    fun fetchPhotoOfSpirit(@Query("earth_date") earthDate: String?,
                           @Query("page") page: Int,
                           @Query("api_key") apiKey: String?): Deferred<ResultSet>

    @GET("/mars-photos/api/v1/rovers/opportunity/photos")
    fun fetchPhotoOfOpportunity(@Query("earth_date") earthDate: String?,
                                @Query("page") page: Int,
                                @Query("api_key") apiKey: String?): Deferred<ResultSet>
}