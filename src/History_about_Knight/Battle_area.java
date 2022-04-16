
package History_about_Knight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static javax.swing.plaf.synth.Region.LABEL;

public class Battle_area {

    public static void main(String[] args) throws InterruptedException {
        Scanner history_stop = new Scanner(System.in);

        Zombie second = new Zombie("Zombie.txt");
        second.setDefense(0, 20, 0, 30);
        Knight first = new Knight("Knight.txt");
        first.setDefense(30, 30, 30, 30);
        Zombie third = new Zombie("Zombie.txt");
        third.setDefense(20, 50, 50, 50);
        Zombie outlaw_big = new Zombie("outlaw_big.txt");
        Zombie outlaw_small = new Zombie("outlaw_small.txt");
        Zombie bear = new Zombie("Bear.txt");
        Zombie outlaw_bridge_1 = new Zombie("outlaw_bridge.txt");
        outlaw_bridge_1.setDefense(0, 40, 10, 10);
        Zombie outlaw_bridge_2 = new Zombie("outlaw_bridge.txt");
        outlaw_bridge_2.setDefense(15, 25, 10, 0);
        Zombie outlaw_bridge_3 = new Zombie("outlaw_bridge.txt");
        outlaw_bridge_3.setDefense(0, 0, 30, 5);
        Zombie outlaw_bridge_4 = new Zombie("outlaw_bridge.txt");
        outlaw_bridge_4.setDefense(50, 10, 20, 20);
        Zombie knight_in_the_dark_1 = new Zombie("knight_in_the_dark.txt");
        knight_in_the_dark_1.setDefense(70, 70, 10, 10);
        Zombie knight_in_the_dark_2 = new Zombie("knight_in_the_dark.txt");
        knight_in_the_dark_2.setDefense(50, 100, 30, 10);
        Zombie knight_in_the_dark_3 = new Zombie("knight_in_the_dark.txt");
        knight_in_the_dark_3.setDefense(0, 100, 50, 50);

        read_file("[1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();

        read_file("[1-1].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(first, second, third);

        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        first.halt();    // привал

        first.level_up();  // повышение уровня

        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();

        first.print_inv_and_money();
        market_place(first);

        read_file("Thief_1.txt");
        first.bufer_string = history_stop.nextLine();
        first.thief_1 = (first.bufer_string.equals("1") ? true : false);

        read_file("out_law_story.txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(first, outlaw_small, outlaw_big);

        read_file("[2].txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test(first, bear);

        first.halt();    // привал
        first.level_up();  // повышение уровня

        read_file("[2-1].txt");
        bridge(first, outlaw_bridge_1, outlaw_bridge_2, outlaw_bridge_3, outlaw_bridge_4);
        bridge(first, outlaw_bridge_1, outlaw_bridge_2, outlaw_bridge_3, outlaw_bridge_4);
        System.out.println(Arrays.toString(first.param_inventory));
        first.halt();    // привал
        first.level_up();

        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        read_file("[3].txt");
        history_stop.nextLine();
        read_file("[4].txt");
        history_stop.nextLine();

        fight_test_vs_shadow(first, knight_in_the_dark_1, knight_in_the_dark_2);
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        first.halt();    // привал
        first.level_up();

        read_file("[5].txt");
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        fight_test_vs_shadow(first, knight_in_the_dark_1, knight_in_the_dark_2, knight_in_the_dark_3);
        first.halt();
        first.level_up();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        read_file("[6].txt");
        System.out.println();
        System.out.println("Нажмиет Enter для продолжения");
        history_stop.nextLine();
        first.halt();
        read_file("[7].txt");
        System.out.println("Нажмиет Enter для продолжения");

    }

    static String str(int a) {

        String buf_st;
        buf_st = Integer.toString(a);
        return buf_st;
    }  // служебная вещь. переводит быстро int в String.


    static String space(String s, int a) {
        String str = "";
        int buf;
        buf = a - s.length();
        for (int i = 0; i < buf; i++) {
            str = str + " ";
        }
        return str;
    }  // Добавляет нужное количество пробелов(функци связана с ровным выводами по столбцам)

    static void print_battle_life(Humanoid a, Humanoid b) {
        int maxlenght = 0;

        String[][] str = {{a.name, b.name},

                {"Шлем:           " + str(a.param_humanoid[0]) + "/" + str(a.copy_param_humanoid[0]) + " [" + str(a.defense[0]) + "]",
                        str(b.param_humanoid[0]) + "/" + str(b.copy_param_humanoid[0]) + " [" + str(b.defense[0]) + "]"},
                {"Нагрудник:      " + str(a.param_humanoid[1]) + "/" + str(a.copy_param_humanoid[1]) + " [" + str(a.defense[1]) + "]",
                        str(b.param_humanoid[1]) + "/" + str(b.copy_param_humanoid[1]) + " [" + str(b.defense[1]) + "]"},
                {"Нарукавники:    " + str(a.param_humanoid[2]) + "/" + str(a.copy_param_humanoid[2]) + " [" + str(a.defense[2]) + "]",
                        str(b.param_humanoid[2]) + "/" + str(b.copy_param_humanoid[2]) + " [" + str(b.defense[2]) + "]"},
                {"Поножи:         " + str(a.param_humanoid[3]) + "/" + str(a.copy_param_humanoid[3]) + " [" + str(a.defense[3]) + "]",
                        str(b.param_humanoid[3]) + "/" + str(b.copy_param_humanoid[3]) + " [" + str(b.defense[3]) + "]"},
                {"Сила орудия:    " + str(a.param_humanoid[4]), str(b.param_humanoid[4])}};


        for (String[] z : str) {
            if (z[0].length() > maxlenght) {
                maxlenght = z[0].length();
            }
            ;
        }

        maxlenght += 4;

        for (int i = 0; i < str.length; i++) {
            str[i][0] = str[i][0] + space(str[i][0], maxlenght) + str[i][1];
            System.out.println(str[i][0]);
        }
    }


    static void read_file(String str) {
        File buf_read = new File(str);
        //String path = buf_read.getAbsolutePath(); // показывает где лежит файл(нужно понять как переназначить корневую папку.)
        //System.out.println(path);
        try {
            Scanner scan_for_read = new Scanner(buf_read);
            while (scan_for_read.hasNext()) {
                System.out.println(scan_for_read.nextLine());
            }
            scan_for_read.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Часть истории не найдена");

        }
    }

    enum market {
        SHIELD(1, 200),
        POITIO_OF_HEALTH(2, 100),
        MOLOTOV(3, 150);

        private int numb_for_tovar;
        private int coast;

        market(int buf_number, int buf_coast) {

            this.numb_for_tovar = buf_number;
            this.coast = buf_coast;
        }

        public int getNumb_for_tovar() {
            return numb_for_tovar;
        }

        public int getCoast() {
            return coast;
        }
    }

    static void market_place(Humanoid buf) {
        System.out.println("Вас встречает трактирщик. На его прилавке скучают вещи, вы внимательно смотрите на них.");
        System.out.println(market.SHIELD.numb_for_tovar + " Щит | Цена: " + market.SHIELD.coast);
        System.out.println(market.POITIO_OF_HEALTH.numb_for_tovar + " Зелье здоровья | Цена: " + market.POITIO_OF_HEALTH.coast);
        System.out.println(market.MOLOTOV.numb_for_tovar + " Коктейль молотова | Цена: " + market.MOLOTOV.coast);
        System.out.println("0 Выход из трактира");

        while (!buf.market_exit) {
            String for_market_scanner;
            Scanner scan_market = new Scanner(System.in);
            for_market_scanner = scan_market.nextLine();
            switch (for_market_scanner) {
                case ("1"):
                    if (market.SHIELD.coast <= buf.money) {
                        buf.money -= market.SHIELD.coast;
                        buf.param_inventory[1] += 2;
                        System.out.println("Вы купили щит!");
                        break;
                    } else {
                        System.out.println("Невозможно купить щит. Вам не хватает " + (market.SHIELD.coast - buf.money));
                        break;
                    }
                case ("2"):
                    if (market.POITIO_OF_HEALTH.coast <= buf.money) {
                        buf.money -= market.POITIO_OF_HEALTH.coast;
                        buf.param_inventory[3] += 1;
                        System.out.println("Вы купили зелье!");
                        break;
                    } else {
                        System.out.println("Невозможно купить зелье. Вам не хватает " + (market.POITIO_OF_HEALTH.coast - buf.money));
                        break;
                    }

                case ("3"):
                    if (market.MOLOTOV.coast <= buf.money) {
                        buf.money -= market.MOLOTOV.coast;
                        buf.param_inventory[2] += 1;
                        System.out.println("Вы купили молотов");
                        break;
                    } else {
                        System.out.println("Невозможно купить коктейль молотова. Вам не хватает " + (market.MOLOTOV.coast - buf.money));
                        break;
                    }

                case ("0"): {
                    buf.market_exit = true;
                    break;
                }

                default:
                    System.out.println("Значение введено неправильно");
            }
        }
        buf.market_exit = false;

    }


    static void print_battle_life_vs_shadow(ArrayList<Humanoid> list) {
        int maxlenght = 0;
        String[] str_final_print = new String[]
                {"                " + list.get(0).name,
                        "Шлем:           " + str(list.get(0).param_humanoid[0]) + "/" + str(list.get(0).copy_param_humanoid[0]) + " [" + str(list.get(0).defense[0]) + "]",
                        "Нагрудник:      " + str(list.get(0).param_humanoid[1]) + "/" + str(list.get(0).copy_param_humanoid[1]) + " [" + str(list.get(0).defense[1]) + "]",
                        "Нарукавники:    " + str(list.get(0).param_humanoid[2]) + "/" + str(list.get(0).copy_param_humanoid[2]) + " [" + str(list.get(0).defense[2]) + "]",
                        "Поножи:         " + str(list.get(0).param_humanoid[3]) + "/" + str(list.get(0).copy_param_humanoid[3]) + " [" + str(list.get(0).defense[3]) + "]",
                        "Сила орудия:    " + str(list.get(0).param_humanoid[4])};


        for (int i = 1; i < list.size(); i++) {

            String[] str = {list.get(i).name, "", "", "", "", ""};

            for (String z : str_final_print) {
                if (z.length() > maxlenght) {
                    maxlenght = z.length();
                }
            }
            maxlenght += 4;

            for (int q = 0; q < str.length; q++) {
                str_final_print[q] = str_final_print[q].concat(space(str_final_print[q], maxlenght)).concat(str[q]);

            }
        }
        for (String s : str_final_print) {
            System.out.println(s);

        }
    }

    static void fight_test_vs_shadow(Humanoid first, Zombie... enemy) {
        int round = 0;
        int sum_enemy = enemy.length;
        System.out.println(sum_enemy);
        ArrayList<Humanoid> list_participant = new ArrayList<>();
        list_participant.add(first);

        for (int i = 0; i < sum_enemy; i++) {
            list_participant.add(enemy[i]);
        }

        while ((list_participant.get(0).Humanoid_is_alife()) && (list_participant.size() > 1)) {
            round++;
            System.out.println("*****" + "ROUND " + round + "**********************************************************************************************");
            print_battle_life_vs_shadow(list_participant);
            first.Attack(list_participant.get(1));
            first.print_info_fight();
            for (int i = 1; i < list_participant.size(); i++) {
                list_participant.get(i).Attack(first);
                list_participant.get(i).print_info_fight();
            }

            if (!list_participant.get(1).Humanoid_is_alife()) {
                list_participant.get(1).money = new Random().nextInt(90) + 100;
                System.out.println("Враг пал, вы собрали с трупа: " + list_participant.get(1).money + " золотых");
                first.money += list_participant.get(1).money;
                System.out.println();
                list_participant.remove(1).reborn();
                list_participant.remove(1);
            }
            if (!first.Humanoid_is_alife()) {
                System.out.println("Сэр Томас погиб. Его натура не выдержала вызова судьбы.");
                System.exit(0);
            }

        }
        first.down_health();  // Зелье бодрит, и завышает временно характеристики здоровья. После боя, все приходит в норму.
    }

    static void print_battle_life_test(ArrayList<Humanoid> list) {
        int maxlenght = 0;
        String[] str_final_print = new String[]
                {"                " + list.get(0).name,
                        "Шлем:           " + str(list.get(0).param_humanoid[0]) + "/" + str(list.get(0).copy_param_humanoid[0]) + " [" + str(list.get(0).defense[0]) + "]",
                        "Нагрудник:      " + str(list.get(0).param_humanoid[1]) + "/" + str(list.get(0).copy_param_humanoid[1]) + " [" + str(list.get(0).defense[1]) + "]",
                        "Нарукавники:    " + str(list.get(0).param_humanoid[2]) + "/" + str(list.get(0).copy_param_humanoid[2]) + " [" + str(list.get(0).defense[2]) + "]",
                        "Поножи:         " + str(list.get(0).param_humanoid[3]) + "/" + str(list.get(0).copy_param_humanoid[3]) + " [" + str(list.get(0).defense[3]) + "]",
                        "Сила орудия:    " + str(list.get(0).param_humanoid[4])};


        for (int i = 1; i < list.size(); i++) {

            String[] str = {list.get(i).name,
                    str(list.get(i).param_humanoid[0]) + "/" + str(list.get(i).copy_param_humanoid[0]) + " [" + str(list.get(i).defense[0]) + "]",
                    str(list.get(i).param_humanoid[1]) + "/" + str(list.get(i).copy_param_humanoid[1]) + " [" + str(list.get(i).defense[1]) + "]",
                    str(list.get(i).param_humanoid[2]) + "/" + str(list.get(i).copy_param_humanoid[2]) + " [" + str(list.get(i).defense[2]) + "]",
                    str(list.get(i).param_humanoid[3]) + "/" + str(list.get(i).copy_param_humanoid[3]) + " [" + str(list.get(i).defense[3]) + "]",
                    str(list.get(i).param_humanoid[4])};

            for (String z : str_final_print) {
                if (z.length() > maxlenght) {
                    maxlenght = z.length();
                }
            }
            maxlenght += 4;

            for (int q = 0; q < str.length; q++) {
                str_final_print[q] = str_final_print[q].concat(space(str_final_print[q], maxlenght)).concat(str[q]);

            }
        }
        for (String s : str_final_print) {
            System.out.println(s);

        }

    }

    static void fight_test(Humanoid first, Zombie... enemy) {
        int round = 0;
        int sum_enemy = enemy.length;
        System.out.println(sum_enemy);
        ArrayList<Humanoid> list_participant = new ArrayList<>();
        list_participant.add(first);

        for (int i = 0; i < sum_enemy; i++) {
            list_participant.add(enemy[i]);
        }

        while ((list_participant.get(0).Humanoid_is_alife()) && (list_participant.size() > 1)) {
            round++;
            System.out.println("*****" + "ROUND " + round + "**********************************************************************************************");
            print_battle_life_test(list_participant);
            first.Attack(list_participant.get(1));

            if (first.vortex == true) {
                for (int i = 1; i < list_participant.size(); i++) {
                    for (int j = 0; j < 4; j++) {
                        list_participant.get(i).param_humanoid[j] -= 40;
                    }
                }
                first.vortex = false;
            }

            first.print_info_fight();
            for (int i = 1; i < list_participant.size(); i++) {
                list_participant.get(i).Attack(first);
                list_participant.get(i).print_info_fight();
            }

            for (int i = 1; i < list_participant.size(); i++) {         // куда я полез... Ввел ветер, теперь перемены!
                if (!list_participant.get(i).Humanoid_is_alife()) {
                    list_participant.get(i).money = new Random().nextInt(90) + 100;
                    System.out.println("Враг пал, вы собрали с трупа: " + list_participant.get(i).money + " золотых");
                    first.money += list_participant.get(i).money;
                    System.out.println();
                    list_participant.get(i).reborn();
                    list_participant.remove(i);
                    i--;
                }
            }


            if (!first.Humanoid_is_alife()) {
                System.out.println("Сэр Томас погиб. Его натура не выдержала вызова судьбы.");
                System.exit(0);
            }

        }
        first.down_health();  // Зелье бодрит, и завышает временно характеристики здоровья. После боя, все приходит в норму.
    }

    static void bridge(Humanoid buf, Zombie... enemy) {

        while (!buf.event_on_bridge) {
            String for_market_scanner;
            Scanner scan_market = new Scanner(System.in);
            for_market_scanner = scan_market.nextLine();
            switch (for_market_scanner) {
                case ("2"):
                    if (buf.money > 400) {
                        buf.money -= 400;

                        buf.chance_to_attack -= 7;
                        System.out.println("Сэр Томас ощутил жжение в области своего достоинства. " +
                                "вполне может быть, это было и верное решени...\nВаша уверенность упала(-7) и теперь ваша базовая" +
                                "меткость составляет: " + buf.chance_to_attack);

                        buf.event_on_bridge = true;

                        break;
                    } else {
                        buf.chance_to_attack -= 15;
                        System.out.println("У вас не нашлось нужной суммы. Жулики забрали все что у вас есть, включая ваш инвентарь" +
                                "\nТак жалко сэр Томас себя еще никогда не ощущал. \nВаша уверенность упала(-15) и теперь ваша базовая" +
                                "меткость составляет:  " + buf.chance_to_attack);
                        buf.param_inventory = Arrays.stream(buf.param_inventory).map(e -> {
                            e = 0;
                            return e;
                        }).toArray();
                        buf.money = 0;
                        buf.event_on_bridge = true;
                        break;
                    }
                case ("1"):
                    fight_test(buf, enemy);
                    buf.event_on_bridge = true;
                    break;
                default:
                    System.out.println("Значение введено неправильно");
            }
        }
        buf.event_on_bridge = false;

    }

}

class Humanoid implements Humanoid_ability {
    boolean vortex = false;  // супео способность волна ветро, бьет по всем врагам.

    boolean i_am_fire = false;
    boolean thief_1 = false;
    String bufer_string;

    String name;
    int chance_to_attack = 80;
    int chance_to_attack_in_fire = chance_to_attack - 15;
    boolean market_exit = false;                 // 0 - do in market, 1 - not do in market
    boolean event_on_bridge = false;           // переключаитаель события на мосту.
    boolean halt_param = false;                // Переключатель для привала(замыкает while)
    boolean halt_craft = false;                // переключатель для крафта брони.
    boolean level_up_param = false;           // Переключатель повышения уровня(замыкает while)
    int[] param_humanoid = {1, 1, 1, 1, 1}; // {head:Torso:Hand:lags; Attack}
    int[] defense = {0, 0, 0, 0};        // Armor HTHL
    int[] param_inventory = {0, 2, 1, 1}; //{shield_buf, shield_in_inventory,molotov,poition_of_health}
    String info_str_figth;
    int[] copy_param_humanoid = Arrays.copyOfRange(param_humanoid, 0, param_humanoid.length);
    int[] copy_param_defense = Arrays.copyOfRange(defense, 0, defense.length);
    int money = new Random().nextInt(150) + 75;
    //int burn_damage=Math.round(param_humanoid[4]/2);


    Humanoid(String str_file) {
//        String path = new File(str_file).getAbsolutePath(); // показывает где лежит файл(нужно понять как переназначить корневую папку.)
//        System.out.println(path);
        File file_humanoid = new File(str_file);

        try {
            Scanner str_scan = new Scanner(file_humanoid);
            this.name = str_scan.nextLine();
            this.param_humanoid[0] = Integer.parseInt(str_scan.nextLine());
            this.param_humanoid[1] = Integer.parseInt(str_scan.nextLine());
            this.param_humanoid[2] = Integer.parseInt(str_scan.nextLine());
            this.param_humanoid[3] = Integer.parseInt(str_scan.nextLine());
            this.param_humanoid[4] = Integer.parseInt(str_scan.nextLine());
            this.copy_param_humanoid = Arrays.copyOfRange(this.param_humanoid, 0, 8);
            str_scan.close();
        } catch (IOException | NoSuchElementException | NumberFormatException er) {
            this.name = "No name";
            this.param_humanoid[0] = 20;
            this.param_humanoid[1] = 20;
            this.param_humanoid[2] = 20;
            this.param_humanoid[3] = 20;
            this.param_humanoid[4] = 1;
            this.copy_param_humanoid = Arrays.copyOfRange(this.param_humanoid, 0, 5);
            System.out.println("Default:");
        }
    }

    static String Parts_of_body(int a) {
        Map<Integer, String> parts_of_body = new TreeMap<>();
        parts_of_body.put(1, "голове");
        parts_of_body.put(2, "телу");
        parts_of_body.put(3, "рукам");
        parts_of_body.put(4, "ногам");
        return parts_of_body.get(a);
    }

    void swith_for_halt() {
        Scanner scan_halt = new Scanner(System.in);
        String buf_str = scan_halt.nextLine();
        switch (buf_str) {
            case "1":
                if (param_inventory[3] > 0) {
                    for (int i = 0; i < param_inventory.length; i++) {
                        param_humanoid[i] += 70;
                    }
                    param_inventory[3] -= 1;
                    System.out.println("Вы выпили зелье! Теперь ваше здовровье");
                    down_health();
                    print_health_info();
                    System.out.println("Что еще хотите сделать?");
                    break;
                } else {
                    System.out.println("У вас нет зелья!");
                    break;
                }

            case "2":
                if (param_inventory[0] == 0) {

                    if (this.param_inventory[1] >= 2) {
                        this.param_inventory[0] += 2;
                        this.param_inventory[1] -= 2;
                        System.out.println("Вы приготовили щит к следующему бою");
                        break;
                    } else {
                        System.out.println("У вас нет щитов");
                        break;
                    }
                } else {
                    System.out.println("Ваш щит уже приготовлен, его прочность: " + param_inventory[0]);
                    break;
                }

            case "3":
                if (halt_craft)
                    System.out.println("На привале можно починить лишь один элемент брони. Вы уже этим воспользовались");
                LABEL_1:
                while (!halt_craft) {
                    System.out.println("Что будем чинить? 1-2-3-4? Прочность элемента повышаеться на 30");
                    Scanner str_craft = new Scanner(System.in);
                    String buf_str_for_craft = str_craft.nextLine();
                    switch (buf_str_for_craft) {
                        case "1": {
                            defense[0] += 30;
                            halt_craft = true;
                            System.out.println("Доспех починен! Что выберете еще?");
                            print_defense();
                            break;
                        }
                        case "2": {
                            defense[1] += 30;
                            halt_craft = true;
                            System.out.println("Доспех починен! Что выберете еще?");
                            print_defense();
                            break;
                        }
                        case "3": {
                            defense[2] += 30;
                            halt_craft = true;
                            System.out.println("Доспех починен! Что выберете еще?");
                            print_defense();
                            break;
                        }
                        case "4": {
                            defense[3] += 30;
                            halt_craft = true;
                            System.out.println("Доспех починен! Что выберете еще?");
                            print_defense();
                            break;
                        }
                        default:
                            System.out.println("Введено недопустимое значение");
                            System.out.println();
                            continue LABEL_1;

                    }
                    break;
                }
                break;

            case "0": {
                halt_param = true;

                break;
            }

            default:
                System.out.println("Введено недопустимое значение");
        }

    }

    void halt() {
        System.out.println();
        System.out.println("После битвы вы решили устроить короткий привал");
        print_health_info();
        print_inv_and_money();
        System.out.println();
        System.out.println("Что будете делать?\n" +
                "1 - Выпить зелье\n" +
                "2 - Приготовить щит\n" +
                "3 - Отремонтировать на выбор один элемент брони\n" +
                "0 - Продолжить путешествие\n");
        while (!halt_param) {
            swith_for_halt();
        }
        halt_param = false;
        halt_craft = false;
        System.out.println("Вы продолжили путешествие.");
        System.out.println();

    }

    void print_info_fight() {
        System.out.println(info_str_figth);
        info_str_figth = "";
    }

    void print_inv_and_money() {
        System.out.println();
        System.out.println("Золота у вас: " + money +
                "\nПрочность щита в руке: " + param_inventory[0] + "\nКоличество щитов: " + param_inventory[1] + "\nКоктейля молотова: " + param_inventory[2] + "\nЦелебного зелья: " + param_inventory[3]);
        System.out.println();
    }

    void print_defense() {
        System.out.println("Состояние брони: " +
                "\nШлем: " + defense[0] + " Нагрудник: " + defense[1] + " Нарукавники: " + defense[2] + " Поножи: " + defense[3]);
    }

    void reborn() {
        this.param_humanoid = Arrays.copyOfRange(copy_param_humanoid, 0, 5);
        this.defense = Arrays.copyOfRange(copy_param_defense, 0, copy_param_defense.length);
        this.i_am_fire = false;
        this.chance_to_attack = 80;
    }

    void down_health() {
        for (int i = 0; i < 4; i++) {
            if (copy_param_humanoid[i] < param_humanoid[i]) param_humanoid[i] = copy_param_humanoid[i];
        }
    }

    void print_health_info() {
        String info_str;
        String spec_char = "";


        info_str = ("Голова: " + param_humanoid[0] + "/" + copy_param_humanoid[0] + " [" + defense[0] + "]" +
                " Тело: " + param_humanoid[1] + "/" + copy_param_humanoid[1] + " [" + defense[1] + "]" +
                " Руки: " + param_humanoid[2] + "/" + copy_param_humanoid[2] + " [" + defense[2] + "]" +
                " Ноги: " + param_humanoid[3] + "/" + copy_param_humanoid[3] + " [" + defense[3] + "]" +
                " Сила оружия: " + param_humanoid[4]);
        for (int i = 0; i < info_str.length(); i++) {
            spec_char += "-";
        }
        System.out.println(spec_char);
        System.out.println(this.name);
        System.out.println(info_str);
    }

    void setDefense(int a, int b, int c, int d) {
        defense = new int[]{a, b, c, d};
        copy_param_defense = Arrays.copyOfRange(defense, 0, defense.length);
    }

    boolean Humanoid_is_alife() {
        boolean b = false;
        for (int a : param_humanoid) {
            if (a <= 0) {
                b = false;
                break;
            } else b = true;
        }
        return b;
    }

    void level_up() {
        System.out.println();
        System.out.println("Сэр Томас отдышался. Оглядел поле боя и решил задуматься, точнее некоторые мысли " +
                "\nназойливые как комары заставляли его это сделать. Не в силах сражаться с самим собой он впустил к себе одну из них." +
                "\n1 - Как сильно бьеться мое сердце, словно удары молота о наковальню. Мое тело идеальный механизм!" +
                "\n2 - А ведь не так быстро двигался враг, был момент даже когда мне показалось, что время замедлилось." +
                "\n3 - Я несколько иначе ощущал свой меч, словно он стал моим продолжением");
        while (!level_up_param) {
            swith_for_level_up();
        }
        level_up_param = false;
        System.out.println();
    }

    void swith_for_level_up() {
        Scanner scan_level_up = new Scanner(System.in);
        String buf_str = scan_level_up.nextLine();
        switch (buf_str) {
            case "1":
                for (int i = 0; i < 4; i++) {
                    param_humanoid[i] += 10;
                    copy_param_humanoid[i] += 10;
                }
                System.out.println("Ваше здоровье увеличено на 10 едениц по каждому пунку.");
                print_health_info();
                level_up_param = true;
                break;
            case "2":
                chance_to_attack += 5;
                System.out.println("Ваша базовая меткость увеличилась на 5 едениц, теперь она состовляет:" + chance_to_attack);
                level_up_param = true;
                break;
            case "3":
                param_humanoid[4] += 7;
                copy_param_humanoid[4] += 7;
                System.out.println("Ваш меч острее не стал, но мастерство увеличило наносимый урон:" + param_humanoid[4]);
                print_health_info();
                level_up_param = true;
                break;
            default:
                System.out.println("Сэр Томас немного отвлекся, но смог с легкостью сосредоточиться вновь.");
        }

    }

    @Override
    public void Attack(Humanoid a) {

    }
}

class Zombie extends Humanoid implements Humanoid_ability {
    int money = new Random().nextInt(90) + 100;

    Zombie(String str_file) {
        super(str_file);
    }

    public void Attack(Humanoid a) {

        int multiplier;
        int buf_rnd_critical = new Random().nextInt(101) + 1;
        int rnd = new Random().nextInt(4);

        if (i_am_fire) {
            param_humanoid[4] = Math.round(copy_param_humanoid[4] / 2);
            chance_to_attack = chance_to_attack_in_fire;
            for (int i = 0; i <= 3; i++) {
                param_humanoid[i] -= 10;
            }

            System.out.println(this.name + " Получил урон 30. И теперь теряет здоровье каждый ход (- 10).Урон снижен вдвое! Меткость его упала до " + this.chance_to_attack);
        }

        if (a.param_inventory[0] > 0) {
            a.param_inventory[0] -= 1;
            info_str_figth = "Удар пришелся по щиту! Состояние щита: " + a.param_inventory[0];
        } else {
            if (buf_rnd_critical < this.chance_to_attack) {

                if (a.defense[rnd] > 0) {
                    a.defense[rnd] -= Math.round(this.param_humanoid[4] * 0.33);
                    a.param_humanoid[rnd] -= Math.round(this.param_humanoid[4] * 0.25);
                    a.defense[rnd] = ((a.defense[rnd] < 0) ? 0 : (a.defense[rnd]));
                    info_str_figth = "Ваш доспех снизил урон, вы получили " + Math.round(this.param_humanoid[4] * 0.25) + " Урона по " + Knight.Parts_of_body(rnd + 1) + " | " + " Доспех повредился на " + Math.round(this.param_humanoid[4] * 0.33);
                } else {
                    a.param_humanoid[rnd] -= this.param_humanoid[4];
                    info_str_figth = "Вы  получили урон:" + this.param_humanoid[4];
                }
            } else {
                info_str_figth = this.name + " промахнулся!";
            }
        }
    }
}

class Knight extends Humanoid implements Humanoid_ability {

    Knight(String str_file) {
        super(str_file);
    }

    int Missiles_attack(int a) {
        int buf = a;
        while (buf == a) {
            buf = new Random().nextInt(4) + 1;
        }
        return buf;
    }

    int Calculate_chance_attack(int for_buf_war) {
        int result;
        switch (for_buf_war) {
            case 1: {
                result = -10;
                break;
            }
            case 2: {
                result = 0;
                break;
            }
            case 3: {
                result = -20;
                break;
            }
            default: {
                result = -20;
                break;
            }
        }
        return result;
    }

    public void Attack(Humanoid a) {
        String str_info = "Вы нанесли урон: ";
        int buf_war = 0;
        String checking_the_str = new String();
        boolean checking_the_str_swith = false;
        int buf_critical_damage, buf_chance_damage, temp_attack = 0;
        temp_attack = this.param_humanoid[4];
        int buf_X = 1;
        int buf_chance;

        System.out.println("Атакуй! 1 - голова " + (chance_to_attack - 10) + "% | 2 -тело " + (chance_to_attack) +
                "% | 3 - руки " + (chance_to_attack - 20) + "% | 4 - ноги " + (chance_to_attack - 20) +
                "% | Символ  s = (щит)  m = (коктейль Молотова)  p=(Зелье исцеления)");

        while (!checking_the_str_swith) {
            Scanner str_war = new Scanner(System.in);
            checking_the_str = str_war.nextLine().toLowerCase();
            switch (checking_the_str) {
                case ("w"):
                    vortex = true;
                    checking_the_str_swith = true;
                    info_str_figth = "Вы разрываете врагов мощным порывом ветра! Урон каждому составил по 40 едениц!";
                    break;
                case ("s"):
                    if (this.param_inventory[1] >= 2) {
                        this.param_inventory[0] += 2;
                        this.param_inventory[1] -= 2;
                        info_str_figth = "Вы достали щит!";
                        checking_the_str_swith = true;
                        break;
                    } else {
                        System.out.println("У вас нет щитов");
                        break;
                    }
                case ("m"):
                    if (param_inventory[2] > 0) {
                        for (int i = 0; i < (a.param_humanoid.length - 1); i++) {
                            a.param_humanoid[i] -= 30;
                        }
                        info_str_figth = "Противник в огне!";
                        a.i_am_fire = true;
                        param_inventory[2] -= 1;
                        checking_the_str_swith = true;
                        break;
                    } else {
                        System.out.println("У вас нет Молотова");
                        break;
                    }
                case ("p"):
                    if (this.param_inventory[3] > 0) {
                        for (int i = 0; i < this.param_inventory.length; i++) {
                            this.param_humanoid[i] += 70;
                        }
                        this.param_inventory[3] -= 1;
                        info_str_figth = "Вы ицелились на 70 очков";
                        checking_the_str_swith = true;
                        break;
                    } else {
                        System.out.println("У вас нет зелья!");
                        break;
                    }

                case ("1"):
                case ("2"):
                case ("3"):
                case ("4"):


                    buf_war = Integer.valueOf(checking_the_str);

                    buf_chance = this.chance_to_attack;
                    buf_chance += Calculate_chance_attack(buf_war);

                    checking_the_str_swith = true;
                    buf_critical_damage = new Random().nextInt(100);
                    buf_chance_damage = new Random().nextInt(100);

                    if (buf_critical_damage < 20) {
                        buf_X = 2;
                    }

                    if (buf_chance_damage <= buf_chance) {
                        int damage_to_enemy;
                        String str_damage_defense;
                        damage_to_enemy = (int) (Math.round((temp_attack * buf_X) * (a.defense[buf_war - 1] > 0 ? 0.25 : 1)));
                        a.param_humanoid[buf_war - 1] -= damage_to_enemy;
                        str_damage_defense = String.valueOf(Math.round(a.defense[buf_war - 1] > 0 ? temp_attack - temp_attack * 0.33 : 0));
                        a.defense[buf_war - 1] -= Math.round(a.defense[buf_war - 1] > 0 ? temp_attack * 0.33 : 0);
                        a.defense[buf_war - 1] = (a.defense[buf_war - 1] < 0 ? 0 : a.defense[buf_war - 1]);
                        info_str_figth = "Вы нанесли урон: " + damage_to_enemy + (buf_X == 2 ? " Критический удар!" : "") +
                                " Противник смог отразить " + (temp_attack - damage_to_enemy < 0 ? 0 : temp_attack - damage_to_enemy) + " урона";
                    } else {
                        buf_chance_damage = new Random().nextInt(100);
                        if (buf_chance_damage <= 50) {
                            buf_war = Missiles_attack(buf_war);
                            temp_attack /= 2;

                            int damage_to_enemy;
                            String str_damage_defense;
                            damage_to_enemy = (int) (Math.round((temp_attack * buf_X) * (a.defense[buf_war - 1] > 0 ? 0.25 : 1)));
                            a.param_humanoid[buf_war - 1] -= damage_to_enemy;
                            str_damage_defense = String.valueOf(Math.round(a.defense[buf_war - 1] > 0 ? temp_attack - temp_attack * 0.33 : 0));
                            a.defense[buf_war - 1] -= Math.round(a.defense[buf_war - 1] > 0 ? temp_attack * 0.33 : 0);
                            a.defense[buf_war - 1] = (a.defense[buf_war - 1] < 0 ? 0 : a.defense[buf_war - 1]);

                            info_str_figth = "Вы промазали, но чудом попали по " + Knight.Parts_of_body(buf_war) + ". Урон ваш снижен вдвое" + "\n" +
                                    "Вы нанесли урон: " + damage_to_enemy + (buf_X == 2 ? " Критический удар!" : "") +
                                    " Противник смог отразить " + (temp_attack - damage_to_enemy) + " урона";
                        } else info_str_figth = "Вы промахнулись!";

                    }

                    break;

                default:
                    System.out.println("Введено неправильное значение.\nАтакуйте часть тела (1-4) \nИли совершите действие (Щит, Молотов, Зелье)");

            }

        }
        checking_the_str_swith = false;

    }
}

interface Humanoid_ability {

    void Attack(Humanoid a);

    default void Armor(int a, int b, int c, int d) {
    }

}
