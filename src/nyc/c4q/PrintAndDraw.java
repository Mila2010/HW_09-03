package nyc.c4q;

import java.util.concurrent.TimeUnit;

/**
 * Created by Millochka on 9/6/16.
 */
public class PrintAndDraw {

    protected static final String[] linesForBox = {

            "-----",
            "\t-----",
            "\t-----\n",
            "| 1",
            "\t|",
            "\t| 2",
            "\t|",
            "\t| 3",
            "\t|\n",
            "-----",
            "\t-----",
            "\t-----\n"
    };

    protected static final String[] linesForIntersection = {

            "-----\t\t",
            "-----\t\t",
            "-----\n",
            "( 1",
            "\t)",
            "\t\t( 2",
            "\t)",
            "\t\t( 3",
            "\t)\n",
            "-----\t\t",
            "-----\t\t",
            "-----\n"



    };

    public final String [] operators={
            "-",
            "/",
            "*",
            "+"
    };

//    public final String[] battle ={
//        "/\t",
//            "/\t",
//            "/\t",
//            "/\t",
//            "/\n",
//            "$\t",
//            "$\t",
//            "$\t",
//            "$\t",
//            "$\n",
//            "\\\t",
//            "\\\t",
//            "\\\t",
//            "\\\t",
//            "\\\n"
//
//
//    };

    public static final String[] battle = {
            "\\",
            "*",
            "/\t",
            "\\",
            "*",
            "/\n",
            "\\",
            "*",
            "/\t",
            "\\",
            "*",
            "/\n",
            "\\",
            "*",
            "/\t",
            "\\",
            "*",
            "/\n",
            "\\",
            "*",
            "/\t",
            "\\",
            "*",
            "/\n\n"

    };


    public String[] getlinesForIntersection(){

        return linesForIntersection;
    }


    public static void printRight(){
        System.out.println(">");
    }

    public static void  printString(String input){

        System.out.println(input);
    }

    public static void printDelimiter(){
        printString("--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*" +
                "--*--*--*--*--*--*--*--*--*--*");
    }

    public static void drawFigure(String input[]){
        for(int i=0;i<input.length;i++ )
            System.out.print(input[i]);


    }

    public static void drawBattleFigure(String input[]) throws InterruptedException {
        for (int i = 0; i < input.length; i++){
            System.out.print(input[i]);
            if((i+1)%6==0){
                TimeUnit.MILLISECONDS.sleep(2000);
            }

        }



    }

}
