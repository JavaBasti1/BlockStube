package de.javabasti.testplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.javabasti.testplugin.Main;

public class CountDown_Command implements CommandExecutor {

	int count = 11;
	int count2;

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if (cs instanceof Player) {
			Player p = (Player) cs;
			p.sendMessage("§cDu hast einen 10 Sekunden Countdown gestartet.");
			count2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

				@Override
				public void run() {
					count--;
					Bukkit.broadcastMessage("§cNoch §e" + count + " §eSekunden §cübrig.");
					
					if (count == 0) {
						Bukkit.broadcastMessage("§cDer Countdown ist abgelaufen.");
						Bukkit.getScheduler().cancelTask(count2);
					}
				}
			}, 0, 20);
		} else {
			cs.sendMessage("You have to be a Player!");
		}

		return true;
	}

}
