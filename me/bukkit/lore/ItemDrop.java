package me.bukkit.lore;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import me.bukkit.main.Main;

public class ItemDrop implements Listener {
	private Main plugin;

	public ItemDrop(Main pl) {
		this.plugin = pl;
	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		Item droppedItem = e.getItemDrop();
		ItemStack DroppedItemStack = droppedItem.getItemStack();
		Player p = e.getPlayer();
		List<String> loreList = new ArrayList<String>();
		if ((DroppedItemStack.hasItemMeta()) && (DroppedItemStack.getItemMeta().getLore() != null)) {
			int loreSize = DroppedItemStack.getItemMeta().getLore().size();
			for (int i = 0; i < loreSize; i++) {
				loreList.add((String) DroppedItemStack.getItemMeta().getLore().get(i));
			}
			if (loreList.contains(ChatColor.translateAlternateColorCodes('&',
					this.plugin.settings.getLang().getString("Lore.UntradeableLore")))) {
				e.setCancelled(true);
				Data.sendMessage(this.plugin.settings.getLang().getString("Messages.NoDrop"), p);
				return;
			}
		}
	}
}
