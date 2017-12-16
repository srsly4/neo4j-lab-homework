package pl.agh.graphbd.commands;


import pl.agh.graphbd.Dao;
import pl.agh.graphbd.domain.User;

public class AddUserCommand extends Command {
    @Override
    public void execute() {
        System.out.println("Enter first name: ");
        String firstName = input.getLine();
        System.out.println("Enter last name: ");
        String lastName = input.getLine();

        User user = Dao.createUser(session, firstName, lastName);
        System.out.println(user.toString());
    }

    @Override
    public String getDescription() {
        return "adds a new user to the database";
    }
}
