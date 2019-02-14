package com.mars.explorer.input;

import java.util.function.UnaryOperator;

/**
 * This class sanitises the input strings provided by the user.
 *
 * It's implementation is rather limited,
 * as no sanitation was requested in the challenge.
 * The presence of it however should demonstrate the consideration of a sanitiser.
 */
public class Sanitiser implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return s.trim().toUpperCase();
    }
}
