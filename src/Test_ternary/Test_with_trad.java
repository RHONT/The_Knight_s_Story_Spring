package Test_ternary;

import java.util.Random;

import static Test_ternary.Unit.*;

public class Test_with_trad {
    public static void main(String[] args) {

        Thread t1 = new Thread(new r_good());
        Thread t2 = new Thread(new r_enemy());
        t2.start();
        t1.start();


    }
}

class Unit {
    static final Object lock = new Object();

    static int health_hero = 500;
    static int damag_hero = 5;
    static int damag_enemy = 5;
    static int health_enemy = 500;

    static void atack_good() {
        synchronized (lock) {

            health_hero -= damag_enemy;
            health_enemy -= damag_hero;
            System.out.println("Поток хороший:  Жизнь Врага:" + health_enemy + "  Он бьет героя на: " + damag_enemy);
            System.out.println("Поток хороший:  Жизнь Героя: " + health_hero + "  Он бьет героя на: " + damag_hero);

        }
    }

    static void atack_enemy() {
        synchronized (lock) {

            health_hero -= damag_enemy;
            health_enemy -= damag_hero;
            System.out.println("Поток плохой:  Жизнь Врага:" + health_enemy + "  Он бьет героя на: " + damag_enemy);
            System.out.println("Поток плохой:  Жизнь Героя: " + health_hero + "  Он бьет героя на: " + damag_hero);
        }
    }
}


class r_good implements Runnable {
    @Override
    public void run() {
        while ((health_enemy >= 0) && (health_hero >= 0)) {
            atack_good();
        }
        if (health_enemy <= 0) System.out.println("Злодей умер!");
        if (health_hero <= 0) System.out.println("Герой умер!");
    }
}

class r_enemy implements Runnable {
    @Override
    public void run() {
        while ((health_enemy >= 0) && (health_hero >= 0)) {
            atack_enemy();
        }
        if (health_enemy <= 0) System.out.println("Злодей умер!");
        if (health_hero <= 0) System.out.println("Герой умер!");
    }
}


