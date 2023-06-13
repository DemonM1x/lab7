package org.example;

import org.example.collection.City;

import java.time.ZonedDateTime;

public class AutoGenFieldsSetter {
    public static Request setFields(Request aRequest) {
        City city = aRequest.getCommand().getCity();
        String author = aRequest.getSession().getName();

        if (city != null) {
            city.setCreationDate(ZonedDateTime.now());
            city.setAuthor(author);
        }
        return aRequest;
    }
}
