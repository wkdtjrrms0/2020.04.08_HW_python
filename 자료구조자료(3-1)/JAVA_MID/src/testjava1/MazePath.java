package testjava1;
import java.util.*; //유틸디렉토리 안에 있는 모든 클래스 임포트(스택, 큐, 연결리스트 포함)
import java.util.Stack;

class MazeCell { // 지점과 경로를 활용하기 위한 MazeCell 클래스
	int i;
	int j;
	int dir;

	public MazeCell(int _i, int _j, int _dir) { // 경로와 지점을 설정하기 위한 접근제어자
		i = _i;
		j = _j;
		dir = _dir;
	}
	
	public String toString() { // 문자열형태로 미로의 지점표현
		return "<" + i + "," + j + ">";
	}
}

class DFS {  //깊이우선탐색
	private int maze[][] = { // 2차원 배열로 미로생성(방향을 바꿀때 오류가 나지 않게하기 위해 가장 끝 테두리는 1로 설정)
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, // 0
			{ 1, 0, 1, 1, 0, 1, 1, 1 }, // 1
			{ 1, 0, 0, 1, 0, 1, 1, 1 }, // 2
			{ 1, 1, 0, 0, 0, 1, 1, 1 }, // 3
			{ 1, 1, 1, 0, 0, 0, 1, 1 }, // 4
			{ 1, 0, 0, 0, 1, 1, 1, 1 }, // 5
			{ 1, 1, 0, 1, 0, 0, 0, 1 }, // 6
			{ 1, 0, 0, 0, 0, 1, 0, 0 }, // 7
			{ 1, 1, 1, 1, 1, 1, 1, 1 }  // 8
	};
	private int maze_forpicture[][] = { // 2차원 배열로 미로생성(지나온 경로를 표현하기 위한 배열)
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, // 0
			{ 1, 0, 1, 1, 0, 1, 1, 1 }, // 1
			{ 1, 0, 0, 1, 0, 1, 1, 1 }, // 2
			{ 1, 1, 0, 0, 0, 1, 1, 1 }, // 3
			{ 1, 1, 1, 0, 0, 0, 1, 1 }, // 4
			{ 1, 0, 0, 0, 1, 1, 1, 1 }, // 5
			{ 1, 1, 0, 1, 0, 0, 0, 1 }, // 6
			{ 1, 0, 0, 0, 0, 1, 0, 0 }, // 7
			{ 1, 1, 1, 1, 1, 1, 1, 1 }  // 8
	};
	private int move[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북, 동, 남, 서
	private int m = maze.length - 2; // m = 7(목적지 행)
	private int n = maze[0].length - 1; // n = 7(목적지 열)

	public void DepthFirstTraversal() { // 깊이우선탐색(DFS)
		Stack<Integer> routeX = new Stack<>(); Stack<Integer> routeY = new Stack<>();   //경로를 저장하기 위한 스택
		Stack<Integer> routeX1 = new Stack<>(); Stack<Integer> routeY1 = new Stack<>(); //저장된 경로를 차례로 정렬하기 위한 스택

		int i = 1; int j = 1; //행, 열을 나타내는 i, j에 출발점인 1행 1열 대입
		routeX.push(i); routeY.push(j);  //스택에 미로의 출발점 삽입
		for (; i != m || j != n;) {  //현재 지점이 목적지인 m행 n열이 될때까지 반복
			if (maze[i][j] == 0) {   //현재위치가 0이 아닐때, 즉 벽이 아닐때 수행한다.
				maze[i][j] = 1;  //현재위치에 지나왔다는 의미와 방향전환중 되돌아가지 못하도록 1을 대입

				i = i + move[0][0]; j = j + move[0][1];     //현재위치를  각각 북, 동, 남, 서쪽으로 이동하도록 설정하고 그 지점이 이동가능한 지점이면 스택에 삽입하고 continue로 아래를 거치지 않고 반복문으로 되돌아간다. 이동 불가능하다면 다시 이동 전의 위치로 설정한다.
				if (maze[i][j] == 0) {routeX.push(i); routeY.push(j); continue;}
				else {i = i - move[0][0]; j = j - move[0][1];}

				i = i + move[1][0]; j = j + move[1][1];
				if (maze[i][j] == 0) {routeX.push(i); routeY.push(j); continue;} 
				else {i = i - move[1][0]; j = j - move[1][1];}

				i = i + move[2][0]; j = j + move[2][1];
				if (maze[i][j] == 0) {routeX.push(i); routeY.push(j); continue;} 
				else {i = i - move[2][0]; j = j - move[2][1];}

				i = i + move[3][0]; j = j + move[3][1];
				if (maze[i][j] == 0) {routeX.push(i); routeY.push(j); continue;} 
				else {i = i - move[3][0]; j = j - move[3][1];}

				if (i == 1 && j == 1) {System.out.println("경로를 발견하지 못했습니다."); return;}  //위 과정을 반복하다가 목적지를 찾지 못하고 i와 j 값이 가장 처음 스택에 담긴 (1,1)이 되면 문구와 함께 반복문을 종료한다.
				routeX.pop(); routeY.pop();  //북, 동, 남, 서쪽으로 이동가능하지 않아 왔던길을 다시 돌아가기 위해 막힌지점의 데이터를 스택에서 제거하고 이전지점의 데이터를 유지한채로 i와 j에 대입한다. 그리고 이전지점에 0을 대입하여 벽을다시 뚫는다.
				i = routeX.peek(); j = routeY.peek();
				maze[i][j] = 0;  
			}
		}
		System.out.println("경로를 발견했습니다."); //위의 반복문이 종료되었다는건 목적지에 도착했다는 의미이므로 문구를 출력한다.
		while (routeX.isEmpty() != true && routeY.isEmpty() != true) {  //경로가 저장되있는 스택의 데이터가 모두 빠져나갈때까지 반복한다.
			int x = routeX.peek(); int y = routeY.peek();  //스택 상단의 데이터를 유지한채로 x, y에 대입
			maze_forpicture[x][y] = 2;  //목적지부터 출발지 사이의 경로지점을 2로 바꾸어준다.
			if (routeX.isEmpty() == true && routeY.isEmpty() == true) {break;} //스택의 x, y가 둘 다 비어있을 경우 반복문을 종료한다.
			routeX1.push(routeX.pop()); routeY1.push(routeY.pop()); //경로정보가 담긴 routeX, routeY 스택에서  가장최근에 들어간 목적지부터 출발지 순의 데이터를 지움과 동시에 routeX1, routeY1에 삽입한다.
		}
		while (routeX1.isEmpty() != true && routeY1.isEmpty() != true) { //루트 X1, Y1스택의 데이터가 없어질때 까지 반복한다.
			int x = routeX1.pop(); int y = routeY1.pop(); //루트 X1, Y1의 데이터를 최근의 데이터부터 삭제함과 동시에 x, y 변수에 대입하고 아래에서 좌표형태로 출력한다.
			System.out.println("<" + x + "," + y + ">");
		}
		displayMaze(); //만들어둔 시각화 함수를 불러온다.
	}
	public void displayMaze() { // 미로에서 0으로 되어있는 갈 수 있는 부분은 빈 네모, 1로 되어있는 벽은 검은 네모, 올바른 경로는 2이므로 화살표처리함
		String[] str = { "□", "■", "☞" };
		for (int i = 0; i < maze_forpicture.length; i++) {
			for (int j = 0; j < maze_forpicture[0].length; j++) {
				System.out.print(str[(maze_forpicture[i][j])]);
			}
			System.out.println(""); // 각 행마다 띄어줌
		}
	}
}


class BFS {
	private int maze[][] = { // 2차원 배열로 미로생성(방향을 바꿀때 오류가 나지 않게하기 위해 가장 끝 테두리는 1로 설정)
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, // 0
			{ 1, 0, 1, 1, 0, 1, 1, 1 }, // 1
			{ 1, 0, 0, 1, 0, 1, 1, 1 }, // 2
			{ 1, 1, 0, 0, 0, 1, 1, 1 }, // 3
			{ 1, 1, 1, 0, 0, 0, 1, 1 }, // 4
			{ 1, 0, 0, 0, 1, 1, 1, 1 }, // 5
			{ 1, 1, 0, 1, 0, 0, 0, 1 }, // 6
			{ 1, 0, 0, 0, 0, 1, 0, 0 }, // 7
			{ 1, 1, 1, 1, 1, 1, 1, 1 } // 8
	};	
	private int move[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북, 동, 남, 서
	private int m = maze.length - 2; // m = 7(목적지 행)
	private int n = maze[0].length - 1; // n = 7(목적지 열)	
	
	public void BreadthFirstTraversal() { // 너비우선탐색(BFS)
		Queue<Integer> routeX = new LinkedList<Integer>(); //연결리스트를 사용하여 경로를 저장할 큐 생성
		Queue<Integer> routeY = new LinkedList<Integer>(); //연결리스트를 사용하여 경로를 저장할 큐 생성
		int i = 1; int j = 1; int k = 0; int r = 0; maze[1][1] = -1;  //행과 열을 나타내는 i와 j를 시작점인 <1,1>로 초기화, k는 지나간 경로에 넣어줄 값이고, r은 범위가 넓어지는 경로탐색중 도착점이 아닌 지점에서 k값의 변화를 막기위해 사용, maze[1][1] = -1을 통해 첫 지점 -1로 설정
		routeX.add(i); routeY.add(j);  //초기의 경로 <1, 1>을 경로로 설정한 큐에 넣는다.
		while (routeX.isEmpty() != true && routeY.isEmpty() != true) { //큐 x와 y의 값이 없어질동안 반복문 수행
				k = k - 1; i = routeX.poll(); j = routeY.poll();  // 지나온 경로를 음수로 표현할 것이기 때문에 k값을 감소시켜주고 이후 검사할 지점을 큐에서 제거한다.
				if(maze[i][j] == r) {k = k + 1;}  //큐에서 꺼낸 미로에서의 값과 이전에 실시한 미로에서의 값이 일치할 경우 k값 증가
				if (i != m || j != n) {  //도착점인 m과 n값일때까지 수행
					for (int d = 0; d < 4; d++) {  //방향을 나타내는 d값을 설정하여 북, 동, 남, 서 방향으로 탐색
						if (d == 0) {  //방향이 북쪽일 때
							i = i + move[0][0]; j = j + move[0][1]; //행과 열값을 방향에 맞게 더해주고 빼준다.
							if (maze[i][j] == 0) {  //이동가능한 경로일 경우 수행
								routeX.add(i); routeY.add(j);  //행열값을 큐에 넣는다.
								k = k - 1;  //지나간 경로를 표시하기 위해 기존의 k에 -1해서 대입한다.
								maze[i][j] = k;  //감소시킨 k 값을 미로에 대입
								k = k + 1;  //타 방향에도 0인 경우가 있을 수 있으므로 k값을 다시 1 증가시킨다.
								i = i - move[0][0]; j = j - move[0][1];  //타 방향도 검사하기 위해 이동전의 위치로 재설정
							} else {
								i = i - move[0][0]; j = j - move[0][1]; //이동할 수 없는 경로이고, 타 방향을 검사하기 위해 이동전의 위치로 재설정
							}
						}
						
						if (d == 1) {
							i = i + move[1][0]; j = j + move[1][1];
							if (maze[i][j] == 0) {
								routeX.add(i); routeY.add(j);
								k = k - 1;
								maze[i][j] = k;
								k = k + 1;
								i = i - move[1][0]; j = j - move[1][1];
							} else {
								i = i - move[1][0]; j = j - move[1][1];
							}
						}

						if (d == 2) {
							i = i + move[2][0]; j = j + move[2][1];
							if (maze[i][j] == 0) {
								routeX.add(i); routeY.add(j);
								k = k - 1;
								maze[i][j] = k;
								k = k + 1;
								i = i - move[2][0]; j = j - move[2][1];
							} else {
								i = i - move[2][0]; j = j - move[2][1];
							}
						}

						if (d == 3) {
							i = i + move[3][0]; j = j + move[3][1];
							if (maze[i][j] == 0) {
								routeX.add(i); routeY.add(j);
								k = k - 1;
								maze[i][j] = k;
								k = k + 1;
								i = i - move[3][0]; j = j - move[3][1];
							} else {
								i = i - move[3][0]; j = j - move[3][1];
							}
						}
						r = maze[i][j];
					}
				} 
				else {  //현 위치가 도착점과 동일한 경우일 떄 수행
					System.out.println("경로를 발견했습니다."); //경로발견문구 출력
					displayMaze();  //콘솔창에 시각화된 결과 출력
					return;
				}
		}
		System.out.println("경로를 발견하지 못했습니다."); //큐의 데이터가 없어질때까지 종료되지 않았으므로 경로탐새실패문구 출력
	}
	public void displayMaze() {
		System.out.println("<BFS 탐색의 진행방향(1은 벽이고 음수를 양의 부호로 바꾸면 순서를 알 수 있으며 퍼져나가며 탐색하는 것을 나타낸다 )>");  //시각화자료 안내문구 출력
		for (int i = 0; i < maze.length; i++) {  //미로 찾기를 수행한 미로상태 출력
			for (int j = 0; j < maze[0].length; j++) {
				System.out.printf("%-5d", maze[i][j]);
			}
			System.out.println(""); // 각 행마다 띄어줌
		}
		
		int x = m; int y = n; int prex = 0; int prey = 0; int c = 0; //x, y에 행, 열의 도착점인 m, n 대입, prex, prey는 이동 전의 행열값, c는 저장된 좌표배열에서 사용됨
		System.out.println("<BFS 탐색의 최단경로를 출력합니다.>");
		String arr[] = new String[-maze[m][n]];  //BFS의 경우 목적지까지의 경로가 최단거리이므로 최단거리의 좌표개수를 배열의 크기로 설정
		
		while(true) { //break를 만날때까지 무한반복
			arr[c] = "<" + x + "," + y + ">";  //배열에 좌표형태로 목적지부터 출발지 순으로 저장
			if(x == 1 && y == 1) {maze[x][y] = 0; break;} //x, y가 출발위치에 도착했을때 미로의 출발점에 0을 대입하고 무한반복을 종료한다.
			for(int d = 0; d < 4; d++) { //현재 위치에서 북, 동, 남, 서 방향을 검사하는 것을 반복한다. 현재 위치의 값보다 이전위치의 값이 1 클 경우 현재위치에 이전위치를 대입하고 미로에 0을 대입한다.
				if(d == 0) {prex = x - 1; prey = y; if(maze[x][y] == maze [prex][prey] - 1) {maze[x][y] = 0; x = prex; y = prey; break;}}   
				if(d == 1) {prex = x; prey = y + 1; if(prey < n + 1) {if(maze[x][y] == maze [prex][prey] - 1) {maze[x][y] = 0; x = prex; y = prey; break;}}} //문제에서 정의된 도착점이 미로의 끝부분이다. 미로의 끝부분에서 동쪽방향을 수행할때 오류가 나므로 배열의 안쪽에서만 수행하도록 조건문설정
				if(d == 2) {prex = x + 1; prey = y; if(maze[x][y] == maze [prex][prey] - 1) {maze[x][y] = 0; x = prex; y = prey; break;}}
				if(d == 3) {prex = x; prey = y - 1; if(maze[x][y] == maze [prex][prey] - 1) {maze[x][y] = 0; x = prex; y = prey; break;}}
			}
			c++;  //배열의 요소값 증가
		}
		for(int i = arr.length - 1; i >= 0; i--) {System.out.println(arr[i]);}  //출발좌표가 저장되어 있는 배열의 마지막부터 목적지좌표가 저장되어있는 배열의 처음부분까지 출력
		String[] str = { "□", "■", "☞" }; 
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if(maze[i][j] == 1) {System.out.print(str[1]);}  //미로의 벽인 1값은 검은네모 출력
				if(maze[i][j] == 0) {System.out.print(str[2]);}  //미로의 최단경로에 대입한 0값에는 화살표 출력
				if(maze[i][j] < 0) {System.out.print(str[0]);}  //미로의 최단경로가 아니라 0값은 아니지만 탐색할때 지나갔으므로 음수값이 들어가있는 곳은 빈 네모로 출력
			}
			System.out.println(""); // 각 행마다 띄어줌
		}
	}

}

