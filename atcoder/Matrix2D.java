class Mat2x2{
    long[][] a;
    Mat2x2(long a00, long a01, long a10, long a11){
        a = new long[2][2];
        a[0][0] = a00;
        a[0][1] = a01;
        a[1][0] = a10;
        a[1][1] = a11;
    }
    Mat2x2 mul(Mat2x2 b){
        long a00 = a[0][0]*b.a[0][0] + a[0][1]*b.a[1][0]; 
        long a01 = a[0][0]*b.a[0][1] + a[0][1]*b.a[1][1]; 
        long a10 = a[1][0]*b.a[0][0] + a[1][1]*b.a[1][0]; 
        long a11 = a[1][0]*b.a[0][1] + a[1][1]*b.a[1][1];
        return new Mat2x2(a00, a01, a10, a11);
    }
    Vec2d mul(Vec2d b){
        long a0 = a[0][0] * b.a[0] + a[0][1] * b.a[1];
        long a1 = a[1][0] * b.a[0] + a[1][1] * b.a[1];
        return new Vec2d(a0, a1);
    }
}
class Vec2d{
    long[] a;
    Vec2d(long a0, long a1){
        a = new long[2];
        a[0] = a0;
        a[1] = a1;
    }
    Vec2d add(Vec2d b){
        return new Vec2d(a[0] + b.a[0], a[1] + b.a[1]);
    }
}