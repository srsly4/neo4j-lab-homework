package pl.agh.graphbd.commands;


import pl.agh.graphbd.Dao;
import pl.agh.graphbd.domain.Observes;

public class AddObervesRelationCommand extends Command {

    @Override
    public void execute() {
        System.out.println("Enter user id (the one which knows the second): ");
        Long userId = Long.parseLong(input.getLine());
        System.out.println("Enter second user id: ");
        Long secondUserId = Long.parseLong(input.getLine());

        Observes observes = Dao.createObservesRelation(session, userId, secondUserId);

        if (observes == null) {
            System.out.println("One of entered IDs doesn\'t exists.");
            return;
        }
        System.out.println(observes.toString());
    }

    @Override
    public String getDescription() {
        return "adds an observers relation";
    }
}
