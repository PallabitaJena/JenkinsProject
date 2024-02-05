package TestScriptJava;

import org.testng.annotations.Test;

public class RemoveDuplicateWithoutCollection {

    @Test
    public void removeduplicateTest() {
        int[] arrayNumber = {4, 2, 7, 4, 9, 2, 5, 1, 7};
        System.out.println("The Original Array is:");
        printArray(arrayNumber);

        int[] result = removeDuplicates(arrayNumber);

        System.out.println("Post removing duplicates the Array is:");
        printArray(result);
    }

    private static void printArray(int[] numbers) {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    private static int[] removeDuplicates(int[] numbers) {
        int length = numbers.length;
        int newSize = 0;

        //To find out the total number of unique numbers
        for (int i = 0; i < length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                newSize++;
            }

        }
        System.out.println("The numbers of unique number is:"+ newSize);
        //To create the array
        int[] result=new int[newSize];
        int index=0;
        for (int i = 0; i < length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[index++] = numbers[i];
            }
        }
      return result;
    }

}



