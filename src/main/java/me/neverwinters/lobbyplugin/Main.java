package me.neverwinters.lobbyplugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.neverwinters.lobbyplugin.commands.LobbyCommand;
import me.neverwinters.lobbyplugin.commands.SetLobbyCommand;

public class Main extends JavaPlugin {
    
    /**
     * <p>onEnable</p>
     * <p>On enable plugin execution method</p>
     */
    public void onEnable()
    {

        this.onPluginStartTask();

        // Register Plugin Commands
        this.getCommand(PluginConstants.SET_LOBBY_COMMAND_NAME).setExecutor(new SetLobbyCommand(this));
        this.getCommand(PluginConstants.LOBBY_COMMAND_NAME).setExecutor(new LobbyCommand(this));

    }


    /**
     * <p>onPluginStartTask</p>
     * <p>Plugin configuration initialization and notification method</p>
     */
    private void onPluginStartTask()
    {

        System.out.println(PluginConstants.PLUGIN_CHAT_NAME + " The plugin has been enabled!");
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults();

    }

}
