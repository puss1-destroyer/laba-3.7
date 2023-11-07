package Math;

import java.util.Arrays;

public class Matrix3x3 {
    private final float[][] matrix;

    public Matrix3x3() {
        matrix = new float[3][3];
    }

    public Matrix3x3(float[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix3x3 addition(Matrix3x3 first, Matrix3x3 second) {
        if (first.matrix.length != second.matrix.length || first.matrix[0].length != second.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = first.matrix[i][j] + second.matrix[i][j];
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 subtraction(Matrix3x3 first, Matrix3x3 second) {
        if (first.matrix.length != second.matrix.length || first.matrix[0].length != second.matrix[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = first.matrix[i][j] - second.matrix[i][j];
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 multiplicationByVector(Matrix3x3 matrix, Matrix3x3 columnVector) {
        if (matrix.matrix[0].length != columnVector.matrix.length) {
            throw new IllegalArgumentException("Matrices cannot be multiplied");
        }
        float[][] result = new float[3][1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix.matrix[i][k] * columnVector.matrix[k][j];
                }
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 matrixMultiply(Matrix3x3 first, Matrix3x3 second) {
        if (first.matrix[0].length != second.matrix.length) {
            throw new IllegalArgumentException("Matrices cannot be multiplied");
        }
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                float sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += first.matrix[i][k] * second.matrix[k][j];
                }
                result[i][j] = sum;
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 transpose(Matrix3x3 matrix) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix.matrix[j][i];
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 identity() {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = (i == j) ? 1 : 0;
            }
        }
        return new Matrix3x3(result);
    }

    public Matrix3x3 zero() {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = 0;
            }
        }
        return new Matrix3x3(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (matrix[0].length == 1) {
            for (int i = 0; i < 3; i++) {
                sb.append(matrix[i][0]).append("\n");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
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
        if (!(obj instanceof Matrix3x3 other)) {
            return false;
        }
        return Arrays.deepEquals(this.matrix, other.matrix);
    }

}
