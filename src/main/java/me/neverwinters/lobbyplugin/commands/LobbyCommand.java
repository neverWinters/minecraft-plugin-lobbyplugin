package me.neverwinters.lobbyplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neverwinters.lobbyplugin.Main;
import me.neverwinters.lobbyplugin.PluginConstants;
import me.neverwinters.lobbyplugin.utils.PlayerValidator;

public class LobbyCommand implements CommandExecutor{

    Main plugin;
    PlayerValidator validator = new PlayerValidator();

    /**
     * <p>LobbyCommand</p>
     * <p>Class constructor method</p>
     * @param plugin Current instance of plugin
     */
    public LobbyCommand(Main plugin)
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

        if(plugin.getConfig().getString("lobby.X") == null)
        {

            player.sendMessage(ChatColor.RED + PluginConstants.PLUGIN_CHAT_NAME + "The lobby is not set!");
            return false;

        }

        //  Teleport to lobby
        float x = plugin.getConfig().getInt("lobby.X");
        float y = plugin.getConfig().getInt("lobby.Y");
        float z = plugin.getConfig().getInt("lobby.Z");

        Location lobby = new Location(player.getWorld(), x, y, z);

        player.teleport(lobby);
        

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

        return validator.ValidatePermission(player, PluginConstants.LOBBY_COMMAND_PERMISSION);
    
    }
    
}
