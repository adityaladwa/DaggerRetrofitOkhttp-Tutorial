package com.example.aditya.daggerretrofitokhttp_tutorial;

import android.app.Application;

import com.example.aditya.daggerretrofitokhttp_tutorial.dagger.component.DaggerNetComponent;
import com.example.aditya.daggerretrofitokhttp_tutorial.dagger.component.NetComponent;
import com.example.aditya.daggerretrofitokhttp_tutorial.dagger.module.AppModule;
import com.example.aditya.daggerretrofitokhttp_tutorial.dagger.module.NetModule;

/**
 * Created by Aditya on 09-May-16.
 */
public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
