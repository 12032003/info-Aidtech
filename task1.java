import java.security.SecureRandom;
import java.util.Scanner;

public class task1 {

    public static String generatePassword(int length, String characterSet) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the desired length of the password:");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the character set to be used:");
        String characterSet = scanner.next();

        String password = generatePassword(length, characterSet);

        System.out.println("Your generated password is: " + password);

        scanner.close(); // Add this line to close the Scanner object
    }
}