public class MazePath {
	private int[][] maze = { // 2차원 배열로 미로생성(방향을 바꿀때 오류가 나지 않게하기 위해 가장 끝 테두리는 1로 설정)
			{ 1, 1, 1, 1, 1, 1, 1, 1 }, // 1
			{ 1, 0, 1, 1, 0, 1, 1, 1 }, // 2
			{ 1, 0, 0, 1, 0, 1, 1, 1 }, // 3
			{ 1, 1, 0, 0, 0, 1, 1, 1 }, // 4
			{ 1, 1, 1, 0, 0, 0, 1, 1 }, // 5
			{ 1, 0, 0, 0, 1, 1, 1, 1 }, // 6
			{ 1, 1, 0, 1, 0, 0, 0, 1 }, // 7
			{ 1, 0, 0, 0, 0, 1, 0, 0 }, // 8
			{ 1, 1, 1, 1, 1, 1, 1, 1 } // 9
	};
	private int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북, 동, 남, 서
	private int m = maze.length - 2; // m = 7(목적지 행)
	private int n = maze[0].length - 1; // n = 7(목적지 열)

	public MazePath() {
		int mark[][] = new int[maze.length][maze[0].length]; // 경로가 지나간 곳을 표시하기 위한 mark배열 생성
		Stack st = new Stack(); // 지나간 경로를 삽입할 스택
		Stack st1 = new Stack(); // 바른 순서의 경로를 위한스택
		st.push(new MazeCell(1, 1, 1)); // 초기출발위치 <1,1> 및 동쪽 방향 설정
		while (st.isEmpty() != true) { // st의 데이터가 없을때까지 반복
			MazeCell mc = (MazeCell) st.pop(); // 지나온 경로를 가리키는 데이터 제거함
			while (mc.dir <= 3) { // 방향은 0,1,2,3이 북,동,남,서를 의미하고 3이하일 경우에만 반복
				int nextI = mc.i + move[mc.dir][0]; // 이동하고자 하는 방향으로 i+
				int nextJ = mc.j + move[mc.dir][1]; // 이동하고자 하는 방향으로 j+

				if (nextI == m && nextJ == n) { // 목적지 행,열과 이동할 지점이 일치하는 미로경로 발견
					System.out.println("경로를 발견했습니다");
					st.push(new MazeCell(mc.i, mc.j, mc.dir)); // 마지막경로를 스택에 삽입
					st.push(new MazeCell(nextI, nextJ, 0)); // 마지막지점도 스택에 삽입
					while (st.isEmpty() != true) { // 스택에 데이터가 없을때까지 반복
						st1.push((MazeCell) st.pop()); // 스택의 데이터를 목적지->출발지순으로 제거하면서 스택1에 올바른길 삽입, 가장 마지막에 스택1의 TOP은
														// 출발지임
					}
					while (st1.isEmpty() != true) { // 스택1에 데이터가 없을때까지 반복
						mc = (MazeCell) st1.pop(); // 스택1 TOP에 위치한 데이터를 mc에 대입
						System.out.println(mc); // 올바른 경로 출력(toString매소드는 자동 호출되므로 mc만 써도 됨)
						maze[mc.i][mc.j] = 2; // 올바른경로를 구분하기 위해 2로 바꿔줌
					}
					displayMaze(); // 경로를 가시화하여 출력
					return;
				}
				if (maze[nextI][nextJ] == 0 && mark[nextI][nextJ] == 0) { // 이동가능하고 방문하지 않은 위치가 있을때 수행
					mark[nextI][nextJ] = 1; // 방문했다는 것을 표시
					st.push(new MazeCell(mc.i, mc.j, mc.dir)); // 지나온경로를 스택에 삽입
					// mc = new MazeCell(nextI,nextJ,0); //새로운 위치, 방향 설정 방향은 초기화
					mc.i = nextI;
					mc.j = nextJ;
					mc.dir = 0;
				} else {
					mc.dir++; // 목적지도 아니고 이동가능하면서 방문하지 않은 위치가 아니라면 방향전환
				}
			}
		}
		System.out.println("경로를 발견하지 못했습니다");

	}

	public void displayMaze() { // 미로에서 0으로 되어있는 갈 수 있는 부분은 빈 네모, 1로 되어있는 벽은 검은 네모, 올바른 경로는 2이므로 화살표처리함
		String[] str = { "□", "■", "☞" };
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(str[(maze[i][j])]);
			}
			System.out.println(""); // 각 행마다 띄어줌
		}
	}

	public static void main(String[] args) {
		new MazePath();
		DFS create1 = new DFS();
		create1.DepthFirstTraversal();
		BFS create2 = new BFS();
		create2.BreadthFirstTraversal();
	}
}