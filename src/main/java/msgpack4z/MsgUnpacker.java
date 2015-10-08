package msgpack4z;

import java.io.IOException;
import java.math.BigInteger;

public interface MsgUnpacker {

    MsgType nextType() throws IOException;
    byte unpackByte() throws IOException;
    short unpackShort() throws IOException;
    int unpackInt() throws IOException;
    long unpackLong() throws IOException;
    BigInteger unpackBigInteger() throws IOException;
    double unpackDouble() throws IOException;
    float unpackFloat() throws IOException;
    int unpackArrayHeader() throws IOException;
    void arrayEnd() throws IOException;
    void mapEnd() throws IOException;
    int unpackMapHeader() throws IOException;
    boolean unpackBoolean() throws IOException;
    void unpackNil() throws IOException;
    String unpackString() throws IOException;
    byte[] unpackBinary() throws IOException;
    ExtensionTypeHeader unpackExtensionType() throws IOException;
    void readPayload(byte[] destination) throws IOException;
    void close() throws IOException;

}
