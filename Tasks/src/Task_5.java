import java.security.MessageDigest;
import java.util.Arrays;

public class Task_5 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1_1(new int[]{72, 29, 7, 0, 3}));
        System.out.println(Arrays.toString(Ex1_2("Hello")));
        System.out.println("Задание 2:");
        System.out.println(Ex2("Rook", "A8", "H8"));
        System.out.println("Задание 3:");
        System.out.println(Ex3("butl", "beautiful"));
        System.out.println("Задание 4:");
        System.out.println(Ex4(new int[]{16, 28}));
        System.out.println("Задание 5:");
        System.out.println(Arrays.toString(Ex5(new String[]{"toe", "ocelot", "maniac"})));
        System.out.println("Задание 6:");
        System.out.println(Ex6(1234567890123456l));
        System.out.println("Задание 7:");
        System.out.println(Ex7(108));
        System.out.println("Задание 8:");
        System.out.println(Ex8("password123"));
        System.out.println("Задание 9:");
        System.out.println(Ex9("jOn SnoW, kINg IN thE noRth."));
        System.out.println("Задание 10:");
        System.out.println(Ex10(19));
    }

    public static char[] Ex1_1(int[] a) {//зашифровать строку
        char[] b = new char[a.length];//создлаем массив чаров
        b[0] = (char) a[0];//кладем нулевой элемент массива в чаровый массив
        for (int i = 1; i < a.length; i++) {//бежим по массиву
            b[i] = (char) (a[i - 1] + a[i]);//складываем предыдущий и итый элементы массива и переводим в чар
            a[i] = a[i - 1] + a[i];//увеличиваем итый элемент массива
        }
        return b;
    }

    public static int[] Ex1_2(String a) {//расшифровать строку
        int[] c = new int[a.length()];//создаем массив
        c[0] = (int) a.charAt(0);//инициализируем первый элемент массива
        for (int i = 1; i < a.length(); i++) {//бежим по строке
            c[i] = (int) a.charAt(i) - (int) a.charAt(i - 1);//записываем в итый элемент массива разницу мужду последним и предпоследним элементами
        }
        return c;
    }

    public static boolean Ex2(String a, String b, String c) {//фигуры
        //"пешка", "конь", "слон", "Ладья", "Ферзь"и " король"
        //"Pawn", "Knight", "Bishop", "Rook", "Queen" and "King"
        char b1 = b.charAt(0);
        int b2 = Integer.parseInt(String.valueOf(b.charAt(1)));
        char c1 = c.charAt(0);
        int c2 = Integer.parseInt(String.valueOf(c.charAt(1)));
        if (a == "Pawn") {//если пешка, то буквы одинаковые, а разница в клеточках = 1
            if (b1 == c1) {
                return (b2 - c2) == 1;
            } else return false;
        }
        if (a == "Knight") {//если конь, то смотрим разницу в буквах
            if (Math.abs(b1 - c1) == 1 || Math.abs(b1 - c1) == 2) {
                return Math.abs(b2 - c2) == 2;//разница в цифрах
            } else return false;
        }
        if (a == "Bishop") {//если слон, то разница букв=разницке цифр
            return Math.abs(b2 - c2) == Math.abs(b1 - c1);
        }
        if (a == "Rook") {//если ладья
            return (b1 == c1 || b2 == c2);//должнф бфть равны буквы или цифры
        }
        if (a == "Queen") {//ферзь
            return (Math.abs(b2 - c2) == Math.abs(b1 - c1) || b1 == c1);//либо условие слона либо условие ладьи
        } else return (Math.abs(b2 - c2) == 1 && Math.abs(b1 - c1) == 1);
    }

    public static boolean Ex3(String a, String b) {//входная строка
        String c = "";//новая строка для записи повторенных букв
        for (int i = 0; i < a.length(); i++) {//бежим по входной строке
            for (int j = i; j < b.length(); j++) {//сравниваем буквы с большой строкой
                if (b.charAt(j) == a.charAt(i)) {//есдли есть совпадение
                    c += b.charAt(j);//записываем букву в новую строку
                    j = b.length() - 1;//перескакиваем на следубщую букву
                }
            }
        }
        int count = 0;//счетчик
        for (int i = 0; i < a.length(); i++) {//бежим по входной строке
            if (c.charAt(i) == a.charAt(i)) count++;//считаем совпадение
        }
        return count == a.length();//совпадения==длина входного слова?
    }

    public static int Ex4(int[] a) {//произведение числа
        int b = 0;
        for (int i = 0; i < a.length; i++) {
            b += a[i];//сумам массива
        }
        int c = 1;
        while (b > 9) {//пока б число
            c = 1;
            while (b > 0) {//пока б больше 0
                c *= b % 10;//домножаем хвостик на с
                b = b / 10;//отсекаем хвостик
            }
            b = c;
        }
        return c;
    }

    public static String[] Ex5(String[] a) {//гласные в словах
        String b = a[0];//берем первое слово
        String d1 = "";//строки для записи гласных
        String d2 = "";
        for (int i = 0; i < a[0].length(); i++) {//записываем гласные из первого слова
            if (a[0].charAt(i) == 'a' || a[0].charAt(i) == 'e' || a[0].charAt(i) == 'i' || a[0].charAt(i) == 'o' || a[0].charAt(i) == 'u' || a[0].charAt(i) == 'y')
                d1 += a[0].charAt(i);
        }
        for (int i = 1; i < a.length - 1; i++) {//бежим по массиву слов
            for (int j = 0; j < a[i].length(); j++) {//записываем глассные текущео слова
                if (a[i].charAt(j) == 'a' || a[i].charAt(j) == 'e' || a[i].charAt(j) == 'i' || a[i].charAt(j) == 'o' || a[i].charAt(j) == 'u' || a[i].charAt(j) == 'y')
                    d2 += a[i].charAt(j);
            }
            int count = 0;
            for (int k1 = 0; k1 < d1.length(); k1++) {//сравниваем гласные первого и текущего слова
                for (int k2 = k1; k2 < d2.length(); k2++) {
                    if (d2.charAt(k2) == d1.charAt(k1))
                        count++;
                }
            }
            if (count == d2.length()) {
                b = b + " " + a[i];
            }//если глассные одинаковы, то дописываем слово в новую строку
            d2 = "";
        }
        String[] b1 = b.split(" ");//делим строку по словам
        return b1;
    }

    public static boolean Ex6(long a) {//банковская карта
        String t = String.valueOf(a);//записываем номер карты в строку
        if (t.length() >= 14 && t.length() <= 19) {//проверяем длинну
            int b = (int) a % 10;//берем контрольную цифру
            int[] c = new int[t.length() - 1];//создаем новый массив
            a = a / 10;//укорачиваем а на один символ с конца
            for (int i = 0; i < t.length() - 1; i++) {//записыаем цифры карты в обратном порядке в массив
                c[i] = (int) a % 10;
                a = a / 10;
            }
            for (int i = 0; i < c.length; i++) {//если порядковый номер элемента не четный, то увеличим его в 2 раза
                if (i % 2 != 0) {
                    c[i] = c[i] * 2;
                    if (c[i] > 9) {//если после умножения на два элемент стал числом, то сложим его цифры
                        c[i] = c[i] / 10 + c[i] % 10;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < c.length; i++) {
                sum += c[i];//слоджим все элементы массив
            }
            sum = 10 - sum % 10;//10-последнее число суммы
            return sum == b;//полученный результат = контрольной цифре?
        } else {
            return false;
        }
    }

    public static String Ex7(int a) {//текстовые числа
        String[] b1 = {" ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] b2 = {" ", " ", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                "eighty", "ninety"};
        String c = "";
        if (a == 0) {//если число =0
            return "zero";
        }
        if (a < 100) {//если число меньше 100
            if (a < 20) {//меньше 20
                return b1[a];//выводм соответствующий элемент
            }
            if (a > 20) {//больше 20
                c = c + b2[a / 10] + " " + b1[a % 10];//выводим первое число из второго массива и второе число из первого массива
                return c;
            }
        }
        if (a >= 100) {//если больше ста
            c = c + b1[a / 100] + " hundred " + b2[a % 100 / 10] + " " + b1[a % 10];//первый массив+ сто+второй массив+первый массив
            return c;
        }
        return "";
    }

    public static String Ex8(String base) {//хеш алгоритм
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");// Статический метод getInstance вызывается с хэшированием
            byte[] hash = digest.digest(base.getBytes("UTF-8"));//преобразуем строку в массив байтов
            StringBuffer hexString = new StringBuffer();//создаст пустой (не содержащий символов) объект
            //Чтобы справиться с созданием временного мусора из-за модификаций объекта String, можно использовать класс StringBuffer.
            for (int i = 0; i < hash.length; i++) {//бежим по массиву
                String hex = Integer.toHexString(0xff & hash[i]);
                //это встроенная функция в Java, которая возвращает строковое представление целочисленного аргумента в виде целого числа без знака в базе 16.
                if (hex.length() == 1) hexString.append('0');// обновляет значение объекта, который вызвал метод.
                hexString.append(hex);
            }

            return hexString.toString();//выводим хешированную строук
        } catch (Exception ex) {//исключение
            throw new RuntimeException(ex);//востанавливает олбычный ход выполнения
        }
    }

    public static String Ex9(String a) {//игра престолов
        //and, the, of, in.
        String[] b = a.split(" ");
        String c = "";
        for (int i = 0; i < b.length; i++) {
            b[i] = b[i].toLowerCase();
            if (b[i].equals("and") == true || b[i].equals("the") == true || b[i].equals("of") == true || b[i].equals("in") == true) {
                c = c + " " + b[i].toLowerCase();
            } else {
                b[i] = b[i].substring(0, 1).toUpperCase() + b[i].substring(1).toLowerCase();
                c = c + " " + b[i];
            }
        }
        return c;
    }

    public static String Ex10(int val) {//выводит шестугольники
        {
            String res = "недопустимое число";
            int start = 1, mult = 1, r = 1, os = 0, probs = 0;//р-количесвто строк//ос-допустимое количество символов
            while (start <= val)//пробс/пробелы//старт-количество символов//
            {
                if (start == val)//если число относится к решетке
                {
                    res = "\n";//обнуляем поле результата
                    for (int i = 0; i < r; i++) {//рисуем строки до середины
                        probs = r - i;
                        os = r + i;
                        for (int j = 0; j < probs; j++) {//ставим пробелы
                            res += " ";
                        }
                        for (int j = 0; j < os; j++) {//рисуем круги
                            res += "○ ";
                        }
                        res += "\n";
                    }
                    for (int i = 0; i < r - 1; i++) {//рисуем строки после середины
                        probs++;
                        os--;
                        for (int j = 0; j < probs; j++) {
                            res += " ";
                        }
                        for (int j = 0; j < os; j++) {
                            res += "○ ";
                        }
                        res += "\n";
                    }
                    return res;
                }
                start += 6 * mult;//относится ли число к решетке?
                mult++;
                r++;
            }
            return res;
        }
    }
}
