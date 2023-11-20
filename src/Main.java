import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random(0);
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int n = sc.nextInt();
        List list = new List();
        for (int i = 0; i < n; i++){
            //list.push_front(rand.nextInt(100));
        list.push_back(rand.nextInt(100));
        }
list.print();
        list.reverse_print();
        list.pop_front();
        list.pop_back();
        list.print();
        list.reverse_print();
        System.out.print("Введите значение добавляемого элемента: ");
        int value = sc.nextInt();
        System.out.print("Введите индекс добавляемого элемента: ");
        int index= sc.nextInt();
        list.insert(value,index);
        list.print();
    }

}