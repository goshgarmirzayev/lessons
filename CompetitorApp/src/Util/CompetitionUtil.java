package Util;

import beans.Competitor;
import beans.User;
import config.Config;
import config.Initialization;

import java.util.Random;
import java.util.Scanner;

public class CompetitionUtil {
    public static Competitor[] registerCompetitors(){
     Scanner sc = new Scanner(System.in);
        System.out.println("How many competitors will participate in competition?");
        int competitorCount= sc.nextInt();
        Competitor[] competitors= new Competitor[competitorCount];
        for(int i=0;i<competitorCount;i++){
       Competitor competitor= registerCompetitor();

            competitors[i]=competitor;
        }
    Initialization.config.setCompetitors(competitors);
        System.out.println("All competitors successfully registered!");
        return competitors;
    }


    public static Competitor registerCompetitor(){
             Scanner sc = new Scanner(System.in);
             System.out.println("Competitor name:");
             String name =sc.nextLine();
             System.out.println("Competitor surname :");
             String surname =sc.nextLine();
             System.out.println("Competitor age :");
             int age =sc.nextInt();
             Competitor competitor =new Competitor(name,surname,age);
             return competitor;

    }
    public static void printCompetitors(Competitor[]competitors){
        if(competitors==null || competitors.length==0){
            return;
        }
        for(int i=0;i<competitors.length;i++){
            Competitor c=competitors[i];
            System.out.println(c); ///obyektin icinde to string metodu var override olunub!
            // burada obyekt capa verilir !!
        }
    }
    public static void printCompetitors(){
        printCompetitors(Initialization.config.getCompetitors());
    }

    public static Competitor[] registerCompetitorsAndInfo(){
        Competitor [] competitors=registerCompetitors();
        CompetitionUtil.printCompetitors(competitors);
        return competitors;
    }
    public static boolean startCompetition(){
        int winner = chooseWinner(Initialization.config.getCompetitors().length);
        System.out.println("Guess winner?");
        Scanner sc= new Scanner (System.in);
        int guessedWinner =sc.nextInt();
        if(guessedWinner==winner){
            System.out.println("You won!Your point increase to "+Initialization.config.getUser().getPoint());
            increasePoint();
            return true;
        }else {
            System.out.println("You failed!");
            return false;
        }
    }

    public static void increasePoint(){
        User user =Initialization.config.getUser();
        user.setPoint(user.getPoint()+10);
    }

    public  static void showPoint(){
        System.out.println("Your point :"+ Initialization.config.getUser().getPoint());
    }
    public static void increaseCompetitors(){
        Competitor [] competitorsOld =Initialization.config.getCompetitors();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many competitors do you want to append?");
        int  increasecount= sc.nextInt(); //3
        Competitor[] competitorsNew =new Competitor[competitorsOld.length+increasecount];
        for (int i=0;i<competitorsOld.length;i++){
            competitorsNew[i]=competitorsOld[i];
        }
        for(int i =competitorsOld.length;i<competitorsOld.length+increasecount;i++){
            competitorsNew[i]=registerCompetitor();
        }
        Initialization.config.setCompetitors(competitorsNew);
    }
    public static int chooseWinner(int number){
//        int randomNum;
//
//        randomNum=(int) (number*Math.random()+1);
//        return randomNum ;
        Random random =new Random();
        int selectedMember =random.nextInt(number);
       int res= ((selectedMember-1)+1)+1;
       return res;
    }
}
