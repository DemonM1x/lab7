package org.example.commands;

import org.example.Receiver;
import org.example.Request;
import org.example.Response;
import org.example.TypeOfAnswer;
import org.example.collection.City;

public class AddIfMinCommand extends AbstractCommand implements Execute{
    private final Receiver receiver;
    public AddIfMinCommand(Receiver receiver){
        super("add_if_min","add new element to the collection if element is minimal","{element}", true);
        this.receiver = receiver;
    }
    public Response execute(Request request){
        City city = request.getCommand().getCity();
        TypeOfAnswer status = receiver.addIfMin(city);
        return new Response(status);
    }
}
