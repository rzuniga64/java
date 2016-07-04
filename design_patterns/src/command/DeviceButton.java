package command;

/**
 *  This is known as the invoker
 *  It has a method press() that when executed causes the execute method to be called.
 *  The execute method for the Command interface then calls the method assigned in the class that implements the
 *  Command interface
 */

class DeviceButton{

    private Command theCommand;

    DeviceButton(Command newCommand){
        theCommand = newCommand;
    }

    void press(){
        theCommand.execute();
    }
    void pressUndo(){
        theCommand.undo();
    }   // Now the remote can undo past commands
}
