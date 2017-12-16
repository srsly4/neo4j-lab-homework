package pl.agh.graphbd.commands;


import pl.agh.graphbd.Dao;
import pl.agh.graphbd.domain.Post;
import pl.agh.graphbd.domain.User;

import java.util.Date;

public class AddPostCommand extends Command {

    @Override
    public void execute() {
        System.out.println("Enter post content:");
        String content = input.getLine();
        System.out.println("Enter post userId:");
        Long userId = Long.parseLong(input.getLine());
        System.out.println(Dao.createPost(session, content, userId).toString());
    }

    @Override
    public String getDescription() {
        return "adds post";
    }
}
