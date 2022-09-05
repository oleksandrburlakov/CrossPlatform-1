import java.util.Scanner;

public class ScannerHelper implements ScannerHelperInterface {
    private String message;

    ScannerHelper() {
        this.message = "Please write number of interactions:";
    }

    ScannerHelper(String message) {
        this();
        if (message != null) {
            this.message = message;
        }
    }

    @Override
    public int getIterationNumber() {
        Scanner scanner = new Scanner(System.in);
        Integer result = null;
        while(result == null) {
            try {
                System.out.println(message);
                result = scanner.nextInt();
            } catch (Exception ex) {
                scanner.next();
                System.out.println("Sorry, you have written not an integer. Please, try again");
            }
        }
        return result.intValue();
    }
}
