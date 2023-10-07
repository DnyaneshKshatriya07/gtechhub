import java.util.Scanner;

public class Calculator {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int FNumber = sc.nextInt();
        
        System.out.print("Enter the type of Symbol you want to perform (+, -, *, /): ");
        String Symbol = sc.next();
        
        System.out.print("Enter the second number: ");
        int SNumber = sc.nextInt();

        int result = Operation(FNumber, SNumber, Symbol);
        System.out.println("Your answer is: " + result);
    }

    public static int Operation(int FNumber, int SNumber, String Symbol)
    {
        int result = 0;
        if (Symbol.equals("+")) {
            result = FNumber + SNumber;
        }
        else if (Symbol.equals("-")) {
            result = FNumber - SNumber;
        }
        else if (Symbol.equals("*")) {
            result = FNumber * SNumber;
        }
        else if (Symbol.equals("/")) {
            result = FNumber / SNumber;
        }
        else {
            System.out.println("Invalid Symbol");
        }
        return result;
    }
}