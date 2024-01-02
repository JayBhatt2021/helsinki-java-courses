# University of Helsinki's Java MOOCs

This repository comprises my solutions for
the [Java Programming I and Java Programming II](https://java-programming.mooc.fi/) MOOCs, offered by the University of
Helsinki. The file hierarchy in this repository has been streamlined for enhanced usability in the terminal.

## Two Types of Assignment Subdirectories

While exploring this repository, you'll encounter two distinct assignment subdirectories: those necessitating the
regular Java execution procedure and those requiring a specialized JavaFX execution process. For simplicity, these will
be referred to as the  **Java** and **JavaFX** subdirectories, respectively.

### Java Subdirectories

The majority of assignment subdirectories fall under the Java category. To execute the code in one of these directories,
follow this example:

1. Navigate to `mooc-java-programming-i/part07-Part07_08.BigYear`:

```bash
$ cd mooc-java-programming-i/part07-Part07_08.BigYear
```

2. Execute `mainProgram` (the class file **NOT** the Java file) using the `java` command:

```bash
$ java mainProgram
```

3. Interact with the program as a user.

### JavaFX Subdirectories

A subset of assignment subdirectories falls under the JavaFX category. To run the code in a JavaFX subdirectory, use the
following example as a guide. Note that there are multiple ways to manually execute JavaFX code; a quick Google search
should provide helpful insights.

1. Navigate to `mooc-java-programming-ii/part13-Part13_12.VocabularyPractice`:

```bash
$ cd mooc-java-programming-ii/part13-Part13_12.VocabularyPractice
```

2. Assuming you have `openjfx` installed, input the following command:

```bash
$ java --module-path /usr/share/openjfx/lib --add-modules javafx.controls VocabularyPracticeApplication 
```

3. Interact with the JavaFX application as a user.
