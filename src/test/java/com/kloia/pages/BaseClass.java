package com.kloia.pages;

import net.serenitybdd.core.pages.PageObject;

public class BaseClass extends PageObject {

    public static void setUp(){
        PageInitialize.runClass();
    }
}
