package service;

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
}
