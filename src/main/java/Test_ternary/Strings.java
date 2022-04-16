package Test_ternary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {

    static void read_file() {
        File buf_read = new File("C:\\IO__NIO\\1.txt");
        String text;
        ArrayList<String> rr = new ArrayList<>();


        try {
            Scanner scan_for_read = new Scanner(buf_read);

            while (scan_for_read.hasNext()) {
                text = scan_for_read.nextLine();
                if (text == "#####################") rr.add("*");
                Pattern pattern = Pattern.compile("\\d+");
                Matcher m = pattern.matcher(text);
                while (m.find()) {
                    rr.add(m.group());
                }
            }
            scan_for_read.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Часть истории не найдена");

        }
        System.out.println(rr);
    }

    public static void main(String[] args) {
        read_file();
    }
}

