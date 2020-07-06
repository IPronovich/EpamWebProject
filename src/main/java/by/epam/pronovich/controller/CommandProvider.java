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
        commandBox.put(ADD_PRODUCT_FORM, new ProductAdderForm());
        commandBox.put(ADD_PRODUCT, new ProductAdder());
        commandBox.put(CHANGE_PRODUCT_INFO_FORM, new ProductInfoChangeForm());
        commandBox.put(SAVE_PRODUCT_CHANGES, new ProductChangesSaver());
        commandBox.put(AUTHENTICATION, new Authentication());
        commandBox.put(REGISTRATION, new Registration());
        commandBox.put(REVIEW_FORM, new ReviewForm());
        commandBox.put(ADD_REVIEW, new ReviewAdder());
        commandBox.put(CATALOG, new CatalogShower());
        commandBox.put(REVIEW, new ReviewShower());
        commandBox.put(PRODUCTINFO, new ProductInfoShower());
        commandBox.put(OLENER, new StartPageLoading());
        commandBox.put(PRODUCT, new ProductsShower());
        commandBox.put(LOKALIZATION, new Lokalization());
        commandBox.put(HISTORY, new History());
        commandBox.put(ADD_TO_BASKET, new ToBasketAdder());
        commandBox.put(DELETE_FROM_BASKET, new FromBasketDeleter());
        commandBox.put(CHECKOUT, new Checkout());
        commandBox.put(UPDATE_STATUS, new StatusUpdating());
        commandBox.put(SHOW_ORDERS, new OrdersShower());
        commandBox.put(SEARCH, new Search());
    }


    public Command getCommand(String name) {
        Command command = null;
        try {
            CommandName commandName = valueOf(name.toUpperCase());
            command = commandBox.get(commandName);
        } catch (Exception e) {
            command = commandBox.get(WRONG_REQUEST);
        }
        return command;
    }
}
