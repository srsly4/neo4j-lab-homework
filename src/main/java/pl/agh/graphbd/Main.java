package pl.agh.graphbd;


import org.neo4j.ogm.session.Session;
import pl.agh.graphbd.commands.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Character, Command> commandMap;
    private static InputProcessor input;
    public static void main(String[] args) {
        Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();
        input = InputProcessor.getInstance();
        commandMap = new HashMap<>();
        commandMap.put('u', new ShowUsersCommand());
        commandMap.put('a', new AddUserCommand());
        commandMap.put('o', new AddObervesRelationCommand());
        commandMap.put('f', new ShowUserRelationsCommand());

//        User testUser = new User("Test", "Testowy");
//        session.save(testUser);
//
//        System.out.println("All persons:");
//        Collection<User> users = session.loadAll(User.class);
//        users.forEach(user -> System.out.println(user.getFirstName() + ' ' + user.getLastName()));

        System.out.println("Neo4J lab homework - Szymon Piechaczek");
        commandLoop();
    }

    public static void commandLoop() {
        Character current = '\0';
        do {
            System.out.println("\nAvailable commands [press q to exit]:\n");
            commandMap.forEach((character, cmd) -> {
                System.out.println(String.format("[%c] - %s", character, cmd.getDescription()));
            });

            System.out.println("=> ");
            boolean scanned = false;
            while (!scanned || current == '\n') {
                scanned = true;
                current = input.getCharacter();
            }

            if (commandMap.keySet().contains(current)) {
                commandMap.get(current).execute();
            }

        } while (current != 'q');

    }

}
