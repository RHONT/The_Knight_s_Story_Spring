package Test_ternary;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class test_calk_ {
    static int Missiles_attack(int a) {
        int buf = a;
        while (buf == a) {
            buf = new Random().nextInt(4) + 1;
        }
        return buf;
    }

    public static void main(String[] args) {
        int i = 0;
//         while (i!=100) {
//             i++;
//             System.out.println(Missiles_attack(2));
//         }
        Map<Integer, String> parts_of_body = new TreeMap<>();
        parts_of_body.put(1, "голове");
        parts_of_body.put(2, "телу");
        parts_of_body.put(3, "рукам");
        parts_of_body.put(4, "ногам");

        Iterator it = parts_of_body.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            if (pairs.getValue() == "ногам") {
                System.out.println(pairs.getKey());
            }
        }
        it.remove();
    }
}
