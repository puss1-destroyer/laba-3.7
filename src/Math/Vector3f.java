package Math;

public class Vector3f {
    private static final float eps = 1e-7f;
    private float x, y, z;

    public Vector3f() {

    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f addition(Vector3f first, Vector3f second) {
        float x = first.x + second.x;
        float y = first.y + second.y;
        float z = first.z + second.z;
        return new Vector3f(x, y, z);
    }

    public Vector3f subtraction(Vector3f first, Vector3f second) {
        float x = first.x - second.x;
        float y = first.y - second.y;
        float z = first.z - second.z;
        return new Vector3f(x, y, z);
    }

    public Vector3f multiplicationByScalar(Vector3f vector, float scalar) {
        float x = vector.x * scalar;
        float y = vector.y * scalar;
        float z = vector.z * scalar;
        return new Vector3f(x, y, z);
    }

    public Vector3f divisionByScalar(Vector3f vector, float scalar) {
        if (Math.abs(scalar) <= eps) {
            throw new ArithmeticException("Division by zero");
        }
        float x = vector.x / scalar;
        float y = vector.y / scalar;
        float z = vector.z / scalar;
        return new Vector3f(x, y, z);
    }

    public float vectorLength(Vector3f vector) {
        return (float) Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2) + Math.pow(vector.z, 2));
    }

    public Vector3f normalize(Vector3f vector) {
        float length = vectorLength(vector);
        if (Math.abs(length) <= eps) {
            throw new ArithmeticException("Division by zero");
        }
        float invLength = 1 / length;
        float x = vector.x * invLength;
        float y = vector.y * invLength;
        float z = vector.z * invLength;
        return new Vector3f(x, y, z);
    }

    public float scalarProduct(Vector3f first, Vector3f second) {
        return (first.x * second.x) + (first.y * second.y) + (first.z * second.z);
    }

    public Vector3f vectorProduct(Vector3f first, Vector3f second) {
        //i        j        k
        //f.x      f.y      f.z
        //s.x      s.y      s.z
        float i = 1, j = 1, k = 1;
        float x = (first.y * second.z - second.y * first.z) * i;
        float y = -((first.x * second.z) - (second.x * first.z)) * j;
        float z = (first.x * second.y - second.x * first.y) * k;
        return new Vector3f(x, y, z);
    }

    public String toString() {
        return "Vector (" + x + " , " + y + " , " + z + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vector3f other)) {
            return false;
        }
        return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps && Math.abs(z - other.z) < eps;
    }
}

