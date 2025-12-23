package fractionaddition;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        int numer1 = readIntRange(sc, "첫 번째 분수 분자 입력 (1~999): ");
        int denom1 = readIntRange(sc, "첫 번째 분수 분모 입력 (1~999): ");

        int numer2 = readIntRange(sc, "두 번째 분수 분자 입력 (1~999): ");
        int denom2 = readIntRange(sc, "두 번째 분수 분모 입력 (1~999): ");

        // 분수 계산을 담당하는 FractionCalculator 객체 셍성
        FractionCalculator fc = new FractionCalculator(numer1, denom1, numer2, denom2);

        // FractionCalculator에 분수 덧셈 및 기약분수 계산 요청
        int[] result = fc.addAndReduce();

        // 결과 출력
        System.out.println("결과 = [" + result[0] + "," + result[1] + "]");

        sc.close();
    }

    // 정수 입력을 받아 숫자인지와 범위(1~999)를 검증하는 메서드
    // 잘못된 입력이 들어오면 올바른 값이 입력될 때까지 반복한다.
    private static int readIntRange(Scanner sc, String prompt) {

        // 올바른 값이 입력될 때까지 무한 반복
        while (true) {
            // 입력 안내 문구 출력
            System.out.print(prompt);

            // 숫자가 아닌 값(문자, 기호 등)이 입력된 경우
            if (!sc.hasNextInt()) {
                System.out.println("잘못된 입력입니다! 숫자만 입력하세요.");
                sc.next();
                continue;
            }

            // 숫자인 경우 값 읽기
            int value = sc.nextInt();

            // 범위를 벗어난 경우
            if (value < 1 || value > 999) {
                System.out.println("잘못된 입력입니다! 1~999 범위로 입력하세요.");
                continue;
            }

            // 숫자이고 범위도 올바르면 값 반환
            return value;
        }
    }
}
