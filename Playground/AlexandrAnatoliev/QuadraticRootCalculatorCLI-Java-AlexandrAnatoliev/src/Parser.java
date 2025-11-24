public class Parser {
    String input;

    public Parser(String input) {
        this.input = input;
    }

    public boolean isPolynomial() {
        if(getFirstXIndex() == -1) {
            printExample();
            return false;
        }
        if(getSecondXIndex() == -1) {
            printExample();
            return false;
        }
        if(getA() == 0) {
            printExample();
            return false;
        }
        return true;
    }

    private int getFirstXIndex() {
        return input.indexOf('x');
    }

    private int getSecondXIndex() {
        int start = getFirstXIndex() + 1;
        int finish = input.length();
        return start + input.substring(start, finish).indexOf('x');
    }

    private int getExponentOperatorIndex() {
        return input.indexOf('^');
    }

    private void printExample() {
        System.out.println("Examples of use:");
        System.out.println("java QRCalculator \"2x^2 + 3x - 4\"");
        System.out.println("java QRCalculator \"-3x^2-4x+6\"");
    }

    private double getNumber(String text) {
        String number = text.replaceAll("[^0-9.-]","");
        if(number.isEmpty()) {
            return 1;
        }
        return Double.parseDouble(number);
    }

    public double getA() {
        return getNumber(input.substring(0, getFirstXIndex()));
    }

    public double getB() {
        return getNumber(input.substring(
                    getExponentOperatorIndex() + 2, 
                    getSecondXIndex()));
    }

    public double getC() {
        return getNumber(input.substring(
                    getSecondXIndex() + 1,
                    input.length()));
    }
}
