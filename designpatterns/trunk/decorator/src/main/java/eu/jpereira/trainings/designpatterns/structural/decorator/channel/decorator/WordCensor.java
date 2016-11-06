package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

import java.util.regex.Pattern;

/**
 * Created by ubuntu-master on 06.11.16.
 */
public class WordCensor extends SocialChannelDecorator {

    private String[] wordsToCensor;
    public WordCensor(SocialChannel channel, String... wordsToCensor){
        this.wordsToCensor = wordsToCensor;
        this.delegate = channel;
    }

    public WordCensor(String... wordsToCensor){
        this.wordsToCensor = wordsToCensor;
    }
    @Override
    public void deliverMessage(String message) {
        StringBuilder builder = new StringBuilder();
        String censoredMessage = message.replaceAll(censorWords(wordsToCensor), "#");
        builder.append(censoredMessage);
        if (delegate != null) {
            delegate.deliverMessage(builder.toString());
        }
//        System.out.println(censoredMessage);
    }

    public static void main(String[] args){
//        WordCensor a = new WordCensor("Microsoft");
//        a.deliverMessage("Microsoft Windows is great!!");
//        SocialChannel channel =new WordCensor(new URLAppender("http://jpereira.eu"), "Microsoft");
//        System.out.println(channel.deliverMessage(););
    }

    public static String censorWords(String... words) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (sb.length() > 0) sb.append("|");
            sb.append(
                    String.format("(?<=(?=%s).{0,%d}).",
                            Pattern.quote(w),
                            w.length()-1
                    )
            );
        }
        return sb.toString();
    }
}
