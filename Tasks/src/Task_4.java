public class Task_4 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1(10,7 ,"hello my name is Bessie and this is my essay"));
        System.out.println("Задание 2:");
        System.out.println(Ex2("()()()"));
        System.out.println("Задание 3:");
        System.out.println(Ex3("foo_bar"));
        System.out.println(Ex3("fooBar"));
        System.out.println("Задание 4:");
        System.out.println(Ex4(9, 17, 30, 1.5));
        System.out.println("Задание 5:");
        System.out.println(Ex5("55 kilos", "1.65 meters"));
        System.out.println("Задание 6:");
        System.out.println(Ex6(999));
        System.out.println("Задание 7:");
        System.out.println(Ex7("abbccc"));
        System.out.println("Задание 8:");
        System.out.println(Ex8("Sam I am!", "Green eggs and ham."));
        System.out.println("Задание 9:");
        System.out.println(Ex9(1222345, 12345));
        System.out.println("Задание 10:");
        System.out.println(Ex10("AZYWABBCATTTA", 'A'));
    }
    public static String Ex1 (int a, int b, String c){//ессе
     String[] words = c.split(" ");//делим строку на слова по пробелу
     String neW="";//новаяя стркоа для записи "новых строк"
     int split= 0;
     String d="";//само эссе
     for (int i=0;i < a;i++){//бежим по массиву слов
            if ((b-(neW.length()-split))>=(words[i].length())){//если в "новой" строке есть место для нового слова, то допистаь
                neW=neW + words[i]+" ";
                split++;
            }else {//иначе записать новую строку в эссе и очистить строку
                d = d + neW+"\n";
                neW="";
                neW = words[i]+" ";
                split=1;
            }
        }d = d+words[a-1];//костыль для записи последнего слова
     return d;
     }
     public static String Ex2 (String a){//скобки
        String b = "\"";//первый разделитель
        int left=0, right = 0;//счестчик левых и правых скобок
        for (int i=0;i<a.length();i++){//бежим по строке

            if (a.charAt(i)=='('){//если правая, то ++
                right++;
                b+=a.charAt(i);//запишем ее в строку
            }if (a.charAt(i)==')'){//если левая, то ++
                left++;
                b+=a.charAt(i);//запишем ее в строку
                if (right==left)//если счетчики равны, то закрываем разделитель
                    b+="\" \"";
            }

        } b=b.substring(0, b.length() - 1);//костыль для удаления лишних разделителй
         b=b.substring(0, b.length() - 1);
         return b;
     }
     public static String Ex3 (String a){//
         String b = "";//новая строка
        for(int i = 0;i<a.length();i++){

            if (a.charAt(i)=='_'){//если найден "пробел"
                i++;//пропускаем его и берем следующую букву
                b+=Character.toUpperCase(a.charAt(i));//возводим следущую букву в верхний регистр

            }else if (a.charAt(i)>='A'&&a.charAt(i)<='Z'){///если надйена заглавная буква
                b= b + "_"+Character.toLowerCase(a.charAt(i));//добавляем пробел и букву в нижний регистр
            }else b+=a.charAt(i);//иначе просто добавляем букву
        }return b;
     }private static String Ex4 (int t1,int t2,int M,double x){//работа
        int countX=0;//переработанное время
        double Sum=0;//сумма
        if (t1<9){//если работа начата раньше
            countX+=(9-t1);//переработка
            t1=t1-(9-t1);//начинаем работу "вовремя"
        }
        if (t2>17){//если работа начата позже
            countX+=(t2-17);//переработка
            t2=t2-(t2-17);// заканчиваем работу "вовремя"
        }
        Sum=(t2-t1)*M+countX*x*M;//сумма
        return ("$"+Sum+"0");//вывод строк

    }public static String Ex5 (String a, String b){//масса тела
        String[] a1 = a.split(" ");//делим строки на слова по пробелу
        String[] b1 = b.split(" ");
        double w=Double.parseDouble(a1[0]);//сило веса
        double h=Double.parseDouble(b1[0]);//число роста
        a = a1[1];//строка веса
        b=b1[1];//строка роста
        if (a.charAt(0)=='p'){//перводим весв килограммы
            w = w*0.45;
        }
        if (b.charAt(0)=='i'){//переводм рост в метры
            h=h*2.54;
        }
        double c = ((double)((int)(w/(h*h)*100))/100);//расчет индекса массы тела
        if(c<18.5){//ответ в соответствии со значением индекса
            return c + " Overweight";
        }else if (c>=18.5 && c<=24.9){
            return c + " Normal weight";
        }else return c + " Underweight";
    }
    public static int Ex6 (int a){//мультипликативное постоянство
        if (a<10){//если цифра, то 0
            return 0;
        }
        int b=0;//счетчик
        int sum=1;
        while (a>9){//пока число (а не цифра)
            while (a>0){//пока цифра
                sum*=a%10;//суммируем последнюю цифру
                a=a/10;//уменьшаем на 1
            }
            a=sum;//переписываем сумму в а
            b++;//счетчик иттераций
        }return b;
    }
    public static String Ex7 (String a){//звездная пентограмма
        a+=" ";//костыль добавим еще один символ для корректнойработы
        String b="";//новая строка для записи пентограммы
        int c=1;//счетчик повторов
        for (int i=0;i<a.length()-1;i++){//берем первый элемент
            for (int j=i+1;j<a.length();j++){//перебираем следующие элементы
                if (a.charAt(i)==a.charAt(j)){//если соседние элементы равны
                    c++;//с+1
                }else if (c>1){//если с больше 1
                    b=b+a.charAt(i)+"*"+c;//в строку записываем элемент умножить и множитель
                    i+=c;//перепрыгиваем повторые символы
                    c=1;//счетчик 1
                }else {//если с=1
                    b=b+a.charAt(i);//запишем просто элемент
                    j=a.length()-1;//перескочим на следующий символ
                }
            }
        }

        return b;
    }public static boolean Ex8 (String a, String b){//рифма
        //'a','e','i','o','u' 'y'
        String[] a1 = a.split(" ");//получаем строки по словам через пробел
        String[] b1 = b.split(" ");
        a= a1[a1.length-1];//получаем последние слова каждой тсроки
        b= b1[b1.length-1];
        String a2="";//пустые строки для записи гласных
        String b2="";
        int c=0;//счетчик
        for (int i=0;i<a.length();i++){//бежим по первому слову и записываем в новую строку гласные
            if (a.charAt(i)=='a'||a.charAt(i)=='e'||a.charAt(i)=='i'||a.charAt(i)=='o'||a.charAt(i)=='u'||a.charAt(i)== 'y')
                a2+=a.charAt(i);
        }
        for (int i=0;i<b.length();i++){//бежим по второму слову и записываем в новую строку гласные
            if (b.charAt(i)=='a'||b.charAt(i)=='e'||b.charAt(i)=='i'||b.charAt(i)=='o'||b.charAt(i)=='u'||b.charAt(i)== 'y')
                b2+=b.charAt(i);
        }

            for (int i=0; i< a2.length(); i++){//считаем повторы гласных в новых строках
                for (int j=0; j< b2.length(); j++){
                    if (a2.charAt(i)==b2.charAt(j)) c++;
                }
            }
        return c==a2.length();//равны ли повторы гласных длинне первой сравниваемой строки
    }
    public static boolean Ex9 (long a, long b){//три и два
        long a1=1;//временное число
        long a2=1;//выходное число
        long b1=1;//временное число
        long b2=1;//выходное число
        int c1=1;//счестчик чисел
        int c2=1;
        while (a>0){//пока первое число больше 0
            if (a%10==a/10%10){//последняя цифра=предпослежней?
                c1++;//счетчик+1
                a1=a%10;//отсекаем последнее число в новую переменную
                a/=10;//укорачиваем слово
            }else {
                if(c1==3){//если найдено три одинаковые цифры, то
                    c1=1;//обнуляем счетчик
                    a2=a1;//запоминаем повторяющуюся цифру
                }else {
                    c1=1;

                }
                a/=10;
            }
        }
        while (b>0){//тот эже принцип, как и в первом числе, только два повтора
            if (b%10==b/10%10){
                c2++;
                b1=b%10;
                b/=10;
            }else{
                if(c2==2){
                    c2=1;
                    b2=b1;
                }else {
                    c2=1;

                }
                b/=10;
            }
        }
        return (b2==a2);//равны ли повторяющиеся цифры?
    }
    public static int Ex10 (String a, char b){//книги
        String c = String.valueOf(b);//переводим чар в строку
        String[] a1 = a.split(c);//делим строку по разделителям
        return a1.length;//выводм количество подстрок
    }



}
