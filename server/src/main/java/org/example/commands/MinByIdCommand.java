package org.example.commands;

import org.example.Receiver;
import org.example.Request;
import org.example.Response;
import org.example.TypeOfAnswer;

import java.util.Collections;

public class MinByIdCommand extends AbstractCommand implements Execute {
    private final Receiver receiver;
    public MinByIdCommand(Receiver receiver){
        super("min_by_id", "outputs the birthday of the governor from the collection, the value of the id field of which is the minimum", "", true);
        this.receiver = receiver;

    }

    public Response execute(Request request){
        if (receiver.getMainCollection().size() != 0) {
            return new Response("governor:\nbirthday: " + Collections.min(receiver.getMainCollection()).getGovernor().getBirthday().toString(), TypeOfAnswer.SUCCESSFUL);
        }
        else return new Response(TypeOfAnswer.EMPTYCOLLECTION);
    }

}
