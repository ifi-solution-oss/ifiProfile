import java.util.Random;

public class MapingMatrix {

		// TODO Auto-generated constructor stub
		public void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {
			  
		    int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();
		 
		    System.out.println(generatedString);
		}
	}

