package uk.sauch.ctf.tool;

import java.util.Map;

public interface IFrequencyAnalysis {
    Map<Character, Integer> characterFrequency(final String input);

    Map<Bigram, Integer> bigramFrequency(final String input);

    Map<Trigram, Integer> trigramFrequency(final String input);
}
