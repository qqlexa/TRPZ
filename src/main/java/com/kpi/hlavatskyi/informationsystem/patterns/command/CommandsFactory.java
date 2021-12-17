package com.kpi.hlavatskyi.informationsystem.patterns.command;

import jakarta.servlet.http.HttpServletRequest;

public class CommandsFactory {

    private CommandsFactory() {}

    public static Command getCommand(HttpServletRequest request) {
        String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
        for (Commands command : Commands.values()) {
            if (command.getPath().equals(url)) {
                return command.getCommand();
            }
        }
        throw new NotFoundCommandException("Not found Command for " + url);
    }

}
