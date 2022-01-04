package com.kloia.pages;

public class PageInitialize extends BaseClass{
    public static BestBuyPage bestBuyPage;
    public static SignInPage signInPage;

    public static void runClass(){
        bestBuyPage = new BestBuyPage();
        signInPage = new SignInPage();
    }
}
