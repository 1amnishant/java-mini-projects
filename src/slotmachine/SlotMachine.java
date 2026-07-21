package slotmachine;

import java.util.Random;
import java.util.Scanner;
public class SlotMachine {
    public static void main(String []args){

        Scanner scanner = new Scanner(System.in);

        String ifPlay;
        int balance = 1000;
        int bet;
        int payout;
        String[] row;


        System.out.println("WELCOME TO SLOT MACHINE\n");
        while(balance>0){
            System.out.print("---------------------------------");
            System.out.println("\nCurrent balance: Rs"+balance);
            System.out.print("How much money you wanna bet on: Rs");
            bet= scanner.nextInt();
            scanner.nextLine();
            if(bet>balance) {
                System.out.println("INSUFFICIENT FUND");
                continue;
            }
            else if(bet<=0){
                System.out.println("You cannot bet 0 or Less than");
                continue;
            }
            else{
                balance-=bet;

            }
            System.out.println("---------------------------------");
            System.out.println("\nSpinning🎲......🎲......🎲.......\n");
            System.out.println("*********************************");
            row=spinRow();
            printRow(row);
            payout=getPayout(row,bet);
            if(payout>0){
                System.out.println("You have won Rs"+payout);
                balance+= payout;
            }
            else{
                System.out.println("Sorry Better Luck Next time");
            }
            System.out.println("*********************************");
            System.out.print("\nWanna play again(y/n): ");
            ifPlay= scanner.next().toLowerCase();
            if(!ifPlay.equals("y")){
                break;
            }
        }
        System.out.println("GAME OVER!");
        System.out.println("Your current Balance: Rs"+balance);
        scanner.close();
    }
    static String[] spinRow() {
        String[] symbols= {"🍎", "🥭", "🍒", "🔔", "🗿", "🍋"};
        String[] row= new String[3];
        Random random = new Random();
        for(int i=0;i<3;i++){
            row[i]=symbols[random.nextInt(symbols.length)];
        }
        return row;
    }
    static void printRow(String[]row){

        System.out.println(" "+String.join(" | ",row));
    }
    static int getPayout(String[]row, int bet){
        if(row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch(row[0]){
                case"🍎" -> bet*3;
                case"🥭" -> bet*4;
                case"🍒" -> bet*5;
                case"🔔" -> bet*8;
                case"🍋" -> bet*10;
                case"🗿" -> bet*20;
                default->0;
            };
        }
        else if(row[0].equals(row[1])){
            return switch(row[0]){
                case"🍎" -> bet*2;
                case"🥭" -> bet*3;
                case"🍒" -> bet*4;
                case"🔔" -> bet*6;
                case"🍋" -> bet*8;
                case"🗿" -> bet*10;
                default->0;
            };
        }
        else if(row[1].equals(row[2])){
            return switch(row[1]){
                case"🍎" -> bet*2;
                case"🥭" -> bet*3;
                case"🍒" -> bet*4;
                case"🔔" -> bet*6;
                case"🍋" -> bet*8;
                case"🗿" -> bet*10;
                default->0;
            };
        }
        return 0;
    }
}
