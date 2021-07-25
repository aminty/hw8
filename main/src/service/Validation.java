package service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public String isValid(String regex, String msg, String errMsg) {
        String input;
        Pattern pt = Pattern.compile(regex);
        while (true) {
            try {
                System.out.print("-> "+msg);
                input = new Scanner(System.in).next();
                Matcher mt = pt.matcher(input);
                if (mt.matches()) return input;
                 else throw new Exception(errMsg);
            } catch (Exception e) {
                PrintMessage.showErr(e.getMessage());
            }
        }
    }
}
