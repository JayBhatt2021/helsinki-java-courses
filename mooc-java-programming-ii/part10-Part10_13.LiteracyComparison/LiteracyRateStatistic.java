public class LiteracyRateStatistic {
    private String sex;
    private String nation;
    private int year;
    private double literacyRate;

    public LiteracyRateStatistic(String sex, String nation, int year, double literacyRate) {
        this.sex = sex;
        this.nation = nation;
        this.year = year;
        this.literacyRate = literacyRate;
    }

    public String getSex() {
        return this.sex;
    }

    public String getNation() {
        return this.nation;
    }

    public int getYear() {
        return this.year;
    }

    public double getLiteracyRate() {
        return this.literacyRate;
    }

    @Override
    public String toString() {
        return this.nation + " (" + this.year + "), " + this.sex + ", " + this.literacyRate;
    }
}
