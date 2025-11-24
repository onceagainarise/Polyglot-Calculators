public class QRCalculator  {
    public static void main(String args[]) {
        double a;
        double b;
        double c;
        double d;
        Parser parser;

        if (args.length > 0) {
            String polinomial = args[0];
            parser = new Parser(polinomial);
        } else {
            System.out.println("No arguments");
            return;
        }

        if(parser.isPolynomial()) {
            a = parser.getA();
            b = parser.getB();
            c = parser.getC();
            d = getDiscriminant(a, b, c);

            if(d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (d == 0) {
                double x = -b / (2 * a);
                System.out.println("x = " + x);
            } else {
                System.out.println("No real roots exists");
            }
        }
    }

    public static double getDiscriminant(double a, double b, double c) {
        return b * b  - 4 * a * c;
    }
}

