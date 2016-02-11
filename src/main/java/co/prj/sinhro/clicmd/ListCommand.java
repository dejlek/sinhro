package co.prj.sinhro.clicmd;

/**
 *
 * @author dejan
 */
public final class ListCommand implements CLICommand {

    @Override
    public String getCommand() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "Lists all sources and destinations configured in the config file (~/.config/sinhro.conf).";
    }

    @Override
    public void handle(String... argArguments) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void showHelp() {
        System.out.println("<sinhro> list");
        System.out.println("");
        System.out.println("  Lists all sources and destinations configured in the config file "
                + "(~/.config/sinhro.conf).");
    }


}
