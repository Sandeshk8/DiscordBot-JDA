package com.discordp.test.Commands;

import com.discordp.test.Types.ServerCommands;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class BanCoammand implements ServerCommands {
    @Override
    public void PerformCommands(String[] argumennt, Guild guild, Member member, Message message, TextChannel textChannel) {
        if(argumennt.length ==3){
            Member member1 = message.getMentionedMembers().get(0);
            String reason = argumennt[2];
            if(member1!=null){
                if(reason!=null){
                    if(member1.hasPermission(Permission.BAN_MEMBERS)){
                        textChannel.sendMessage(member1.getUser().getName() + " was BANNED for " + reason).queue();
                        member1.ban(0,reason).queue();
                    }else{
                        textChannel.sendMessage("you or me don't have banning permissions").queue();
                    }
                }
            }
        }else {
            textChannel.sendMessage("use correct format -> !ban <@user> <reason>").queue();
        }
    }
}
