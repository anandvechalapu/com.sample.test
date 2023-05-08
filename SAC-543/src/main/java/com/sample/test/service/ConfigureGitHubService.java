package com.sample.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.test.repository.ConfigureGitHubRepository;
import com.sample.test.model.ConfigureGitHub;

@Service
public class ConfigureGitHubService {

    @Autowired
    private ConfigureGitHubRepository configureGitHubRepository;

    public ConfigureGitHub validateCredentials(String username, String password, String url, String repositoryName) {
        return configureGitHubRepository.validateCredentials(username, password, url, repositoryName);
    }

    public ConfigureGitHub getGitHubInfo(String title, String username, String url) {
        return configureGitHubRepository.getGitHubInfo(title, username, url);
    }

    public List<ConfigureGitHub> getAllGitHubInfo() {
        return configureGitHubRepository.getAllGitHubInfo();
    }

    public ConfigureGitHub updateGitHubInfo(String title, String username, String url) {
        return configureGitHubRepository.updateGitHubInfo(title, username, url);
    }

    public void deleteGitHubInfo(String title, String username, String url) {
        configureGitHubRepository.deleteGitHubInfo(title, username, url);
    }

}