package de.javabasti.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.javabasti.testplugin.commands.CountDown_Command;
import de.javabasti.testplugin.commands.InventoryOpen_Command;
import de.javabasti.testplugin.listeners.Inventory_Event;
import de.javabasti.testplugin.utils.CreateInventory_Util;

public class Main extends JavaPlugin {

	private static Main instance;
	public CreateInventory_Util createInventory_Util;

	@Override
	public void onEnable() {
		instance = this;
		createInventory_Util = new CreateInventory_Util();
		createInventory_Util.Test_Inventory();
		registerEvents();
	}

	@Override
	public void onDisable() {

	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		
		// EVENTS
		pm.registerEvents(new Inventory_Event(this), this);
	
		// COMMANDS
		Bukkit.getPluginCommand("inventory").setExecutor(new InventoryOpen_Command());
		Bukkit.getPluginCommand("countdown").setExecutor(new CountDown_Command());
	}

	public static Main getInstance() {
		
		return instance;
	}
}
