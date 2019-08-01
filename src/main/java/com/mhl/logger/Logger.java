package com.mhl.logger;

public class Logger {
    public void error(final String errorLog) {
        System.out.print(String.format("error:log=>%s", errorLog));
    }

    public void error(final String errorLog, final Exception exception) {
        System.out.print(String.format("error:log=>%s", errorLog));
        exception.printStackTrace();
    }
}
