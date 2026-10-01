package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        List<Lesson> list = new ArrayList<>();
        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            System.out.println("\nDados da "+i+"a aula:");
            System.out.print("Conteudo ou tarefa (c/t)? ");
            char type = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Titulo: ");
            String title = sc.nextLine();
            Lesson lesson;
            if(type=='c'){
                System.out.print("URL do video: ");
                String url = sc.next();
                System.out.print("Duracao em segundos: ");
                int duration = sc.nextInt();
                lesson = new Video(title, url, duration);
            }else{
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questoes: ");
                int totalQuestions  = sc.nextInt();
                lesson = new Task(title, description, totalQuestions);

            }
            sc.nextLine();
            list.add(lesson);
        }
        int totalSeconds = 0;
        for(Lesson lesson: list){
            totalSeconds += lesson.duration();
        }
        System.out.printf("%nDURACAO TOTAL DO CURSO = %d segundos",totalSeconds);

        sc.close();
    }
}
