package com.itemApi.services;

import com.itemApi.models.PeopleApiResponse;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private String peopleApiUrl = "https://randomuser.me/api/?results=%d&inc=name,phone,picture,location,email" +
            "";
    private String quotesApiUrl = "https://type.fit/api/quotes";
    private RestTemplate restTemplate = new RestTemplate();

    public JSONArray getPeople(int howMany) {
        return restTemplate.getForObject(peopleApiUrl.formatted(howMany), PeopleApiResponse.class).results();
    }

    public List<String> getQuotes(int howMany) {
        ArrayList<String> quotes = new ArrayList<>();
        String quotePrefix = "\"text\": \"";
        String quoteSuffix = "\"";
        for (int fetched = 0; fetched < howMany; fetched += 16) {
            String jsonString = restTemplate.getForObject(quotesApiUrl, String.class);
            String[] stringArr = jsonString.split(quotePrefix);
            for (int i = 1; i < stringArr.length; i++) {
                String quote = stringArr[i].split(quoteSuffix)[0];
                quotes.add(quote);
            }
        }

        return quotes.subList(0, howMany);
    }
}
