package xize.cheatlincher;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import xize.cheatlincher.checks.blockHandler;
import xize.cheatlincher.configuration.Config;
import xize.cheatlincher.configuration.readme;

public class CheatLincher extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	private Config config = new Config(this);
	private readme Readme = new readme(this);
	private blockHandler blockhandler = new blockHandler(this);
	
	public void onEnable() {
		log.info("[CheatLincher] has been enabled!");
		blockhandler.getBlockActions();
		config.createConfig();
		Readme.createReadMe();
	}
	
	
	public void onDisable() {
		log.info("[CheatLincher] has been disabled!");
	}

}
