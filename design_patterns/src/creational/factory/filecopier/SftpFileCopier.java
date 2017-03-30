package creational.factory.filecopier;

/**
 * SftpFileCopier class.
 */
public class SftpFileCopier implements FileCopier {

    /** copy method. */
    public void copy() {

        System.out.println("Copy using Sftp");
    }
}
