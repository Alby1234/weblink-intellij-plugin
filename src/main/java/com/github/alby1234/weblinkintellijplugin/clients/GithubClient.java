package com.github.alby1234.weblinkintellijplugin.clients;

import com.github.alby1234.weblinkintellijplugin.exceptions.UnexpectedRepositoryResponseException;

import java.io.IOException;

public interface GithubClient {

    /**
     * Return the github url of the file with name {@param fileName},
     * path {@param path}, for the user with username {@param username}
     * and in the repo with name {@param repoName}
     */
    String getGithubUrlOfFile(String username, String fileName, String filePath, String repoName)
            throws UnexpectedRepositoryResponseException, IOException;
}
