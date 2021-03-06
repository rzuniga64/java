package structural.proxy;

/**
 *  This interface will contain just those methods that you want the structural.proxy to provide access to.
 */
interface GetATMData
{
    ATMState getATMData();
    int getCashInMachine();
}