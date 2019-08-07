package com.mhl;

import com.mhl.factory.SingleBeanFactory;

public class Application {
    public static void main(final String[] args) {
        SingleBeanFactory.getBirthdayGreetingStarter().run();
    }
}
