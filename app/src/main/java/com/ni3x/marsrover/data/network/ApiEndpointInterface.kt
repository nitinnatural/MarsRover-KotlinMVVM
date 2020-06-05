package com.ni3x.marsrover.data.network

import com.ni3x.marsrover.data.model.Dataset
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpointInterface {
    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    fun getPhotoByCuriosity(@Query("earth_date") earthDate: String?,
                            @Query("page") page: Int,
                            @Query("api_key") apiKey: String?): Call<Dataset>

    @GET("/mars-photos/api/v1/rovers/spirit/photos")
    fun getPhotoBySpirit(@Query("earth_date") earthDate: String?,
                         @Query("page") page: Int,
                         @Query("api_key") apiKey: String?): Call<Dataset>

    @GET("/mars-photos/api/v1/rovers/opportunity/photos")
    fun getPhotoByOpportunity(@Query("earth_date") earthDate: String?,
                              @Query("page") page: Int,
                              @Query("api_key") apiKey: String?): Call<Dataset>
}