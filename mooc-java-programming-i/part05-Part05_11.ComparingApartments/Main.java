public class Main {
    public static void main(String[] args) {
        // you can write code here to try out your program
        Apartment manhattanStudioApt = new Apartment(1, 16, 5500);
        Apartment atlantaTwoBedroomApt = new Apartment(2, 38, 4200);

        System.out.println(manhattanStudioApt.largerThan(atlantaTwoBedroomApt));
        System.out.println(manhattanStudioApt.priceDifference(atlantaTwoBedroomApt));
        System.out.println(manhattanStudioApt.moreExpensiveThan(atlantaTwoBedroomApt));
    }
}
