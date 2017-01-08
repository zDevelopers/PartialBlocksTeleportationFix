package fr.zcraft.PartialBlocksTPFix;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;


public final class PartialBlocksTeleportationFix extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerTeleport(final PlayerTeleportEvent ev)
    {
        final Material below = ev.getTo().clone().add(0, -1, 0).getBlock().getType();
        
        if (below == Material.GRASS_PATH || below == Material.SOUL_SAND || below == Material.SOIL)
            ev.setTo(ev.getTo().add(0, 0.5, 0));
    }
}
