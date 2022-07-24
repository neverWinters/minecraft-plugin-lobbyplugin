package me.neverwinters.lobbyplugin.utils;

import org.bukkit.entity.Player;

public class PlayerValidator 
{
    /**
     * <p>ValidatePermission</p>
     * <p>Validate if the current player have permission to execute a specific command</p>
     * @param player Player who try to execute the command
     * @param permissionName Command permission name
     * @return true if player has permission to execute the command, otherwise false
     */
    public boolean ValidatePermission(Player player, String permissionName)
    {

        return player.hasPermission(permissionName);

    }

    /**
     * <p>ValidateOp</p>
     * <p>Validate if the current player is Operator</p>
     * @param player Current instance of player
     * @return true if player is Operator, otherwise false
     */
    public boolean ValidateOp(Player player)
    {

        return player.isOp();
        
    }

}
