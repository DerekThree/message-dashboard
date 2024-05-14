package com.itemApi.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

@Service
public class MessageServiceImpl implements MessageService {
    private final String templateString = getFileContents(new File("src/main/resources/template.txt"));

    private String getTransformedString(String originalString, String replacementMarker, Function<String, String> replacementFunction) {
        String [] stringArr = originalString.split(replacementMarker);

        for (int i = 1; i < stringArr.length; i++) {
            if (i % 2 == 0) continue;
            stringArr[i] = replacementFunction.apply(stringArr[i].trim());
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stringArr) sb.append(s);
        return sb.toString();
    }

    public String getMessage(Map<String, String> replacementMap) {
        String randomizedTemplate = getTransformedString(templateString, "@@", this::getRandomOption);
        return getTransformedString(randomizedTemplate, "##", replacementMap::get);
    }

    private String getRandomOption(String optionsString) {
        String[] options = optionsString.split("[|]");
        int i = (int) Math.floor(options.length * Math.random());
        return options[i].trim();
    }

    private String getFileContents(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
