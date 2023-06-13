package org.example.commands;

import org.example.Receiver;
import org.example.Request;
import org.example.Response;
import org.example.TypeOfAnswer;

public class RegisterUserCommand extends AbstractCommand implements Execute{
    private final Receiver receiver;

    public RegisterUserCommand(Receiver aReceiver) {
        super("register", "add new user to system", "login, password", true);
        receiver = aReceiver;
    }

    @Override
    public Response execute(Request aRequest) {
        String username = aRequest.getSession().getName();
        String password = aRequest.getSession().getPassword();
        if (!receiver.loginUser(username, password)) {
            if (receiver.registerUser(username, password)) return new Response(TypeOfAnswer.SUCCESSFUL);
        }
        return new Response(TypeOfAnswer.ALREADYREGISTERED);
    }
}
