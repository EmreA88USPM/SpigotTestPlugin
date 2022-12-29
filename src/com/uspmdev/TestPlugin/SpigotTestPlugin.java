package com.uspmdev.TestPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotTestPlugin extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        config.addDefault("youAreAwesome", true);
        config.options().copyDefaults(true);
        saveConfig();

       // Enable our class to check for new players using onPlayerJoin()
       getServer().getPluginManager().registerEvents(this, this);
    }

    // This method checks for incoming players and sends them a message
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (config.getBoolean("youAreAwesome")) {
            player.sendMessage("sen varya sen kralsin, adamsin :)");
        } else {
            player.sendMessage("Sen bir salaksin hatta senden bir bok bile olmaz >:(");
        }
    }
	//Fired when plugin is disabled
	@Override
	public void onDisable() {
		
	}
	
	public class GameHub{
		private static JavaPlugin plugin;
		
		//For other classes in our library
		public static JavaPlugin getPlugin() {
			return plugin;
		}
		
		//this method must not be used any where in the library!
		/*0public static void setPlugin(final JavaPlugin plugin) {
			MyLibrary.plugin = plugin;
		}*/
	}
	
}
