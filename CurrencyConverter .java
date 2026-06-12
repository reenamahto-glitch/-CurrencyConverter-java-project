import java.util.Scanner;

class CurrencyConverter {

    public double convert(String from, String to, double amount) {
        double rate = getExchangeRate(from, to);
        return amount * rate;
    }

    private double getExchangeRate(String from, String to) {

        if (from.equals("USD") && to.equals("INR")) return 83.0;
        if (from.equals("INR") && to.equals("USD")) return 0.012;

        if (from.equals("USD") && to.equals("EUR")) return 0.92;
        if (from.equals("EUR") && to.equals("USD")) return 1.08;

        if (from.equals("USD") && to.equals("JPY")) return 150.0;
        if (from.equals("JPY") && to.equals("USD")) return 0.0067;

        if (from.equals("INR") && to.equals("JPY")) return 1.8;
        if (from.equals("JPY") && to.equals("INR")) return 0.55;

        if (from.equals("EUR") && to.equals("INR")) return 90.0;
        if (from.equals("INR") && to.equals("EUR")) return 0.011;

        if (from.equals(to)) return 1.0;

        return 0;
    }
}

public class project {   

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println(" Global Currency Converter ");

        while (true) {
            System.out.println("\nAvailable Currencies: USD, INR, EUR, JPY");

            System.out.print("Enter FROM currency: ");
            String from = sc.next().toUpperCase();

            System.out.print("Enter TO currency: ");
            String to = sc.next().toUpperCase();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            double result = converter.convert(from, to, amount);

            if (result == 0) {
                System.out.println(" Invalid currency conversion!");
            } else {
                System.out.println(" Converted Amount: " + result + " " + to);
            }

            System.out.print("\nDo you want to convert again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println(" Thank you!");
                break;
            }
        }

        sc.close();
    }
}