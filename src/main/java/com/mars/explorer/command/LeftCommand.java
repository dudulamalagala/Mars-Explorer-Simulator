package com.mars.explorer.command;

import com.mars.explorer.configuration.Configuration;

public class LeftCommand extends AbstractCommand {
    @Override
    public Configuration applyInternal(Configuration configuration) {
        return new Configuration(configuration.position(), configuration.orientation().left());
    }
}
