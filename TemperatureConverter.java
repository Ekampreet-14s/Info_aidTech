import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTemperature Conversion Utility");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. Fahrenheit to Kelvin");
            System.out.println("6. Kelvin to Fahrenheit");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Enter temperature value: ");
            double temperature = scanner.nextDouble();

            double convertedTemperature;

            switch (choice) {
                case 1:
                    convertedTemperature = celsiusToFahrenheit(temperature);
                    System.out.println("Result: " + convertedTemperature + " °F");
                    break;
                case 2:
                    convertedTemperature = fahrenheitToCelsius(temperature);
                    System.out.println("Result: " + convertedTemperature + " °C");
                    break;
                case 3:
                    convertedTemperature = celsiusToKelvin(temperature);
                    System.out.println("Result: " + convertedTemperature + " K");
                    break;
                case 4:
                    convertedTemperature = kelvinToCelsius(temperature);
                    System.out.println("Result: " + convertedTemperature + " °C");
                    break;
                case 5:
                    convertedTemperature = fahrenheitToKelvin(temperature);
                    System.out.println("Result: " + convertedTemperature + " K");
                    break;
                case 6:
                    convertedTemperature = kelvinToFahrenheit(temperature);
                    System.out.println("Result: " + convertedTemperature + " °F");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        double celsius = fahrenheitToCelsius(fahrenheit);
        return celsiusToKelvin(celsius);
    }

    public static double kelvinToFahrenheit(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        return celsiusToFahrenheit(celsius);
    }
}
