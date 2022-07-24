import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        boolean onGoing = true;
        boolean inputOnGoing = true;
        boolean questionsOnGoing = true;
        Scanner scanner = new Scanner(System.in);

        Kategorie filme = new Kategorie("Filme");
        try {
            filme.load();
        } catch (IOException e) {
            System.out.println("Bei load ist etwas schief gelaufen:");
            e.printStackTrace();
        }

        while (onGoing){
            //print
            for (int i = 0; i < filme.listOfThings.size(); i++) {
                System.out.println(filme.listOfThings.get(i).name
                        +" " + filme.listOfThings.get(i).elo);
            }
            while (inputOnGoing){


                System.out.println("How many things do you want to add?");
                int answer = scanner.nextInt();

                for (int i = 0; i < answer; i++) {
                    System.out.println("Enter name of new thing: ");
                    String name = scanner.nextLine();
                    Thing temp = new Thing(name);
                    filme.listOfThings.add(temp);
                    filme.safe();
                }
                filme.safe();
                inputOnGoing = false;
                break;
            }


            //---------------------------------------
            while (questionsOnGoing){
                System.out.print("How many questions? ");
                int n = scanner.nextInt();

                for (int i=0; i<n;i++){
                    Random random = new Random();
                    int a = random.nextInt(filme.listOfThings.size());
                    Thing a1 = filme.listOfThings.get(a);
                    int b = random.nextInt(filme.listOfThings.size());
                    Thing b1 = filme.listOfThings.get(b);
                    System.out.println("Which one was better? ");
                    System.out.println(a1.name + " or " + b1.name + " ?    1/2:");

                    boolean wasValidAnswer = false;
                    int answer = 0;
                    while (!wasValidAnswer){
                        answer = scanner.nextInt();
                        if(answer == 1 || answer == 2){
                            wasValidAnswer = true;
                        }
                    }
                    if (answer == 1){
                        filme.listOfThings.get(a).elo += 50;
                        filme.listOfThings.get(b).elo -= 50;
                    } else if (answer == 2){
                        filme.listOfThings.get(b).elo += 50;
                        filme.listOfThings.get(a).elo -= 50;
                    } else{
                        filme.safe();
                        break;
                    }
                }
                questionsOnGoing = false;
            }
            onGoing = false;
        }
        filme.safe();
        System.exit(0);
    }
}
