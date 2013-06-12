package xize.cheatlincher.checks.blocks;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import xize.cheatlincher.CheatLincher;

public class fastbreak_SurvivalCheck implements Listener {
	CheatLincher plugin;
	public fastbreak_SurvivalCheck(CheatLincher plugin) {
		this.plugin = plugin;
	}
	
	protected static HashMap<String, Long> time = new HashMap<String, Long>();
	
	@EventHandler
	public void fastbreak(BlockBreakEvent e) {
		if(e.getPlayer().getGameMode() == GameMode.SURVIVAL || e.getPlayer().getGameMode() == GameMode.ADVENTURE) {
			if(time.containsKey(e.getPlayer().getName())) {
				//e.getPlayer().sendMessage("Result: " + lvl);
				if(e.getPlayer().getInventory().getItemInHand().containsEnchantment(Enchantment.DIG_SPEED)) {
					if(System.currentTimeMillis() - time.get(e.getPlayer().getName()) <= 27) {
						Long lvl = System.currentTimeMillis() - time.get(e.getPlayer().getName());
						for(Player p : Bukkit.getOnlinePlayers()) {
							if(p.hasPermission("cheatlincer.checks.fastbreak")) {
								p.sendMessage(ChatColor.RED + "[CheatLincher] " + ChatColor.GRAY + e.getPlayer().getName() + " tried to destroy blocks faster than normal but used a Diamond shovel with efficiency enchant fastbreakSurvival VL: " + lvl);
							}
						}
						e.setCancelled(true);
						time.put(e.getPlayer().getName(), System.currentTimeMillis());
					} else {
						time.put(e.getPlayer().getName(), System.currentTimeMillis());
					}
				} else if(e.getPlayer().getItemInHand().getType() == Material.IRON_SPADE) {
					if(System.currentTimeMillis() - time.get(e.getPlayer().getName()) <= 300) {
						Long lvl = System.currentTimeMillis() - time.get(e.getPlayer().getName());
						for(Player p : Bukkit.getOnlinePlayers()) {
							if(p.hasPermission("cheatlincer.checks.fastbreak")) {
								p.sendMessage(ChatColor.RED + "[CheatLincher] " + ChatColor.GRAY + e.getPlayer().getName() + " tried to destroy blocks faster than normal fastbreakSurvival VL: " + lvl);
							}
						}
						e.setCancelled(true);
						time.put(e.getPlayer().getName(), System.currentTimeMillis());
					} else {
						time.put(e.getPlayer().getName(), System.currentTimeMillis());
					}
				}
			} else {
				time.put(e.getPlayer().getName(), System.currentTimeMillis());
			}
		}
	}

}
