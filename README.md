# Mars Explorer Simulator Challenge

A simple simulator representing a mars explorer moving on a tabletop.

For further explanation of design an approach see `SOLUTION.md`.

## Example usage

Invoke the mars explorer simulator as follows:

```sh
java -jar mars-explorer-<version>.jar [commands.txt]
```

The simulator can be invoked with a plain text file containing commands, one command per line.
If no command file is given, commands are read form `sdtin`.

For a specification of the commands and on how the robot reacts to them, see `PROBLEM.md`.

## Getting Started

### Build

To build the project, just run `mvn clean package`.
The built JAR along with sample inputs can be found in the `./target/` directory.

### Test

Building with `mvn clean package` already runs the unit tests.

`mvn clean verify` would also run integration tests, but none are present as of yet.

