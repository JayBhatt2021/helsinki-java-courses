public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public boolean equals(Object compared) {
        // if the variables are located in the same place, they are the same
        if (this == compared) {
            return true;
        }

        // if compared is not instance of SimpleDate, the objects are not the same
        if (!(compared instanceof SimpleDate)) {
            return false;
        }

        // let's cast compared to SimpleDate
        SimpleDate otherDate = (SimpleDate) compared;

        // if the values are the same, the objects are the same
        if (this.day == otherDate.day && this.month == otherDate.month
                && this.year == otherDate.year) {
            return true;
        }

        // otherwise, the objects are not the same
        return false;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
}
