package com.itemApi.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    DataService dataService;

    @Autowired
    MessageService messageService;

    @Override
    public String getItems(int howMany) {
        JSONArray people = dataService.getPeople(howMany);
        List<String> quotes = dataService.getQuotes(howMany);

        for (int i=0; i < howMany; i++) {
            HashMap<String, String> inputMap = new HashMap<>();
            inputMap.put("quote", quotes.get(i));
            Map item = (Map) people.get(i);
            Map name = (Map) item.get("name");
            inputMap.put("title", (String) name.get("title"));
            inputMap.put("first", (String) name.get("first"));
            inputMap.put("last", (String) name.get("last"));
            item.put("message", messageService.getMessage(inputMap));
        }
        return people.toJSONString();
    }
}
