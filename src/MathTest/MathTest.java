package MathTest;

import Math.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathTest {
    private Vector2f vec2f1;
    private Vector2f vec2f2;
    private Vector2f result2f;
    private float scalar2f;
    private Vector3f vec3f1;
    private Vector3f vec3f2;
    private Vector3f result3f;
    private float scalar3f;
    private Vector4f vec4f1;
    private Vector4f vec4f2;
    private Vector4f result4f;
    private float scalar4f;
    private Matrix3x3 matrix3x3First;
    private Matrix3x3 matrix3x3Second;
    private Matrix3x3 columnVector3x1;
    private Matrix3x3 matrix3x3Result;
    private final float[][] firstDataFor3x3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private final float[][] secondDataFor3x3 = {{7, 0, -2}, {-4, 1, 6}, {0, -1, 5}};
    private final float[][] dataForColumnVector3x1 = {{7}, {-4}, {0}};
    private Matrix4x4 matrix4x4First;
    private Matrix4x4 matrix4x4Second;
    private Matrix4x4 columnVector4x1;
    private Matrix4x4 matrix4x4Result;
    private final float[][] firstDataFor4x4 = {{1, 2, 3, 4}, {4, 5, 6, 7}, {2, 4, 6, 8}, {1, 3, 5, 7}};
    private final float[][] secondDataFor4x4 = {{2, -1, 0, -4}, {3, 0, -4, -4}, {0, -4, 2, -9}, {3, -4, 0, 1}};
    private final float[][] dataForColumnVector4x1 = {{1}, {2}, {3}, {4}};

    @BeforeEach
    void setUp() {
        vec2f1 = new Vector2f(1f, 2f);
        vec2f2 = new Vector2f(3f, 4f);
        result2f = new Vector2f();
        scalar2f = 10f;
        vec3f1 = new Vector3f(1f, 2f, 3f);
        vec3f2 = new Vector3f(4f, 5f, 6f);
        result3f = new Vector3f();
        scalar3f = 5f;
        vec4f1 = new Vector4f(1, 2, 3, 4);
        vec4f2 = new Vector4f(5, 6, 7, 8);
        result4f = new Vector4f();
        scalar4f = 15f;
        matrix3x3First = new Matrix3x3(firstDataFor3x3);
        matrix3x3Second = new Matrix3x3(secondDataFor3x3);
        columnVector3x1 = new Matrix3x3(dataForColumnVector3x1);
        matrix3x3Result = new Matrix3x3();
        matrix4x4First = new Matrix4x4(firstDataFor4x4);
        matrix4x4Second = new Matrix4x4(secondDataFor4x4);
        columnVector4x1 = new Matrix4x4(dataForColumnVector4x1);
        matrix4x4Result = new Matrix4x4();
    }

    @Test
    public void testAddVec2f() {
        Vector2f expected = new Vector2f(4f, 6f);
        Assertions.assertEquals(expected, result2f.addition(vec2f1, vec2f2));
    }

    @Test
    public void testSubVec2f() {
        Vector2f expected = new Vector2f(-2f, -2f);
        Assertions.assertEquals(expected, result2f.subtraction(vec2f1, vec2f2));
    }

    @Test
    public void test1MultiByScalarVec2f() {
        Vector2f expected = new Vector2f(10f, 20f);
        Assertions.assertEquals(expected, result2f.multiplicationByScalar(vec2f1, scalar2f));
    }

    @Test
    public void test2MultiByScalarVec2f() {
        Vector2f expected = new Vector2f(30f, 40f);
        Assertions.assertEquals(expected, result2f.multiplicationByScalar(vec2f2, scalar2f));
    }

    @Test
    public void test1DivByScalarVec2f() {
        Vector2f expected = new Vector2f(0.1f, 0.2f);
        Assertions.assertEquals(expected, result2f.divisionByScalar(vec2f1, scalar2f));
    }

    @Test
    public void test2DivByScalarVec2f() {
        Vector2f expected = new Vector2f(0.3f, 0.4f);
        Assertions.assertEquals(expected, result2f.divisionByScalar(vec2f2, scalar2f));
    }

    @Test
    public void test1LenVec2f() {
        float expected = 2.236068f;
        Assertions.assertEquals(expected, result2f.vectorLength(vec2f1));
    }

    @Test
    public void test2LenVec2f() {
        float expected = 5.0f;
        Assertions.assertEquals(expected, result2f.vectorLength(vec2f2));
    }

    @Test
    public void test1NormVec2f() {
        Vector2f expected = new Vector2f(0.4472136f, 0.8944272f);
        Assertions.assertEquals(expected, result2f.normalize(vec2f1));
    }

    @Test
    public void test2NormVec2f() {
        Vector2f expected = new Vector2f(0.6f, 0.8f);
        Assertions.assertEquals(expected, result2f.normalize(vec2f2));
    }

    @Test
    public void testScalarProdVec2f() {
        float expected = 11.0f;
        Assertions.assertEquals(expected, result2f.scalarProduct(vec2f1, vec2f2));
    }

    @Test
    public void testAddVec3f() {
        Vector3f expected = new Vector3f(5f, 7f, 9f);
        Assertions.assertEquals(expected, result3f.addition(vec3f1, vec3f2));
    }

    @Test
    public void testSubVec3f() {
        Vector3f expected = new Vector3f(-3f, -3f, -3f);
        Assertions.assertEquals(expected, result3f.subtraction(vec3f1, vec3f2));
    }

    @Test
    public void test1MultiByScalarVec3f() {
        Vector3f expected = new Vector3f(5f, 10f, 15f);
        Assertions.assertEquals(expected, result3f.multiplicationByScalar(vec3f1, scalar3f));
    }

    @Test
    public void test2MultiByScalarVec3f() {
        Vector3f expected = new Vector3f(20f, 25f, 30f);
        Assertions.assertEquals(expected, result3f.multiplicationByScalar(vec3f2, scalar3f));
    }

    @Test
    public void test1DivByScalarVec3f() {
        Vector3f expected = new Vector3f(0.2f, 0.4f, 0.6f);
        Assertions.assertEquals(expected, result3f.divisionByScalar(vec3f1, scalar3f));
    }

    @Test
    public void test2DivByScalarVec3f() {
        Vector3f expected = new Vector3f(0.8f, 1.0f, 1.2f);
        Assertions.assertEquals(expected, result3f.divisionByScalar(vec3f2, scalar3f));
    }

    @Test
    public void test1LenVec3f() {
        float expected = 3.74165739f;
        Assertions.assertEquals(expected, result3f.vectorLength(vec3f1));
    }

    @Test
    public void test2LenVec3f() {
        float expected = 8.774964f;
        Assertions.assertEquals(expected, result3f.vectorLength(vec3f2));
    }

    @Test
    public void test1NormVec3f() {
        Vector3f expected = new Vector3f(0.26726124f, 0.5345225f, 0.8017837f);
        Assertions.assertEquals(expected, result3f.normalize(vec3f1));
    }

    @Test
    public void test2NormVec3f() {
        Vector3f expected = new Vector3f(0.45584232f, 0.5698029f, 0.6837635f);
        Assertions.assertEquals(expected, result3f.normalize(vec3f2));
    }

    @Test
    public void testScalarProdVec3f() {
        float expected = 32f;
        Assertions.assertEquals(expected, result3f.scalarProduct(vec3f1, vec3f2));
    }

    @Test
    public void test1ProdVec3f() {
        Vector3f expected = new Vector3f(-3, 6, -3);
        Assertions.assertEquals(expected, result3f.vectorProduct(vec3f1, vec3f2));
    }

    @Test
    public void test2ProdVec3f() {
        Vector3f expected = new Vector3f(3, -6, 3);
        Assertions.assertEquals(expected, result3f.vectorProduct(vec3f2, vec3f1));
    }
    @Test
    public void test3ProdVec3f() {
        //[axb]=-[bxa]
        Vector3f expected = new Vector3f(-3, 6, -3);//[axb]
        Assertions.assertEquals(expected.multiplicationByScalar(expected,-1), result3f.vectorProduct(vec3f2, vec3f1));
    }
    @Test
    public void test4ProdVec3f() {
        Vector3f expected = new Vector3f(0, 0, 0);
        Assertions.assertEquals(expected, result3f.vectorProduct(vec3f1, vec3f1));
    }
    @Test
    public void test5ProdVec3f() {
        Vector3f expected = new Vector3f(0, 0, 0);
        Assertions.assertEquals(expected, result3f.vectorProduct(vec3f2, vec3f2));
    }

    @Test
    public void testAddVec4f() {
        Vector4f expected = new Vector4f(6f, 8f, 10f, 12f);
        Assertions.assertEquals(expected, result4f.addition(vec4f1, vec4f2));
    }

    @Test
    public void testSubVec4f() {
        Vector4f expected = new Vector4f(-4f, -4f, -4f, -4f);
        Assertions.assertEquals(expected, result4f.subtraction(vec4f1, vec4f2));
    }

    @Test
    public void test1MultiByScalarVec4f() {
        Vector4f expected = new Vector4f(15f, 30f, 45f, 60f);
        Assertions.assertEquals(expected, result4f.multiplicationByScalar(vec4f1, scalar4f));
    }

    @Test
    public void test2MultiByScalarVec4f() {
        Vector4f expected = new Vector4f(75f, 90f, 105f, 120f);
        Assertions.assertEquals(expected, result4f.multiplicationByScalar(vec4f2, scalar4f));
    }

    @Test
    public void test1DivByScalarVec4f() {
        Vector4f expected = new Vector4f(0.06666667f, 0.13333334f, 0.2f, 0.26666668f);
        Assertions.assertEquals(expected, result4f.divisionByScalar(vec4f1, scalar4f));
    }

    @Test
    public void test2DivByScalarVec4f() {
        Vector4f expected = new Vector4f(0.33333334f, 0.4f, 0.46666667f, 0.53333336f);
        Assertions.assertEquals(expected, result4f.divisionByScalar(vec4f2, scalar4f));
    }

    @Test
    public void test1lenVec4f() {
        float expected = 5.47722558f;
        Assertions.assertEquals(expected, result4f.vectorLength(vec4f1));
    }

    @Test
    public void test2lenVec4f() {
        float expected = 13.190906f;
        Assertions.assertEquals(expected, result4f.vectorLength(vec4f2));
    }

    @Test
    public void test1NormVec4f() {
        Vector4f expected = new Vector4f(0.18257418f, 0.36514837f, 0.5477226f, 0.73029673f);
        Assertions.assertEquals(expected, result4f.normalize(vec4f1));
    }

    @Test
    public void test2NormVec4f() {
        Vector4f expected = new Vector4f(0.37904903f, 0.45485884f, 0.5306686f, 0.60647845f);
        Assertions.assertEquals(expected, result4f.normalize(vec4f2));
    }

    @Test
    public void testScalarProdVec4f() {
        float expected = 70f;
        Assertions.assertEquals(expected, result4f.scalarProduct(vec4f1, vec4f2));
    }

    @Test
    public void testAddMatrix3x3() {
        float[][] content = {{8, 2, 1}, {0, 6, 12}, {7, 7, 14}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.addition(matrix3x3First, matrix3x3Second));
    }

    @Test
    public void test1SubMatrix3x3() {
        float[][] content = {{-6, 2, 5}, {8, 4, 0}, {7, 9, 4}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.subtraction(matrix3x3First, matrix3x3Second));
    }

    @Test
    public void test2SubMatrix3x3() {
        float[][] content = {{6, -2, -5}, {-8, -4, 0}, {-7, -9, -4}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.subtraction(matrix3x3Second, matrix3x3First));
    }

    @Test
    public void test1MultiByVecMatrix3x3() {
        float[][] content = {{-1}, {8}, {17}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.multiplicationByVector(matrix3x3First, columnVector3x1));
    }

    @Test
    public void test2MultiByVecMatrix3x3() {
        float[][] content = {{49}, {-32}, {4}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.multiplicationByVector(matrix3x3Second, columnVector3x1));
    }

    @Test
    public void test1MultiMatrix3x3() {
        float[][] content = {{-1, -1, 25}, {8, -1, 52}, {17, -1, 79}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.matrixMultiply(matrix3x3First, matrix3x3Second));
    }

    @Test
    public void test2MultiMatrix3x3() {
        float[][] content = {{-7, -2, 3}, {42, 45, 48}, {31, 35, 39}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.matrixMultiply(matrix3x3Second, matrix3x3First));
    }

    @Test
    public void test1TransMatrix3x3() {
        float[][] content = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.transpose(matrix3x3First));
    }

    @Test
    public void test2TransMatrix3x3() {
        float[][] content = {{7, -4, 0}, {0, 1, -1}, {-2, 6, 5}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.transpose(matrix3x3Second));
    }

    @Test
    public void testIdenMatrix3x3() {
        float[][] content = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.identity());
    }

    @Test
    public void testZeroMatrix3x3() {
        float[][] content = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Matrix3x3 expected = new Matrix3x3(content);
        Assertions.assertEquals(expected, matrix3x3Result.zero());
    }

    @Test
    public void testAddMatrix4x4() {
        float[][] content = {{3, 1, 3, 0}, {7, 5, 2, 3}, {2, 0, 8, -1}, {4, -1, 5, 8}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.addition(matrix4x4First, matrix4x4Second));
    }

    @Test
    public void test1SubMatrix4x4() {
        float[][] content = {{-1, 3, 3, 8}, {1, 5, 10, 11}, {2, 8, 4, 17}, {-2, 7, 5, 6}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.subtraction(matrix4x4First, matrix4x4Second));
    }

    @Test
    public void test2SubMatrix4x4() {
        float[][] content = {{1, -3, -3, -8}, {-1, -5, -10, -11}, {-2, -8, -4, -17}, {2, -7, -5, -6}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.subtraction(matrix4x4Second, matrix4x4First));
    }

    @Test
    public void test1MultiByVecMatrix4x4() {
        float[][] content = {{30}, {60}, {60}, {50}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.multiplicationByVector(matrix4x4First, columnVector4x1));
    }

    @Test
    public void test2MultiByVecMatrix4x4() {
        float[][] content = {{-16}, {-25}, {-38}, {-1}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.multiplicationByVector(matrix4x4Second, columnVector4x1));
    }

    @Test
    public void test1MultiMatrix4x4() {
        float[][] content = {{20, -29, -2, -35}, {44, -56, -8, -83}, {40, -58, -4, -70}, {32, -49, -2, -54}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.matrixMultiply(matrix4x4First, matrix4x4Second));
    }

    @Test
    public void test2MultiMatrix4x4() {
        float[][] content = {{-6, -13, -20, -27}, {-9, -22, -35, -48}, {-21, -39, -57, -75}, {-12, -11, -10, -9}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.matrixMultiply(matrix4x4Second, matrix4x4First));
    }

    @Test
    public void test1TransMatrix4x4() {
        float[][] content = {{1, 4, 2, 1}, {2, 5, 4, 3}, {3, 6, 6, 5}, {4, 7, 8, 7}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.transpose(matrix4x4First));
    }

    @Test
    public void test2TransMatrix4x4() {
        float[][] content = {{2, 3, 0, 3}, {-1, 0, -4, -4}, {0, -4, 2, 0}, {-4, -4, -9, 1}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.transpose(matrix4x4Second));
    }

    @Test
    public void testIdenMatrix4x4() {
        float[][] content = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.identity());
    }

    @Test
    public void testZeroMatrix4x4() {
        float[][] content = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        Matrix4x4 expected = new Matrix4x4(content);
        Assertions.assertEquals(expected, matrix4x4Result.zero());
    }

}
