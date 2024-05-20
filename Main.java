//Agora, imagine que temos uma lista de frações: [1/3, 2/5, 3/8, 4/7]

import java.util.ArrayList;
import java.util.List;

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction findMaxFraction(List<Fraction> fractions) {
        Fraction maxFraction = fractions.get(0);
        for (Fraction fraction : fractions) {
            if (fraction.numerator * maxFraction.denominator > maxFraction.numerator * fraction.denominator) {
                maxFraction = fraction;
            }
        }
        return maxFraction;
    }
}

public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(3, 4);
        Fraction fraction2 = new Fraction(1, 2);

        Fraction sum = fraction1.add(fraction2);
        System.out.println("Soma das frações: " + sum);

        List<Fraction> fractionList = new ArrayList<>();
        fractionList.add(new Fraction(1, 3));
        fractionList.add(new Fraction(2, 5));
        fractionList.add(new Fraction(3, 8));
        fractionList.add(new Fraction(4, 7));

        Fraction maxFraction = Fraction.findMaxFraction(fractionList);
        System.out.println("Fração com maior valor: " + maxFraction);
    }
}