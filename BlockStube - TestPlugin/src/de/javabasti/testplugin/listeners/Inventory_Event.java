package de.javabasti.testplugin.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.javabasti.testplugin.Main;

public class Inventory_Event implements Listener {

	Main pl;

	public Inventory_Event(Main instance) {
		pl = instance;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getClickedInventory().getName().equals("§eTestInventory")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().getType().equals(Material.NETHER_STAR)
						&& (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eKlick hier für was cooles"))) {
					p.sendMessage("Cool, du hast das Item angeklickt. LOL");
				}
			}
		}
	}

}
