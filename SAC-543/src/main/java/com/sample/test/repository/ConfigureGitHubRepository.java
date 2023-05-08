package com.sample.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConfigureGitHubRepository extends JpaRepository<ConfigureGitHub, Long> {

    @Query("SELECT c FROM ConfigureGitHub c WHERE c.username = :username AND c.password = :password AND c.url = :url AND c.repositoryName = :repositoryName")
    ConfigureGitHub validateCredentials(@Param("username") String username, @Param("password") String password, 
    @Param("url") String url, @Param("repositoryName") String repositoryName);

    @Query("SELECT c FROM ConfigureGitHub c WHERE c.title = :title AND c.username = :username AND c.url = :url")
    ConfigureGitHub getGitHubInfo(@Param("title") String title, @Param("username") String username, @Param("url") String url);

    @Query("SELECT c FROM ConfigureGitHub c ORDER BY c.title ASC")
    List<ConfigureGitHub> getAllGitHubInfo();

    @Query("SELECT c FROM ConfigureGitHub c WHERE c.title = :title AND c.username = :username AND c.url = :url")
    ConfigureGitHub updateGitHubInfo(@Param("title") String title, @Param("username") String username, @Param("url") String url);

    @Query("DELETE FROM ConfigureGitHub c WHERE c.title = :title AND c.username = :username AND c.url = :url")
    void deleteGitHubInfo(@Param("title") String title, @Param("username") String username, @Param("url") String url);
}