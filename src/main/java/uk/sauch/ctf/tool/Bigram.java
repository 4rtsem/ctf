package uk.sauch.ctf.tool;

public record Bigram(Character first, Character second) {
    public static Bigram of(final String string) {
        assert string.length() == 2;
        return new Bigram(string.charAt(0), string.charAt(1));
    }

    @Override
    public String toString() {
        return String.valueOf(first) + second;
    }
}
