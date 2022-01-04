package com.kloia.stepDefs;

import com.kloia.pages.BaseClass;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void start(){
        BaseClass.setUp();
    }
}
