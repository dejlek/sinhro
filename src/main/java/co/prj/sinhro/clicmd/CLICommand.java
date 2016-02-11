package co.prj.sinhro.clicmd;

/**
 * An interface for CLI commands.
 *
 * @author dejan
 */
public interface CLICommand {
    /**
     * Use this method to obtain the name of the command.
     *
     * @return A String object containing the name.
     */
    String getCommand();

    /**
     * Use this method to obtain the short description of the command (used in the help output).
     *
     * @return String object which contains the short description.
     */
    String getDescription();

    /**
     * Finally, when you want to execute particular CLI command, use this method.
     * @param argArguments List of arguments after the command.
     */
    void handle(String... argArguments);

    /**
     * Print out command's help.
     */
    void showHelp();

} // CLICommand interface
