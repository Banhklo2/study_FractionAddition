package fractionaddition;

public class FractionCalculator {

    // 속성
    private int numer1, denom1;
    private int numer2, denom2;

    // 생성자
    public FractionCalculator(int numer1, int denom1, int numer2, int denom2) {
        this.numer1 = numer1;
        this.denom1 = denom1;
        this.numer2 = numer2;
        this.denom2 = denom2;
    }

    // 메서드
    public int[] addAndReduce() {

        // 분수 덧셈
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;

        // 최대공약수
        int gcd = gcd(numer, denom);

        // 기약분수로 약분
        numer /= gcd;
        denom /= gcd;

        // [4] 기약분수의 분자와 분모를 배열로 반환
        return new int[]{numer, denom};
    }

    // 최대공약수를 구하는 메서드
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
