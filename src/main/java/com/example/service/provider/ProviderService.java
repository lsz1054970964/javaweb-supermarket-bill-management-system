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

    // Update provider by id
    public boolean updateProvider(Providers provider);

    // Delete provider by id
    public int deleteProvider(int id);
}
