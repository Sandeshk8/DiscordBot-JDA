package com.discordp.test.Commands;

import com.discordp.test.Types.ServerCommands;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class ClearCommand implements ServerCommands {

    @Override
    public void PerformCommands(String[] argumennt, Guild guild, Member member, Message message, TextChannel textChannel) {
        if(argumennt.length<2){
            textChannel.sendMessage("use the right format -> !clear <amount>").queue();
        }else{
            try{
                message.delete().queue();
                List <Message> messageList = textChannel.getHistory().retrievePast(Integer.parseInt(argumennt[1])).complete();
                textChannel.deleteMessages(messageList).queue();

                textChannel.sendMessage("Deleted "+argumennt[1] + " messages in "+ textChannel.getAsMention() ).queue();
            } catch (IllegalArgumentException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}
