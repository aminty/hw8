package service;

import java.util.ArrayList;

public class PrintMessage {
    public static void printMenu(String [] items,String menuName){
        System.out.println("-----------"+menuName+"-----------");
        for (int i=0;i< items.length; i++) {
            System.out.printf(" [%d] - %s \n",i+1,items[i]);
        }
    }
    public static void showMsg(String input){
        System.out.println("--->>> Message : "+input);
    }
    public static void showErr(String input){
        System.out.println("--->>> Error : "+input);
    }
    public static void printItem(ArrayList<String> attr){
        StringBuilder line=new StringBuilder();
        for (int i=0;i<=100;i++)
            line.append("-");
        System.out.println(line);
        System.out.printf("-> | [%s] MODEL: %s  CATEGORY: %s --> %s PRICE: %s AVAILABLE COUNT: %s |\n",
                attr.get(0),attr.get(1),attr.get(2),attr.get(3),attr.get(4),attr.get(5));
    }
}
