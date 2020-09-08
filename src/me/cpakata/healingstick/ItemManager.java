package me.cpakata.healingstick;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemManager {
	
	public static ItemStack wand;
	
	public static void init() { createHealWand(); }
	
	private static void createHealWand() {
		ItemStack item = new ItemStack(Material.STICK,1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("Healing Stick");
		List<String> lore = new ArrayList<>();
		lore.add("This stick heals 2 hearts!");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		wand = item;
		
		
		//Shaped Recipe
		ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"), item);
		sr.shape("I  "," S ","  S");
		sr.setIngredient('I', Material.IRON_INGOT);
		sr.setIngredient('S', Material.STICK);
		Bukkit.getServer().addRecipe(sr);
		
	}
	
}
