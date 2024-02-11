package cz.darklabs.labscore.plugin;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public abstract class CorePlugin extends JavaPlugin implements Listener {
	/**
	 * The instance of this plugin
	 */
	private static volatile CorePlugin instance;

	/**
	 * Shortcut for getDescription().getVersion()
	 */
	@Getter
	private static String version;

	/**
	 * Shortcut for getName()
	 */
	@Getter
	private static String named;

	/**
	 * Shortcut for getFile()
	 */
	@Getter
	private static File source;

	/**
	 * Shortcut for getDataFolder()
	 */
	@Getter
	private static File data;

	/**
	 * Returns the instance of {@link CorePlugin}.
	 * <p>
	 * It is recommended to override this in your own {@link CorePlugin}
	 * implementation, so you will get the instance of that, directly.
	 *
	 * @return this instance
	 */
	public static CorePlugin getInstance() {
		if (instance == null) {
			try {
				instance = JavaPlugin.getPlugin(CorePlugin.class);

			} catch (final IllegalStateException ex) {
				if (Bukkit.getPluginManager().getPlugin("PlugMan") != null)
					Bukkit.getLogger().severe("Failed to get instance of the plugin, if you reloaded using PlugMan you need to do a clean restart instead.");

				throw ex;
			}

			Objects.requireNonNull(instance, "Cannot get a new instance! Have you reloaded?");
		}

		return instance;
	}

	/**
	 * Get if the instance that is used across the library has been set. Normally it
	 * is always set, except for testing.
	 *
	 * @return if the instance has been set.
	 */
	public static final boolean hasInstance() {
		return instance != null;
	}

	@Override
	public void onLoad() {
		// Set the instance
		try {
			getInstance();
		} catch (final Throwable ex) {
			instance = this;
		}

		// Cache results for best performance
		version = instance.getDescription().getVersion();
		named = instance.getDataFolder().getName();
		source = instance.getFile();
		data = instance.getDataFolder();

		this.onCoreLoad();
	}

	@Override
	public void onEnable() {

		this.onCoreEnable();
	}

	@Override
	public void onDisable() {

		this.onCoreDisable();
	}

	/**
	 * Return the corresponding major Java version such as 8 for Java 1.8, or 11 for Java 11.
	 *
	 * @return the major Java version
	 */
	public static int getJavaVersion() {
		String version = System.getProperty("java.version");

		if (version.startsWith("1."))
			version = version.substring(2, 3);

		else {
			final int dot = version.indexOf(".");

			if (dot != -1)
				version = version.substring(0, dot);
		}

		if (version.contains("-"))
			version = version.split("\\-")[0];

		return Integer.parseInt(version);
	}

	/**
	 * Called before the plugin is started, see {@link JavaPlugin#onLoad()}
	 */
	protected void onCoreLoad() {

	}

	/**
	 * The main loading method, called when we are ready to load
	 */
	protected abstract void onCoreEnable();

	/**
	 * The main method called when we are about to shut down
	 */
	protected void onCoreDisable() {
	}

	/**
	 * Invoked before settings were reloaded.
	 */
	protected void onCorePreReload() {
	}

	/**
	 * Invoked after settings were reloaded.
	 */
	protected void onCoreReload() {
	}
}
