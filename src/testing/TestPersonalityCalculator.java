package testing;
//Uncomment the below code to test your application

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import service.PersonalityCalculator;

public class TestPersonalityCalculator {
	PersonalityCalculator pc = new PersonalityCalculator();

	@Test
	public void testFindYourBrainTypeMethod() {
		String options = "1,2,3,2,1,4,5,2,3,4,5,4,3,2,3,4,5,3,2,4";
		assertEquals("rightbrained",pc.findYourBrainType(options));
		options = "4,5,4,2,5,3,2,4,3,5,4,5,2,4,3,2,3,5,2,4";
		assertEquals("leftbrained",pc.findYourBrainType(options));
		options = "1,2,3,2,1,4,2,2,2,2,2,4,3,2,3,4,2,3,2,4";
		assertEquals("noclearpreference",pc.findYourBrainType(options));
		try {
			if(options.contains("0"))
				pc.findYourBrainType(options);
			if(options.contains(null))
				pc.findYourBrainType(options);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}