package me.Loeka.Broadcast;

import java.util.Timer;

import org.bukkit.plugin.java.JavaPlugin;


import me.Loeka.Broadcast.Commands.Broadcast;

public class Main extends JavaPlugin{

	public static Main getPlugin() {
		return Main.getPlugin(Main.class);
	}
	
	Timer broadcastTimer = new Timer();
	
	@Override
	public void onEnable() {
		registerCmds();
		saveDefaultConfig();
		
		if(Main.getPlugin(Main.class).getConfig().getBoolean("automaticBroadcast") == true) {
			int delay = Main.getPlugin(Main.class).getConfig().getInt("delay");
			broadcastTimer.schedule(new AutoBroadcast(), 0, delay);
		}
		//String prefix = Main.getPlugin(Main.class).getConfig().getString("prefix");
		//getLogger().info(prefix);
	}
	
	@Override
	public void onDisable() {
		broadcastTimer.cancel();
	}
	
	public void registerCmds() {
		this.getCommand("broadcast").setExecutor(new Broadcast(this));
	}
}
