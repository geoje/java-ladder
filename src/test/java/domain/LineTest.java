package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("라인")
public class LineTest {
    @DisplayName("랜덤 생성 테스트")
    @Test
    void randomCreateTest() {
        // given
        int count = 3;
        Function<Integer, List<Boolean>> generator = number -> List.of(true, false, true);
        List<Boolean> expected = List.of(true, false, true);

        // when
        Line actual = Line.create(generator, count);

        // then
        assertThat(actual)
                .extracting("scaffold")
                .isEqualTo(expected);
    }
}
