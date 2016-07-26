package memento;

/**
 * The type Originator.
 */
class Originator{

    private String article;

    /**
     *  Sets the value for the article.
     *
     *  @param newArticle the new article
     */
    void set(String newArticle) {
        System.out.println("From Originator: Current Version of Article\n"+newArticle+ "\n");
        this.article = newArticle;
    }

    /**
     * Create a new Memento with a new article.
     *
     * @return the memento
     */
    Memento storeInMemento() {
        System.out.println("From Originator: Saving to Memento");
        return new Memento(article);
    }

    /**
     *  Get the article currently stored in memento.
     *
     *  @param memento the memento
     *  @return the string
     */
    String restoreFromMemento(Memento memento) {

        article = memento.getSavedArticle();

        System.out.println("From Originator: Previous Article Saved in Memento\n"+article + "\n");
        return article;
    }
}