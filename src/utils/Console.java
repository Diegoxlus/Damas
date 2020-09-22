package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Console {

    public static Console console;

    public static Console instance() {
        if (Console.console == null) {
            Console.console = new Console();
        }
        return Console.console;
    }
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readString(String message) {
        String input = null;
        this.write(message);
        try {
            input = this.bufferedReader.readLine();
        } catch (Exception ex) {
            writeError("string");
        }
        return input;
    }

    public String readString() {
        return this.readString("");
    }

    public int readInt(String message) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readString(message));
                ok = true;
            } catch (Exception ex){
                this.writeError("integer");
            }
        } while (!ok);

        return input;
    }

    public void write(String string) {
        System.out.print(string);
    }

    public void writeln(String string) {
        System.out.println(string);
    }

    public void writeError(String validFormat){
        System.out.println("FORMAT ERROR!!!, "+ "Enter a " + validFormat);
    }

    public char readChar(String message) {
        char charValue = ' ';
        boolean ok = false;
        do {
            String input = this.readString(message);
            if (input.length() != 1) {
                this.writeError("character");
            } else {
                charValue = input.charAt(0);
                ok = true;
            }
        } while (!ok);
        return charValue;
    }
}
