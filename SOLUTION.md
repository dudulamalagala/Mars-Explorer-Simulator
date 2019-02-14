# Solution explanation

## Approach

- The robot is the central object of the program, getting the boundaries of the tabletop injected.
- Transitions of the robot ar encapsulated via the command pattern.
- All processing steps from reading a command string provided by the user
  to execution of that very command and/or printing a report to stdout
  are designed as a pipeline using the Java Streams API.

## Design decisions

- No tests for
    - Library wrappers (e.g. stdio & file read)
    - data objects (e.g. in configuration package)
- Errors are rather only logged and fallback actions are taken.
  The Java Stream API does not provide exception handling, like e.g. RxJava.
- Integration tests:
    - No sophisticated integration tests with mocks etc.
    - The existing integration test was simple enough to be run along the other JUnit test.
