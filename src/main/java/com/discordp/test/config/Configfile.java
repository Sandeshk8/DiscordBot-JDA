package com.discordp.test.config;

import com.discordp.test.Main;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Configfile {
    public static void loadconfig(){
        String filename = "config.yml";
        ClassLoader classLoader = Main.class.getClassLoader();

        try(InputStream inputStream = classLoader.getResourceAsStream(filename)){
        String res = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        System.out.println(res);

            File file =  new File(filename);
            if(!file.exists()){
                file.createNewFile();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
                bufferedWriter.write(res);
                bufferedWriter.close();
            }
        }catch (IOException exception){

        }
    }
}
