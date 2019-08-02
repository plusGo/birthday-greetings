package com.mhl;

import com.mhl.factory.BeanFactory;
import com.mhl.starter.BirthdayGreetingsStarter;

public class Application {
    public static void main(final String[] args) {
        final BirthdayGreetingsStarter birthdayGreetingStarter = BeanFactory.getBirthdayGreetingStarter();
        birthdayGreetingStarter.run();
    }
}
