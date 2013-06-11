package xize.cheatlincher.checks.blocks;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import xize.cheatlincher.CheatLincher;

public class fastplace_SurvivalCheck implements Listener {
	CheatLincher plugin;
	public fastplace_SurvivalCheck(CheatLincher plugin) {
		this.plugin = plugin;
	}

	protected static HashMap<String, Long> placeTime = new HashMap<String, Long>();

	@EventHandler
	public void checkFastPlace(BlockPlaceEvent e) {
		if(e.getPlayer().getGameMode() == GameMode.SURVIVAL || e.getPlayer().getGameMode() == GameMode.ADVENTURE) {
			if(placeTime.containsKey(e.getPlayer().getName())) {
				if(System.currentTimeMillis() - placeTime.get(e.getPlayer().getName()) <= 140) {
					long lvl = System.currentTimeMillis() - placeTime.get(e.getPlayer().getName()) ;
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(p.hasPermission("cheatlincher.checks.fastplace")) {
							p.sendMessage(ChatColor.RED + "[CheatLincher] " + ChatColor.GRAY + e.getPlayer().getName() + " tried to place a block faster than normal SurvivalBlockPlace VL: " + lvl);
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

}
