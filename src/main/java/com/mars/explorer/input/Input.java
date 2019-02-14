package com.mars.explorer.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Parses the users input.
 *
 * The class takes the arguments provided to the program
 * and either reads the file provided as a parameter
 * or reads the input from stdin if no file was given.
 *
 * The input is provided as stream of strings, each representing one command string.
 * The command string that should be sanitised and parsed into a command object.
 */
public class Input implements Function<String[], Stream<String>> {
    private final static Logger LOGGER = Logger.getLogger(Input.class.getName());

    /**
     * Provide user input as specified by args. In a faulty case, an empty stream is returned.
     *
     * @param args The arguments given to the program.
     * @return A stream of strings representing the input, or an empty string in a faulty case.
     */
    @Override
    public Stream<String> apply(String[] args) {
        switch (args.length) {
            case 0:
                return stdinStream();
            case 1:
                return fileStream(args[0]);
            default:
                LOGGER.severe("Invalid number of arguments. Must be either empty or one filename.");
                return Stream.empty();
        }
    }

    /**
     * Reads the provided input file asynchronously using NIO.
     */
    private Stream<String> fileStream(String filePath) {
        try {
            return Files.lines(Paths.get(filePath));
        } catch (IOException e) {
            LOGGER.severe("Could not read input: " + e.getMessage());
            return Stream.empty();
        }
    }

    /**
     * Reads input from stdin.
     * While the file's stream is inherently asynchronous, achieving the same
     * for stdin input would have been too much work.
     */
    private Stream<String> stdinStream() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();

        System.out.println("Please enter the desired commands for the toy robot simulator.");
        System.out.println("Enter one command per line.");
        System.out.println("To complete the input and start execution, type 'CTRL + D' (Unix) or 'CTRL + Z' + 'Return' (Windows).");
        System.out.println();

        while (scanner.hasNext()) {
            result.add(scanner.nextLine());
        }

        return result.stream();
    }
}
