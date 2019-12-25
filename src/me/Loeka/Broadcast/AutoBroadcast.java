package me.Loeka.Broadcast;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class AutoBroadcast extends TimerTask{

	int i = 1;
	String prefix = Main.getPlugin(Main.class).getConfig().getString("prefix");
	String defaultColor = Main.getPlugin(Main.class).getConfig().getString("defaultColor");
	
	public void run() {
		
		String message = Main.getPlugin(Main.class).getConfig().getString("message" + i);
		if(message != null) {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix) + " " + ChatColor.translateAlternateColorCodes('&', defaultColor) + ChatColor.translateAlternateColorCodes('&', message));
			i++;
		} else {
			//Terug naar eerste message gaan
			i = 1;
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix) + " " + ChatColor.translateAlternateColorCodes('&', defaultColor) + ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("message" + i)));
			i++;
		}
		
	}

}
