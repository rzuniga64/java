package creational.factory.filecopier;

/**
 * FileCopierFactory class.
 */
final class FileCopierFactory {

    /** Constructor. */
    FileCopierFactory() { }

    /**
     * getFactoryCopier method.
     * @param protocol protocol
     * @return FileCopier
     */
    FileCopier getFactoryCopier(final String protocol) {

        if ("scp".equals(protocol)) {
            return new ScpFileCopier();
        } else if ("sftp".equals(protocol)) {
            return new SftpFileCopier();
        } else {
            return new SrmLiteFileCopier();
        }
    }
}
