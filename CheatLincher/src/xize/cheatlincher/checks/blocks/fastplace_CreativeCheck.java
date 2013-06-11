package xize.cheatlincher.checks.blocks;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import xize.cheatlincher.CheatLincher;

public class fastplace_CreativeCheck implements Listener {
	CheatLincher plugin;
	public fastplace_CreativeCheck(CheatLincher plugin) {
		this.plugin = plugin;
	}

	protected static HashMap<String, Long> placeTime = new HashMap<String, Long>();

	@EventHandler
	public void fastplace(BlockPlaceEvent e) {
		if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
			if(placeTime.containsKey(e.getPlayer().getName())) {
				if(System.currentTimeMillis() - placeTime.get(e.getPlayer().getName()) <= 61) {
					long lvl = System.currentTimeMillis() - placeTime.get(e.getPlayer().getName()) ;
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(p.hasPermission("cheatlincher.checks.fastplace")) {
							p.sendMessage(ChatColor.RED + "[CheatLincher] " + ChatColor.GRAY + e.getPlayer().getName() + " tried to place a block faster than normal CreativeBlockPlace VL: " + lvl);
						}
					}
					placeTime.put(e.getPlayer().getName(), System.currentTimeMillis());
					e.setCancelled(true);
				} else {
					placeTime.put(e.getPlayer().getName(), System.currentTimeMillis());
				}
			} else {
				placeTime.put(e.getPlayer().getName(), System.currentTimeMillis());
			}
		}
	}
	
	@EventHandler
	public void quit(PlayerQuitEvent e) {
		if(placeTime.containsKey(e.getPlayer().getName())) {
			placeTime.remove(e.getPlayer().getName());
		}
	}
	
	@EventHandler
	public void quit(PlayerKickEvent e) {
		if(placeTime.containsKey(e.getPlayer().getName())) {
			placeTime.remove(e.getPlayer().getName());
		}
	}

}
