
# Discord bot made in Java

A custom bot made using JDA(Java Discord Api) with 12+ basic functionalities and few more.



## Demo



![](https://i.imgur.com/ybNsZ23.gif)
## Command List With There Functionalities

| Command             | Function                                                                |
| ----------------- | ------------------------------------------------------------------ |
| !help| embed which returns helpfully information to operate this bot |
| !hello | responds with a hello message |
| !mention <user>|used to mention the user(ping specific user) |
| !setrole <user> <role-ID> | used to give/set role for a user |
| !react <channel-name> <message-ID> <emoji>| used to react under a certain message (bot reacts) |
| !dm | bot direct message's the user  |
| !create_text_channel | creates new voice channel  |
| !create_category| creates new category |
| !invite| generates a new limited 24hr invite link  |
| !clear <amount>| clears the amounts of messages for you limited upto 100(discord api limit) |
| !ban <user> <reason>| bans a user from discord server |
| !kick <user> <reason>|kicks a user from discord server |
| !unban <user-ID>| unbans the user from server|
| !embed| generates a sample embed |
 
- more Functions coming soon.
## Screenshots

![App Screenshot](https://i.imgur.com/vbm65dM.png)

![](https://i.imgur.com/unFywZ3.png)

![](https://i.imgur.com/3AaVunY.png)


## Documentation

[Documentation](https://github.com/DV8FromTheWorld/JDA)


## Authors

- [@SandeshK8](https://www.github.com/sandeshk8)


## Installation

Install by building it in your ide
insert the token in two places firstly in Main.java

change ->
```bash
public static void main(String[] args) {
   Configfile.loadconfig();
        jdaBuilder = JDABuilder.createDefault("your token");
.....
```
and then in config file

- open config.yml

change ->
```bash
token = "your token"
#(without the Apostrophes)
```

    
## Feedback

If you have any feedback, please reach out to us at Sandeshkadam213@gmail.com

