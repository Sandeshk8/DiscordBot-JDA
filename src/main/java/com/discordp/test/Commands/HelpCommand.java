package com.discordp.test.Commands;

import com.discordp.test.Types.ServerCommands;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommands {

    @Override
    public void PerformCommands(String[] argumennt, Guild guild, Member member, Message message, TextChannel textChannel) {
            textChannel.sendMessage("TBA").queue();
    }
}
