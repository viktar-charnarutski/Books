package lynda.java.lambda;

/**
 *
 */
public class Book {
    private String title;
    private String authorFName;
    private String authorLName;
    private int pages;

    Book(String title, String authorFName, String authorLName,
         int pages) {
        this.title = title;
        this.authorFName = authorFName;
        this.authorLName = authorLName;
        this.pages = pages;

    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getAuthorFName() {
        return authorFName;
    }

    void setAuthorFName(String authorFName) {
        this.authorFName = authorFName;
    }

    String getAuthorLName() {
        return authorLName;
    }

    void setAuthorLName(String authorLName) {
        this.authorLName = authorLName;
    }

    int getPages() {
        return pages;
    }

    void setPages(int pages) {
        this.pages = pages;
    }

    public String toString() {
        return getTitle() + " Written By: " + getAuthorFName() + " " + getAuthorLName();
    }
}
