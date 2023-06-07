package LeetCode;

public class PlusOne {

    // Define a public method named 'plusOne' which takes an integer array as input and returns an integer array.
    public int[] plusOne(int[] digits) {

        // Initialize a flag 'carry' to represent if there's a carry from the previous digit addition
        boolean carry = false;

        // Start from the least significant digit (the last element of the array)
        int i = digits.length - 1;

        // As long as there's a carry and there are more digits to process
        do {

            // If the current digit is 9, set it to 0 and continue the carry to the next digit
            if (digits[i] == 9) {
                digits[i] = 0;
                carry = true;
            } else {

                // If the current digit is not 9, just add 1 to it and stop the carry
                digits[i] = digits[i] + 1;
                carry = false;
            }

            // Move to the next digit
            i--;

            // Continue the loop as long as there's a carry and there are more digits to process
        } while (carry && i >= 0);

        // After processing all digits, if there's still a carry
        if(carry) {

            // Create a new array with an extra digit
            int[] result = new int[digits.length + 1];

            // Set the first digit to 1
            result[0] = 1;

            // Return the new array
            return result;
        }

        // If there's no carry left, just return the original array
        return digits;
    }
}