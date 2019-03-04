public class ComplexNumber {
    private double a;
    private double b;

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        if (this.b >= 0) {
            String number = this.a + " + " + this.b + "i";
            return number;
        }
        else {
            String number = this.a + " " + this.b + "i";
            return number;
        }
    }

    public ComplexNumber add(ComplexNumber other) {
        double newreal = this.a + other.a;
        double newcomplex = this.b + other.b;
        return new ComplexNumber(newreal, newcomplex);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double newreal = this.a - other.a;
        double newcomplex = this.b - other.b;
        return new ComplexNumber(newreal, newcomplex);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double firsts = this.a*other.a;  //real
        double lasts = this.b*other.b;  //real negative
        double inners = this.b*other.a;  //complex
        double outers = this.a*other.b;  //complex
        double newreal = firsts - lasts;
        double newcomplex = inners + outers;
        return new ComplexNumber(newreal, newcomplex);
    }

    public ComplexNumber conjugate() {
        double newreal = this.a;
        double newcomplex = this.b*-1;
        return new ComplexNumber(newreal, newcomplex);
    }

    public ComplexNumber divide(ComplexNumber other) {
        ComplexNumber conjugate = other.conjugate();
        ComplexNumber numerator = this.multiply(conjugate);
        double denominator = other.a*other.a + other.b*other.b;
        double newreal = numerator.a/denominator;
        double newcomplex = numerator.b/denominator;
        return new ComplexNumber(newreal, newcomplex);
    }

}
