package patternMatching;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        String example = "asender id: 116/sequence number: 117/depth: 443/sending time: 4/23/2020 2:08:54 AM/data: Hello I am SN: 116 this is event # 117 from my sideEnd-End Delay is:2.74550137092987E-05delay registered @ Sink: 621.932901880787";
        Pattern pattern = Pattern.compile("1{2}|7{1}");
        Matcher matcher = pattern.matcher(example);
        while (matcher.find()) {
        	System.out.println(matcher.start()+":"+matcher.end());
            System.out.println(matcher.group());
        }
    }
}
//0-9 are 48 -57
//a-z : 97 to 122
//A-Z : 65 to 90
