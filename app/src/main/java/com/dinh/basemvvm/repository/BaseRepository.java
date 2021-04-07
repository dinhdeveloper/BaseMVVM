package com.dinh.basemvvm.repository;

public class BaseRepository {
    public static BaseRepository instance;


    public static BaseRepository getInstance(){
        if (instance==null){
            instance = new BaseRepository();
        }
        return instance;
    }
}
