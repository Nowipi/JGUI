package nowipi.jgui.windows.ffm;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.ValueLayout;

public class C {
    public static final ValueLayout.OfBoolean BOOL = ValueLayout.JAVA_BOOLEAN;
    public static final ValueLayout.OfByte CHAR = ValueLayout.JAVA_BYTE;
    public static final ValueLayout.OfShort SHORT = ValueLayout.JAVA_SHORT;
    public static final ValueLayout.OfInt INT = ValueLayout.JAVA_INT;
    public static final ValueLayout.OfLong LONG_LONG = ValueLayout.JAVA_LONG;
    public static final ValueLayout.OfFloat FLOAT = ValueLayout.JAVA_FLOAT;
    public static final ValueLayout.OfDouble DOUBLE = ValueLayout.JAVA_DOUBLE;
    public static final AddressLayout POINTER = ValueLayout.ADDRESS;
    public static final ValueLayout.OfInt LONG = ValueLayout.JAVA_INT;
    public static final ValueLayout.OfDouble LONG_DOUBLE = ValueLayout.JAVA_DOUBLE;

    private C() {
    }
}
