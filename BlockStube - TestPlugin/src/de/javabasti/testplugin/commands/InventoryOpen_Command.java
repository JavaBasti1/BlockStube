package de.javabasti.testplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.javabasti.testplugin.Main;

public class InventoryOpen_Command implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if (cs instanceof Player) {
			Player p = (Player) cs;
			p.openInventory(Main.getInstance().createInventory_Util.getTestInv());
		} else {
			cs.sendMessage("You have to be a Player!");
		}

		return true;
	}

}
