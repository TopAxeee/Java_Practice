public class Task_1 {
    public static void main (String[] args){
        System.out.println("Задание 1:");
        System.out.println(Ex1(5,2));
        System.out.println("Задание 2:");
        System.out.println(Ex2(6,2));
        System.out.println("Задание 3:");
        System.out.println(Ex3(2,2,1));
        System.out.println("Задание 4:");
        System.out.println(Ex4(3,2,8));
        System.out.println("Задание 5:");
        System.out.println(Ex5(5,2,10));
        System.out.println("Задание 6:");
        System.out.println(Ex6('A'));
        System.out.println("Задание 7:");
        System.out.println(Ex7(10));
        System.out.println("Задание 8:");
        System.out.println(Ex8(5,7));
        System.out.println("Задание 9:");
        System.out.println(Ex9(new int[]{5, 7, 3, 5, 7, 6, 0}));
        System.out.println("Задание 10:");
        System.out.println(Ex10(3,5,9));

    }
    public static int Ex1 (int a, int b){//остаток от деление
        return a%b;
    }//остаток от деления
    public static int Ex2 (int a, int b){//площать прямоугольного треугольника
        return a*b/2;
    }//площаль треугольника
    public static int Ex3 (int chicken, int pig, int cow){//количество ног животных
        return chicken*2+pig*4+cow*4;
    }//посчитать количесто ног
    public static boolean Ex4 (int prob, int prize, int pay){//является лли правдной, что а*в больше с
        return prob*prize>pay;
    }// prob * prize > pay
    public static String Ex5 (int a, int b, int c){//определетить выполненную операцию
        if (a*b==c){return "умножение";}
        else if (a/b==c){return "деление";}
        else if (a-b==c){return "вычитание";}
        else if (a+b==c){return "сложение";}
        else {return "ничего";}
    }
    public static int Ex6 (char a){//номер буквы в аски коде
        return (int) a;
    }
    public static int Ex7 (int a){//сумма чисел до числа
        int sum=1;
        for(int i=2;i<=a;i++){
            sum=sum+i;
        }
        return sum;
    }
    public static int Ex8 (int a, int b){//длина третьего ребра треугольника
        return a+b-1;
    }//максимальное значение третьего ребра (сумаа двух больше третьей)
    public static int Ex9 (int arr[]){//сумма кубов массивов
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum=sum+arr[i]*arr[i]*arr[i];
        }
        return sum;
    }public static boolean Ex10 (int a, int b, int c){//а*b/с
    return a*b%c==0;
    }
}
