package com.github.alby1234.weblinkintellijplugin.clients;

import com.github.alby1234.weblinkintellijplugin.exceptions.UnexpectedRepositoryResponseException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpGithubClient implements GithubClient {

    private final String githubBaseUrl = "https://api.github.com";

    @Override
    public String getGithubUrlOfFile(String username, String fileName, String filePath, String repoName)
            throws UnexpectedRepositoryResponseException, IOException {
        String query = buildGithubUrlOfFileQuery(username, fileName, filePath, repoName);

        URL url;
        try{
            url = new URL(githubBaseUrl + "/search/code?q=" + query);
        } catch (MalformedURLException e) {
            throw e;
        }

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) connection.getContent()));
        JsonObject rootObject = root.getAsJsonObject();
        JsonArray possibleMatches = rootObject.get("items").getAsJsonArray();

        return findCorrectUrlForFileFromJsonArray(fileName, possibleMatches);
    }

    private String buildGithubUrlOfFileQuery(String username, String fileName, String filePath, String repoName) {
        StringBuilder query = new StringBuilder();
        query.append("user:");
        query.append(username);
        query.append("%20");
        query.append("filename:");
        query.append(fileName);
        query.append("%20");
        query.append("path:");
        query.append(filePath);
        query.append("%20");
        query.append("repo:");
        query.append(repoName);
        return query.toString();
    }

    private String findCorrectUrlForFileFromJsonArray(String fileName, JsonArray possibleMatches)
            throws UnexpectedRepositoryResponseException {
        String githubUrl = "";

        for (JsonElement file : possibleMatches) {
            JsonObject possibleMatch = file.getAsJsonObject();
            if (possibleMatch.get("name").getAsString().equals(fileName)) {
                githubUrl = possibleMatch.get("html_url").getAsString();
                break;
            }
        }

        if (githubUrl.equals("")) {
            throw new UnexpectedRepositoryResponseException("No matching urls found for " + fileName + ". Check the path and repo name.");
        }
        return githubUrl;
    }
}
