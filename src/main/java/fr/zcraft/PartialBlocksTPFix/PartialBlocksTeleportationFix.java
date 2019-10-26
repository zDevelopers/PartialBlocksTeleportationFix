package fr.zcraft.PartialBlocksTPFix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;


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
        // We check the block under the player after the teleportation, and
        // we teleport it a little bit above if it's a buggy block.
        switch (ev.getTo().clone().add(0, -1, 0).getBlock().getType())
        {
            case GRASS_PATH:
            case SOUL_SAND:
            case FARMLAND:
            case LILY_PAD:
                ev.setTo(ev.getTo().add(0, 0.5, 0));
        }
    }
}
