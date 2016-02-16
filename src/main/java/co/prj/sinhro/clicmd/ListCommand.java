package co.prj.sinhro.clicmd;

import co.prj.sinhro.App;
import java.util.Map;
import java.util.Set;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;

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
        Ini ini = app.getIni();
        Set<Map.Entry<String, Section>> sectionSet = ini.entrySet();
        for (Map.Entry<String, Section> entry : sectionSet) {
            String name = entry.getKey();
            if (name.startsWith("loc.")) {
                name = name.replace("loc.", "");
                String type = entry.getValue().get("type");
                String desc = entry.getValue().get("desc");
                System.out.println(name + " (" + type + ") - " + desc);
            }
        }
    }

    @Override
    public void showHelp() {
        System.out.println("<sinhro> list");
        System.out.println("");
        System.out.println("  Lists all sources and destinations configured in the config file "
                + "(~/.config/sinhro.conf).");
    }

} // ListCommand class
