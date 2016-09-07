package nyc.c4q;

import java.util.Scanner;

public class Main {




        public static void main(String[] args) throws InterruptedException {
            Scanner scanner = new Scanner(System.in);
            boolean userDecision = false;
            String userToChoose = "";
            do{
                Game game = new Game();

                PrintAndDraw.printString(game.moveThroughTheGame( ));

                game.printString("Do you want to play again?");
                game.printString(">");
                userToChoose = scanner.next();
                if(game.validatePrimitiveAnswer(userToChoose)){

                    userDecision = true;

                } else{ userDecision = false; }
            }while(userDecision);
            // write your code here
        }


    }

