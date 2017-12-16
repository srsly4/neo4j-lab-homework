package pl.agh.graphbd.commands;


public class TruncateDatabaseCommand extends Command {
    @Override
    public void execute() {
        session.purgeDatabase();
        System.out.println("Done.");
    }

    @Override
    public String getDescription() {
        return "destroys all data";
    }
}
