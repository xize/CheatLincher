package xize.cheatlincher.configuration;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import xize.cheatlincher.CheatLincher;

public class Config {
	CheatLincher plugin;
	public Config(CheatLincher plugin) {
		this.plugin = plugin;
	}
	
	Logger log = Logger.getLogger("Minecraft");
	
	public void createConfig() {
		try {
			File f = new File(plugin.getDataFolder() + File.separator + "config.yml");
			if(f.exists()) {
				log.info("[CheatLincher] config.yml found!");
			} else {
				FileConfiguration con = YamlConfiguration.loadConfiguration(f);
				con.set("ignore-ops", true);
				con.set("survival-Fly", true);
				con.set("creative-Fly", true);
				con.set("timer", true);
				con.set("movemorepackets", true);
				con.set("fastBreak-Survival", true);
				con.set("fastBreak-Creative", true);
				con.set("fastplace-Survival", true);
				con.set("fastplace-Creative", true);
				con.set("SpambotCheck-pwnage", true);
				con.set("SpambotCheck-flood", true);
				con.set("SpambotCheck-humanSpam", true);
				con.save(f);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
