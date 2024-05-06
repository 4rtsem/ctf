package uk.sauch.ctf;

import uk.sauch.ctf.caesar.CaesarStringCipher;
import uk.sauch.ctf.caesar.IStringCipher;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        challenge0();
    }

    private static void challenge0() throws IOException {
        final var fileName = "0000challenge0.txt";
        var fileContent = readFileAsString(fileName);

        final IStringCipher cipher = new CaesarStringCipher();
        for (int i = 0; i < 27; i++) {
            System.out.print("i = " + i + " " + fileContent);
            fileContent = cipher.decode(fileContent);
        }
    }

    private static String readFileAsString(String fileName) throws IOException {
        var bytes = new DataInputStream(new FileInputStream(fileName)).readAllBytes();
        return new String(bytes);
    }
}