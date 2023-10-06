import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map; // 빙고판 배열
	static int[] call; // 사회자가 호명하는 숫자 목록
	static int line;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		map = new int[5][5];
		call = new int[25];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				// 빙고판에 쓰여진 숫자를 입력받는다.
				if(i<5) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				else {
					int index = (i-5) * 5 + j;
					call[index] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		OUT: for(int i=0; i<25; i++) {
			line = 0;
			
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					// 사회자가 호명한 숫자가 빙고칸의 숫자와 일치하는 경우
					if(map[j][k] == call[i]) {
						map[j][k] = 0;
						break;
					}
				}
			}
			
				// 가로, 세로, 대각선에 대해 빙고 개수를 확인한다.
				row();
				column();
				diagonal();
					
				// 빙고 선의 개수가 3개 이상 그어지는 순간, 사회자가 몇 번째 수를 불렀는지 반환한다.
				if(line >= 3) {
					sb.append(i+1);
					break OUT;
				}
			}
		
		System.out.println(sb);
}
	
	public static void row() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j] == 0) {
					if(j == 4) {
						line += 1;
					}
					continue;
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void column() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[j][i] == 0) {
					if(j == 4) {
						line += 1;
					}
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void diagonal() {
		// 왼쪽 대각선
		for(int i=0; i<5; i++) {
			if(map[i][i] == 0) {
				if(i==4) {
					line += 1;
				}
			}
			else {
				break;
			}
		}
		
		// 오른쪽 대각선
		for(int i=0; i<5; i++) {
			if(map[4-i][i] == 0) {
				if(i==4) {
					line += 1;
				}
			}
			else {
				break;
			}
		}
	}
}