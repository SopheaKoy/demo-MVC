package co.sophea.mvcapp.exception;

import java.rmi.server.ExportException;
import java.util.Scanner;

public class ApplicationException {
    private static int myNumber(){
        try{
            return 100;
        }catch (ArithmeticException | NumberFormatException e){
            return 200;
        }finally {
            System.out.println("Hello Finally");
        }
    }
    private static void checkAge(int age){
        if(age<18){
            throw new IllegalArgumentException("You still a kid");
        }
    }
    private static void test(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter Data : ");
            Integer data = Integer.parseInt(scanner.nextLine());
            System.out.println("Data : "+data);
        }catch(ArithmeticException | NumberFormatException e){
            //System.out.println(e.getMessage());
            throw  new RuntimeException();
        }
    }
    public static void main(String[] args) {
        try{
            test();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("========================");
        myNumber();
        System.out.println("========================");
        myNumber();
        try{
            checkAge(10);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
