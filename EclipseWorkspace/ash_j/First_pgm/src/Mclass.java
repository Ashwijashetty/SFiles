
public class Mclass {
	
	   public static void main( String args[] )
	   {
	      String firstString = "This sentence ends in 5 stars *****";
	         
	      System.out.printf( "Original String 1: %s\n", firstString );

	      // replace 'stars' with 'carets'
	      firstString = firstString.replaceAll( "stars", "carets" );

	      System.out.printf(
	         /*"\"carets\" substituted for \"stars\":*/" %s\n", firstString );

	   }
	}

