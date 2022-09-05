public class Main {
    public static void main(String[] args) {
        ScannerHelper scanner = new ScannerHelper();
        final int n = scanner.getIterationNumber();
        CalculateHelper helper = new CalculateHelper();
        Fraction fraction = new Fraction(1,1);
        for(int i = 1; i <= n; ++i) {
            int numerator = helper.getNumerator(i);
            int denominator = helper.getDenominator(i);
            Fraction tempFraction = new Fraction(numerator, denominator);
            fraction = tempFraction.Add(fraction);
            if (i > 15) {
                System.out.println(fraction.toString() + " = " + fraction.toBigDecimal().toString());
            } else {
                System.out.println(fraction.toString() + " = " + fraction.toDouble());
            }
        }
    }
}