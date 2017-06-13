package com.simplexservers.minecraft.bedoverride;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	private static final long SLEEP_DURATION = 100L;
	private long enterTime = 0L;

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerEnterBed(PlayerBedEnterEvent event) {
		enterTime = event.getPlayer().getWorld().getTime();
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerLeaveBed(PlayerBedLeaveEvent event) {
		event.getPlayer().getWorld().setFullTime(enterTime + SLEEP_DURATION);
	}

}
