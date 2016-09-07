package nyc.c4q;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * Created by Millochka on 9/6/16.
 */
public class Game extends DataValidation{

    private boolean flashLight = false;
    private int score =0;
    Random random = new Random();;
    Scanner scanner = new Scanner(System.in);
    private int[] passcode = new int[6];
    private boolean sward =false;
    private int targetNumber;


    public Game(){

    }

    private String[] logicQuestions={

            "If some Beyonce fans also like Taylor Swift, \n" +
                    "and some Swifties are fans of Nicki Minaj,\n" +
                    "then some Bey fans are definitely Nicki fans? \n" +
                    "True or False?",
            "A men's rights activities has 17 packs of Doritos.\n" +
                    "He eats all but 9 of them. How many packs are left? None , 8 or 9?",
            "The cat is super sad about getting old. \n" +
                    "The day before yesterday she was 15, and next year she will be 18.\n" +
                    "This is true on only one day. When is her birthday? 12.30, 12.31 or 01.01?",
            "Dog has five daughters. Each of the daughters has one brother. How many children does the dog have?\n" +
                    "5, 6 or 10?",
            "Papa johns have an offer where they let you swap five empty\n" +
                    "pizza boxes for a free pizza. Tom has 25 pizza boxes.\n" +
                    " How many free pizzas can he get? 5, 6 or 10?",
    };

    private String[] logicAnswers={
            "False",
            "9",
            "12.31",
            "6",
            "6"
    };


    public int getQuestionsLength(){
        return questions.length;
    }

    public boolean guessNumber(int guessedNumber){
        int i = 1;
        targetNumber = random.nextInt(15)+ 1;
        do{
            if(guessedNumber == targetNumber){

                flashLight = true;

                return true;


            }else if(guessedNumber> targetNumber){

                System.out.println("My number is less than yours:)Please try again, you have " + (4-i) + " attempts left");
                i++;
                guessedNumber = scanner.nextInt();
            }else {
                System.out.println("My number is grater than yours:)Please try again, you have " + (4-i) + " attempts left");

                guessedNumber = scanner.nextInt();
                i++;
            }

        }while(i<4);

        if(guessedNumber == targetNumber){
            flashLight = true;
            return true;}

        return false;

    }



    public boolean guessBox(){
        drawFigure(linesForBox);
        System.out.println("Are you choosing 1, 2 or 3 one to check? ");
        System.out.println("> ");
        int randomBox = random.nextInt(3)+1;
        int guessedBox = scanner.nextInt();
        int i=1;
        while(i<4) {

            if (randomBox == guessedBox) {
                System.out.println("Wow,it was impressive my friend! ");

                return true;

            } else {

                if (flashLight) {

                    System.out.println("You lost one time, but I have a really good news for you! As you have your flashlight, " +
                            "you are eligible for few more attempts. Please go ahead and guess the box: ");

                    randomBox = random.nextInt(3)+1;
                    guessedBox = scanner.nextInt();

                    i++;


                }else{
                    System.out.println("You lost this time, my friend");
                    return false;
                }
            }

        }


        return false;
    }


    public boolean solveEquation() throws InterruptedException {
        printString("Do you see this door with some passcode? " +
                "If you will get the passcode the 250 points will be yours.\n" +
                "To get the passcode you will require to solve 4 equations and the answers will be the passcode numbers. \n" +
                "In order to be successful keep in mind this statement: \n" +
                "it is much easier to consider just the whole number for division excluding the reminder");
        int i =0;
        TimeUnit.MILLISECONDS.sleep(1000);

        while(i<4) {
            int multiplier = random.nextInt(4) + 1;
            int freeMember = random.nextInt(8) + 1;
            String operator = operators[(random.nextInt(4) + 1) - 1];
            int eaqulsTo = random.nextInt(10) + 1;
            int result = 0;
            System.out.println(multiplier + "* X " + operator + freeMember + "= " + eaqulsTo + "  x = ?");
            switch (operator.charAt(0)) {
                case '-':
                    result = (eaqulsTo + freeMember) / multiplier;
                    break;
                case '+':
                    result = (eaqulsTo - freeMember) / multiplier;
                    break;
                case '/':
                    result = (eaqulsTo * freeMember) / multiplier;
                    break;
                case '*':
                    result = (eaqulsTo / freeMember) / multiplier;
                    break;
                default:
                    result = 8;
            }
            System.out.println("Please type your answer?\n >");
            int userAnswer = scanner.nextInt();
            if (result == userAnswer) {
                printString("You are really good in math!");
                i++;
                passcode[i] = result;
            } else {
                printString("Sorry, the answer is : " + result + "You are not receiving 250 coins");
                return false;
            }
        }
        printString("You've just" +
                " earned 250 coins! you will need it later!");
        return true;

    }

    public void answerNumberofQuestions(){
        boolean temp = true;
        //setUserRandomNumber(scanner.nextInt());


        String userAnswer = "";
        int j = random.nextInt(questions.length-5) + 1;
        for (int i = j; i < j+4; i++) {
            printString("Please answer the following question: ");

            printString(questions[i]);
            //if(temp){
            //scanner.nextLine();
            //temp = false;}

            userAnswer = scanner.nextLine();
            if (validateAnAnswer(userAnswer)) {
                score += 250;
                printString("Hmmm, you are rigth. Great job!Now you receiving 250 coins for that answer");
            } else {

                printString("Oops, it is not the correct answer, I'm sorry:(");
            }


        }
    }



