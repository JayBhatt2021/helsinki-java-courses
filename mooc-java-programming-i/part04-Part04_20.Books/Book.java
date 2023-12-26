/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
public class Book {
    private String title;
    private int pages;
    private int publicationYear;
    
    public Book(String title, int pages, int publicationYear) {
        this.title = title;
        this.pages = pages;
        this.publicationYear = publicationYear;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    @Override
    public String toString() {
        return this.title + ", " + this.pages + " pages, " + this.publicationYear;
    }
}
