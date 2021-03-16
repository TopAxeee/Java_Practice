import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        System.out.println(Ex1("ABCD", 2));
        System.out.println("Задание 2:");
        System.out.println(Ex2(new int[]{6, 2, 1, 0, 9, 0, 55, -10}));
        System.out.println("Задание 3:");
        Ex3(new int[]{2, 2, 1});
        System.out.println(Ex3(new int[]{1, 2, 1}));
        System.out.println("Задание 4:");
        int [] g={3,2,8};
        System.out.println(Arrays.toString(Ex4(g)));
        System.out.println("Задание 5:");
        System.out.println(Ex5(2.10));
        System.out.println("Задание 6:");
        System.out.println(Ex6(7));
        System.out.println("Задание 7:");
        System.out.println(Ex7("10256"));
        System.out.println("Задание 8:");
        System.out.println(Ex8("cola","abba"));
        System.out.println("Задание 9:");
        System.out.println(Ex9("automation", "auto-"));
        System.out.println("Задание 10:");
        System.out.println(Ex10(3));

    }

    public static String Ex1(String s1, int n) {//повторить символ строки
        String s2 = "";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < n; j++) {
                s2 = s2 + s1.charAt(i);

            }
        }
        return s2;
    }
    public static int Ex2(int arr[]) {//разниа между макс и мин
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max - min;
    }
    public static boolean Ex3(int arr[]) {//среднее число массива
        int n=0;
        for (int i=0;i<arr.length;i++){
         n+=arr[i];
        }return n%arr.length==0;
    }
    public static int [] Ex4(int arr[]){//массив сумм
        int [] arr2 = new int [arr.length];//длина массива а
        int sum=0;
        for (int i=0;i<arr.length;i++){
            arr2[i]=arr[i]+sum;
            sum=sum+arr[i];
        }return arr2;
    }
    public static int Ex5 (double n){//число десятичных знаков
        String s = String.valueOf(n);//засунул число в строку
        int count =0;//количествто нулей
        for (int i=0;i<s.length();i++) {
        if (s.charAt(i)=='.'){
            count = s.length()-i;//длинна строки-положение точки=количествто нулей
        }
        }return count;
    }
    public static int Ex6 (int n){//фибоначчи
        int res=0;
        int [] fib = new int [n];//массив чисел фибоначчи
        fib[0]=1;//п6ерваые дваэлемента массива
        fib[1]=2;
        for (int i=2;i<n;i++){//начиная с третьего элемента
            fib[i] = fib[i - 1] + fib[i - 2];//формула
            res=fib[i];
        }return res;
    }
    public static boolean Ex7 (String s){//почтовый индекс
        int count=0;
        if(s.length()>5){
            return false;
        }else{
            for (int i=0;i<s.length();i++){//бежим по строке
                if (s.charAt(i)>='0'&& s.charAt(i)<='9'){//элемент строки между 0 и 9
                    count++;//+1
                }else count--;//-1
            }
            if (count==s.length()){return true;}
            else return false;
        }
    }
    public static boolean Ex8 (String a, String b){//странная пара
        return  ((a.charAt((a.length()-1))==b.charAt(0))||(a.charAt((0))==b.charAt(b.length()-1)));
    }//последня и перва ИЛИ первая и последняя
    public static boolean Ex9 (String str, String fix){//префикс суффикс
       if (fix.charAt(fix.length()-1)=='-'){//prefix
           if (str.indexOf(fix.substring(fix.length()))==0){//если вхождение префикса без черточки
               return true;
           }return false;
       }else if (fix.charAt(0)=='-'){//suffix
           if (str.indexOf(fix.substring(0))==(str.length()-fix.length()+1)){
               //если вхождение суффикса = длинастроки-длина суффикса (с палочкой)+1 (для вычита палочки)
               return true;
           }return false;
       }else return false;

    }public static int Ex10 (int a){//шаги по картинке
        if(a%2==0){
            return a;
        }else return a+2;
    }
}