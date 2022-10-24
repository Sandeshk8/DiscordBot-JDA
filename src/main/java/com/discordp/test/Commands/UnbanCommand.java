package com.discordp.test.Commands;

import com.discordp.test.Types.ServerCommands;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class UnbanCommand implements ServerCommands {
    @Override
    public void PerformCommands(String[] argumennt, Guild guild, Member member, Message message, TextChannel textChannel) {
        if(argumennt.length==2){
            String unbanId = argumennt[1];
            guild.unban(unbanId).queue();
        }else{
            textChannel.sendMessage("use correct format -> !unban <userID>").queue();
        }
    }
}
