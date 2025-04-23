package testing;

final class Matrix4f {

    public float
            m00, m01, m02, m03,
            m10, m11, m12, m13,
            m20, m21, m22, m23,
            m30, m31, m32, m33;

    public Matrix4f(float m00, float m01, float m02, float m03,
                    float m10, float m11, float m12, float m13,
                    float m20, float m21, float m22, float m23,
                    float m30, float m31, float m32, float m33) {
        this.m00 = m00;this.m01 = m01;this.m02 = m02;this.m03 = m03;
        this.m10 = m10;this.m11 = m11;this.m12 = m12;this.m13 = m13;
        this.m20 = m20;this.m21 = m21;this.m22 = m22;this.m23 = m23;
        this.m30 = m30;this.m31 = m31;this.m32 = m32;this.m33 = m33;
    }

    public static Matrix4f identity() {
        return new Matrix4f(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public static Matrix4f ortho(float left, float right, float top, float bottom, float near, float far) {
        return new Matrix4f(
                2f / (right - left), 0 , 0, - ((right + left) / (right - left)),
                0, 2f / (top - bottom), 0, - ((top + bottom) / (top - bottom)),
                0, 0, - 2f / (far - near), - ((far + near) / (far - near)),
                0, 0, 0, 1
        );
    }

    public static Matrix4f translate(Matrix4f mat, float x, float y, float z) {
        Matrix4f translation = new Matrix4f(
                1, 0, 0, x,
                0, 1, 0, y,
                0, 0, 1, z,
                0, 0, 0, 1
        );

        return multiply(mat, translation);
    }

    public static Matrix4f rotate(Matrix4f mat, float radians, Axis axis) {
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);

        Matrix4f rotation;
        switch (axis) {
            case X -> rotation = new Matrix4f(
                    1, 0,   0,    0,
                    0, cos, -sin, 0,
                    0, sin, cos,  0,
                    0, 0,   0,    1
            );
            case Y -> rotation = new Matrix4f(
                    cos,  0, sin, 0,
                    0,    1, 0,   0,
                    -sin, 0, cos, 0,
                    0,    0, 0,   1
            );
            case Z -> rotation = new Matrix4f(
                    cos, -sin, 0, 0,
                    sin, cos,  0, 0,
                    0,   0,    1, 0,
                    0,   0,    0, 1
            );
            default -> throw new IllegalArgumentException("Unknown axis: " + axis);
        }

        return multiply(mat, rotation);
    }

    public static Matrix4f scale(Matrix4f mat, float x, float y, float z) {
        Matrix4f scale = new Matrix4f(
                x, 0, 0, 0,
                0, y, 0, 0,
                0, 0, z, 0,
                0, 0, 0, 1
        );

        return multiply(mat, scale);
    }

    public static Matrix4f multiply(Matrix4f a, Matrix4f b) {
        float[] result = new float[16];
        float[] m = new float[] {
                a.m00, a.m01, a.m02, a.m03,
                a.m10, a.m11, a.m12, a.m13,
                a.m20, a.m21, a.m22, a.m23,
                a.m30, a.m31, a.m32, a.m33
        };
        float[] n = new float[] {
                b.m00, b.m01, b.m02, b.m03,
                b.m10, b.m11, b.m12, b.m13,
                b.m20, b.m21, b.m22, b.m23,
                b.m30, b.m31, b.m32, b.m33
        };

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                result[row * 4 + col] =
                        m[row * 4]     * n[col] +
                                m[row * 4 + 1] * n[4 + col] +
                                m[row * 4 + 2] * n[8 + col] +
                                m[row * 4 + 3] * n[12 + col];
            }
        }

        return new Matrix4f(
                result[0], result[1], result[2], result[3],
                result[4], result[5], result[6], result[7],
                result[8], result[9], result[10], result[11],
                result[12], result[13], result[14], result[15]
        );
    }

    public float[] toArray() {
        return new float[] {
                m00, m10, m20, m30,
                m01, m11, m21, m31,
                m02, m12, m22, m32,
                m03, m13, m23, m33
        };
    }
}
