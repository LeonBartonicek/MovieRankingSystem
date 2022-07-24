import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Kategorie {
    //filename.txt   = Filme/Serien;
    //b.txt
    private String fileName ="filename.txt";
    private String name;
    public ArrayList<Thing> listOfThings = new ArrayList<>();
    public Kategorie(String name) {
        this.name= name;
    }

    public void load() throws IOException {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split(",");
                listOfThings.add(new Thing(arr[0], Integer.parseInt(arr[1])));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void safe() {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for (Thing thing : listOfThings) {
                myWriter.write(thing.name + "," + thing.elo + "\n");
            }
            //.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
