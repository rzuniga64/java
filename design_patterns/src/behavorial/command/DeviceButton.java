package behavorial.command;

/**
 * This is known as the Invoker.
 * It has a method press() that when executed causes the execute method to be called.
 * The execute method for the Command interface then calls the method assigned in the class that implements the
 * Command interface
 */
class DeviceButton{

    private Command theCommand;

    /**
     * Instantiates a new Device button.
     *
     * @param newCommand the new behavorial.command
     */
    DeviceButton(Command newCommand){
        theCommand = newCommand;
    }

    /**
     * Method to call different commands in different object.
     */
    void press(){
        theCommand.execute();
    }

    /**
     * Method to allow the remote to undo past commands
     */
    void pressUndo(){
        theCommand.undo();
    }
}
