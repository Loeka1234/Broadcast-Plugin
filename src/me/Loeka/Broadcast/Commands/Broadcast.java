package me.Loeka.Broadcast.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.Loeka.Broadcast.Main;

public class Broadcast implements CommandExecutor{

	static Main plugin;
	public Broadcast(Main main) {
		plugin = main;
	}

	String prefix = Main.getPlugin(Main.class).getConfig().getString("prefix"); //Prefix of the broadcast
	String defaultColor = Main.getPlugin(Main.class).getConfig().getString("defaultColor"); //Default color of the broadcast
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("broadcast")) {
			//Kijken naar de perms
			if(sender.hasPermission("Broadcast.broadcast")) {
				
				//Kijken wat de message is
				if(args.length >= 1) {
					
					String message = "" + ChatColor.translateAlternateColorCodes('&', defaultColor);
					
				    for(int i=0; i<=args.length - 1; i++){  
				        message += " " + args[i];
				    } 
				    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
				} else {
					sender.sendMessage(ChatColor.RED + "Add a message to your broadcast!");
				}
				
				return true;
			}
		}
		return false;
	}

	

}
