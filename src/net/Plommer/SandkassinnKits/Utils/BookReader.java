package net.Plommer.SandkassinnKits.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import net.Plommer.SandkassinnKits.SandkassinnKits;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BookReader {
	protected SandkassinnKits plugin;
	public BookReader(SandkassinnKits plugin) {
		this.plugin = plugin;
	}
	
	public ItemStack ReaderBook(String name) {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta bm = (BookMeta)book.getItemMeta();
		try {
			Scanner scan = new Scanner(new FileReader(plugin.getDataFolder().getAbsolutePath() + "/"+ name +".txt"));
		    int page = 0;
		    String line;
		    HashMap<Integer, String> lines = new HashMap<Integer, String>();
		    StringBuilder string = new StringBuilder();
		    while(scan.hasNextLine()){
		        line = scan.nextLine();
		        if(line.contains("page:")) {
		        	if(page != 0) {
		        		lines.put(page, string.toString());
		        		string.delete(0, string.length());
		        	}
		        	page++;
		        } else if(page != 0) {
			        	String e = line + "\n";
			        	string.append(e);
		        } else if(page == 0) {
		        	if(line.contains("title")) {
		        		String[] te = line.split(":");
						bm.setTitle(te[1].replace("_", " "));
		        	} else if(line.contains("author")) {
		        		String[] te = line.split(":");
						bm.setAuthor(te[1].replace("_", " "));
		        	}
		        }
			}
		    scan.close();
		    for(int i : lines.keySet()) {
		    	int old = 1;
		    	if(i == old) {
		    		String builder = lines.get(i);
		    		bm.addPage(Utils.buildString(builder, new HashMap<String, String>()));
		    	} else {
		    		String builder = lines.get(i);
		    		bm.addPage(Utils.buildString(builder, new HashMap<String, String>()));
		    		old = i;
		    	}
		    }
		} catch(IOException e) {
			
		}
		book.setItemMeta(bm);
		return book;
	}
	
}
