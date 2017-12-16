package pl.agh.graphbd.commands;

import pl.agh.graphbd.domain.User;

public class ShowUsersCommand extends Command {
    @Override
    public void execute() {
        System.out.println("All users:");
        session.loadAll(User.class, 2).forEach((user) -> {
            System.out.println(user.toString());
        });

    }

    @Override
    public String getDescription() {
        return "shows all users in db";
    }
}
