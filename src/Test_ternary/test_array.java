package Test_ternary;

import java.util.Arrays;

public class test_array {
    public static void main(String[] args) {
        String[] str = new String[10];
        str[0] = "sdf";
        str[1] = str[0].concat("1111");
        str[1] = str[1].concat("!!!!!");
        str[2] = str[2].concat("2222");
        System.out.println(Arrays.toString(str));
    }

}
