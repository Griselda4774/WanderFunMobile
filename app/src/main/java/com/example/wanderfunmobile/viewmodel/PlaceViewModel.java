package com.example.wanderfunmobile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wanderfunmobile.application.dto.ResponseDto;
import com.example.wanderfunmobile.application.repository.PlaceRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PlaceViewModel extends ViewModel {
    private final PlaceRepository placeRepository;


    @Inject
    public PlaceViewModel(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    private final MutableLiveData<ResponseDto<Object>> getAllPlacesResponseLiveData = new MutableLiveData<>();
    private final MutableLiveData<ResponseDto<Object>> getPlaceByIdResponseLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public LiveData<ResponseDto<Object>> getAllPlacesResponseLiveData() {
        return getAllPlacesResponseLiveData;
    }

    public LiveData<ResponseDto<Object>> getPlaceByIdResponseLiveData() {
        return getPlaceByIdResponseLiveData;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void getAllPlaces() {
        isLoading.setValue(true);
        placeRepository.getAllPlaces().observeForever(response -> {
            getAllPlacesResponseLiveData.setValue(response);
            isLoading.setValue(false);
        });
    }

    public void getPlaceById(Long placeId) {
        isLoading.setValue(true);
        placeRepository.getPlaceById(placeId).observeForever(response -> {
            getPlaceByIdResponseLiveData.setValue(response);
            isLoading.setValue(false);
        });
    }
}
