package com.discordp.test;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

import java.util.TimerTask;

public class Des extends TimerTask {

    private int count = 0;
    private final JDA jda =Main.getJda();
    private String[] rmessages = {"thinking about you","that makes sense","counting the stars","thanks for checking on me"};

    @Override
    public void run(){
        if(jda != null){
            jda.getPresence().setActivity(Activity.watching(rmessages[count]));
            count = (count+1)%rmessages.length;
        }
    }

}
