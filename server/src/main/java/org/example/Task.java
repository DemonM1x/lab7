package org.example;

import java.util.concurrent.Callable;

public class Task  {

    private final CommandManager commandManager;
    private final Request request;

    public Task(CommandManager commandManager, Request aRequest) {
        this.commandManager = commandManager;
        request = aRequest;
    }

    public Response call() {
        return commandManager.execute(request);
    }
}
