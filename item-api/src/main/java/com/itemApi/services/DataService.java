package com.itemApi.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public interface DataService {
    JSONArray getPeople(int howMany);
    List<String> getQuotes(int howMany);
}
