package org.teamcarter.Noobs;

import java.util.*;
import java.util.logging.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class Noobs extends JavaPlugin
{
public static final Logger log = Bukkit.getLogger();
public static final String COMMAND_PATH = "org.teamcarter.Noobs.Commands";
public static final String COMMAND_PREFIX = "CMD_";
@Override
public void onLoad()
{
log.info(String.format("[NOOBS]:  is now loading...";
}
@Override
public void onEnable()
{
log.info(String.format("[NOOBS]: Version 1 has been enabled";
}
@Override
public void onDisable()
{
log.info(String.format("[NOOBS]:  has been disabled!");
}
@Override
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
try
{
Player sender_p = null;
boolean senderIsConsole = false;
if (sender instanceof Player)
{
sender_p = (Player) sender;
log.info(String.format("[PLAYERCOMMANDBYUSER] %s(%s): /%s ",
sender_p.getName(),
ChatColor.stripColor(sender_p.getDisplayName()),
commandLabel
}
else
{
senderIsConsole = true;
log.info(String.format("[CONSOLECOMMANDBYUSER] %s: /%s",
sender.getName(), commandLabel
}
IPCommand dispatcher;
try
{
ClassLoader classLoader = Noobs.class.getClassLoader();
dispatcher = (IPCommand) classLoader.loadClass(String.format("%s.%s%s", COMMAND_PATH, COMMAND_PREFIX, cmd.getName().toLowerCase())).newInstance();
dispatcher.setPlugin(this);
}
catch (Throwable ex)
{
log.log(Level.SEVERE, "[" + getDescription().getName() + "] Command not loaded: " + cmd.getName(), ex);
sender.sendMessage(ChatColor.RED + "Command Error: Command not loaded: " + cmd.getName());
return true;
}
try
{
return dispatcher.run(sender, sender_p, cmd, commandLabel, args, senderIsConsole);
}
catch (Throwable ex)
{
sender.sendMessage(ChatColor.RED + "Command Error: " + ex.getMessage());
}
dispatcher = null;
}
catch (Throwable ex)
{
log.log(Level.SEVERE, "[" + getDescription().getName() + "] Command Error: " + commandLabel, ex);
sender.sendMessage(ChatColor.RED + "Unknown Command Error Please contact your local developer");
}
return true;
}
}
