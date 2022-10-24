package com.discordp.test.Commands;

import com.discordp.test.Types.ServerCommands;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class KickCommand implements ServerCommands {
    @Override
    public void PerformCommands(String[] argumennt, Guild guild, Member member, Message message, TextChannel textChannel) {
        if(argumennt.length == 3){
            Member target = message.getMentionedMembers().get(0);
            String reason = argumennt[2];
            if(reason != null){
                if(target != null){
                    if(member.hasPermission(Permission.KICK_MEMBERS)){
                        textChannel.sendMessage(target.getUser().getName() + " was kicked for " + reason).queue();
                        target.kick(reason).queue();
                    }
                }
            }

        }
    }
}
