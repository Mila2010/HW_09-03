package nyc.c4q;

import java.util.Scanner;

/**
 * Created by Millochka on 9/6/16.
 */
public class DataValidation extends PrintAndDraw{


    public static final String[] questions = {
            "What is the name of the current President of USA?",
            "Which built in method is used in Java to compare two Objects? ",
            "What is the capital of Russia?",
            "How many planets in the Solar System?",
            "What is the name of Peter Griffin's youngest son?",
            "What is the most famous Vincent van Gogh's picture?",
            "What is the last name of Steve Job's partner in making first Macintosh computer?",
            "How many cohorts in Access Code this year?",
            "What is the full first name of Access Code 3.3 Saturday instructor?",
            "What is the full first name of Access Code 3.3 Program manager?",
            "What is the derivative of x^2 ?",
            "One pound steel comparing to one pound of feather is: heavier? lighter or equal?",
            "What is the first name of Titanic's director?",
            "Name NY State famous hockey team?",
            "What is the last name of the light bulb inventor?"


    };

    private static int userRandomNumber;

    public static void setUserRandomNumber(int input){
        userRandomNumber=input;

    }

    public static int getUserRandomNumber(){

        return userRandomNumber;
    }

    private enum Answer{

        BARACK_OBAMA,
        EQUALS,
        MOSCOW,
        EIGHT,
        STEWIE,
        STARRY_NIGHT,
        WOZNIAK,
        THREE,
        JONATHAN,
        NIKO,
        TWO_X,
        EQUAL,
        JAMES,
        RANGERS,
        EDISON
    }
    private static Scanner scanner = new Scanner(System.in);

    public static boolean validatePrimitiveAnswer(String input){
        while(true){
            switch (input) {

                case "yes":
                case "y":
                    return true;
                case "no":
                case "n":
                    return false;

                default: System.out.println("Oops, I am afraid I don't undertand your answer, please answer yes or no?");
                    input = scanner.next().toLowerCase();


            }
        }
    }


    public boolean validateAnAnswer(String inputAnswer){

        String tempAnswer= "";
        for(Answer answer: Answer.values() ){

            if (answer.name().indexOf('_') >= 0 ){
                tempAnswer = answer.name().substring(0, answer.toString().indexOf('_')) + " "
                        + answer.name().substring(answer.toString().indexOf('_') + 1, answer.toString().length());
            } else {
                tempAnswer = answer.name();
            }

            if (inputAnswer.equalsIgnoreCase(tempAnswer)) {
                return true;
            }


        }
        return false;


    }

    public static void pressAnyKeyToContinue()
    {
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public boolean validateNumber(int inputNumber)
    {
        while(inputNumber<1||inputNumber>questions.length){
            System.out.println("Oops, it seems that you typed number which is out of the range. Please try again and give " +
                    "me some number between 1 and " + questions.length + " ?");

            inputNumber =scanner.nextInt();

        }
        userRandomNumber = inputNumber;
        return true;
    }

}
