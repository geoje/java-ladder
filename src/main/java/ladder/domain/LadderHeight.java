package ladder.domain;

public class LadderHeight {

    private static final int MIN_HEIGHT = 1;

    private final int value;

    private LadderHeight(int value) {
        this.value = value;
        validateMin(value);
    }

    public static LadderHeight from(String height) {
        return new LadderHeight(Integer.parseInt(height));
    }

    private static void validateMin(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 1 이상의 정수이어야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
