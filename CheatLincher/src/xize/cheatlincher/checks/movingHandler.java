package xize.cheatlincher.checks;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import xize.cheatlincher.CheatLincher;
import xize.cheatlincher.checks.moving.timer;

public class movingHandler {
	CheatLincher plugin;
	public movingHandler(CheatLincher plugin) {
		this.plugin = plugin;
	}
	
	public void getMoveActions() {
		if(getKey("timer")) { getListener(new timer(plugin));}
	}
	
	public boolean getKey(String path) {
		try {
			File f = new File(plugin.getDataFolder() + File.separator + "config.yml");
			if(f.exists()) {
				FileConfiguration con = YamlConfiguration.loadConfiguration(f);
				if(con.getBoolean(path)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void getListener(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, plugin);
	}

}
