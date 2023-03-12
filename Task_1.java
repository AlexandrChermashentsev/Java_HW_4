package Seminar_4_HW;

import java.util.ArrayList;
import java.util.Scanner;


/*
Реализовать консольное приложение, которое:
Принимает от пользователя строку вида text~num

Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

     // text~num (например, word~4)
// print~num (распечатать текст)

// word~1
// foo~5
// qwerty~10
// bar~5
// print~10 -> qwerty
// print~1 -> word
// print~2 -> пустая строка или исключение NoSuchElementException
// print~5 -> bar
*/
public class Task_1 {

    public static void main(String[] args) {
        System.out.println("Введите пары строк в формате: 'слово-число'\n'help' - памятка");
        Scanner in = new Scanner(System.in);
        ArrayList<String> dict_my = new ArrayList<>();
        boolean run = true;

        while (run){
            String couple = in.nextLine();
            if (couple.toLowerCase().equals("exit")){
                break;
            } else if (couple.toLowerCase().equals("help")){
                System.out.println("Вводите пары слов в формате 'слово-число'");
                System.out.println("'exit' - ЗАКОНЧИТ программу");
                System.out.println("'print-число' - выведет СЛОВО из пары 'слово-число'");
                continue;
            }

            String[] split = couple.split("-");
            String word = split[0];
            int number = Integer.parseInt(split[1]);

            if (word.toLowerCase().equals("print")){
                for (int i = 0; i < dict_my.size(); i++) {
                    String[] temp_split = dict_my.get(i).split("-");
                    String temp_word = temp_split[0];
                    int temp_number = Integer.parseInt(temp_split[1]);
                    if (temp_number == number){
                        System.out.println("Искомое слово -> " + temp_word);
                    }
                }
            } else {
                dict_my.add(couple);
            }
        }
        in.close();
    }
}
