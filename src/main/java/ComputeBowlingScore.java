import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComputeBowlingScore {

	public int compute(String allScores) {

		int score = 0;
		List<Round> rounds = parseScoreInRoundsList(allScores);

		for (int roundNumber = 0; roundNumber < 10; roundNumber++) {

			Round currentRound = rounds.get(roundNumber);
			score = score + currentRound.computeRoundScore();
		}
		return score;
	}

	protected List<Round> parseScoreInRoundsList(String allScores) {
		List<Round> rounds = new ArrayList<Round>();

		List<Character> scoreList = createIteratorOnScoresChars(allScores);
		Iterator<Character> it = scoreList.iterator();

		int throwNumber = 0;
		while (it.hasNext()) {

			Character currentThrow = it.next();
			Character nextThrow = throwNumber + 1 < scoreList.size() ? scoreList.get(throwNumber + 1) : '-';
			Character afterNextThrow = throwNumber + 2 < scoreList.size() ? scoreList.get(throwNumber + 2) : '-';
			Round round = new Round(nextThrow, afterNextThrow); 
			throwNumber++;


			switch (currentThrow) {
			case 'X':
				round.beAStrike();
				break;

			default:
				Character next = it.next();
				switch (next) {
				case '/':
					round.beASpare();
					break;
				case '-': 
				default:
					round.beNormal(currentThrow, next);
					break;
				}

				break;
			}
			rounds.add(round);

		}
		return rounds;
	}

	private List<Character> createIteratorOnScoresChars(String allScores) {
		List<Character> scoreList = new ArrayList<Character>();
		char[] scoresArray = allScores.toCharArray();
		for (char scoreInChar : scoresArray) {
			scoreList.add(new Character(scoreInChar));
		}

		return scoreList;
	}

	/**
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */

//	public int computeV0(String allScores) {
//		int score = 0;
//
//		char[] scoresArray = allScores.toCharArray();
//		char previousScore = '0';
//		for (char currentScore : scoresArray) {
//
//			if (currentScore != '-') {
//				if (currentScore == '/') {
//					score += 10 - Character.getNumericValue(previousScore);
//					previousScore = '0';
//				} else if (currentScore == 'X') {
//					if (previousScore == 'X') {
//						score += 10 * 2;
//					}
//					score += 10;
//					previousScore = currentScore;
//				} else {
//					int currentScoreValue = Character.getNumericValue(currentScore);
//					score += currentScoreValue;
//					previousScore = currentScore;
//				}
//			}
//
//		}
//		return score;
//	}

}
