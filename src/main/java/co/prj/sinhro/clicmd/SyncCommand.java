package co.prj.sinhro.clicmd;

import co.prj.sinhro.App;

/**
 *
 * @author dejan
 */
public final class SyncCommand extends BaseCommand {

    /**
     * Basic constructor to take App object.
     *
     * @param argApp App object.
     */
    public SyncCommand(final App argApp) {
        super(argApp);
    }

    @Override
    public String getCommand() {
        return "sync";
    }

    @Override
    public String getDescription() {
        return "Synchronises <source> and <destination> locations.";
    }

    @Override
    public void handle(final String... argArguments) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void showHelp() {
        System.out.println("<sinhro> sync <location1> <location2>");
        System.out.println("");
        System.out.println("  Copies all new files from <location1> to <location2>.");
    }

} // SyncCommand class
