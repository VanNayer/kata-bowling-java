import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoundUTest {
	private Round currentRound;

	@Before
	public void setup() {

	}

	

	@Test
	public void computeRoundScore_withANormalRound_shouldBeOnlyValue() {
		// Setup
		currentRound = new Round(null , null);
		currentRound.beNormal(3);

		// Test
		int computedScore = currentRound.computeRoundScore();

		// Asserts
		Assert.assertEquals(3, computedScore);

	}

	@Test
	public void computeRoundScore_withASpareRound_shouldAddTheNextTrowValue() {
		// Setup
		currentRound = new Round('3' , null);
		currentRound.beASpare();

		// Test
		int computedScore = currentRound.computeRoundScore();

		// Asserts
		Assert.assertEquals(13, computedScore);

	}
	
	@Test
	public void computeRoundScore_withASpareRoundFollowedByAFail_shouldAddTheNextTrowValue() {
		// Setup
		currentRound = new Round('-' , null);
		currentRound.beASpare();

		// Test
		int computedScore = currentRound.computeRoundScore();

		// Asserts
		Assert.assertEquals(10, computedScore);

	}
	
	@Test
	public void computeRoundScore_withASpareRoundFollowedByAStrike_shouldAddTheNextTrowValue() {
		// Setup
		currentRound = new Round('X' , null);
		currentRound.beASpare();

		// Test
		int computedScore = currentRound.computeRoundScore();

		// Asserts
		Assert.assertEquals(20, computedScore);

	}


	@Test
	public void computeRoundScore_withAStrikeRound_shouldAddTheTwoNextTrowValue() {
		// Setup
		currentRound= new Round('3' ,'4');
		currentRound.beAStrike();
		

		// Test
		int computedScore = currentRound.computeRoundScore();

		// Asserts
		Assert.assertEquals(17, computedScore);

	}
	
	@Test
	public void computeRoundScore_withAStrikeRoundFollowedByAStrikeThenASimple_shouldAddTheTwoNextTrowValue() {
		// Setup
		currentRound= new Round('X' ,'4');
		currentRound.beAStrike();
		

		// Test
		int computedScore = currentRound.computeRoundScore();

		// Asserts
		Assert.assertEquals(24, computedScore);

	}
	
	@Test
	public void computeRoundScore_withAStrikeRoundFollowedByTwoStrikes_shouldAddTheTwoNextTrowValue() {
		// Setup
		currentRound= new Round('X' ,'X');
		currentRound.beAStrike();
		

		// Test
		int computedScore = currentRound.computeRoundScore();

		// Asserts
		Assert.assertEquals(30, computedScore);

	}
	
	@Test
	public void computeRoundScore_withAStrikeRoundFollowedByASpare_shouldAddTen() {
		// Setup
		currentRound= new Round('3' ,'/');
		currentRound.beAStrike();
		

		// Test
		int computedScore = currentRound.computeRoundScore();

		// Asserts
		Assert.assertEquals(20, computedScore);

	}
}
