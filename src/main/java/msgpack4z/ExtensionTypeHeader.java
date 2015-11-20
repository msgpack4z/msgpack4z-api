package msgpack4z;

/**
 * Header of the Extension types
 */
public class ExtensionTypeHeader {

    public final byte type;
    public final int length;

    /**
     * Creates an extension type header
     *
     * @param type
     *            the extension type as a byte
     * @param length
     *            the data length
     */
    public ExtensionTypeHeader(byte type, int length) {
        if (length < 0)
            throw new IllegalArgumentException("length must be >= 0");
        this.type = type;
        this.length = length;
    }

    @Override
    public int hashCode() {
        return (type + 31) * 31 + length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExtensionTypeHeader) {
            ExtensionTypeHeader other = (ExtensionTypeHeader) obj;
            return this.type == other.type && this.length == other.length;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("ExtensionTypeHeader(type: %d, length: %d)", type, length);
    }
}
