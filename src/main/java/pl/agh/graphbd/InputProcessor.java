package pl.agh.graphbd;


import java.util.Scanner;

public class InputProcessor {

    private Scanner scanner;
    private InputProcessor() {
        scanner = new Scanner(System.in);
    }

    public Character getCharacter() {
        return scanner.nextLine().charAt(0);
    }

    public String getLine() {
        return scanner.nextLine();
    }

    private static InputProcessor instance;
    public static InputProcessor getInstance() {
        if (instance == null) {
            instance = new InputProcessor();
        }
        return instance;
    }
}
