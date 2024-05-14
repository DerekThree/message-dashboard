package com.itemApi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.simple.JSONArray;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PeopleApiResponse(JSONArray results) {}
