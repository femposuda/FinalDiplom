package org.example;

import static java.util.regex.Pattern.matches;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameString() {
        return name.length() <= 19
                && name.length() >= 3
                && matches("\\S+ \\S+", name);
    }
}
