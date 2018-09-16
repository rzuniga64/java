package behavorial.memento;

/**
 *  The type Memento.
 *  Used stores an objects state at a point in time so it can be returned to that state later.
 *  It simply allows you to undo/redo changes on an Object
 */
class Memento {

    // The article stored in Memento Object
    private String article;

    /**
     *  Instantiates a new Memento. Save a new article String to the Memento Object.
     *  @param newArticle the article save
     */
    Memento(String newArticle) {

        article = newArticle;
    }

    /**
     *  Gets saved article.
     *  @return the saved article
     */
    String getSavedArticle() {

        return article;
    }
}