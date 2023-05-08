package com.sample.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.test.service.ConfigureGitHubService;
import com.sample.test.model.ConfigureGitHub;

@RestController
public class ConfigureGitHubController {

    @Autowired
    private ConfigureGitHubService configureGitHubService;

    @PostMapping("/validateCredentials")
    public ResponseEntity<ConfigureGitHub> validateCredentials(@RequestParam String username, @RequestParam String password, @RequestParam String url, @RequestParam String repositoryName) {
        ConfigureGitHub gitHub = configureGitHubService.validateCredentials(username, password, url, repositoryName);
        return ResponseEntity.ok(gitHub);
    }

    @GetMapping("/getGitHubInfo")
    public ResponseEntity<ConfigureGitHub> getGitHubInfo(@RequestParam String title, @RequestParam String username, @RequestParam String url) {
        ConfigureGitHub gitHub = configureGitHubService.getGitHubInfo(title, username, url);
        return ResponseEntity.ok(gitHub);
    }

    @GetMapping("/getAllGitHubInfo")
    public ResponseEntity<List<ConfigureGitHub>> getAllGitHubInfo() {
        List<ConfigureGitHub> gitHub = configureGitHubService.getAllGitHubInfo();
        return ResponseEntity.ok(gitHub);
    }

    @PutMapping("/updateGitHubInfo")
    public ResponseEntity<ConfigureGitHub> updateGitHubInfo(@RequestBody ConfigureGitHub configureGitHub) {
        ConfigureGitHub gitHub = configureGitHubService.updateGitHubInfo(configureGitHub.getTitle(), configureGitHub.getUsername(), configureGitHub.getUrl());
        return ResponseEntity.ok(gitHub);
    }

    @DeleteMapping("/deleteGitHubInfo")
    public ResponseEntity<Void> deleteGitHubInfo(@RequestParam String title, @RequestParam String username, @RequestParam String url) {
        configureGitHubService.deleteGitHubInfo(title, username, url);
        return ResponseEntity.ok().build();
    }

}