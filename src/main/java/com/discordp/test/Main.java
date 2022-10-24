package com.discordp.test;

import com.discordp.test.Types.CommandManager;
import com.discordp.test.config.Configfile;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.util.Timer;

public class Main extends ListenerAdapter {

    private static JDABuilder jdaBuilder;
    private static JDA jda;
    public static void main(String[] args) {

        Configfile.loadconfig();
        jdaBuilder = JDABuilder.createDefault("");

        jdaBuilder.setStatus(OnlineStatus.IDLE);


        jdaBuilder.addEventListeners(new Main());
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        try {
            jda = jdaBuilder.build();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        setdes();
        RegisterCommands();
    }

    private static void setdes(){
        Des des = new Des();
        Timer timer = new Timer();
        timer.schedule(des,0,10000);
    }

    private static void RegisterCommands(){
        CommandManager commandManager = new CommandManager();
        jda.addEventListener(commandManager);
    }
    public static JDA getJda(){
        return jda;
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        if(!event.getMember().getUser().isBot()){
            TextChannel textChannel = event.getGuild().getSystemChannel();
            if(textChannel != null){
                textChannel.sendMessage(event.getMember().getAsMention() + " has joined the server" ).queue();
            }
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        String[] arg = message.split(" ");
        if (message.equals("!embed") || (message.equals("!Embed"))) {
            EmbedBuilder embedBuilde = new EmbedBuilder();

            embedBuilde.setTitle("hey this is a test embed");
            embedBuilde.setColor(0xCF0A0A);
            embedBuilde.setDescription("lorem something here lorem something here \n lorem something here lorem something here");
            embedBuilde.setFooter("footer here ",event.getAuthor().getAvatarUrl());

            event.getChannel().sendMessage(embedBuilde.build()).queue();

        }
        if (message.equals("!hello") || message.equals("!Hello")) {

            event.getChannel().sendMessage("hi this is a test command").queue();
        }
        if (arg[0].equals("!mention") || arg[0].equals("!Mention")) {
            Member member = event.getMessage().getMentionedMembers().get(0);
            if (!member.getUser().isBot()) {
                event.getChannel().sendMessage("you pinged" + member.getUser().getAsMention()).queue();
            } else {
                event.getChannel().sendMessage("cant ping bots").queue();
            }
        }
        if (arg[0].equals("!setrole") || arg[0].equals("!Setrole")) {
        Member member = event.getMessage().getMentionedMembers().get(0);
            if(member != null ){
                Role role = event.getGuild().getRoleById(arg[2]);
                    if(role != null){
                        event.getGuild().addRoleToMember(member , role).queue();
                        event.getChannel().sendMessage("Added role " + role.getAsMention() + " to " + member.getUser()).queue();
                    }
            }

        }
        if (arg[0].equals("!react") || arg[0].equals("!React")){
            if(arg.length == 4){
            TextChannel textChannel = event.getMessage().getMentionedChannels().get(0);
                if(textChannel != null){
                    String emote = arg[3];
                    textChannel.addReactionById(Long.parseLong(arg[2]), emote).queue();
                }
            }else{
                event.getChannel().sendMessage("use the right format").queue();
            }
        }
        if (message.equals("!dm") || message.equals("!DM")){
            if(event.getMember().getUser() != null){
                event.getMember().getUser().openPrivateChannel().queue(channel ->{
                channel.sendMessage("Testing message").queue();
            });}

        }
        if (message.equals("!create_text_channel")){
            Guild guild = event.getGuild();
            Member member = event.getMember();
            if(member != null) {
                guild.createTextChannel("Text-Channel").queue(textChannel -> {
                    textChannel.putPermissionOverride(member).setAllow(Permission.ADMINISTRATOR).queue();
                    event.getChannel().sendMessage("successfully created a new text-channel").queue();
                });
            }
        }
        if (message.equals("!create_voice_channel")){
            Guild guild = event.getGuild();
            Member member = event.getMember();
            if(member != null) {
                guild.createVoiceChannel("Voice").queue(voiceChannel -> {
                    voiceChannel.putPermissionOverride(member).setAllow(Permission.ADMINISTRATOR).queue();
                    event.getChannel().sendMessage("successfully created a new Voice Channel").queue();
                });
            }
        }
        if (message.equals("!create_category")){
            Guild guild = event.getGuild();
            Member member = event.getMember();

            if(member != null) {
                guild.createCategory("New Category").queue(category -> {
                    category.putPermissionOverride(member).setAllow(Permission.ADMINISTRATOR).queue();
                    event.getChannel().sendMessage("successfully created a new Category").queue();
                });
            }
        }
        if (message.equals(("!invite"))){
            TextChannel textChannel =event.getChannel();
            textChannel.sendMessage("Here is your invite for this server - " + textChannel.createInvite().complete().getUrl()).queue();

        }

        }


    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event){
        if(!event.getAuthor().isBot()){
            event.getChannel().sendMessage("hey this is still work in progress").queue();
        }
    }

    @Override
    public void onGuildUpdateName(@NotNull GuildUpdateNameEvent event) {
        TextChannel textChannel = event.getGuild().getSystemChannel();
        if (textChannel != null){
            String old = event.getOldName();
            String newName = event.getNewName();

            textChannel.sendMessage("name changed from **" + old + "** to **"+ newName+"**").queue();

        }
    }


}
