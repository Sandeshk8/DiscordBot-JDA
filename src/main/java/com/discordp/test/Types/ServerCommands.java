package com.discordp.test.Types;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public interface ServerCommands {
    public void PerformCommands(String[] argumennt, Guild guild, Member member , Message message, TextChannel textChannel);


}
