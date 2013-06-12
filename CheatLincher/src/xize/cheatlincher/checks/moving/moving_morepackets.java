package xize.cheatlincher.checks.moving;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import xize.cheatlincher.CheatLincher;

public class moving_morepackets implements Listener {
	CheatLincher plugin;
	public moving_morepackets(CheatLincher plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void morepackets(PlayerMoveEvent e) {
		if(e.getTo().getX() - e.getFrom().getX() > 1 || e.getFrom().getX() - e.getTo().getX() > 1 || e.getTo().getZ() - e.getFrom().getZ() > 1 || e.getFrom().getZ() - e.getTo().getZ() > 1) {
			Location loc = e.getPlayer().getLocation();
			if(loc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
				e.getPlayer().teleport(loc);
				double lvl = e.getFrom().distance(loc);
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(p.hasPermission("cheatlincher.checks.movingmorepackets")) {
						p.sendMessage(ChatColor.RED + "[CheatLincher] " + ChatColor.GRAY + "player " + e.getPlayer().getName() + " is running to fast movemorepackets VL: " + lvl);
					}
				}
			}
		}
	}

}
