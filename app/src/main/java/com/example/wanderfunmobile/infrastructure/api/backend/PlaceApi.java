package com.example.wanderfunmobile.infrastructure.api.backend;

import com.example.wanderfunmobile.application.dto.ResponseDto;
import com.example.wanderfunmobile.application.dto.place.PlaceDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlaceApi {
    @GET("place")
    Call<ResponseDto<List<PlaceDto>>> getAllPlaces();

    @GET("place/{placeId}")
    Call<ResponseDto<PlaceDto>> getPlaceById(@Path("placeId") Long placeId);
}
