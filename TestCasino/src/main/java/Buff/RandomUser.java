package Buff;

import java.util.Random;

public class RandomUser {
    public static String name = "";
    public static String[] enSimbols = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static String[] ruSimbols = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о",
            "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ы", "ь", "ъ", "э", "ю", "я", "0", "1", "2", "3",
            "4", "5", "6", "7", "8", "9", "0"};

    public static String getEnName() {
        name ="";
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int k = random.nextInt(36);
            name = name.concat(enSimbols[k]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public static String getRuName() {
        name ="";
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int k = random.nextInt(43);
            name = name.concat(ruSimbols[k]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
