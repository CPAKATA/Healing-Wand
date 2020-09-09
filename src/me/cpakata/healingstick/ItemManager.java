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
	
	public static ItemStack HealWand;
	public static ItemStack TeleportWand;
	public static ItemStack ExplosionWand;
	
	public static void init() {
		createHealWand(); 
		createTeleportWand();
		createExplosionWand();
	}
	
	private static void createHealWand() {
		ItemStack item = new ItemStack(Material.STICK,1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("&AHealing Stick");
		List<String> lore = new ArrayList<>();
		lore.add("&EThis stick heals 2 hearts!");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		HealWand = item;
		
		
		//Shaped Recipe
		ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("HealWand"), item);
		sr.shape("E  "," S ","  S");
		sr.setIngredient('E', Material.EMERALD);
		sr.setIngredient('S', Material.STICK);
		Bukkit.getServer().addRecipe(sr);
		
	}
	
	private static void createTeleportWand() {
		ItemStack item = new ItemStack(Material.STICK,1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("&5Teleport Stick");
		List<String> lore = new ArrayList<>();
		lore.add("&EWith that stick you can teleport!");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		TeleportWand = item;
		
		ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("TeleportWand"), item);
		sr.shape("P  "," S ","  S");
		sr.setIngredient('P', Material.ENDER_PEARL);
		sr.setIngredient('S', Material.STICK);
		Bukkit.getServer().addRecipe(sr);
	}
	
	private static void createExplosionWand() {
		ItemStack item = new ItemStack(Material.BLAZE_ROD,1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("&CExplosion Stick");
		List<String> lore = new ArrayList<>();
		lore.add("&EBe ready...");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		ExplosionWand = item;
		
		ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("ExplosionWand"), item);
		sr.shape("E  "," S ","  S");
		sr.setIngredient('B', Material.BLAZE_POWDER);
		sr.setIngredient('S', Material.STICK);
		Bukkit.getServer().addRecipe(sr);
	}
	
}
