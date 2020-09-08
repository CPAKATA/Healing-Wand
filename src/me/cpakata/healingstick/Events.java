package me.cpakata.healingstick;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Events implements Listener {
	
	@EventHandler
	public static void onLeftClick(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player whoWasHit = (Player) e.getEntity();
            Player whoHit = (Player) e.getDamager();
            if (whoHit.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.wand.getItemMeta()))
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

}
