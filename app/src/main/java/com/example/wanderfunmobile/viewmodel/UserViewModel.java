package com.example.wanderfunmobile.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wanderfunmobile.application.dto.ResponseDto;
import com.example.wanderfunmobile.application.dto.user.ChangeInfoDto;
import com.example.wanderfunmobile.application.repository.UserRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserViewModel extends ViewModel {
    private final UserRepository userRepository;

    @Inject
    public UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final MutableLiveData<ResponseDto<Object>> getSelfInfoResponseLiveData = new MutableLiveData<>();
    private final MutableLiveData<ResponseDto<Object>> updateSelfInfoResponseLiveData = new MutableLiveData<>();
    private final MutableLiveData<ResponseDto<Object>> deleteSelfResponseLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public MutableLiveData<ResponseDto<Object>> getSelfInfoResponseLiveData() {
        return getSelfInfoResponseLiveData;
    }

    public MutableLiveData<ResponseDto<Object>> updateSelfInfoResponseLiveData() {
        return updateSelfInfoResponseLiveData;
    }

    public MutableLiveData<ResponseDto<Object>> deleteSelfResponseLiveData() {
        return deleteSelfResponseLiveData;
    }

    public MutableLiveData<Boolean> isLoading() {
        return isLoading;
    }

    public void getSelfInfo(String bearerToken) {
        isLoading.setValue(true);
        userRepository.getSelfInfo(bearerToken).observeForever(response -> {
            getSelfInfoResponseLiveData.setValue(response);
            isLoading.setValue(false);
        });
    }

    public void updateSelfInfo(String bearerToken, ChangeInfoDto changeInfoDto) {
        isLoading.setValue(true);
        userRepository.updateSelfInfo(bearerToken, changeInfoDto).observeForever(response -> {
            updateSelfInfoResponseLiveData.setValue(response);
            isLoading.setValue(false);
        });
    }

    public void deleteSelf(String bearerToken) {
        isLoading.setValue(true);
        userRepository.deleteSelf(bearerToken).observeForever(response -> {
            deleteSelfResponseLiveData.setValue(response);
            isLoading.setValue(false);
        });
    }
}
