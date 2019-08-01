package com.mhl.logger;

public class Logger {
    public void error(final String errorLog) {
        System.out.println(String.format("error:log=>%s", errorLog));
    }

    public void error(final String errorLog, final Exception exception) {
        this.error(errorLog);
        exception.printStackTrace();
    }
}
