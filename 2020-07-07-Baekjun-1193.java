import java.util.*;
public class BJA1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input_num = sc.nextInt();  // 분수 번호 X(1<=X<=10,000,000) 입력
		int count = 0;	// 분수의 번호
		int k = 1;    // for문 반복횟수
		int level = 1;
		int level_firstnum = 1;
		int dividend = 0;	//분자
		int divisor = 0;	//분모

		for(int i=1 ; i<=k ; i++) {
			count++;	//for문이 한 번 반복될 때마다 1씩 증가한다.

			if(count == input_num) {	//for문을 돌다가 입력한 분수 번호와 count가 같아지면
				if(level % 2 == 0) {	//level이 짝수인 경우
					dividend = 1 + (count-level_firstnum);
					divisor = level - (count-level_firstnum);
					System.out.println(dividend + "/" + divisor);
				}else {	//level이 홀수인 경우
					dividend = level - (count-level_firstnum);
					divisor = 1 + (count-level_firstnum);
					System.out.println(dividend + "/" + divisor);
				}
				break;
			}
			/* 아래 if문은 현재 level에 속하는 분수 개수만큼 for문이 반복되고 나서 i==k 가 될 때,
			 * level을 1 증가시키고, 증가시킨 level의 firstnum를 초기화하는 명령을 수행한다.
			 * 또한, 증가된 level 에 속하는 분수 개수만큼 for문을 다시 반복해야 하므로 i=0으로 초기화하고,
			 * 이전 level보다 속하는 분수 개수가 하나 더 많으므로 반복 횟수인 k 역시 1 증가시킨다.
			 * (level_firstnum 이 계차수열 형태를 띠기 때문)
			 */
			if(i==k) {
				level++;
				level_firstnum = count+1;
				i=0;
				k++;
			}
		}
	}
}