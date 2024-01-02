public class Main {
    public static void main(String[] args) {
        SimpleDate date1 = new SimpleDate(15, 10, 2022);
        SimpleDate date2 = new SimpleDate(20, 12, 2021);
        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);

        if (date1.earlier(date2)) {
            System.out.println("Date 1 is earlier than Date 2.");
        } else {
            System.out.println("Date 2 is earlier than Date 1.");
        }

        int difference = date1.differenceInYears(date2);
        System.out.println("Difference in years: " + difference);

        if (date1.equals(date2)) {
            System.out.println("Date 1 and Date 2 are equal.");
        } else {
            System.out.println("Date 1 and Date 2 are not equal.");
        }
    }
}
