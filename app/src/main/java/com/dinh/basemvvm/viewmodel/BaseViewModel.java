package com.dinh.basemvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dinh.basemvvm.model.BaseResponseModel;
import com.dinh.basemvvm.repository.BaseRepository;

public abstract class BaseViewModel<M> extends ViewModel {
    private MutableLiveData<BaseResponseModel<M>> data;
    private BaseRepository repository;

    public void init() {
        if (data != null) {
            return;
        }
        repository = BaseRepository.getInstance();
        //data = repository.getDataBase();
    }

    public LiveData<BaseResponseModel<M>> getList() {
        return data;
    }
}
