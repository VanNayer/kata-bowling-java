import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputeBowlingScoreUTest {

	private ComputeBowlingScore computeBowlingScore;

	@Before
	public void setup() {
		computeBowlingScore = new ComputeBowlingScore();
	}

	@Test
	public void parseScoreInRoundsList_WithEverythingMissed_ShouldReturn10Round() {
		// setup

		// action
		List<Round> roundsList = computeBowlingScore
				.parseScoreInRoundsList("--------------------");

		// assert
		Assert.assertEquals(10, roundsList.size());
	}
	
	@Test
	public void parseScoreInRoundsList_WithAStrikeInTheMiddle_ShouldReturn10Rounds() {
		// setup

		// action
		List<Round> roundsList = computeBowlingScore
				.parseScoreInRoundsList("------X------------");

		// assert
		Assert.assertEquals(10, roundsList.size());
	}

	@Test
	public void parseScoreInRoundsList_With2StrikeInARowInTheMiddle_ShouldReturn10Rounds() {
		// setup

		// action
		List<Round> roundsList = computeBowlingScore
				.parseScoreInRoundsList("------XX----------");

		// assert
		Assert.assertEquals(10, roundsList.size());
	}
	
	
	@Test
	public void parseScoreInRoundsList_With2SpareInTheMiddle_ShouldReturn10Rounds() {
		// setup

		// action
		List<Round> roundsList = computeBowlingScore
				.parseScoreInRoundsList("------4/-----/------");

		// assert
		Assert.assertEquals(10, roundsList.size());
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
	public void compute_withOneSpareAllPinsOnSecondShoot_ShouldReturn10() {
		// Setup

		// Test
		int computedScore = computeBowlingScore.compute("-------/------------");

		// Asserts
		Assert.assertEquals(Round.SPARE_NUMBERPOINTS, computedScore);

	}

	@Test
	public void compute_withOneSpareInTwoTimes_ShouldReturn10() {
		// Setup

		// Test
		int computedScore = computeBowlingScore
				.compute("------4/------------");

		// Asserts
		Assert.assertEquals(Round.SPARE_NUMBERPOINTS, computedScore);

	}

	@Test
	public void compute_withTwoSpare_ShouldReturn20() {
		// Setup

		// Test
		int computedScore = computeBowlingScore
				.compute("------4/-----/------");

		// Asserts
		Assert.assertEquals(Round.SPARE_NUMBERPOINTS * 2, computedScore);

	}

	@Test
	public void compute_withOneStrike_ShouldReturn10() {
		// Setup

		// Test
		int computedScore = computeBowlingScore.compute("--------X----------");

		// Asserts
		Assert.assertEquals(Round.STRIKE_NUMBERPOINTS, computedScore);

	}

	@Test
	public void compute_with2StrikesInRow_ShouldReturn40() {
		// Setup

		// Test
		int computedScore = computeBowlingScore.compute("------XX----------");

		// Asserts
		Assert.assertEquals(30, computedScore);

	}

	@Test
	/**
	 * A partir d'ici c'est imbitable, on a laché la V0 
	 */
	public void compute_with1SpareFollowedByStrike_ShouldReturn30() {
		// Setup

		// Test
		int computedScore = computeBowlingScore.compute("--------4/X--------");

		// Asserts
		Assert.assertEquals(20, computedScore);

	}

	@Test
	public void compute_withPerfectGame_ShouldReturn300() {
		// Setup

		// Test
		int computedScore = computeBowlingScore.compute("XXXXXXXXXXXX");

		// Asserts
		Assert.assertEquals(300, computedScore);

	}

}
