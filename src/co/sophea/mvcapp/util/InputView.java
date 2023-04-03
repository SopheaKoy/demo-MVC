package co.sophea.mvcapp.util;

import java.util.Scanner;
public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static String getText(String label){
        System.out.println(label);
        return scanner.next();
    }
    public static Integer getInteger(String label){
        do{
            System.out.println(label);
            try{
                return Integer.parseInt(scanner.next());
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
    public static Double getFloatPoint(String label){
        do{
            System.out.println(label);
            try{
                return Double.parseDouble(scanner.next());
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
    public static void pressEnterToContinue(){
        System.out.println("------------------------");
        System.out.println("Press Enter to Continue");
        System.out.println("------------------------");
        System.out.println();
        try{
            System.in.read();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
