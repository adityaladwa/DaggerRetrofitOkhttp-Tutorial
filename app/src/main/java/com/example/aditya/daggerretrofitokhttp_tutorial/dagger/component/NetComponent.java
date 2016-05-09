package com.example.aditya.daggerretrofitokhttp_tutorial.dagger.component;

import com.example.aditya.daggerretrofitokhttp_tutorial.dagger.module.AppModule;
import com.example.aditya.daggerretrofitokhttp_tutorial.dagger.module.NetModule;
import com.example.aditya.daggerretrofitokhttp_tutorial.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aditya on 09-May-16.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
