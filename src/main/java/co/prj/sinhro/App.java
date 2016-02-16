package co.prj.sinhro;

import co.prj.sinhro.clicmd.CLICommand;
import java.util.Collection;
import java.util.HashMap;
import org.ini4j.Ini;

/**
 * A class to hold (global) application state.
 * @author dejan
 */
public final class App {

    /**
     * Here we store application configuration (from the Ini file).
     */
    private final HashMap<String, Object> config;

    /**
     * Here we keep all our CLICommand objects.
     */
    private Collection<CLICommand> commands;

    /**
     * INI file configuration (parsed sinhro.conf file).
     */
    private Ini ini;

    /**
     * Default constructor.
     */
    public App() {
        config = new HashMap<>();
    }

    // :::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // ::::: Accessors
    // :::::::::::::::::::::::::::::::::::::::::::::::::::::::

    /**
     * Use this method to set a value of a specific configuration "variable".
     *
     * @param argKey Name of the variable (String).
     * @param argValue Value of the variable.
     */
    public void set(final String argKey, final Object argValue) {
        config.put(argKey, argValue);
    }

    /**
     * Convenience method which can be used when we need key-spaces.
     *
     * It concatenates all the argKeys strings into a single String object, and use that object a key.
     *
     * Example:
     *
     * <pre>
     *    set(filePathString, "customer", "department", "salaries");
     * </pre>
     * In this example, we are actually creating the "customer.department.salaries" key, and using that String object
     * as a key to put the filePathString object into the `config` map.
     *
     * @param argValue Object to put into the `config` map.
     * @param argKeys Parts of the key used.
     */
    public void set(final Object argValue, final String... argKeys) {
        config.put(String.join(".", argKeys), argValue);
    }

    /**
     * Get a configuration variable value.
     * @param argKey Name of the variable.
     *
     * @return Actual value, if the key is set, null otherwise.
     */
    public Object get(final String argKey) {
        return config.get(argKey);
    }

    /**
     * Returns a collection of CLICommand objects.
     *
     * @return Collection<CLICommand> object with all the commands in it.
     */
    public Collection<CLICommand> getCommands() {
        return commands;
    }

    /**
     * Use this method to set the Collection<CLICommand> commands collection.
     *
     * @param argCommands Collection<CLICommand> object.
     */
    public void setCommands(final Collection<CLICommand> argCommands) {
        commands = argCommands;
    }

    /**
     * Use this method to obtained parsed INI file data.
     *
     * @return Ini object.
     */
    public Ini getIni() {
        return ini;
    }

    /**
     * Use this method to set the parsed INI data.
     *
     * @param argIni Ini object.
     */
    public void setIni(final Ini argIni) {
        ini = argIni;
    }

} // App class
