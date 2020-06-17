package by.epam.pronovich.controller;


import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.controller.command.CommandName;
import by.epam.pronovich.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

import static by.epam.pronovich.controller.command.CommandName.*;

public class CommandProvider {

    private final Map<CommandName, Command> commandBox = new HashMap<>();


    public CommandProvider() {
        commandBox.put(WRONG_REQUEST, new WrongRequest());
        commandBox.put(LOGOUT, new Logout());
        commandBox.put(USER_CHANGE_INFO_FORM, new UserChangeInfoForm());
        commandBox.put(SAVE_USER_CHANGES, new SaveUserChanges());
        commandBox.put(ADD_PRODUCT_FORM, new AddProductForm());
        commandBox.put(ADD_PRODUCT, new AddProduct());
        commandBox.put(CHANGE_PRODUCT_INFO_FORM, new ProductInfoChangeForm());
        commandBox.put(SAVE_PRODUCT_CHANGES, new SaveProductChanges());
        commandBox.put(AUTORIZATION, new Autorization());
        commandBox.put(REGISTRATION, new Registration());
        commandBox.put(REVIEW_FORM, new ReviewForm());
        commandBox.put(ADD_REVIEW, new AddReview());
        commandBox.put(CATALOG, new CatalogShowing());
        commandBox.put(REVIEW, new ReviewShowing());
        commandBox.put(PRODUCTINFO, new ProductInfoShowing());
        commandBox.put(OLENER, new StartPageLoading());
        commandBox.put(PRODUCT, new ProductsShowing());
        commandBox.put(LOKALIZATION, new Lokalization());
    }


    public Command getCommand(String name) {
        Command command = null;
        try {
            CommandName commandName = valueOf(name.toUpperCase());
            command = commandBox.get(commandName);
        } catch (Exception e) {
            System.out.println("WRONG COMMAND");
            command = commandBox.get(WRONG_REQUEST);
        }
        return command;
    }
}
