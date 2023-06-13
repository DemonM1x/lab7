package org.example.commands;

import org.example.Receiver;
import org.example.Request;
import org.example.Response;
import org.example.TypeOfAnswer;

public class LoginUserCommand extends AbstractCommand implements Execute{
    private final Receiver receiver;

    public LoginUserCommand(Receiver aReceiver) {
        super("login", "authorization user in system", "login, password",true);
        receiver = aReceiver;
    }

    @Override
    public Response execute(Request aRequest) {
        String username = aRequest.getSession().getName();
        String password = aRequest.getSession().getPassword();
        System.out.println(username +" " + password);
        return receiver.loginUser(username, password)
                ? new Response(TypeOfAnswer.SUCCESSFUL)
                : new Response(TypeOfAnswer.NOTMATCH);
    }
}
