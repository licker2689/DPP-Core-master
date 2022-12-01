package net.wesjd.anvilgui.version;

import net.wesjd.anvilgui.version.VersionWrapper;
import org.bukkit.Bukkit;

/**
 * Matches the server's NMS version to its {@link net.wesjd.anvilgui.version.VersionWrapper}
 *
 * @author Wesley Smith
 * @since 1.2.1
 */
public class VersionMatcher {

    /**
     * Matches the server version to it's {@link net.wesjd.anvilgui.version.VersionWrapper}
     *
     * @return The {@link net.wesjd.anvilgui.version.VersionWrapper} for this server
     * @throws IllegalStateException If the version wrapper failed to be instantiated or is unable to be found
     */
    public net.wesjd.anvilgui.version.VersionWrapper match() {
        final String serverVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].substring(1);
        try {
            return (VersionWrapper) Class.forName(getClass().getPackage().getName() + ".Wrapper" + serverVersion).newInstance();
        } catch (IllegalAccessException | InstantiationException exception) {
            throw new IllegalStateException("Failed to instantiate version wrapper for version " + serverVersion, exception);
        } catch (ClassNotFoundException exception) {
            throw new IllegalStateException("AnvilGUI does not support server version \"" + serverVersion + "\"", exception);
        }
    }

}
