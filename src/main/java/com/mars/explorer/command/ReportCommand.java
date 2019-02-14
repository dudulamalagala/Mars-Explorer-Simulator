package com.mars.explorer.command;

import com.mars.explorer.configuration.Configuration;

/**
 * Applies no transition to the robot but indicates a report should be made in the simulator's main().
 */
public class ReportCommand extends AbstractCommand {
    @Override
    public Configuration applyInternal(Configuration configuration) {
        return configuration;
    }
}
