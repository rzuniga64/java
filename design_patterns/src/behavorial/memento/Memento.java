package behavorial.memento;

/**
 *  The type Memento.
 *
 *  Used stores an objects behavorial.state at a point in timebso it can be returned to that behavorial.state later.
 *  It simply allows you to undo/redo changes on an Object
 */
class Memento {

    // The article stored in behavorial.memento Object
    private String article;

    /**
     * Instantiates a new Memento. Save a new article String to the behavorial.memento Object
     *
     * @param articleSave the article save
     */
    Memento(String articleSave) { article = articleSave; }

    /**
     * Gets saved article.
     *
     * @return the saved article
     */
    String getSavedArticle() { return article; }
}