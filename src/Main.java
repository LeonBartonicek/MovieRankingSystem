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
            filme.sort();
            for (int i = 0; i < filme.listOfThings.size(); i++) {
                Thing currentThing = filme.listOfThings.get(i);
                String zeile = currentThing.getName();

                int j= currentThing.getName().length();
                while (j< filme.longestWordCharCount()+2){
                    zeile += " ";
                    j++;
                }
                zeile += currentThing.getElo();
                System.out.println(zeile);
            }

            while (inputOnGoing){

                System.out.println("How many things do you want to add?");
                int howMany = scanner.nextInt();

                for (int i = 0; i < howMany; i++) {
                    System.out.println("Enter name of new thing: ");
                    String name = scanner.next();
                    System.out.println("name: "+name);
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
                    System.out.println(a1.getName() + " or " + b1.getName() + " ?");

                    boolean wasValidAnswer = false;
                    int answer = 0;
                    while (!wasValidAnswer){
                        answer = scanner.nextInt();
                        if(answer == 1 || answer == 2){
                            wasValidAnswer = true;
                        }
                    }
                    if (answer == 1){
                        filme.listOfThings.get(a).increaseElo();
                        filme.listOfThings.get(b).decreaseElo();
                    } else if (answer == 2){
                        filme.listOfThings.get(b).increaseElo();
                        filme.listOfThings.get(a).decreaseElo();
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
