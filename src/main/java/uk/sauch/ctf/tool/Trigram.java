package uk.sauch.ctf.tool;

public record Trigram(Character first, Character second, Character third) {
    public static Trigram of(final String string) {
        assert string.length() == 3;
        return new Trigram(string.charAt(0), string.charAt(1), string.charAt(2));
    }

    @Override
    public String toString() {
        return String.valueOf(first) + second + third;
    }
}
