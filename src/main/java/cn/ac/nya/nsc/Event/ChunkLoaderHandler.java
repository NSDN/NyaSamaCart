package cn.ac.nya.nsc.Event;

import cn.ac.nya.nsc.Cart.AnchorCart;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.event.entity.EntityEvent;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by drzzm on 2017.4.30.
 */
public class ChunkLoaderHandler implements ForgeChunkManager.LoadingCallback, ForgeChunkManager.OrderedLoadingCallback, ForgeChunkManager.PlayerOrderedLoadingCallback {
    private static ChunkLoaderHandler instance;

    public static ChunkLoaderHandler instance() {
        if (instance == null)
            instance = new ChunkLoaderHandler();
        return instance;
    }

    @SubscribeEvent
    public void entityEnteredChunk(EntityEvent.EnteringChunk event) {
        Entity entity = event.entity;
        if (entity instanceof AnchorCart) {
            if (!entity.worldObj.isRemote) {
                ((AnchorCart) entity).forceChunkLoading(event.newChunkX, event.newChunkZ);
            } else {
                ((AnchorCart) entity).setupChunks(event.newChunkX, event.newChunkZ);
            }
        }
    }

    @Override
    public void ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world) {
        for (ForgeChunkManager.Ticket ticket : tickets) {
            if (ticket.isPlayerTicket())
                continue;
            Entity entity = ticket.getEntity();
            if (entity instanceof AnchorCart) {
                AnchorCart anchor = (AnchorCart) entity;
                anchor.setChunkTicket(ticket);
                anchor.forceChunkLoading(anchor.chunkCoordX, anchor.chunkCoordZ);
            }
        }
    }

    @Override
    public List<ForgeChunkManager.Ticket> ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world, int maxTicketCount) {
        Set<ForgeChunkManager.Ticket> worldTickets = new HashSet<ForgeChunkManager.Ticket>();
        Set<ForgeChunkManager.Ticket> cartTickets = new HashSet<ForgeChunkManager.Ticket>();
        for (ForgeChunkManager.Ticket ticket : tickets) {
            Entity entity = ticket.getEntity();
            if (entity == null) {
                int y = ticket.getModData().getInteger("yCoord");
                if (y >= 0) {
                    worldTickets.add(ticket);
                }
            } else {
                if (entity instanceof AnchorCart) {
                    cartTickets.add(ticket);
                }
            }
        }

        List<ForgeChunkManager.Ticket> claimedTickets = new LinkedList<ForgeChunkManager.Ticket>();
        claimedTickets.addAll(cartTickets);
        claimedTickets.addAll(worldTickets);
        return claimedTickets;
    }

    @Override
    public ListMultimap<String, ForgeChunkManager.Ticket> playerTicketsLoaded(ListMultimap<String, ForgeChunkManager.Ticket> tickets, World world) {
        return LinkedListMultimap.create();
    }

}
