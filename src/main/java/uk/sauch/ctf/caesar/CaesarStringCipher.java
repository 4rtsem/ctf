package uk.sauch.ctf.caesar;

public class CaesarStringCipher implements IStringCipher {

    @Override
    public String encode(String input) {
        return input.chars()
                .map(i -> {
                    if (isUppercaseCharacter(i)) {
                        var i1 = i - 3;
                        if (i1 < 65) {
                            i1 += 26;
                        }
                        return i1;
                    }
                    if (isLowercaseCharacter(i)) {
                        var i1 = i - 3;
                        if (i1 < 97) {
                            i1 += 26;
                        }
                        return i1;

                    }
                    return i;
                })
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    public String decode(String input) {
        return input.chars()
                .map(i -> {
                    if (isUppercaseCharacter(i)) {
                        var i1 = i + 3;
                        if (i1 > 90) {
                            i1 -= 26;
                        }
                        return i1;
                    }
                    if (isLowercaseCharacter(i)) {
                        var i1 = i + 3;
                        if (i1 > 122) {
                            i1 -= 26;
                        }
                        return i1;

                    }
                    return i;
                })
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static boolean isUppercaseCharacter(int i) {
        return i >= 65 && i <= 90;
    }

    private static boolean isLowercaseCharacter(int i) {
        return i >= 97 && i <= 122;
    }

}
