package xize.cheatlincher.checks.moving;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import xize.cheatlincher.CheatLincher;

public class Survivaltimer implements Listener {
	CheatLincher plugin;
	public Survivaltimer(CheatLincher plugin) {
		this.plugin = plugin;
	}
	
	protected static HashMap<String, Long> timer = new HashMap<String, Long>();
	
	@EventHandler
	public void checkTimer(PlayerMoveEvent e) {
			if(timer.containsKey(e.getPlayer().getName())) {
				if(System.currentTimeMillis() - timer.get(e.getPlayer().getName()) <= 20) {
					e.getPlayer().teleport(e.getFrom());
					long lvl = System.currentTimeMillis() - timer.get(e.getPlayer().getName());
					e.getPlayer().sendMessage("result: " + lvl);
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(p.hasPermission("cheatlincher.checks.timer")) {
							p.sendMessage(ChatColor.RED + "[CheatLincher] " + ChatColor.GRAY + e.getPlayer().getName() + " tried to use timer he moved inside 1 miliseconds!");
						}
					}
					timer.put(e.getPlayer().getName(), System.currentTimeMillis());
				} else {
					timer.put(e.getPlayer().getName(), System.currentTimeMillis());
				}
			} else {
				timer.put(e.getPlayer().getName(), System.currentTimeMillis());
			}
	}

}
