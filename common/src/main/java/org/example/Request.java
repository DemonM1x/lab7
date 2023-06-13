package org.example;

import org.example.collection.City;

import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {

    private final CommandFactory command;
    private Session session;

    public Request(CommandFactory commandFactory, Session aSession) {
        command = commandFactory;
        this.session = aSession;

    }

    public CommandFactory getCommand(){
        return command;
    }

    public Session getSession(){
        return session;
    }

    @Override
    public String toString() {
        return command.toString() + "from (" + session.toString() + ")";
    }

}
