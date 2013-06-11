package xize.cheatlincher.checks;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import xize.cheatlincher.CheatLincher;
import xize.cheatlincher.checks.blocks.fastplace_CreativeCheck;
import xize.cheatlincher.checks.blocks.fastplace_SurvivalCheck;

public class blockHandler {
	CheatLincher plugin;
	public blockHandler(CheatLincher plugin) {
		this.plugin = plugin;
	}
	
	public void getBlockActions() {
		if(getKey("fastplace-Survival")) { getListener(new fastplace_SurvivalCheck(plugin)); }
		if(getKey("fastplace-Creative")) { getListener(new fastplace_CreativeCheck(plugin)); }
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
