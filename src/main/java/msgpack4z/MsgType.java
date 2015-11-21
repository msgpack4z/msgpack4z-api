package msgpack4z;

public enum MsgType {
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#formats-nil">nil type</a>
     */
    NIL,
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#bool-format-family">boolean type</a>
     */
    BOOLEAN,
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#int-format-family">integer type</a>
     */
    INTEGER,
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#float-format-family">float type</a>
     */
    FLOAT,
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#str-format-family">string type</a>
     */
    STRING,
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#array-format-family">array type</a>
     */
    ARRAY,
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#map-format-family">map type</a>
     */
    MAP,
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#bin-format-family">binary type</a>
     */
    BINARY,
    /**
     * <a href="https://github.com/msgpack/msgpack/blob/master/spec.md#ext-format-family">extension type</a>
     */
    EXTENSION
}
