package creational.factory.filecopier;

/**
 *  Use a factory design pattern to implement a client program that can call FileCopy regardless of which copier is
 *  used. For example, RTFDocument and PlainTextDocument use different formats to copy a document.
 */
public final class TestFileCopier {

    /** Constructor. */
    private TestFileCopier() { }

    /**
     * Unit tests.
     * @param args args
     */
    public static void main(final String[] args) {

        FileCopierFactory factory = new FileCopierFactory();
        FileCopier fc1 = factory.getFactoryCopier("scp");
        fc1.copy();
        FileCopier fc2 = factory.getFactoryCopier("sftp");
        fc2.copy();
        FileCopier fc3 = factory.getFactoryCopier("srmLite");
        fc3.copy();
    }
}
