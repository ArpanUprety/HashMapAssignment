import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
public class HashMapGrades {
    //Creates a Hashmap
    private static HashMap<String, Integer> Grades;
    public static Scanner input = new Scanner(System.in);
    public static String name;

    public static void main(String[] args) {
        System.out.println("Arpan Uprety \n");
        int grades;

//Instantiates the Hashmap
        Grades = new HashMap<>();
        Population();
        Alteration();


    }

    public static void Population() {
        /* Prepopulates the array so there are values to play with  */
        Grades.put("max", 87);
        Grades.put("sally", 95);
        Grades.put("jane", 82);
        Grades.put("phil", 77);
        Grades.put("henry", 91);
    }

    public static void Alteration() {
        String choice;
// Loops until the user quits the program by typing "q"
        //Links to a different method depending on which one of the valid letters is typed in using a case statement

        do {
            System.out.print(" \n Enter one of the following:  \n " +
                "A to add a student \n U to update a student \n R to remove a student \n L to lookup a student's grade" +
                "\n P to print all grades \n Q to quit \n >>");
            choice = input.nextLine().trim().toLowerCase();
            switch (choice) {
                case "a":
                    addname();
                    break;
                case "u":
                    updateGrade();
                    break;
                case "r":
                    removeStudent();
                    break;
                case "l":
                    DisplaySingleName();
                    break;
                case "p":
                    PrintAllName();
                    break;
            }
        } while (!choice.equals("q"));
        System.out.println("Quitting Program");
    }

    public static void addname() {
        //Accepts input for name for a key, and a input for grade for the key value
        //Creates a Key, and prints the success message
        String cname;
        int cgrade;
        System.out.print("Please enter the name of the student to add: ");
        cname = input.nextLine().trim().toLowerCase();
        System.out.print("Please enter the grade for " + cname + ":");
        String userinput = input.nextLine();
        cgrade = Utilities.parseInt(userinput, 1);
        Grades.put(cname, cgrade);
        System.out.println(cname + " has been added successfully");
    }

    public static void updateGrade() {
        int grade;
//Loops until a Hashmap Name/Key is entered, and then accepts a valid integer for grade ( if not, assigns it a value of 1 for grade)
        //Replaces the current value of the key with the user's input
        do {
            System.out.print("Please enter the name of the student:");
            name = input.nextLine().trim().toLowerCase();
        } while (!Grades.containsKey(name));
        System.out.println("Please enter the grade for " + name);
        String userinput = input.nextLine();
        grade = Utilities.parseInt(userinput, 1);
        Grades.replace(name, grade);
        System.out.printf("The record for %s has been updated \n ", name);

    }

    public static void removeStudent() {
        do {
            // Loops until name is a valid Hashmap key, then if it is, it removes the Key and its value from the HashMap,
            // Prints Success message
            System.out.print("Please enter the name of the student:");
            name = input.nextLine().trim();
        }while (!Grades.containsKey(name));

        if (Grades.containsKey(name))
        Grades.remove(name);
        System.out.printf("The student has been removed \n ");
    }

    public static void DisplaySingleName() {
        /* Takes in input,trims it, and if the name/Key is already contained in the HashMap, prints out all the values for that Key */
        System.out.print("Please enter the name of the student:");
        name = input.nextLine().trim();
        if (Grades.containsKey(name)) {
            System.out.println("Student Name " + name);
            System.out.println("Grade: " + Grades.get(name));
        } else {
            System.out.println("Name doesn't exist!");
        }
    }

    public static void PrintAllName() {
        /* Uses a For Each Loop to loop through each key in Grades, and prints all the Key's Values!! */
        for (String Student :Grades.keySet()) {
            System.out.println("Student: "+  Student +  " Grades: "  + Grades.get(Student));
        }


    }
}