    public boolean quizeForSward(){

        int attempts = flashLight?2:1;
        String userAnswer = "";
        while (attempts>0) {
            int randomIndex = (random.nextInt(5) + 1) - 1;

            printString("Please answer the random logic question, you will have - " + attempts + " attempts. \n" +
                    "The number of attempts depends on the fact if you have flash light or not ");
            pressAnyKeyToContinue();
            printString(logicQuestions[randomIndex]);
            printRight();
            scanner.nextLine();
            userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(logicAnswers[randomIndex])) {

                printString("Sward is yours! Good job! You will need it later.");
                sward = true;

                return true;
            }

            attempts--;

        }

        return false;


    }



    public String moveThroughTheGame( ) throws InterruptedException {
        boolean flag = false;
        int choice;
        printString("Yong knight got lost in forest. On the way to his castle he has faced with the cave.\n " +
                "He heard so many mysterious " +
                "stories about this place, so his curiosity took over his fear and he's advanced.\n " +
                "You need to help the " +
                "brave knight to find hiw way home.\n");

        pressAnyKeyToContinue();
        printString("AHAHAHAHAHAGAGAGAGGAGAGA, now  it is too dark in the cave, but it is neccessary to go forward! \n" +
                "There is the cave ghost who is ready to share some light with the knight. \n" +
                "Ghost really likes to play, he used to be a gambler. \n" +
                "Now if you will guess the number between 1 and 15 he is thinking about, you'll help " +
                "knight to gt the light. \n" +
                "You have 4 attempts, but ghost is a nice one, he’ll give you some hints.");
        pressAnyKeyToContinue();
        printString("Give a few second to the ghost to pick the number");
        TimeUnit.MILLISECONDS.sleep(1000);

        printString("DONE! So type your suggestion:");

        //put some ghost picture
        printRight();
        if (guessNumber(scanner.nextInt())) {

            printString("Wow, you so good at it! The light is yours");
            printDelimiter();
            pressAnyKeyToContinue();
            printString("As knight has a light, it illuminates the road in front of him. So we are going further with no doubts!\n" +
                    "The most interesting is still ahead!");
            printDelimiter();

            pressAnyKeyToContinue();


        } else {

            printString("My friend, this battle has been lost, the number was " + targetNumber + ". But the whole war is in front of you right now! Go ahead");
            printDelimiter();
            //add some opportunity to guess how many roads in front


        }
        printString("Now what do you think this is?");
        drawFigure(linesForIntersection);
        pressAnyKeyToContinue();
        printString("You right - it is an intersection and road rock.\n " +
                "1. You might become a bit richer\n" +
                "2. This way is shortest one, but way too dangerous\n" +
                "3. You might get an extra armor\n" +
                "Where do you want knight to go? Please decide and type the appropriate number?");

        printRight();
        choice = scanner.nextInt();
        TimeUnit.MILLISECONDS.sleep(1000);
        check:
        do {
            switch (choice) {
                case 1:
                    printString("First road has been choosen, which means knight is going to the left. \n" +
                            "So exiting what is waiting over there!");
                    pressAnyKeyToContinue();
                    //printing the door


                    score = solveEquation() ? 250 : 0;
                    break check;
                case 2:

                    break check;
                case 3:
                    printString("Third road has been choosen, which means knight is going to the left. \n" +
                            "So exiting what is waiting over there!");
                    pressAnyKeyToContinue();
                    quizeForSward();
                    break check;
                default:
                    printString("Oooops, we have only 3 different paths, please type 1, 2 or 3 in order to choose one of them: ");
                    printRight();
                    choice = scanner.nextInt();
                    flag = true;

            }
        } while (flag);

        pressAnyKeyToContinue();
        printString("Looks like you've discovered a group of ancient cavemen and they are not happy to see you. Try to look around and find " +
                "some armor from the remains of previous brave ones.\n" +
                "There are three old merchant crates in front of you. Try to guess which one of them might have the armor?");
        printDelimiter();

        if (guessBox()) {

            if (!sward) {

                printString("So, now you have a shield, but you're still missing the weapon that might help you to defeat the cavemen.\n" +
                        "Do you want to check adjacent caves to find to find teh sward? yes or no?");
                printRight();

                if (validatePrimitiveAnswer(scanner.next())) {
                    if (quizeForSward()) {
                        printString("Good job! Sward is yours!");
                    } else {
                        return "Without sward there is no chance to survive the battle! Game is over!";
                    }
                } else {
                    return "Without sward there is no chance to survive the battle! Game is over!";
                }


            }
            printString("Now you ready to fight and a big battle is going to happen!");
            printDelimiter();
        } else {
            return "The crate you picked was empty, so you haven't got an armor. I am Sorry, but game is over";
        }
        pressAnyKeyToContinue();
        drawBattleFigure(PrintAndDraw.battle);

        printString("Hooray!!! Someone wasn't lucky to meet you.");

        pressAnyKeyToContinue();
        printString("Ow no! I'm feeling a heavy breathing at the end of the cave. \n" +
                "Don't know what it is, but it's getting too hot in here.\n ");
        //draw the dragon
        pressAnyKeyToContinue();

        printString("RRRRrrrrrrrrrrrr, who's bothering me here? You not gonna pass unitl you answer 4 of my questions.\n " +
                "Rrrrrrrrrrrrrrr each question gives you 250 coins and you need to have 1000 to pass me rich.\n " +
                "Remember: \n" +
                "1. Don't inclide any special characters in to your answer\n" +
                "2. Type all numbers in words\n" +
                "3. Spell you answers correctly!");

        answerNumberofQuestions();

        if (score >= 1000) {

            return "Good job brave knight! Last hundred that came here made me a good supper. \n" +
                    "Farewell in your new journeys! Next time questions wouldn't be that easy:)";

        } else {

            return "Since dragon wants you to leave rich, but you didn't collect 1000 coins, he decided to eat you.\n" +
                    "GAVE OVER";

        }



    }


}
