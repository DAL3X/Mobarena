package de.dal3x.mobarena.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.dal3x.mobarena.arena.ArenaStorage;
import de.dal3x.mobarena.boss.BossStorage;
import de.dal3x.mobarena.classes.ClassController;
import de.dal3x.mobarena.commands.MobarenaCommand;
import de.dal3x.mobarena.file.Filehandler;
import de.dal3x.mobarena.item.ItemStorage;
import de.dal3x.mobarena.mobs.MobBlueprintStorage;
import de.dal3x.mobarena.mobs.MobGenerator;
import de.dal3x.mobarena.utility.InventoryStorage;
import de.dal3x.mobarena.wave.MobwaveController;

public class MobArenaPlugin extends JavaPlugin{
	
	private static MobArenaPlugin instance;
	private Filehandler fileHandler;
	
	public static MobArenaPlugin getInstance() {
		return instance;
	}
	
	public static void clearInstance() {
		instance = null;
	}
	
	public void onEnable(){
		instance = this;
		init();
		getCommand("mobarena").setExecutor(new MobarenaCommand());
	}
	
	public void onDisable() {
		clearInstances();
	}
	
	public void reload() {
		onDisable();
		onEnable();
	}
	
	private void init() {
		this.fileHandler = Filehandler.getInstance();
		this.fileHandler.loadRessources();
		InventoryStorage.getInstance();
		BossStorage.getInstance();
	}
	
	private void clearInstances() {
		MobArenaPlugin.clearInstance();
		ClassController.clearInstance();
		ArenaStorage.clearInstance();
		ItemStorage.clearInstance();
		MobBlueprintStorage.clearInstance();
		MobGenerator.clearInstance();
		MobwaveController.clearInstance();
		InventoryStorage.clearInstance();
		Filehandler.clearInstance();
		BossStorage.clearInstance();
	}

	public Filehandler getFileHandler() {
		return fileHandler;
	}

	public void setFileHandler(Filehandler fileHandler) {
		this.fileHandler = fileHandler;
	}
}
