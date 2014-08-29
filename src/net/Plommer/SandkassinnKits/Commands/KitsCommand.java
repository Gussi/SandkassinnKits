package net.Plommer.SandkassinnKits.Commands;

import org.bukkit.inventory.ItemStack;
import net.Plommer.SandkassinnKits.Kits;
import net.Plommer.SandkassinnKits.Utils.Utils;

public class KitsCommand extends BaseCommand {
	
	public KitsCommand() {
		bePlayer = true;
		name = " ";
		argLength = 0;
		usage = "<kit nafn>";
	}	
	@Override
	public boolean execute() {
		if(!sender.hasPermission("sandkassinnkits." + args.get(0))) {
			Utils.sendMessage(sender, "&cYou don'ts have permission to do that!");
			return false;
		}
		if(plugin.kitsList.containsKey(args.get(0).toLowerCase())) {
			Kits kits = plugin.kitsList.get(args.get(0).toLowerCase());
			for(ItemStack item : kits.getItems()) {
				player.getInventory().addItem(item);
			}
			Utils.sendMessage(sender, plugin.config.getString("msg.kitsuccsess").replace("{kit}", kits.getName()));
		} else {
			Utils.sendMessage(sender, plugin.config.getString("msg.kiterror"));
		}
		return false;
	}
}
