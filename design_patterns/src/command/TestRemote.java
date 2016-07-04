package command;

import java.util.ArrayList;
import java.util.List;

public class TestRemote {

    public static void main(String[] args){

        // Returns a television
        ElectronicDevice newDevice = TVRemote.getDevice();

        // Defining a command that we want this device to be performing.  We are going to send a device over and have
        // it execute. TurnTVOn executes a command to turn TV on whenever execute is called on this command object.
        // It is going to execute the command on() inside the Television device
        TurnTVOn onCommand = new TurnTVOn(newDevice);

        // Receiver that performs certain actions whenever it is called.
        DeviceButton onPressed = new DeviceButton(onCommand);

        // Press the button on the remote control. It is going to send a generic command over that is going to be
        // onCommand which isn't really generic since it is of type TurnTVOn. It does one thing to a device which call
        // the on() method on them.
        onPressed.press();

        //----------------------------------------------------------
        // Now when execute() is called off() of Television executes
        TurnTVOff offCommand = new TurnTVOff(newDevice);

        // Calling the execute() causes off() to execute in Television
        onPressed = new DeviceButton(offCommand);

        // When press() is called theCommand.execute(); executes
        onPressed.press();

        //----------------------------------------------------------
        // Now when execute() is called volumeUp() of Television executes
        TurnTVUp volUpCommand = new TurnTVUp(newDevice);

        // Calling the execute() causes volumeUp() to execute in Television
        onPressed = new DeviceButton(volUpCommand);

        // When press() is called theCommand.execute(); executes
        onPressed.press();
        onPressed.press();
        onPressed.press();

        //----------------------------------------------------------
        // Creating a TV and Radio to turn off with 1 press
        Television theTV = new Television();
        Radio theRadio = new Radio();

        // Add the Electronic Devices to a List
        List<ElectronicDevice> allDevices = new ArrayList<>();

        allDevices.add(theTV);
        allDevices.add(theRadio);

        // Send the List of Electronic Devices to TurnItAllOff where a call to run execute() on this function will
        // call off() for each device in the list
        TurnItAllOff turnOffDevices = new TurnItAllOff(allDevices);

        // This calls for execute() to run which calls for off() to run for every ElectronicDevice
        DeviceButton turnThemOff = new DeviceButton(turnOffDevices);
        turnThemOff.press();

        //----------------------------------------------------------

		 // It is common to be able to undo a command in a command pattern. To do so, DeviceButton will have a method
         // called undo. Undo() will perform the opposite action that the normal Command performs. undo() needs to be
         // added to every class with an execute()

        turnThemOff.pressUndo();

        // To undo more than one command add them to a LinkedList using addFirst(). Then execute undo on each item until
        // there are none left. (This is your Homework)
    }
}