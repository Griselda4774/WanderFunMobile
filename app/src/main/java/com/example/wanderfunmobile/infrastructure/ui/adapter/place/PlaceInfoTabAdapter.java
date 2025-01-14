package com.example.wanderfunmobile.infrastructure.ui.adapter.place;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.wanderfunmobile.infrastructure.ui.fragment.place.PlaceDescriptionInfoFragment;
import com.example.wanderfunmobile.infrastructure.ui.fragment.place.PlaceGeneralInfoFragment;
import com.example.wanderfunmobile.infrastructure.ui.fragment.place.PlaceImageInfoFragment;
import com.example.wanderfunmobile.infrastructure.ui.fragment.place.PlaceRatingInfoFragment;

public class PlaceInfoTabAdapter extends FragmentStateAdapter {
    public PlaceInfoTabAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PlaceRatingInfoFragment();
            case 2:
                return new PlaceImageInfoFragment();
            case 3:
                return new PlaceDescriptionInfoFragment();
            default:
                return new PlaceGeneralInfoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
