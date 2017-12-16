package pl.agh.graphbd.commands;


import org.neo4j.ogm.model.Result;
import pl.agh.graphbd.Dao;

import java.util.Collection;
import java.util.Map;

public class ShowNodeRelationsCommmand extends Command {
    @Override
    public void execute() {
        System.out.println("Enter node id: ");
        Long id = Long.parseLong(input.getLine());

        Result res = Dao.getRelations(session, id);
        res.forEach(relation -> {
            System.out.println("-----------");
            System.out.println("-----------");
            System.out.println(String.format("[A:%s]-[R:%s]-[B:%s]",
                    ((String[])relation.get("alabel"))[0],
                    relation.get("rtype").toString(),
                    ((String[])relation.get("blabel"))[0]
                    ));
            System.out.println("-----A-----");
            System.out.println(relation.get("a").toString());
            System.out.println("-----R-----");
            System.out.println(relation.get("r").toString());
            System.out.println("-----B-----");
            System.out.println(relation.get("b").toString());
            System.out.println("-----------");
            System.out.println("-----------");
        });

    }

    @Override
    public String getDescription() {
        return "shows any nodes connected with this node id";
    }
}
