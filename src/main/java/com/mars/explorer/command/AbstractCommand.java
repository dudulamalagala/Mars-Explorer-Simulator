package com.mars.explorer.command;

import com.mars.explorer.configuration.Configuration;

/**
 * The abstract command implements the fact,
 * that most commands on a non-placed robot cause no transition at all.
 * In order for implementors of the Command interface not to check
 * for that situation, this abstract class does the job.
 */
abstract class AbstractCommand implements Command {
    @Override
    public final Configuration apply(Configuration configuration) {
        if (configuration == null) {
            return null;
        }
        return this.applyInternal(configuration);
    }

    /**
     * Transform the input configuration, given the robot is placed.
     *
     * @param configuration The input configuration.
     * @return The altered configuration.
     */
    protected abstract Configuration applyInternal(Configuration configuration);
}
