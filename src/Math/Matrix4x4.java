package Math;

import java.util.Arrays;

public class Matrix4x4 {
    private final float[][] matrix;

    public Matrix4x4() {
        matrix = new float[4][4];
    }

    public Matrix4x4(float[][] matrix) {
        this.matrix = matrix;
    }
    public Matrix4x4 addition(Matrix4x4 first, Matrix4x4 second) {
        if (first.matrix.length != second.matrix.length || first.matrix[0].length != second.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = first.matrix[i][j] + second.matrix[i][j];
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 subtraction(Matrix4x4 first, Matrix4x4 second) {
        if (first.matrix.length != second.matrix.length || first.matrix[0].length != second.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = first.matrix[i][j] - second.matrix[i][j];
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 multiplicationByVector(Matrix4x4 matrix, Matrix4x4 columnVector) {
        if (matrix.matrix[0].length != columnVector.matrix.length) {
            throw new IllegalArgumentException("Matrices cannot be multiplied");
        }
        float[][] result = new float[4][1];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    result[i][j] += matrix.matrix[i][k] * columnVector.matrix[k][j];
                }
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 matrixMultiply(Matrix4x4 first, Matrix4x4 second) {
        if (first.matrix[0].length != second.matrix.length) {
            throw new IllegalArgumentException("Matrices cannot be multiplied");
        }
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                float sum = 0;
                for (int k = 0; k < 4; k++) {
                    sum += first.matrix[i][k] * second.matrix[k][j];
                }
                result[i][j] = sum;
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 transpose(Matrix4x4 matrix) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = matrix.matrix[j][i];
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 identity() {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = (i == j) ? 1 : 0;
            }
        }
        return new Matrix4x4(result);
    }

    public Matrix4x4 zero() {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = 0;
            }
        }
        return new Matrix4x4(result);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (matrix[0].length == 1) {
            for (int i = 0; i < 4; i++) {
                sb.append(matrix[i][0]).append("\n");
            }
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    sb.append(matrix[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Matrix4x4 other)) {
            return false;
        }
        return Arrays.deepEquals(this.matrix, other.matrix);
    }
}
