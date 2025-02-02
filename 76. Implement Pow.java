class Solution {
    double power(double b, int e) {
        // code here
        if (e == 0)
            return 1;
        if (e < 0) {
            b = 1 / b;
            e = -e;
        }
        double result = 1.0;
        while (e > 0) {
            if ((e & 1) == 1)
                result *= b;
            b *= b;
            e /= 2;
        }
        return result;
    }
}
