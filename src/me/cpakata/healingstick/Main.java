package me.cpakata.healingstick;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Events(), this);
		ItemManager.init();
	}
	
	public void onDisable() {
		
	}

}
