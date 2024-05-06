package uk.sauch.ctf.caesar;

public interface IStringCipher {
    String encode(String input);

    String decode(String input);
}
