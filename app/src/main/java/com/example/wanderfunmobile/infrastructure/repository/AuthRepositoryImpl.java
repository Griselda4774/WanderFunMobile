package com.example.wanderfunmobile.infrastructure.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wanderfunmobile.application.dto.ResponseDto;
import com.example.wanderfunmobile.application.dto.auth.LoginDto;
import com.example.wanderfunmobile.application.dto.auth.LoginResponseDto;
import com.example.wanderfunmobile.application.dto.auth.RegisterDto;
import com.example.wanderfunmobile.application.dto.auth.TokenResponseDto;
import com.example.wanderfunmobile.application.repository.AuthRepository;
import com.example.wanderfunmobile.infrastructure.api.backend.AuthApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepositoryImpl implements AuthRepository {
    private final AuthApi authApi;

    @Inject
    public AuthRepositoryImpl(AuthApi authApi) {
        this.authApi = authApi;
    }

    @Override
    public LiveData<ResponseDto<LoginResponseDto>> login(LoginDto loginDto) {
        MutableLiveData<ResponseDto<LoginResponseDto>> loginResponseLiveData = new MutableLiveData<>();
        String errorType = "AuthRepositoryImpl Login Error";
        try {
            Call<ResponseDto<LoginResponseDto>> call = authApi.login(loginDto);
            call.enqueue(new Callback<ResponseDto<LoginResponseDto>>() {
                @Override
                public void onResponse(@NonNull Call<ResponseDto<LoginResponseDto>> call,
                                       @NonNull Response<ResponseDto<LoginResponseDto>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        loginResponseLiveData.postValue(response.body());
                    } else {
                        Log.e(errorType, "Error during login onResponse");
                    }
                }
                @Override
                public void onFailure(@NonNull Call<ResponseDto<LoginResponseDto>> call,
                                      @NonNull Throwable t) {
                    Log.e(errorType, "Error during login onFailure");
                }
            });
        } catch (Exception e) {
            Log.e(errorType, "Error during login catch");
        }

        return loginResponseLiveData;
    }

    @Override
    public LiveData<ResponseDto<LoginResponseDto>> register(RegisterDto registerDto) {
        MutableLiveData<ResponseDto<LoginResponseDto>> registerResponseLiveData = new MutableLiveData<>();
        String errorType = "AuthRepositoryImpl Register Error";
        try {
            Call<ResponseDto<LoginResponseDto>> call = authApi.register(registerDto);
            call.enqueue(new Callback<ResponseDto<LoginResponseDto>>() {
                @Override
                public void onResponse(@NonNull Call<ResponseDto<LoginResponseDto>> call,
                                       @NonNull Response<ResponseDto<LoginResponseDto>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        registerResponseLiveData.postValue(response.body());
                    } else {
                        Log.e(errorType, "Error during register onResponse");
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponseDto<LoginResponseDto>> call,
                                       @NonNull Throwable throwable) {
                    Log.e(errorType, "Error during register onFailure");
                }
            });
        } catch (Exception e) {
            Log.e(errorType, "Error during register catch");
        }

        return registerResponseLiveData;
    }

    @Override
    public LiveData<ResponseDto<LoginResponseDto>> logout(String bearerToken) {
        MutableLiveData<ResponseDto<LoginResponseDto>> logoutResponseLiveData = new MutableLiveData<>();
        String errorType = "AuthRepositoryImpl Logout Error";
        try {
            Call<ResponseDto<LoginResponseDto>> call = authApi.logout(bearerToken);
            call.enqueue(new Callback<ResponseDto<LoginResponseDto>>() {
                @Override
                public void onResponse(@NonNull Call<ResponseDto<LoginResponseDto>> call,
                                       @NonNull Response<ResponseDto<LoginResponseDto>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        logoutResponseLiveData.postValue(response.body());
                    } else {
                        Log.e(errorType, "Error during logout onResponse");
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponseDto<LoginResponseDto>> call,
                                      @NonNull Throwable throwable) {
                    Log.e(errorType, "Error during logout onFailure");
                }
            });
        } catch (Exception e) {
            Log.e(errorType, "Error during logout catch");
        }

        return logoutResponseLiveData;
    }

    @Override
    public LiveData<ResponseDto<TokenResponseDto>> refreshToken(String bearerToken) {
        MutableLiveData<ResponseDto<TokenResponseDto>> refreshTokenResponseLiveData = new MutableLiveData<>();
        String errorType = "AuthRepositoryImpl Refresh Token Error";
        try {
            Call<ResponseDto<TokenResponseDto>> call = authApi.refreshToken(bearerToken);
            call.enqueue(new Callback<ResponseDto<TokenResponseDto>>() {
                @Override
                public void onResponse(@NonNull Call<ResponseDto<TokenResponseDto>> call,
                                       @NonNull Response<ResponseDto<TokenResponseDto>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        refreshTokenResponseLiveData.postValue(response.body());
                    } else {
                        Log.e(errorType, "Error during onResponse");
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponseDto<TokenResponseDto>> call,
                                      @NonNull Throwable throwable) {
                    Log.e(errorType, "Error during onFailure");
                }
            });
        } catch (Exception e) {
            Log.e(errorType, "Error during catch");
        }

        return refreshTokenResponseLiveData;
    }
}
