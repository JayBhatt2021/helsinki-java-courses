public class Book {
    private String name;
    private int publishingYear;
    private int pageCount;
    private String author;

    public Book(String name, int ReleaseYear, int pages, String author) {
        this.name = name;
        this.publishingYear = ReleaseYear;
        this.pageCount = pages;
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public int getPublishingYear() {
        return this.publishingYear;
    }

    public int getPagecount() {
        return this.pageCount;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "'" + this.name + "' by " + this.author + " was published in " + this.publishingYear + " and has " +
                this.pageCount + " pages.";
    }
}
