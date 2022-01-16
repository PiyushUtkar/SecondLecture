import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import javax.security.auth.login.LoginException;


public class Main extends ListenerAdapter {
    public static JDABuilder jdaBuilder;
    public static void main(String[] args) {
        jdaBuilder = JDABuilder.createDefault( "OTMxOTcyOTY3ODQ2NTIzMDEy.YeMNdg.M1Q4g-q27oPc3PBZ1sAL6HglOEM" );
        jdaBuilder.setActivity( Activity.playing( "k!help" ) );
        jdaBuilder.setStatus( OnlineStatus.DO_NOT_DISTURB );
        jdaBuilder.addEventListeners( new Main() );
        try {
            jdaBuilder.build();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split( " " );
        String command = message[0];
        String userID = message[1];
        if (command.equals( "k!kick" )){
            event.getGuild().kick( userID ).queue();
            event.getMessage().reply( "Successfully **Kicked** Member With UserID: "+userID ).queue();
            System.out.println("A User Was Kicked With UserID: " + userID);
        } else if (command.equals( "k!ban" )){
            event.getGuild().ban( userID, 7 ).queue();
            event.getMessage().reply( "Successfully **Banned** Member With UserID: "+userID ).queue();
            System.out.println("A User Was Kicked With UserID: " + userID);
        }
    }
}
