package msgpack4z;

import java.io.IOException;
import java.math.BigInteger;

public interface MsgPacker {

    void packByte(byte a) throws IOException;
    void packShort(short a) throws IOException;
    void packInt(int a) throws IOException;
    void packLong(long a) throws IOException;
    void packDouble(double a) throws IOException;
    void packFloat(float a) throws IOException;
    void packBigInteger(BigInteger a) throws IOException;
    void packArrayHeader(int a) throws IOException;
    void arrayEnd() throws IOException;
    void packMapHeader(int a) throws IOException;
    void mapEnd() throws IOException;
    void packBoolean(boolean a) throws IOException;
    void packNil() throws IOException;
    void packString(String a) throws IOException;
    void packBinary(byte[] a) throws IOException;
    byte[] result() throws IOException;

}
