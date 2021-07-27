package service;

import entity.Product;

import java.util.ArrayList;
import java.util.Map;

public class PrintMessage {
    public static void printMenu(String [] items,String menuMsg){
        System.out.println("-----------"+menuMsg+"-----------");
        for (int i=0;i< items.length; i++) {
            System.out.printf(" [%d] - %s \n",i+1,items[i]);
        }
    }
    public static void printMenu(String [] items){
        for (int i=0;i< items.length; i++) {
            System.out.printf(" [%d] - %s \n",i+1,items[i]);
        }
    }
    public static int printCartItem(Map<Integer,Product> map){
        int price=0;
        for (Map.Entry<Integer,Product> pair: map.entrySet()) {
            System.out.format(" [ id: %d ] name: %s, price:%d, count:%d%n", pair.getKey(), pair.getValue().getName(),pair.getValue().getPrice(),pair.getValue().getCount());
            price+=pair.getValue().getPrice();
        }
        System.out.println("------>|Sum of price is : "+price+"|");
        return price;
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
