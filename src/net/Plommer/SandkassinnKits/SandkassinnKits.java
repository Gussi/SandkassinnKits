package net.Plommer.SandkassinnKits;

import java.util.ArrayList;
import java.util.HashMap;

import net.Plommer.SandkassinnKits.Commands.BaseCommand;
import net.Plommer.SandkassinnKits.Commands.CommandHandler;
import net.Plommer.SandkassinnKits.Commands.KitsCommand;
<<<<<<< HEAD
import net.Plommer.SandkassinnKits.Commands.ListCommand;
=======
>>>>>>> 63e73173b77de7be48616d534cdef148d05e574b
import net.Plommer.SandkassinnKits.Configs.GenerateConfigs;
import net.Plommer.SandkassinnKits.Listenners.JoinEvent;
import net.Plommer.SandkassinnKits.Utils.BookReader;
import net.Plommer.SandkassinnKits.Utils.LoadKits;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SandkassinnKits extends JavaPlugin {
	
	public ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();
	public GenerateConfigs gc = new GenerateConfigs(this);
	public FileConfiguration config;
    public HashMap<String, Kits> kitsList = new HashMap<String, Kits>();
    public BookReader br = new BookReader(this);
    
	public void onEnable() {
		//Some stuff
		getCommand("kits").setExecutor(new CommandHandler(this));
		registerCommands();
		getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
		//Custom configs
		config = gc.getCustomConfig();
		//Load kits to class
		new LoadKits(this);
	}
	
	public void onDisable() {
		//
	}
	
	private void registerCommands() {
<<<<<<< HEAD
		commands.add(new ListCommand());
=======
>>>>>>> 63e73173b77de7be48616d534cdef148d05e574b
		commands.add(new KitsCommand());
	}
	
}
