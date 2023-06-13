package org.example.commands;

import org.example.Receiver;
import org.example.Request;
import org.example.Response;
import org.example.collection.City;

public class RemoveGreaterCommand extends AbstractCommand implements Execute {
    private final Receiver receiver;

    public RemoveGreaterCommand(Receiver receiver) {
        super("remove_greater", "remove from the collection all elements greater than the given", "{element}", true);
        this.receiver = receiver;

    }
    @Override
    public Response execute(Request request) {
        City city = request.getCommand().getCity();
        return new Response(receiver.removeGreater(city, request.getSession().getName()));
    }
}
