package behavorial.command;

/**
 *  Each behavorial.command you want to issue will implement the Command interface.
 */
interface Command {

    /**
     * execute.
     */
    void execute();

    /**
     * undo. You may want to offer the option to undo a behavorial.command
     */
    void undo();
}
