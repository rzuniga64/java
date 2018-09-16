package behavorial.memento;

/**
 * The type Originator.
 */
class Originator{

    private String article;

    /**
     *  Sets the value for the article.
     *  @param newArticle the new article
     */
    void set(String newArticle) {

        System.out.println("From Originator: Current Version of Article\n" + newArticle + "\n");
        this.article = newArticle;
    }

    /**
     *  Create a new Memento with a new article.
     *  @return the behavorial.memento
     */
    Memento storeInMemento() {

        System.out.println("From Originator: Saving to Memento");
        return new Memento(this.article);
    }

    /**
     *  Get the article currently stored in behavorial.memento.
     *  @param memento the behavorial.memento
     *  @return the string
     */
    String restoreFromMemento(Memento memento) {

        this.article = memento.getSavedArticle();

        System.out.println("From Originator: Previous Article Saved in Memento\n" + this.article + "\n");
        return this.article;
    }
}