package com.mhl;

import com.mhl.factory.SingleBeanFactory;
import com.mhl.starter.BirthdayGreetingsStarter;

public class Application {
    public static void main(final String[] args) {
        final BirthdayGreetingsStarter birthdayGreetingStarter = SingleBeanFactory.getBirthdayGreetingStarter();
        birthdayGreetingStarter.run();
    }
}
