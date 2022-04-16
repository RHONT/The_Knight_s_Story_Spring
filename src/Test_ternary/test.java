package Test_ternary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class test {


    public static void main(String[] args) {
        int a = 2;

        String s = (a == 1 ? "1" : a == 2 ? "2" : a == 3 ? "3" : a == 4 ? "4" : "Incorrect input");
        System.out.println(s);
        List<Monsters> arrMonsters = new ArrayList<>();
        arrMonsters.add(new Monsters("Goblin"));
        arrMonsters.add(new Monsters("Zombie"));
        arrMonsters.add(new Monsters("Witcher"));
        arrMonsters.add(new Monsters("Fish_eye"));

        Comparator<Monsters> comparator_Monster2 = (o1, o2) -> o1.getId();
        Comparator<Monsters> comparator_Monster = new Comparator<Monsters>() {
            @Override
            public int compare(Monsters o1, Monsters o2) {
                return o1.getId();
            }
        };


    }
}

class Monsters implements Comparable<Monsters> {

    int id;
    String name;

    Monsters(String name) {
        this.name = name;
        this.id = new Random().nextInt(100) + 1;
    }

    public int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    @Override
    public int compareTo(Monsters o1) {
        if (this.id == o1.id) {
            return 0;
        } else if (this.id < o1.id) {
            return -1;
        } else {
            return 1;
        }
    }
}
