import java.util.Arrays;
import java.util.SplittableRandom;

public class Task_6 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1(3));
        System.out.println("Задание 2:");
        System.out.println(Ex2("flag"));
        System.out.println(Ex2("Apple"));
        System.out.println("Задание 3:");
        System.out.println(Ex3("rgb(0,0,0)"));
        System.out.println("Задание 4:");
        System.out.println(Ex4("https://edabit.com?a=1&b=2&a=2"));
        System.out.println("Задание 5:");
        System.out.println(Arrays.toString(Ex5("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println("Задание 6:");
        System.out.println(Ex6(4));
        System.out.println("Задание 7:");
        System.out.println(Ex7("abcabcbb"));
        System.out.println("Задание 8:");
        System.out.println(Ex8(16));
        System.out.println("Задание 9:");
        System.out.println(Ex9("6 * 9 = 60"));
        System.out.println("Задание 10:");
        System.out.println(Ex10(11211230));
    }

    public static int[] Vect(int[] v, int n) {//вектор паскаля
        int i, j;
        int[] nv = new int[n + 1];//создаем массив
        nv[0] = 1;//кладем первый и последний элемент
        nv[n] = 1;
        j = 1;
        for (i = 0; i < n - 1; i++)
            nv[j++] = v[i] + v[i + 1];//считаем число паскаля
        return nv;
    }

    public static int Ex1(int n) {//число белла
        int[] curr;//создаем два массива
        int[] prev;
        int i, j, s;
        int[] Bi = new int[n + 1];//массив белла
        Bi[0] = Bi[1] = 1;//кладем первые два элемента белла
        prev = new int[2];//инициализируем массив
        prev[0] = prev[1] = 1;//кладем значение
        curr = prev;//инициализируем массив
        for (i = 2; i < n + 1; i++) {//ищем число белла
            s = 0;
            for (j = 0; j < i; j++)//берем предыдущие элементы
                s += Bi[j] * curr[j];//умножаем число паскаля и число белла, добавляем к сумме
            Bi[i] = s;//изменяем число белла
            curr = Vect(prev, i);//пересчитываем массив с числами паскаля
            prev = curr;//пересчитываем массив с числами паскаля
        }
        return Bi[n];//выводим число белла
    }

    public static String Ex2(String a) {//поросячая латынь
        //если первый элемент массив - гласная
        if (a.toLowerCase().charAt(0) == 'a' || a.toLowerCase().charAt(0) == 'e' || a.toLowerCase().charAt(0) == 'i' || a.toLowerCase().charAt(0) == 'o' || a.toLowerCase().charAt(0) == 'u' || a.toLowerCase().charAt(0) == 'y') {
            a += "yay";//допишем к концу строки
            return a;
        } else {
            String b = "";//новая строка
            for (int i = 0; i < a.length(); i++) {
                //пока не найдена глассная, записываем буквы в новую строку и удаляем их из строки
                if (a.charAt(i) != 'a' && a.charAt(i) != 'e' && a.charAt(i) != 'i' && a.charAt(i) != 'o' && a.charAt(i) != 'u' && a.charAt(i) != 'y') {
                    b += a.charAt(i);
                    a = a.substring(1);
                    i--;
                } else {
                    i = a.length() - 1;
                }
            }
            a = a + b + "ay";//создаем новую строку
        }
        return a;
    }

     public static boolean Ex3 (String str){//ргба
         String temp = "";
         int i = 0;
         for (; i < 4; i++) {
             temp+=str.charAt(i);
         }
         if (temp.equals("rgb(")||temp.equals("RGB("))
         {
             temp="";
             while (str.charAt(i)!=')')
             {
                 temp+=str.charAt(i);
                 i++;
             }
             if (i!=str.length()-1) return false;
             temp = str.substring(4,str.length()-1);
             String[] temparr = temp.split(",");
             for (int j = 0; j < temparr.length; j++) {
                 double val = Double.parseDouble(String.valueOf(temparr[j]));
                 if (val<0||val>255)
                     return false;
             }
             return true;
         }
         temp+=str.charAt(i);
         i++;
         if (temp.equals("rgba(")||temp.equals("RGBA("))
         {
             temp="";
             while (str.charAt(i)!=')')
             {
                 temp+=str.charAt(i);
                 i++;
             }
             if (i!=str.length()-1) return false;
             i=0;
             for (int j = 0; j < 3; j++) {
                 String temp_val ="";
                 while (temp.charAt(i)!=',')
                 {
                     temp_val+=temp.charAt(i);
                     i++;
                 }
                 i++;
                 double val = Double.parseDouble(temp_val);
                 if (val<0||val>255)
                     return false;
             }
             return true;
         }
         else
         {
             return false;
         }
     }
    public static String Ex4 (String str, String[] ... params)//урл строка
        {
            String temp ="", res="";
            int i = 0;
            for (; i < 8; i++) {//запишем первые 8 символов в новые строки
                temp+=str.charAt(i);
                res+=str.charAt(i);
            }
            if (!temp.equals("https://"))//совпадает ли начало строки?
            {
                return "не является URL";
            }
            else
            {
                while (str.charAt(i)!='.')//пока не найдена точка
                {
                    res+=str.charAt(i);//дописываем символы в строку
                    i++;
                }
                temp ="";
                res+=str.charAt(i);//запишем точку
                i++;
                for (int j = 0; j < 3; j++, i++) {//запишем три символа после точки
                    temp+=str.charAt(i);
                    res+=str.charAt(i);
                }
                if (temp.equals("com")&&i==str.length())//если параметров нет
                {
                    return res;//вернем строку
                }
                temp+=str.charAt(i);//добавим вопросительный знка
                res+=str.charAt(i);//допишем к строке
                ++i;//и+1
                if (temp.equals("com?")&&i!=str.length()-1)//если должны быть параметры и они есть
                {
                    int ques =0, equs=0;
                    for (int j=i; j < str.length(); j++) {//считаем если ли повторы запросов
                        if (str.charAt(j)=='='&&Character.isDigit(str.charAt(j+1))) equs++;
                        if (str.charAt(j)=='&') ques++;
                    }
                    if (ques+1==equs)//если введено корректно
                    {
                        String part = str.substring(i);//удаляем итый элемент
                        String[] words = part.split("&");//массив переменных со значениями
                        String[] names = new String[words.length];//массив имён переменных
                        String[] vals_str = new String[words.length];//массив значений переменных
                        for (int j = 0, k=0; j < words.length; j++) {//пребираем значения
                            names[j]="";
                            vals_str[j]="";
                            while (words[j].charAt(k)!='=')//запись названий переменных
                            {
                                names[j]+=words[j].charAt(k);
                                k++;
                            }
                            k++;
                            while (k!=words[j].length())//запись значений переменных
                            {
                                vals_str[j]+=words[j].charAt(k);
                                k++;
                            }
                            k=0;
                        }//определяем, какие переменные повторяются и оставить только плсденее повторение если оно есть
                        boolean[] repeat = new boolean[words.length];
                        for (int word1 = words.length-1; word1 > 0; word1--) {//сравнение всех переменных по имени
                            for (int word2 = word1-1; word2 >= 0; word2--) {
                                if (names[word1].equals(names[word2]))
                                {
                                    repeat[word2]= true;
                                }
                            }
                        }
                        for (int j = 0; j < words.length; j++) {
                            if (repeat[j]==false){//если повтора нет
                                res+=words[j]+ "&";//записываем переменнную
                            }
                        }
                        res+="\b";
                    }
                }
                else//если должны быть параметры и их нет
                {
                    return "не является URL";
                }
            }
            return res;
    }
    public static String[] Ex5 (String a) {
        String[] b = a.split(" ");//массив слов
        if (b.length < 3) {//если два слова, то выводим строку
            return b;
        } else {
            int max = 0;//макс длина
            int k = 0;//длина
            String[] c = new String[3];//массив из трех слов
            for (int i = 0; i < 3; i++) {//берем первое (пустое) слово
                for (int j = 0; j < b.length; j++) {//берем массив слов
                    if (b[j].length() > max) {//ищем самое длинное слово
                        max = b[j].length();
                        k = j;
                    }
                }
                max = 0;//обнуляем максимум
                c[i] = "#" + b[k].toLowerCase();//делаем хештег
                b[k] = "";//удаляем слово из строки
            }
            return c;
        }
    }

    public static int Ex6(int a) {//последовательность улама
        int[] n = new int[a];//массив длинной в а
        n[0] = 1;//первые два элемента
        n[1] = 2;
        int b = 2;
        int S = 0;
        for (int q = 2; q < a; q++) {//бежим по массиву (для создания новго числа)
            for (int i = q + 1; i < 1000; i++) {//перебираем числа
                int c = 0;//счетчик повторений
                for (int j = 0; j < b - 1; j++) {//перебираем числа массива (которые уже есть)
                    for (int k = j + 1; k < b; k++) {
                        if (n[j] + n[k] == i) {//если сумма числе равна и
                            c++;//счетчик +1
                            S = i;//новое число
                        }
                    }
                }
                if (c == 1) {//если только один способ получения и
                    n[q] = S;//записываем новый элемент массива
                    b++;//б+1
                    i = 999;//начинаем поиск заново для нового числа
                }
            }
        }
        return n[a - 1];//возвращаем чило улама
    }

    public static String Ex7 (String str) {
        int mas[][] = new int[str.length() + 1][str.length() + 1];//двумерный массив длиной в строку+1
        String res = "";//строка для вывода
        int res_length = 0;//длина
        int i, index = 0;
        for (i = 1; i <= str.length(); i++) {//бежим по строкам массива
            for (int j = i + 1; j <= str.length(); j++) {//бежим по элементам строки
                if (str.charAt(i - 1) == str.charAt(j - 1)&& mas[i - 1][j - 1] < (j - i)) {//если элементы строки равны и элемент массива меньше разницы индексов,то
                    mas[i][j] = mas[i - 1][j - 1] + 1;//увеличиваем ячейку на 1
                    if (mas[i][j] > res_length) {//если ячейка больше длины
                        res_length = mas[i][j];//в длину запишем ячейку
                        index = Math.max(i, index);//получим наибольшее значение
                    }
                } else {
                    mas[i][j] = 0;//если повторов нет. то ячейка нулевая
                }
            }
        }
        if (res_length > 0) {//если есть длина строки
            for (i = index - res_length + 1; i <= index; i++) {//запишем в строку резальтат наиболее длинную повторяющуюся строку
                res += str.charAt(i - 1);
            }
        }
        return res;
    }
    public static String Ex8(int a) {
        int[] mas1 = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] mas2 = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        String s = "";
        while (a > 0)              //крутим цикл пока а>0
        {
            if (mas1[i] <= a) {      // i - элемент массива арабских цифр меньше либо равен числу а то
                a = a - mas1[i];   // от числа вычитаем его эквивалент в массиве арабском
                s = s + mas2[i];//добавляем эквивалент в римском массиве
            }else {i++;
            }
        }return s;
    }
    public static boolean Ex9 (String str){
        String temp = str.replace(" ", "");//получим отдельные слова
        for (int i = 0; i < temp.length(); i++) {//берем каждое слово
            if (!Character.isDigit(temp.charAt(i))&&temp.charAt(i)!='+'&&temp.charAt(i)!='-'&&temp.charAt(i)!='*'&&temp.charAt(i)!='/'&&temp.charAt(i)!='>'&&temp.charAt(i)!='<'&&temp.charAt(i)!='='&&temp.charAt(i)!='%')
            {
                return false;//если нет совпадений с операторами. то ложь
            }
        }
        String first = "", second = "", res = "", operand1 = "", operand2 = "";
        double first_val = 0, second_val = 0, res_val = 0;
        char operand1_char, operand2_char,operand12_char=0, operand22_char = 0;
        int i = 0;
        while (str.charAt(i) != '+' && str.charAt(i) != '-' && str.charAt(i) != '*' && str.charAt(i) != '/' && str.charAt(i) != '%') {//получим первое число
            first += str.charAt(i);
            i++;
        }
        operand1 += str.charAt(i);//получим первый операнд
        i++;
        while (str.charAt(i) != '=') {//получим второе число
            second += str.charAt(i);
            i++;
        }
        operand2 += str.charAt(i);//получим второй операнд
        i++;
        while (i != str.length()) {//получим результат
            res += str.charAt(i);
            i++;
        }
        first_val = Double.parseDouble(first);//переводим их в числа
        second_val = Double.parseDouble(second);
        res_val = Double.parseDouble(res);
        operand1_char=operand1.charAt(0);
        if (operand1.length()>1)
        {
            operand12_char=operand1.charAt(1);//перводим операнд в чар
        }
        operand2_char=operand2.charAt(0);
        if (operand2.length()>1)
        {
            operand22_char=operand2.charAt(1);//перводим операнд в чар
        }//проверяем варианты выражений
        if (operand1_char == '+') {
            if (operand2_char == '=') {
                if (first_val + second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val + second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val + second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val + second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        if (operand1_char == '-') {
            if (operand2_char == '=') {
                if (first_val - second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val - second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val - second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val - second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        if (operand2_char == '*') {
            if (operand2_char == '=') {
                if (first_val * second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val * second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val * second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val * second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        if (operand1_char == '/') {
            if (operand2_char == '=') {
                if (first_val / second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val / second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val / second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val / second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        if (operand1_char == '%') {
            if (operand2_char == '=') {
                if (first_val % second_val == res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '>'&& operand22_char == '=') {
                if (first_val % second_val >= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<'&& operand22_char == '=') {
                if (first_val % second_val <= res_val) {
                    return true;
                } else return false;
            }
            if (operand2_char == '<') {
                if (first_val % second_val < res_val) {
                    return true;
                } else return false;
            }
        }
        return false;
    }
    public  static boolean Ex10 (int val){
        int counter =0, temp=val;//счестчик и временная переменная
        while (temp!=0){//получаем количесвто цифр
            temp/=10;
            counter++;
        }
        if (counter%2 ==1){//если нечетное, то ложь
            return false;
        }
        String str = Integer.toString(val);//переводим в строку
        //пока длина больше двух и сумма первого и второго элемента больше 9
        while (str.length()!=2||(Integer.parseInt(String.valueOf(str.charAt(0)))+Integer.parseInt(String.valueOf(str.charAt(1))))>9){
            String str2 = "";//новая строка
            for ( int i = 1, j=str.length();i <= j/2; i++,j--) {//бежим по строке (с концов)
                if (str.charAt(i-1)!=str.charAt(j-1)){//если исходное значение не палиндром
                    for (int k = 0; k < str.length()-1; k+=2) {//складываем два соседних элемента
                        str2+=Integer.toString(Integer.parseInt(String.valueOf(str.charAt(k)))+Integer.parseInt(String.valueOf(str.charAt(k+1))));
                    }
                    str = str2;
                    break;
                }
            }
        }
        if(str.charAt(0)==str.charAt(1))return true;
        else return false;
    }
}
