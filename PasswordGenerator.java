import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired password length: ");
        int passwordLength = scanner.nextInt();

        System.out.print(
                "Enter the character set (1 for letters, 2 for letters + numbers, 3 for letters + numbers + special characters): ");
        int characterSetChoice = scanner.nextInt();

        String characterSet = "";

        switch (characterSetChoice) {
            case 1:
                characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                break;
            case 2:
                characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                break;
            case 3:
                characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
                break;
            default:
                System.out.println(
                        "Invalid character set choice. Using default (letters + numbers + special characters).");
                characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
                break;
        }

        String password = generatePassword(passwordLength, characterSet);
        System.out.println("Generated password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, String characterSet) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(randomIndex));
        }

        return password.toString();
    }

    @Override
    public String toString() {
        return "PasswordGenerator []";
    }
}
