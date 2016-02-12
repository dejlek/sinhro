package co.prj.sinhro.clicmd;

import co.prj.sinhro.App;

/**
 *
 * @author dejan
 */
public abstract class BaseCommand implements CLICommand {
    /**
     * An internal reference to the App object.
     */
    protected final App app;

    /**
     * A constructor you most likely want to use all the time...
     *
     * @param argApp An App object.
     */
    public BaseCommand(final App argApp) {
        app = argApp;
    }

} // BaseCommand class (abstract)
