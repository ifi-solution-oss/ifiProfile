import java.util.UUID;
public class StringRandomizer {
	
	public StringRandomizer() {
		String uuid = UUID.randomUUID().toString();
		//Now this uuid enter to your text box
		//driver.findElement(By.id("text box id")).sendKeys(uuid);
		// random string of length 8 composed of alphabetic characters 
		//String s = RandomStringUtils.randomAlphabetic(8); 

		// random string of length 8 composed of alphabetic characters and numbers
		//String s = RandomStringUtils.randomAlphanumeric(8); 

		// random string of length 8 composed only of lettes a, b, and c
		//String alphabet = "abc";
		//String s = RandomStringUtils.random(8, alphabet);
	}

public static String randomString(int intValue) throws Exception {
    char c[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    int randomPosition;
    String randomString = "";
    for (int i = 0; i < intValue; i++) {
        //randomPosition = generateRandomIntIntRange(0, 51);
        //randomString = randomString + c[randomPosition]; 
    }
    System.out.println(randomString);
    return randomString;        
}
}

