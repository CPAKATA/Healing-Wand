package me.cpakata.healingstick;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Events implements Listener {
	
	@EventHandler
	public static void onLeftClick(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player whoWasHit = (Player) e.getEntity();
            Player whoHit = (Player) e.getDamager();
            if (whoHit.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.HealWand.getItemMeta()))
            {
            	whoHit.getWorld().playEffect(whoWasHit.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
            	if (whoWasHit.getHealth() + 5 >= 20)
            	{
            		whoWasHit.setHealth(20);
            	}
            	else
            	{
            		whoWasHit.setHealth( whoWasHit.getHealth() + 5 );
            	}
            }
        }
	}
	
	public static void onRightClick(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getItem() != null && e.getItem().getItemMeta().equals(ItemManager.ExplosionWand.getItemMeta())) {
				Player player = e.getPlayer();
				player.getWorld().createExplosion(player.getLocation(), 2.0f);
			}
		}
	}

}
