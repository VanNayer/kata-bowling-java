public class ComputeBowlingScore {

	public int compute(String allScores) {
		int score = 0;

		char[] scoresArray = allScores.toCharArray();
		for (char currentScore : scoresArray) {

			if (currentScore != '-') {
				score += Character.getNumericValue(currentScore);
			}

		}
		return score;
	}

}
