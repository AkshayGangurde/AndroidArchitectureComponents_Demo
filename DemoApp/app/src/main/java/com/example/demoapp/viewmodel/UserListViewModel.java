package com.example.demoapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.demoapp.DataRepository;
import com.example.demoapp.room.AppDatabase;
import com.example.demoapp.room.userEntity;

import java.util.List;

public class UserListViewModel extends AndroidViewModel {

    LiveData<List<userEntity>> mobservabledata;
    private final DataRepository mRepository;

    public UserListViewModel(@NonNull Application application) {
        super(application);
        mRepository = DataRepository.getInstance(AppDatabase.getInstance(application.getApplicationContext()));
        mobservabledata=mRepository.loadListfromdb();

    }

    public LiveData<List<userEntity>> getObserveableusers()
    {
        return mobservabledata;
    }

}
