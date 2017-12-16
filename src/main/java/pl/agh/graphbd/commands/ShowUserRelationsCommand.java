package pl.agh.graphbd.commands;


import pl.agh.graphbd.Dao;
import pl.agh.graphbd.domain.Observes;
import pl.agh.graphbd.domain.User;

import java.util.Collection;

public class ShowUserRelationsCommand extends Command {
    @Override
    public void execute() {
        System.out.println("Enter user id:");
        Long userId = Long.parseLong(input.getLine());

        User user = session.load(User.class, userId);

        System.out.println("Observed users:");
        Collection<Observes> observed = user.getObservedUsers();
        observed.forEach((observes) -> System.out.println(observes.toString()));

        System.out.println("Observers:");
        user.getObservers().forEach((observes -> System.out.println(observes.toString())));
    }

    @Override
    public String getDescription() {
        return "shows user relations";
    }
}
