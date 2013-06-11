package xize.cheatlincher.configuration;

import java.io.File;
import java.io.FileWriter;

import xize.cheatlincher.CheatLincher;

public class readme {
	CheatLincher plugin;
	public readme(CheatLincher plugin) {
		this.plugin = plugin;
	}
	
	public void createReadMe() {
		try {
			File f = new File(plugin.getDataFolder() + File.separator + "readme.txt");
			if(f.exists()) {
				f.delete();
				FileWriter w = new FileWriter(f, false);
				w.write("This is CheatLincher, a new anti cheat plugin coded by Xeph0re/Xize which helps you to protect your server against malicious hackers\n");
				w.write("the idea for this plugin is to not use any nms code which break by each update so we use only the Bukkit api to get the max stabillity based on the api\n");
				w.write("\n");
				w.write("=update log=\n");
				w.write("- AntiPwnage (join leave spam, flood spam)\n");
				w.write("- AntiSpambot(Flooding)\n");
				w.write("- humanity spam\n");
				w.write("- fly vertical, also with vclip check\n");
				w.write("- fly movemorepackets\n");
				w.write("- fastbreak check without enchant check\n");
				w.write("- check whenever a player use freecam to open chest through walls as not passable\n");
				w.write("- fastplace check\n");
				w.write("- egg spam check\n");
				w.write("- godmode check (freecam)\n");
				w.write("- godmode check (old food exploit)\n");
				w.write("- spider check\n");
				w.write("- derpmode check\n");
				w.write("- timer check\n");
				w.write("- nofall check\n");
				w.write("- pvp KnockBack/aurora check (when the player has no enchant with pitch check)\n");
				w.write("- pvp check whenever a player moves when he gets hitted");
				w.close();
			} else {
				FileWriter w = new FileWriter(f, false);
				w.write("This is CheatLincher, a new anti cheat plugin coded by Xeph0re/Xize which helps you to protect your server against malicious hackers\n");
				w.write("the idea for this plugin is to not use any nms code which break by each update so we use only the Bukkit api to get the max stabillity based on the api\n");
				w.write("\n");
				w.write("=update log=\n");
				w.write("- AntiPwnage (join leave spam, flood spam)\n");
				w.write("- AntiSpambot(Flooding)\n");
				w.write("- humanity spam\n");
				w.write("- fly vertical, also with vclip check\n");
				w.write("- fly movemorepackets\n");
				w.write("- fastbreak check without enchant check\n");
				w.write("- check whenever a player use freecam to open chest through walls as not passable\n");
				w.write("- fastplace check\n");
				w.write("- egg spam check\n");
				w.write("- godmode check (freecam)\n");
				w.write("- godmode check (old food exploit)\n");
				w.write("- spider check\n");
				w.write("- derpmode check\n");
				w.write("- timer check\n");
				w.write("- nofall check\n");
				w.write("- pvp KnockBack/aurora check (when the player has no enchant with pitch check)\n");
				w.write("- pvp check whenever a player moves when he gets hitted");
				w.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
