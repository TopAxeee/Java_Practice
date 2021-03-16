import java.util.Arrays;

public class Task_3 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1(1,0,-1));
        System.out.println("Задание 2:");
        System.out.println(Ex2("all zip files are zipped"));
        System.out.println("Задание 3:");
        System.out.println(Ex3(6));
        System.out.println("Задание 4:");
        System.out.println(Ex4("Aga"));
        System.out.println("Задание 5:");
        System.out.println(Ex5("#eaecee"));
        System.out.println("Задание 6:");
        System.out.println(Ex6(new int[] {1, 3, 4, 4, 4}, new int [] {2, 5, 7}));
        System.out.println("Задание 7:");
        System.out.println(Ex7(297));
        System.out.println("Задание 8:");
        System.out.println(Ex8("11000100100001"));
        System.out.println("Задание 9:");
        System.out.println(Ex9(12));
        System.out.println("Задание 10:");
        System.out.println(Ex10(3,4,5));

    }
    public static String Ex1 (int a, int b, int c){//квадратное уравнение
        double D = b*b-4*a*c;//найдем дисримнант
        //D=Math.sqrt(D);
        if (D == 0) {
            return "Уравнение имеет один корень: "+ (b*(-1))/(2*a);//х1
        }else if (D>0){
            return "Уравнение имеет два корня: х1= " + (b*(-1)+Math.sqrt(D))/(2*a) + " x2= " + (b*(-1)-Math.sqrt(D))/(2*a);//х1,2
        }else return "Уравнение не имеет действительных корней";
    }
    public static int Ex2 (String s){//второе вхождение зипа
        String zip = "zip";
        int c=s.indexOf(zip);//первое вхождение зипа
        if (c>0){
           return s.indexOf(zip,(c+zip.length()));//второе вхождение зипа
        }else return -1;
    }
    public static boolean Ex3 (int a){//совершенное число
        int b=0;
        for (int i=1;i<a;i++){//суммируем все делители числа А
            if (a%i==0) b+=i;
        }if (b==a){return true;}//если сумма делителей равна А, то правда
        else return false;
    }
    public static String Ex4 (String a){//строки
        if (a.length()>1){//если длина тсроки больше 1
            if (a.charAt(0)==a.charAt(a.length()-1)){//если первый и последний элемент равны
                 return "Two's a pair.";
            }
            if (a.charAt(0)!=a.charAt(a.length()-1)){//меняем послежнйи и первый элементы местами
                 char b = a.charAt(0);
                 char c = a.charAt((a.length()-1));
                 char[] str = a.toCharArray();
                 str[0]=c;
                 str [a.length()-1]=b;
                 return new String (str);
            }
        }else return "Incompatible.";//невозможно, если 1 символ
        return "";
    }
    public static boolean Ex5 (String a){//шестнадцетиричный код
        if (a.length()!=7){//еслидлина не равна семи ложь
            return false;
        }else{
            if (a.charAt(0)!='#'){//если первый элемент решетка, то дальше
                return false;
            }else {
                int count=1;//счетчик
                for (int i=1;i<a.length();i++){//ползем по строке
                    if ((a.charAt(i)>=0 && a.charAt(i)<=9)||(a.charAt(i)>='A' && a.charAt(i)<='F'))//если элементы в пределах 0-9, или А-Ф(англ), то счетчик++
                       count++;
                }
                if (count==a.length()){//если счетчик=длине
                    return true;
                }else return false;
            }
        }
    }
    public static boolean Ex6(int[] a, int [] b){//уникальные символы
        int c1=0; int c2=0;//счетчик уникальных сиволов
        int temp=0;//локальныйй счетчик уник симв
        for (int i=0;i<a.length-1;i++){//бежим по первому массиву
            for (int j=0;j<a.length-1;j++){//сравниваем со следующими элем
                if ((a[i]==a[j])&&(i!=j))//если совпадение элементов (разные индексы)
                    temp++;//счетчик+1
            }
            if (temp==0) c1++;//если символ уникален, то с1++
            temp=0;
        }
        for (int i=0;i<b.length-1;i++){//то же самое со вторым мссивом
            for (int j=0;j<b.length-1;j++){
                if (b[i]==b[j]&&i!=j) temp++;
            }
            if (temp==0) c2++;
            temp=0;
        }
        if (c1==c2) {return true;}//количесвто уникальных элементов одинаково?
        else return false;
    }
    public static boolean Ex7 (int Krap){//число капрекара
        int Krap2 = Krap * Krap;//квадрат числа
        int b=1;//для деления числа на части
        int KrapA;//левая часть
        int KrapB;//правая часть
        String a = Integer.toString(Krap2);//строка для длинны числа
        if (a.length() %2 == 0) {//если длина четная, то
            for (int i=0;i<a.length()/2;i++){//умножаем половину длины
                b*=10;
            }
            KrapA=Krap2%b;//отсекаем половины
            KrapB=Krap2/b;
            return  KrapA+KrapB==Krap;//если сумма половин равна заданному числу
        }else
            for (int i=0;i<(a.length()/2+1);i++){//левая часть на 1 символ длиннее правой
                b*=10;
            }
            KrapA=Krap2%b;//отсекаем половины
            KrapB=Krap2/b;
            return  KrapA+KrapB==Krap;//если сумма половин равна заданному числу
    }
    public static String Ex8 (String a){//длинное количество нуей
        String b="";//пустая строка для записи нулей
        int len=0;//длинна нулей
        int max=0;//максимальная длина
        for (int i=0;i<a.length();i++){//бежим по строке
            if (a.charAt(i)=='0'){
                //b=b+a.charAt(i);
                len++;//считаем длину нулей, пока не найдена 1
            }else {
                if (max<len){//сравниваем длины
                    max=len;
                }
                len=0;
            }

        }
        for (int i=0;i<max;i++){//записываем в строку макс число нудей
            b=b+'0';
        }return b;
    }
    public static int Ex9 (int a){//простое число
        int b=0;
       if (isPrime(a)==true){//если простое число, то вернуть а
           return a;
       }else {

           for (int i=a;i<a+100;i++){//ищем простое число в пределах а+100
               if (isPrime(i)==true){
                   b=i;
                   break;
               }
           }
       }
       return b;
    }
    public static boolean isPrime(int n) {//протсое число из первой лабы
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean Ex10 (int a, int b, int c){//являются ли числа сторонами треугольника
    return (a*a+b*b==c*c||a*a+c*c==b*b||b*b+c*c==a*a);//перебираем возможные варианты пифагорова уравнения со сторонами
    }//прямоугольный треугольник
}
