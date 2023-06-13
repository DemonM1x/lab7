package org.example.commands;

import org.example.Receiver;
import org.example.Request;
import org.example.Response;

public class ClearCommand extends AbstractCommand implements Execute {
    private final Receiver receiver;

    public ClearCommand(Receiver receiver) {
        super("clear", "clear the collection" , "", true);
        this.receiver = receiver;
    }


    @Override
    public Response execute(Request request) {
        return new Response(receiver.clearCollection(request.getSession().getName()));
    }
}
