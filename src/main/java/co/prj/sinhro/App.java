package co.prj.sinhro;

import java.util.HashMap;

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

} // App class
