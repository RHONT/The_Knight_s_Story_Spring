package Test_ternary;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class thrads {
    public static void main(String[] args) {
        ExecutorService as = Executors.newFixedThreadPool(5);

        human h1 = new human(5);
        h1.print();
        zombie z1 = new zombie(40, 10);
        z1.print();
        inter_1 i1 = h1;
        int b = i1.abc(500);
        System.out.println(b);

        inter_1 i2 = z1;

        int c = i2.abc(500);
        System.out.println(c);

        printable pr1 = h1;
        printable pr2 = z1;

        pr1.print();
        pr2.print();
        SuperVolidation s1 = z1;
        z1.Power_Agility("dsd", "sdfsd");

        testt t1 = new testt("Вася", "Пупки");
        System.out.println(t1.name);

        inter_1 i3 = new human(50);
        i3.abc(50);

    }

}

interface inter_1 {
    int abc(int a);
}

interface printable {
    void print();
}

interface SuperVolidation {
    String Power_Agility(String a, String b);
}

class human implements inter_1, printable, SuperVolidation {
    int a;

    @Override
    public int abc(int a) {
        return a * 2;

    }

    public human(int a) {
        this.a = abc(a);
    }

    @Override
    public void print() {
        System.out.println(a);
    }

    @Override
    public String Power_Agility(String a, String b) {
        return (a + b + b);

    }
}

class zombie extends human {

    public zombie(int a, int b) {
        super(a);
        this.a += b;
    }

    @Override
    public String Power_Agility(String a, String b) {
        return (a + b);


    }

    @Override
    public int abc(int a) {
        return super.abc(a + 200);
    }

    @Override
    public void print() {
        System.out.println("Это зомби, он весит: " + a);
    }
}

class testt {
    human as = new zombie(10, 50);
    String name = new String("");
    human az = (human) as;

    public testt(String a, String b) {
        // name=name.concat(az.Power_Agility(a,b)); //работает
        name = name.concat(as.Power_Agility(a, b));
        //as.print();
    }
}