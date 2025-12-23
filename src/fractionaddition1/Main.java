package fractionaddition1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numer1 = readIntRange(sc, "첫 번째 분수 분자 입력 (1~999): ");
        int denom1 = readIntRange(sc, "첫 번째 분수 분모 입력 (1~999): ");

        int numer2 = readIntRange(sc, "두 번째 분수 분자 입력 (1~999): ");
        int denom2 = readIntRange(sc, "두 번째 분수 분모 입력 (1~999): ");

        // 분수 덧셈
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;

        // 최대공약수
        int gcd = gcd(numer, denom);

        // 기약분수
        numer /= gcd;
        denom /= gcd;

        System.out.println("결과 = [" + numer + ", " + denom + "]");

        sc.close();
    }

    // 입력 검증 (숫자 + 범위)
    private static int readIntRange(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!sc.hasNextInt()) {
                System.out.println("잘못된 입력입니다! 숫자만 입력하세요.");
                sc.next();
                continue;
            }

            int value = sc.nextInt();

            if (value < 1 || value > 999) {
                System.out.println("잘못된 입력입니다! 1~999 범위로 입력하세요.");
                continue;
            }

            return value;
        }
    }

    // 최대공약수 (유클리드 호제법)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
