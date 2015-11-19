package msgpack4z;

/**
 * @see <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#ext-format-family">ext format family</a>
 */
public final class ExtTypeHeader {

    private final byte type;
    private final int length;

    public byte getType() {
      return type;
    }

    public int getLength() {
      return length;
    }

    public ExtTypeHeader(byte type, int length) {
        this.type = type;
        this.length = length;
    }

    @Override
    public int hashCode() {
        return (type + 31) * 31 + length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExtTypeHeader) {
            ExtTypeHeader other = (ExtTypeHeader) obj;
            return this.type == other.type && this.length == other.length;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("ExtTypeHeader(%d, %d)", type, length);
    }
}
