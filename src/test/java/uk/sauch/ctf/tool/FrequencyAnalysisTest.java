package uk.sauch.ctf.tool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FrequencyAnalysisTest {

    public static final String INPUT = "LIVITCSWPIYVEWHEVSRIQMXLEYVEOIEWHRXEXIPFEMVEWHKVSTYLXZIXLIKIIXPIJVSZEYPERRGERIM" +
                                       "WQLMGLMXQERIWGPSRIHMXQEREKIETXMJTPRGEVEKEITREWHEXXLEXXMZITWAWSQWXSWEXTVEPMRXRSJ" +
                                       "GSTVRIEYVIEXCVMUIMWERGMIWXMJMGCSMWXSJOMIQXLIVIQIVIXQSVSTWHKPEGARCSXRWIEVSWIIBXV" +
                                       "IZMXFSJXLIKEGAEWHEPSWYSWIWIEVXLISXLIVXLIRGEPIRQIVIIBGIIHMWYPFLEVHEWHYPSRRFQMXLE" +
                                       "PPXLIECCIEVEWGISJKTVWMRLIHYSPHXLIQIMYLXSJXLIMWRIGXQEROIVFVIZEVAEKPIEWHXEAMWYEPP" +
                                       "XLMWYRMWXSGSWRMHIVEXMSWMGSTPHLEVHPFKPEZINTCMXIVJSVLMRSCMWMSWVIRCIGXMWYMX";

    private static final IFrequencyAnalysis ANALYSIS = new FrequencyAnalysis();

    @Test
    void should_calculate_characters_frequency() {
        // when
        var result = ANALYSIS.characterFrequency(INPUT);

        // then
        assertThat(result)
                .hasSize(25)
                .containsEntry('N', 1)
                .containsEntry('F', 6)
                .containsEntry('W', 35)
                .containsEntry('I', 58)
        ;
    }

    @Test
    void should_calculate_bigrams_frequency() {
        // when
        var result = ANALYSIS.bigramFrequency(INPUT);

        // then
        assertThat(result)
                .hasSize(199)
                .containsEntry(Bigram.of("XL"), 13)
                .containsEntry(Bigram.of("VI"), 8)
                .containsEntry(Bigram.of("ER"), 6)
                .containsEntry(Bigram.of("II"), 4)
                .containsEntry(Bigram.of("CS"), 3);
    }

    @Test
    void should_calculate_trigrams_frequency() {
        // when
        var result = ANALYSIS.trigramFrequency(INPUT);

        // then
        assertThat(result)
                .hasSize(386)
                .containsEntry(Trigram.of("XLI"), 9)
                .containsEntry(Trigram.of("IVI"), 4)
                .containsEntry(Trigram.of("VIZ"), 2)
                .containsEntry(Trigram.of("AEK"), 1);
    }
}