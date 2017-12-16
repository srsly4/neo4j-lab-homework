package pl.agh.graphbd.commands;


import pl.agh.graphbd.Dao;
import pl.agh.graphbd.domain.Observes;
import pl.agh.graphbd.domain.Post;
import pl.agh.graphbd.domain.Rated;

public class AddRatedRelationCommand extends Command {

    @Override
    public void execute() {
        System.out.println("Enter user id ");
        Long userId = Long.parseLong(input.getLine());
        System.out.println("Enter post id: ");
        Long postId = Long.parseLong(input.getLine());
        System.out.println("Enter star count: ");
        Integer stars = Integer.parseInt(input.getLine());

        Dao.createRatedRelation(session, userId, postId, stars);
    }

    @Override
    public String getDescription() {
        return "adds a rated relation";
    }
}
