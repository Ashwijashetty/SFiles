package new_pack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regularexp {
	public static void main(String[] args) {
		String inputStr="Test String";
		String patern="Test String";
		boolean patternMatched=Pattern.matches(patern,inputStr);
		System.out.println(patternMatched);
		String input="Shop,Mop,Hopping,Chopping";
		Pattern pattern=Pattern.compile("hop");
        Matcher matcher=pattern.matcher(input);
        System.out.println(matcher.matches());
        while(matcher.find())
        {
        	System.out.println(matcher.group()+" : "+matcher.start()+": "+matcher.end());
         }
        
		
	}

}
