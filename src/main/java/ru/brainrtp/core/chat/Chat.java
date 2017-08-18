package ru.brainrtp.core.chat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.brainrtp.core.Main;

public class Chat implements Listener{

    private Main main;

    public Chat(Main main){
        this.main = main;
        Bukkit.getPluginManager().registerEvents((Listener)this, main);
    }

    @EventHandler
    public void chat(AsyncPlayerChatEvent event){
        event.setFormat("§7" + event.getPlayer().getName() + " §f> " +event.getMessage());
    }
}
