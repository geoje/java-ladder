package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder create(
            BiFunction<Integer, Integer, List<Line>> generator,
            People people,
            LadderHeight ladderHeight) {
        return new Ladder(generator.apply(people.getCount(), ladderHeight.getValue()));
    }
}
