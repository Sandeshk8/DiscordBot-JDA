package com.discordp.test.Types;

import com.discordp.test.Commands.*;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandManager extends ListenerAdapter {

    private final HelpCommand helpCommand;
    private final ClearCommand clearCommand;
    private final KickCommand kickCommand;
    private  final BanCoammand banCoammand;
    private final UnbanCommand unbanCommand;

    public CommandManager(){
        this.helpCommand = new HelpCommand();
        this.clearCommand = new ClearCommand();
        this.kickCommand = new KickCommand();
        this.banCoammand = new BanCoammand();
        this.unbanCommand = new UnbanCommand();
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if(!event.getMember().getUser().isBot()){
            String[]arg = event.getMessage().getContentRaw().split(" ");

            Guild guild =event.getGuild();
            Member member =event.getMember();
            TextChannel textChannel = event.getChannel();
            Message message = event.getMessage();

            switch(arg[0]){
                case "!help":
                    helpCommand.PerformCommands(arg, guild,member,message,textChannel);
                    break;
                case "!clear":
                    clearCommand.PerformCommands(arg,guild,member,message,textChannel);
                    break;
                case "!kick":
                    kickCommand.PerformCommands(arg,guild,member,message,textChannel);
                    break;
                case "!ban":
                    banCoammand.PerformCommands(arg,guild,member,message,textChannel);
                    break;
                case "!unban":
                    unbanCommand.PerformCommands(arg,guild,member,message,textChannel);
                    break;

            }
        }
    }
}
