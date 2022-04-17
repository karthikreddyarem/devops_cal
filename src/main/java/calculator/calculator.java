package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class calculator {

    public static final Logger logger = LogManager.getLogger(calculator.class);

    public calculator() {}

    public static void main(String[] args) {
        calculator cal = new calculator();
        Scanner scanner = new Scanner(System.in);
        double input1, input2;

        do{
            System.out.println("Scientific Calculator");
            System.out.println("Possible operations -- code\nb times a  -- 1\nRoot of a num -- 2\nLog of a num  -- 3\nFactorial of num  -- 4\nAdd two num -- 5\n exit -- 6");
            int operation;

            try{
                operation = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            if (operation < 1 || operation > 5){
                return;
            }
            try{
                System.out.println("Give a possible integer");
                input1 = scanner.nextDouble();
            } catch (InputMismatchException error) {
                return;
            }

            switch(operation){
                case 1:
                    try {
                        System.out.print("Give second input");
                        input2 = scanner.nextDouble();
                    } catch (InputMismatchException error){
                        return;
                    }
                    System.out.println("b times a = " + calculator.times(input1, input2));
                    break;

                case 2:
                    System.out.println("Square root of x = " + calculator.sqt(input1));
                    break;

                case 3:
                    System.out.println("Natural log of x = " + calculator.log(input1));
                    break;
                case 4:
                    System.out.println("Factorial of x = " + calculator.factorial(input1));
                    break;
                case 5:
                    try{
                        System.out.print("Give second number");
                        input2 = scanner.nextDouble();
                    } catch (InputMismatchException error){
                        return;
                    }
                    System.out.println("a + b = " + calculator.sum(input1,input2));
                    break;
                default:
                    System.out.print("Thank You");
                    return;
            }
        }while(true);
    }

    public static double sum(double a,double b){
        logger.info("sum of -" + a +"," + b);
        double result = a+b;
        logger.info("result = " + result);
        return result;
    }

    public static double times(double a, double b){
        logger.info("power of " + a + " times " + b );
        double result = Math.pow(a,b);
        logger.info("RESULT= " + result);
        return result;
    }

    public static double sqt(double num){
        double result = 0;
        try {
            logger.info("square root of - " + num);
            if (num < 0) {
                result = Double.NaN;
                throw new ArithmeticException("square root of negative numbers is not supported");
            } else {
                result = Math.sqrt(num);
            }
        } catch (ArithmeticException error){
            logger.error(" square root of negative numbers is not supported");
        } finally {
            logger.info("result = " + result);
        }
        return result;
    }

    public static double factorial(double num){
        logger.info("factorial of " + num );
        double result = 1.0;
        for (int t = 1; t<= num; t++){
            result *= t;
        }
        logger.info("result = " + result);
        return result;
    }
    public static double log(double num){
        Double result = 0.0;
        try {
            logger.info("log of - " + num);
            if (num < 0){
                result = Double.NaN;
                throw new ArithmeticException("log of negative numbers is not supported");
            }
            else if (num == 0){
                result = Double.NEGATIVE_INFINITY;
                throw new ArithmeticException("Log of 0 is not defined");
            }
            else {
                result = Math.log(num);
            }
        } catch (ArithmeticException error){
            logger.error("Inout is not in range");
        } finally {
            logger.info("result = " + result);
        }
        return result;
    }

}