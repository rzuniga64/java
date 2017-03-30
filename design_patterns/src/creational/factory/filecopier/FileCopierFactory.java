package creational.factory.filecopier;

/**
 * FileCopierFactory class.
 */
public final class FileCopierFactory {

    /** Constructor. */
    public FileCopierFactory() { }

    /**
     * getFactoryCopier method.
     * @param protocol protocol
     * @return FileCopier
     */
    public FileCopier getFactoryCopier(final String protocol) {

        if ("scp".equals(protocol)) {
            return new ScpFileCopier();
        } else if ("sftp".equals(protocol)) {
            return new SftpFileCopier();
        } else {
            return new SrmLiteFileCopier();
        }
    }
}
