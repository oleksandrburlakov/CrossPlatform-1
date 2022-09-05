import java.math.BigDecimal;
import java.math.MathContext;

public class Fraction {
    private long numerator;
    private long denominator;
    private long wholePart;

    public Fraction(long numerator, long denominator) {
        if (numerator / denominator > 0) {
            this.wholePart = numerator / denominator;
            numerator = numerator % denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(long numerator, long denominator, long wholePart) {
        if (numerator / denominator > 0) {
            this.wholePart = numerator / denominator + wholePart;
            numerator = numerator % denominator;
        }
        this.wholePart = wholePart;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public long getNumerator() {
        return  this.numerator;
    }

    public long getDenominator() {
        return  this.denominator;
    }

    public Fraction Add(Fraction fraction) {
        long commonDenominator = fraction.denominator * this.denominator /
                leastCommonMultiple(fraction.denominator, this.denominator);
        long firstMultiplyCoefficient = commonDenominator / this.denominator;
        long secondMultiplyCoefficient = commonDenominator / fraction.denominator;
        long sumOfNumerators = this.numerator * firstMultiplyCoefficient + fraction.numerator * secondMultiplyCoefficient;
        long sumOfWholeParts = this.wholePart + fraction.wholePart;
        long commonMultiplier = this.leastCommonMultiple(sumOfNumerators, commonDenominator);
        return new Fraction(sumOfNumerators / commonMultiplier, commonDenominator / commonMultiplier, sumOfWholeParts);
    }

    public double toDouble() {
        return this.wholePart + (double)(this.numerator) / (double)this.denominator;
    }

    public String toString() {
        if (this.wholePart > 0) {
            return this.wholePart + "(" + this.numerator + "/" + this.denominator + ")";
        }
        return this.numerator + "/" + this.denominator;
    }

    public BigDecimal toBigDecimal() {
        MathContext mc = new MathContext(32);
        BigDecimal bigNumerator = new BigDecimal(this.numerator, mc);
        BigDecimal bigDenominator = new BigDecimal(this.denominator, mc);
        BigDecimal bigWholePart = new BigDecimal(this.wholePart,mc);
        BigDecimal result = bigNumerator
                .divide(bigDenominator, mc)
                .add(bigWholePart, mc);
        return result;
    }

    private long leastCommonMultiple(long numerator, long denominator) {
        long a = numerator;
        long b = denominator;
        while (a != b) {
            if (a > b) {
                a -= b;
            }
            else {
                b -= a;
            }
        }
        return a;
    }
}
