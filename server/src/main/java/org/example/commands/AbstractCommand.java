package org.example.commands;

import org.example.Request;
import org.example.Response;

import java.util.Objects;

public abstract class AbstractCommand implements Execute {
    private final String name;
    private final String description;
    private final String fullname;

    private final boolean isRequiredAuthorization;

    public AbstractCommand(String name, String description  , String fullname, boolean anIsRequiredAuthorization ) {
        this.name = name;
        this.description = description;
        this.fullname = fullname;
        this.isRequiredAuthorization = anIsRequiredAuthorization;
    }

    public boolean getAuthorizationStatus() {
        return isRequiredAuthorization;
    }

    @Override
    public String toString() {
        if(Objects.equals(fullname, "")){
            return name + " - " + description;
        }
        return name + " " + fullname + " - " + description;
    }
    @Override
    public abstract Response execute(Request aRequest);
}
