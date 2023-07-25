package com.example.service.provider;

import com.example.pojo.Providers;

import java.util.List;

public interface ProviderService {

    // Get provider list
    public List<Providers> getProviderList(String proCode, String proName);

    // Add provider
    public boolean addProvider(Providers provider);

    // Get provider by id
    public Providers getProvider(int id);
}
