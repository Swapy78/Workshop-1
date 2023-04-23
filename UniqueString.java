package demo;

import java.util.Scanner;

public class UniqueString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        // Convert the input string to a character array
        char[] str = input.toCharArray();
        int strlength = str.length;
        
        // Initialize variables to keep track of the longest unique substring found so far
        int maxLength = 0;
        int start = 0;
        
        // Loop through all substrings of the input string
        for (int i = 0; i < strlength; i++) {
            // Use a boolean array to keep track of which characters have been visited
            boolean[] visited = new boolean[256];
            for (int j = i; j < strlength; j++) {
                // If we encounter a character that has already been visited, the current substring is not unique
                if (visited[str[j]]) {
                    break;
                }
                visited[str[j]] = true;
                // Calculate the length of the current substring and update maxLength and start if necessary
                int length = j - i + 1;
                if (length > maxLength) {
                    maxLength = length;
                    start = i;
                }
            }
        }
        
        // Print the longest unique substring found
        System.out.println("Longest unique substring: " + input.substring(start, start + maxLength));
        
        sc.close();
    }
}
