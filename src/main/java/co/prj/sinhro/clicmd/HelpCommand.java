package co.prj.sinhro.clicmd;

import java.util.Collection;

/**
 *
 * @author dejan
 */
public final class HelpCommand implements CLICommand {
    /**
     * Here we have all the CLICommand objects.
     */
    private final Collection<CLICommand> commands;

    /**
     * A convenient constructor so we can pass a collection of CLICommand objects, so help can use it to show the help.
     *
     * @param argCommands A Collection<CLICommand> object.
     */
    public HelpCommand(final Collection<CLICommand> argCommands) {
        commands = argCommands;
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
            for (CLICommand cmd : commands) {
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
        for (CLICommand cliCommand : commands) {
            System.out.println("     " + cliCommand.getCommand() + " : " + cliCommand.getDescription());
        }
    } // showHelp() method


} // HelpCommand class
