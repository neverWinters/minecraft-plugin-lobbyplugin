package me.neverwinters.lobbyplugin.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neverwinters.lobbyplugin.Main;
import me.neverwinters.lobbyplugin.PluginConstants;
import me.neverwinters.lobbyplugin.utils.PlayerValidator;
import net.md_5.bungee.api.ChatColor;

public class SetLobbyCommand implements CommandExecutor
{

    Main plugin;
    PlayerValidator validator = new PlayerValidator();

    /**
     * <p>SetLobbyCommand</p>
     * <p>Class constructor method</p>
     * @param plugin Current instance of plugind
     */
    public SetLobbyCommand(Main plugin)
    {

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
    {
        
        Player player = (Player) sender;
        
        if(!(sender instanceof Player))
        {
            
            sender.sendMessage(PluginConstants.PLUGIN_CHAT_NAME + " You cannot do that here!");
            return false;

        }
            
        if(!this.ValidateCommandPermissions(player))
        { 
            
            player.sendMessage(ChatColor.RED + PluginConstants.PLUGIN_CHAT_NAME + " You don't have permission to do this!");
            return false;

        }

        plugin.getConfig().set("lobby.X", player.getLocation().getBlockX());
        plugin.getConfig().set("lobby.Y", player.getLocation().getBlockY());
        plugin.getConfig().set("lobby.Z", player.getLocation().getBlockZ());
        plugin.saveConfig();
        plugin.reloadConfig();
        player.sendMessage(ChatColor.GREEN + PluginConstants.PLUGIN_CHAT_NAME + " You set the lobby successfully!");

        return false;

    }

    /**
     * <p>ValidateCommandPermissions</p>
     * <p>Command permissions and/or constraints validation</p>
     * @param player Player who try to execute the command
     * @return Validators evaluation result
     */
    protected boolean ValidateCommandPermissions(Player player)
    {

        return (
            validator.ValidatePermission(player, PluginConstants.SET_LOBBY_COMMAND_PERMISSION) || 
            validator.ValidateOp(player)
        );
        
    }
    
}
