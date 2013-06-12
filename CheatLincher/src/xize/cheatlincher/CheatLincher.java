package xize.cheatlincher;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import xize.cheatlincher.checks.blockHandler;
import xize.cheatlincher.checks.movingHandler;
import xize.cheatlincher.configuration.Config;
import xize.cheatlincher.configuration.readme;

public class CheatLincher extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	private Config config = new Config(this);
	private readme Readme = new readme(this);
	private blockHandler blockhandler = new blockHandler(this);
	private movingHandler movehandler = new movingHandler(this);
	
	public void onEnable() {
		log.info("[CheatLincher] has been enabled!");
		blockhandler.getBlockActions();
		movehandler.getMoveActions();
		config.createConfig();
		Readme.createReadMe();
	}
	
	
	public void onDisable() {
		log.info("[CheatLincher] has been disabled!");
	}

}
