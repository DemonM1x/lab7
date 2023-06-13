package org.example.commands;

import org.example.Receiver;
import org.example.Request;
import org.example.Response;
import org.example.TypeOfAnswer;
import org.example.collection.City;

import java.util.Set;
import java.util.TreeSet;

public class ShowCommand extends AbstractCommand implements Execute {
    private final Receiver receiver;
    public ShowCommand(Receiver receiver) {
        super("show", "print to standard output all elements of the collection in string representation" , "", false );
        this.receiver = receiver;
    }

    @Override
    public Response execute(Request request) {
        Set<City> cities = receiver.show();
        if (cities == null)return new Response(TypeOfAnswer.EMPTYCOLLECTION);
        else return new Response(cities, TypeOfAnswer.SUCCESSFUL);
    }
}
