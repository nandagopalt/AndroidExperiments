package com.knowledge.android.mvpdaggerexample;

/**
 * Created by Nandagopal T on 2/27/2017.
 */

public class GreetServiceImpl implements IGreetService {

    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
}
