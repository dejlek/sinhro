package co.prj.sinhro.clicmd;

import co.prj.sinhro.App;

/**
 *
 * @author dejan
 */
public final class HelpCommand extends BaseCommand {

    /**
     * Basic constructor to take App object.
     *
     * @param argApp App object.
     */
    public HelpCommand(final App argApp) {
        super(argApp);
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Gives the application help.";
    }

    @Override
    public void handle(final String... argArguments) {
        if (argArguments == null) {
            return;
        }
        if (argArguments.length <= 1) {
            showHelp();
        } else {
            for (CLICommand cmd : app.getCommands()) {
                if (cmd.getCommand().equals(argArguments[1])) {
                    cmd.showHelp();
                }
            }
        }
    } // handle() method

    /**
     * Prints simple help.
     */
    @Override
    public void showHelp() {
        System.out.println("<application> <command> [arg1 [arg2 [...]]]");
        System.out.println("Supported commands:");
        for (CLICommand cliCommand : app.getCommands()) {
            System.out.println("     " + cliCommand.getCommand() + " : " + cliCommand.getDescription());
        }
    } // showHelp() method

} // HelpCommand class
