package ladder.view;

import ladder.domain.Person;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String EXECUTION_RESULT = "실행결과" + System.lineSeparator();
    private static final String PEOPLE_NAMES_DELIMITER = " ";
    private static final String LADDER_FORMAT = String.format("%%%ds", Person.getMaxLength());
    private static final String LINE_PILLAR = "|";
    private static final String LINE_PREFIX = String.format(LADDER_FORMAT, LINE_PILLAR);
    private static final String LADDER_SCAFFOLD = "-".repeat(Person.getMaxLength());
    private static final String LADDER_BLANK = " ".repeat(Person.getMaxLength());

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResult(List<String> names, List<List<Boolean>> lines) {
        printResultTitle();
        printPeopleNames(names);
        printLadderLines(lines);
    }

    private static void printResultTitle() {
        System.out.println(EXECUTION_RESULT);
    }

    private static void printPeopleNames(List<String> names) {
        StringJoiner joiner = new StringJoiner(PEOPLE_NAMES_DELIMITER);
        names.forEach(name -> joiner.add(String.format(LADDER_FORMAT, name)));
        System.out.println(joiner);
    }

    private static void printLadderLines(List<List<Boolean>> lines) {
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(List<Boolean> line) {
        StringJoiner joiner = new StringJoiner(LINE_PILLAR, LINE_PREFIX, LINE_PILLAR);
        line.forEach(exist -> joiner.add(selectScaffold(exist)));
        System.out.println(joiner);
    }

    private static String selectScaffold(Boolean exist) {
        if (exist) {
            return LADDER_SCAFFOLD;
        }
        return LADDER_BLANK;
    }
}
