package uk.sauch.ctf.caesar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CaesarStringCipherTest {

    final IStringCipher cipher = new CaesarStringCipher();

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "XYZABCDEFGHIJKLMNOPQRSTUVW"),
                Arguments.of("abcdefghijklmnopqrstuvwxyz", "xyzabcdefghijklmnopqrstuvw"),
                Arguments.of("!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~", "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"),
                Arguments.of("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD")
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void should_encode(final String plainText, final String expected) {
        // when
        final var actual = cipher.encode(plainText);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void should_decode(final String expected, final String encoded) {
        // when
        final var actual = cipher.decode(encoded);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}