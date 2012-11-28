public class Round {

	private RoundType roundType;
	private int value;
	private Character nextThrow;
	private Character afterNextThrow;

	protected static final int STRIKE_NUMBERPOINTS = 10;
	protected final static int SPARE_NUMBERPOINTS = 10;

	public Round(Character nextThrow, Character afterNextThrow) {
		this.nextThrow = nextThrow;
		this.afterNextThrow = afterNextThrow;

	}

	public void beAStrike() {
		this.roundType = RoundType.STRIKE;
	}

	public void beASpare() {
		this.roundType = RoundType.SPARE;

	}

	public void beNormal(Character firstThrow, Character secondThrow) {
		this.roundType = RoundType.NORMAL;
		this.value = getValueFromAChar(firstThrow) + getValueFromAChar(secondThrow) ;
	}

	public int computeRoundScore() {
		int bonus = 0;
		switch (roundType) {
		case SPARE:
			bonus = getValueFromAChar(nextThrow);
			return SPARE_NUMBERPOINTS + bonus;

		case STRIKE:
			bonus = getValueFromAChar(nextThrow);
			if (afterNextThrow == '/') {
				bonus = 10;
			} else {
				bonus += getValueFromAChar(afterNextThrow);
			}
			return SPARE_NUMBERPOINTS + bonus;

		default:
			return value;
		}

	}

	private int getValueFromAChar(Character throwCharacter) {
		int bonus = 0;
		if (Character.isDigit(throwCharacter)) {
			bonus = Character.getNumericValue(throwCharacter);
		} else if (throwCharacter == 'X') {
			bonus = STRIKE_NUMBERPOINTS;
		}
		return bonus;
	}

}
