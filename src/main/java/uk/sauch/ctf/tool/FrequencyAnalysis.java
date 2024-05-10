package uk.sauch.ctf.tool;

import java.util.ArrayList;
import java.util.Map;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class FrequencyAnalysis implements IFrequencyAnalysis {
    @Override
    public Map<Character, Integer> characterFrequency(final String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(
                        identity(),
                        summingInt(c -> 1)));
    }

    @Override
    public Map<Bigram, Integer> bigramFrequency(final String input) {
        var bigrams = new ArrayList<Bigram>();
        for (int i = 0; i < input.length() - 1; i++) {
            bigrams.add(Bigram.of(input.substring(i, i + 2)));
        }

        return bigrams.stream().collect(groupingBy(
                identity(),
                summingInt(b -> 1)));
    }

    @Override
    public Map<Trigram, Integer> trigramFrequency(final String input) {
        var trigmars = new ArrayList<Trigram>();
        for (int i = 0; i < input.length() - 2; i++) {
            trigmars.add(Trigram.of(input.substring(i, i + 3)));
        }

        return trigmars.stream().collect(groupingBy(
                identity(),
                summingInt(b -> 1)));
    }
}
