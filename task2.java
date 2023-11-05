
import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the variables
        double celsius = 0.0;
        double fahrenheit = 0.0;
        double kelvin = 0.0;

        // Get the temperature scale from the user
        System.out.println("Enter the temperature scale (Celsius, Fahrenheit, or Kelvin):");
        String scale = scanner.next();

        // Get the temperature value from the user
        System.out.println("Enter the temperature value:");
        double temperature = scanner.nextDouble();

        // Convert the temperature to the other two scales
        switch (scale.toLowerCase()) {
            case "celsius":
                celsius = temperature;
                fahrenheit = (temperature * 9 / 5) + 32;
                kelvin = temperature + 273.15;
                break;
            case "fahrenheit":
                celsius = (temperature - 32) * 5 / 9;
                fahrenheit = temperature;
                kelvin = (temperature + 459.67) * 5 / 9;
                break;
            case "kelvin":
                celsius = temperature - 273.15;
                fahrenheit = (temperature * 9 / 5) - 459.67;
                kelvin = temperature;
                break;
            default:
                System.out.println("Invalid temperature scale!");
                return;
        }

        // Print the converted temperatures to the console
        System.out.println(scale.toLowerCase() + ": " + celsius);
        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Kelvin: " + kelvin);

        // Close the Scanner object
        scanner.close();
    }
}

