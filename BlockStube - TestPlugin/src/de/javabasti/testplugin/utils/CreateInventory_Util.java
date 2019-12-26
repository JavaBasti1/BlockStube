package de.javabasti.testplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateInventory_Util {


	private Inventory testInv = Bukkit.createInventory(null, 9, "§eTestInventory");

	public void Test_Inventory() {
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName("§eKlick hier für was cooles");
		item.setItemMeta(itemMeta);

		getTestInv().setItem(4, item);
	}

	public Inventory getTestInv() {
		return testInv;
	}

	public void setTestInv(Inventory testInv) {
		this.testInv = testInv;
	}
}
