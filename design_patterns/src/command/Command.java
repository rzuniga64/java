package command;

// Each command you want to issue will implement the Command interface

interface Command {

    void execute();
    void undo();    // You may want to offer the option to undo a command
}
