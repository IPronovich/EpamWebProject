package by.epam.pronovich.controller.command.impl;

import by.epam.pronovich.controller.CommandProvider;
import by.epam.pronovich.controller.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WrongRequest implements Command {
    Logger logger = LoggerFactory.getLogger(WrongRequest.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) throws ServletException, IOException {
        logger.warn("Request with wrong commant parameter");
    }
}
