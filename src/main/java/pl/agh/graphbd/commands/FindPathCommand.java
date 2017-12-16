package pl.agh.graphbd.commands;


import org.neo4j.ogm.model.Result;
import pl.agh.graphbd.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindPathCommand extends Command {
    @Override
    public void execute() {
        Long aId, bId;
        System.out.println("Enter A node id: ");
        aId = Long.parseLong(input.getLine());
        System.out.println("Enter B node id: ");
        bId = Long.parseLong(input.getLine());

        Result res = Dao.getPathBetweenNodes(session, aId, bId);

        for (Map<String, Object> path : res) {
            System.out.println("Shortest path as below: ");
            System.out.println("########################");

            ArrayList<Object> nodes = (ArrayList<Object>) path.get("npath");
            ArrayList<Object> relations = (ArrayList<Object>) path.get("rpath");

            for (int i = 0; i < nodes.size(); i++) {
                System.out.println("## NODE " + i + " ##");
                System.out.println(nodes.get(i).toString());

                if (i < relations.size()) {
                    System.out.println("## RELATION " + i + " ##");
                    System.out.println(relations.get(i).toString());
                }
            }

            System.out.println("########################");
            System.out.println("########################");
        }
    }

    @Override
    public String getDescription() {
        return "finds shortest path between two nodes id";
    }
}
