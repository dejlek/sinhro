package co.prj.sinhro.clicmd;

import co.prj.sinhro.App;

/**
 *
 * @author dejan
 */
public final class ListCommand extends BaseCommand {

    /**
     * Basic constructor to take App object.
     *
     * @param argApp App object.
     */
    public ListCommand(final App argApp) {
        super(argApp);
    }

    @Override
    public String getCommand() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "Lists all sources and destinations configured in the config file (~/.config/sinhro.conf).";
    }

    @Override
    public void handle(final String... argArguments) {
        System.out.println("LIST = TODO!");
    }

    @Override
    public void showHelp() {
        System.out.println("<sinhro> list");
        System.out.println("");
        System.out.println("  Lists all sources and destinations configured in the config file "
                + "(~/.config/sinhro.conf).");
    }

}
