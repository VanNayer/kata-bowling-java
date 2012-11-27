import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ComputeBowlingScoreUTest {

	ComputeBowlingScore computeBowlingScore = new ComputeBowlingScore(); 
	
	@Before
	public void setup() {
		computeBowlingScore = new ComputeBowlingScore(); 
	}
	
	@Test
	public void compute_WithEverythingMissed_ShouldReturnZero() {
		
		// setup
		
		// action
		int computedScore = computeBowlingScore.compute("--------------------");
		
		// assert
		Assert.assertEquals(0, computedScore);
	}


	@Test
	public void compute_WithOnePinDownEachTime_ShouldReturn20() {
		
		// setup
		
		// action
		int computedScore = computeBowlingScore.compute("11111121111111111111");
		
		// assert
		Assert.assertEquals(21, computedScore);
	}

	@Test
	public void compute_withOneSpare_ShouldReturn10() {
		//Setup
		

		//Test

		//Asserts

	}
}
