package TestScriptJava;
import org.testng.annotations.Test;

import java.util.Scanner;
public class CheckPrime {



       @Test
       public void TestCase1() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number to check if it's prime: ");
            int numberToCheck = scanner.nextInt();

            if (isPrime(numberToCheck)) {
                System.out.println(numberToCheck + " is a prime number.");
            } else {
                System.out.println(numberToCheck + " is not a prime number.");
            }

            scanner.close();
        }

        // Function to check if a number is prime
        private static boolean isPrime(int num) {
           System.out.println(Math.sqrt(num));
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


