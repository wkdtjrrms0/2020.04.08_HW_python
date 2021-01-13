package testjava1;
import java.util.*; //��ƿ���丮 �ȿ� �ִ� ��� Ŭ���� ����Ʈ(����, ť, ���Ḯ��Ʈ ����)
import java.util.Stack;

class MazeCell { // ������ ��θ� Ȱ���ϱ� ���� MazeCell Ŭ����
	int i;
	int j;
	int dir;

	public MazeCell(int _i, int _j, int _dir) { // ��ο� ������ �����ϱ� ���� ����������
		i = _i;
		j = _j;
		dir = _dir;
	}
	
	public String toString() { // ���ڿ����·� �̷��� ����ǥ��
		return "<" + i + "," + j + ">";
	}
}

class DFS {  //���̿켱Ž��
	private int maze[][] = { // 2���� �迭�� �̷λ���(������ �ٲܶ� ������ ���� �ʰ��ϱ� ���� ���� �� �׵θ��� 1�� ����)
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
	private int maze_forpicture[][] = { // 2���� �迭�� �̷λ���(������ ��θ� ǥ���ϱ� ���� �迭)
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
	private int move[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // ��, ��, ��, ��
	private int m = maze.length - 2; // m = 7(������ ��)
	private int n = maze[0].length - 1; // n = 7(������ ��)

	public void DepthFirstTraversal() { // ���̿켱Ž��(DFS)
		Stack<Integer> routeX = new Stack<>(); Stack<Integer> routeY = new Stack<>();   //��θ� �����ϱ� ���� ����
		Stack<Integer> routeX1 = new Stack<>(); Stack<Integer> routeY1 = new Stack<>(); //����� ��θ� ���ʷ� �����ϱ� ���� ����

		int i = 1; int j = 1; //��, ���� ��Ÿ���� i, j�� ������� 1�� 1�� ����
		routeX.push(i); routeY.push(j);  //���ÿ� �̷��� ����� ����
		for (; i != m || j != n;) {  //���� ������ �������� m�� n���� �ɶ����� �ݺ�
			if (maze[i][j] == 0) {   //������ġ�� 0�� �ƴҶ�, �� ���� �ƴҶ� �����Ѵ�.
				maze[i][j] = 1;  //������ġ�� �����Դٴ� �ǹ̿� ������ȯ�� �ǵ��ư��� ���ϵ��� 1�� ����

				i = i + move[0][0]; j = j + move[0][1];     //������ġ��  ���� ��, ��, ��, �������� �̵��ϵ��� �����ϰ� �� ������ �̵������� �����̸� ���ÿ� �����ϰ� continue�� �Ʒ��� ��ġ�� �ʰ� �ݺ������� �ǵ��ư���. �̵� �Ұ����ϴٸ� �ٽ� �̵� ���� ��ġ�� �����Ѵ�.
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

				if (i == 1 && j == 1) {System.out.println("��θ� �߰����� ���߽��ϴ�."); return;}  //�� ������ �ݺ��ϴٰ� �������� ã�� ���ϰ� i�� j ���� ���� ó�� ���ÿ� ��� (1,1)�� �Ǹ� ������ �Բ� �ݺ����� �����Ѵ�.
				routeX.pop(); routeY.pop();  //��, ��, ��, �������� �̵��������� �ʾ� �Դ����� �ٽ� ���ư��� ���� ���������� �����͸� ���ÿ��� �����ϰ� ���������� �����͸� ������ä�� i�� j�� �����Ѵ�. �׸��� ���������� 0�� �����Ͽ� �����ٽ� �մ´�.
				i = routeX.peek(); j = routeY.peek();
				maze[i][j] = 0;  
			}
		}
		System.out.println("��θ� �߰��߽��ϴ�."); //���� �ݺ����� ����Ǿ��ٴ°� �������� �����ߴٴ� �ǹ��̹Ƿ� ������ ����Ѵ�.
		while (routeX.isEmpty() != true && routeY.isEmpty() != true) {  //��ΰ� ������ִ� ������ �����Ͱ� ��� �������������� �ݺ��Ѵ�.
			int x = routeX.peek(); int y = routeY.peek();  //���� ����� �����͸� ������ä�� x, y�� ����
			maze_forpicture[x][y] = 2;  //���������� ����� ������ ��������� 2�� �ٲپ��ش�.
			if (routeX.isEmpty() == true && routeY.isEmpty() == true) {break;} //������ x, y�� �� �� ������� ��� �ݺ����� �����Ѵ�.
			routeX1.push(routeX.pop()); routeY1.push(routeY.pop()); //��������� ��� routeX, routeY ���ÿ���  �����ֱٿ� �� ���������� ����� ���� �����͸� ����� ���ÿ� routeX1, routeY1�� �����Ѵ�.
		}
		while (routeX1.isEmpty() != true && routeY1.isEmpty() != true) { //��Ʈ X1, Y1������ �����Ͱ� �������� ���� �ݺ��Ѵ�.
			int x = routeX1.pop(); int y = routeY1.pop(); //��Ʈ X1, Y1�� �����͸� �ֱ��� �����ͺ��� �����԰� ���ÿ� x, y ������ �����ϰ� �Ʒ����� ��ǥ���·� ����Ѵ�.
			System.out.println("<" + x + "," + y + ">");
		}
		displayMaze(); //������ �ð�ȭ �Լ��� �ҷ��´�.
	}
	public void displayMaze() { // �̷ο��� 0���� �Ǿ��ִ� �� �� �ִ� �κ��� �� �׸�, 1�� �Ǿ��ִ� ���� ���� �׸�, �ùٸ� ��δ� 2�̹Ƿ� ȭ��ǥó����
		String[] str = { "��", "��", "��" };
		for (int i = 0; i < maze_forpicture.length; i++) {
			for (int j = 0; j < maze_forpicture[0].length; j++) {
				System.out.print(str[(maze_forpicture[i][j])]);
			}
			System.out.println(""); // �� �ึ�� �����
		}
	}
}


class BFS {
	private int maze[][] = { // 2���� �迭�� �̷λ���(������ �ٲܶ� ������ ���� �ʰ��ϱ� ���� ���� �� �׵θ��� 1�� ����)
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
	private int move[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // ��, ��, ��, ��
	private int m = maze.length - 2; // m = 7(������ ��)
	private int n = maze[0].length - 1; // n = 7(������ ��)	
	
	public void BreadthFirstTraversal() { // �ʺ�켱Ž��(BFS)
		Queue<Integer> routeX = new LinkedList<Integer>(); //���Ḯ��Ʈ�� ����Ͽ� ��θ� ������ ť ����
		Queue<Integer> routeY = new LinkedList<Integer>(); //���Ḯ��Ʈ�� ����Ͽ� ��θ� ������ ť ����
		int i = 1; int j = 1; int k = 0; int r = 0; maze[1][1] = -1;  //��� ���� ��Ÿ���� i�� j�� �������� <1,1>�� �ʱ�ȭ, k�� ������ ��ο� �־��� ���̰�, r�� ������ �о����� ���Ž���� �������� �ƴ� �������� k���� ��ȭ�� �������� ���, maze[1][1] = -1�� ���� ù ���� -1�� ����
		routeX.add(i); routeY.add(j);  //�ʱ��� ��� <1, 1>�� ��η� ������ ť�� �ִ´�.
		while (routeX.isEmpty() != true && routeY.isEmpty() != true) { //ť x�� y�� ���� ���������� �ݺ��� ����
				k = k - 1; i = routeX.poll(); j = routeY.poll();  // ������ ��θ� ������ ǥ���� ���̱� ������ k���� ���ҽ����ְ� ���� �˻��� ������ ť���� �����Ѵ�.
				if(maze[i][j] == r) {k = k + 1;}  //ť���� ���� �̷ο����� ���� ������ �ǽ��� �̷ο����� ���� ��ġ�� ��� k�� ����
				if (i != m || j != n) {  //�������� m�� n���϶����� ����
					for (int d = 0; d < 4; d++) {  //������ ��Ÿ���� d���� �����Ͽ� ��, ��, ��, �� �������� Ž��
						if (d == 0) {  //������ ������ ��
							i = i + move[0][0]; j = j + move[0][1]; //��� ������ ���⿡ �°� �����ְ� ���ش�.
							if (maze[i][j] == 0) {  //�̵������� ����� ��� ����
								routeX.add(i); routeY.add(j);  //�࿭���� ť�� �ִ´�.
								k = k - 1;  //������ ��θ� ǥ���ϱ� ���� ������ k�� -1�ؼ� �����Ѵ�.
								maze[i][j] = k;  //���ҽ�Ų k ���� �̷ο� ����
								k = k + 1;  //Ÿ ���⿡�� 0�� ��찡 ���� �� �����Ƿ� k���� �ٽ� 1 ������Ų��.
								i = i - move[0][0]; j = j - move[0][1];  //Ÿ ���⵵ �˻��ϱ� ���� �̵����� ��ġ�� �缳��
							} else {
								i = i - move[0][0]; j = j - move[0][1]; //�̵��� �� ���� ����̰�, Ÿ ������ �˻��ϱ� ���� �̵����� ��ġ�� �缳��
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
				else {  //�� ��ġ�� �������� ������ ����� �� ����
					System.out.println("��θ� �߰��߽��ϴ�."); //��ι߰߹��� ���
					displayMaze();  //�ܼ�â�� �ð�ȭ�� ��� ���
					return;
				}
		}
		System.out.println("��θ� �߰����� ���߽��ϴ�."); //ť�� �����Ͱ� ������������ ������� �ʾ����Ƿ� ���Ž�����й��� ���
	}
	public void displayMaze() {
		System.out.println("<BFS Ž���� �������(1�� ���̰� ������ ���� ��ȣ�� �ٲٸ� ������ �� �� ������ ���������� Ž���ϴ� ���� ��Ÿ���� )>");  //�ð�ȭ�ڷ� �ȳ����� ���
		for (int i = 0; i < maze.length; i++) {  //�̷� ã�⸦ ������ �̷λ��� ���
			for (int j = 0; j < maze[0].length; j++) {
				System.out.printf("%-5d", maze[i][j]);
			}
			System.out.println(""); // �� �ึ�� �����
		}
		
		int x = m; int y = n; int prex = 0; int prey = 0; int c = 0; //x, y�� ��, ���� �������� m, n ����, prex, prey�� �̵� ���� �࿭��, c�� ����� ��ǥ�迭���� ����
		System.out.println("<BFS Ž���� �ִܰ�θ� ����մϴ�.>");
		String arr[] = new String[-maze[m][n]];  //BFS�� ��� ������������ ��ΰ� �ִܰŸ��̹Ƿ� �ִܰŸ��� ��ǥ������ �迭�� ũ��� ����
		
		while(true) { //break�� ���������� ���ѹݺ�
			arr[c] = "<" + x + "," + y + ">";  //�迭�� ��ǥ���·� ���������� ����� ������ ����
			if(x == 1 && y == 1) {maze[x][y] = 0; break;} //x, y�� �����ġ�� ���������� �̷��� ������� 0�� �����ϰ� ���ѹݺ��� �����Ѵ�.
			for(int d = 0; d < 4; d++) { //���� ��ġ���� ��, ��, ��, �� ������ �˻��ϴ� ���� �ݺ��Ѵ�. ���� ��ġ�� ������ ������ġ�� ���� 1 Ŭ ��� ������ġ�� ������ġ�� �����ϰ� �̷ο� 0�� �����Ѵ�.
				if(d == 0) {prex = x - 1; prey = y; if(maze[x][y] == maze [prex][prey] - 1) {maze[x][y] = 0; x = prex; y = prey; break;}}   
				if(d == 1) {prex = x; prey = y + 1; if(prey < n + 1) {if(maze[x][y] == maze [prex][prey] - 1) {maze[x][y] = 0; x = prex; y = prey; break;}}} //�������� ���ǵ� �������� �̷��� ���κ��̴�. �̷��� ���κп��� ���ʹ����� �����Ҷ� ������ ���Ƿ� �迭�� ���ʿ����� �����ϵ��� ���ǹ�����
				if(d == 2) {prex = x + 1; prey = y; if(maze[x][y] == maze [prex][prey] - 1) {maze[x][y] = 0; x = prex; y = prey; break;}}
				if(d == 3) {prex = x; prey = y - 1; if(maze[x][y] == maze [prex][prey] - 1) {maze[x][y] = 0; x = prex; y = prey; break;}}
			}
			c++;  //�迭�� ��Ұ� ����
		}
		for(int i = arr.length - 1; i >= 0; i--) {System.out.println(arr[i]);}  //�����ǥ�� ����Ǿ� �ִ� �迭�� ���������� ��������ǥ�� ����Ǿ��ִ� �迭�� ó���κб��� ���
		String[] str = { "��", "��", "��" }; 
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if(maze[i][j] == 1) {System.out.print(str[1]);}  //�̷��� ���� 1���� �����׸� ���
				if(maze[i][j] == 0) {System.out.print(str[2]);}  //�̷��� �ִܰ�ο� ������ 0������ ȭ��ǥ ���
				if(maze[i][j] < 0) {System.out.print(str[0]);}  //�̷��� �ִܰ�ΰ� �ƴ϶� 0���� �ƴ����� Ž���Ҷ� ���������Ƿ� �������� ���ִ� ���� �� �׸�� ���
			}
			System.out.println(""); // �� �ึ�� �����
		}
	}

}

public class MazePath {
	private int[][] maze = { // 2���� �迭�� �̷λ���(������ �ٲܶ� ������ ���� �ʰ��ϱ� ���� ���� �� �׵θ��� 1�� ����)
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
	private int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // ��, ��, ��, ��
	private int m = maze.length - 2; // m = 7(������ ��)
	private int n = maze[0].length - 1; // n = 7(������ ��)

	public MazePath() {
		int mark[][] = new int[maze.length][maze[0].length]; // ��ΰ� ������ ���� ǥ���ϱ� ���� mark�迭 ����
		Stack st = new Stack(); // ������ ��θ� ������ ����
		Stack st1 = new Stack(); // �ٸ� ������ ��θ� ���ѽ���
		st.push(new MazeCell(1, 1, 1)); // �ʱ������ġ <1,1> �� ���� ���� ����
		while (st.isEmpty() != true) { // st�� �����Ͱ� ���������� �ݺ�
			MazeCell mc = (MazeCell) st.pop(); // ������ ��θ� ����Ű�� ������ ������
			while (mc.dir <= 3) { // ������ 0,1,2,3�� ��,��,��,���� �ǹ��ϰ� 3������ ��쿡�� �ݺ�
				int nextI = mc.i + move[mc.dir][0]; // �̵��ϰ��� �ϴ� �������� i+
				int nextJ = mc.j + move[mc.dir][1]; // �̵��ϰ��� �ϴ� �������� j+

				if (nextI == m && nextJ == n) { // ������ ��,���� �̵��� ������ ��ġ�ϴ� �̷ΰ�� �߰�
					System.out.println("��θ� �߰��߽��ϴ�");
					st.push(new MazeCell(mc.i, mc.j, mc.dir)); // ��������θ� ���ÿ� ����
					st.push(new MazeCell(nextI, nextJ, 0)); // ������������ ���ÿ� ����
					while (st.isEmpty() != true) { // ���ÿ� �����Ͱ� ���������� �ݺ�
						st1.push((MazeCell) st.pop()); // ������ �����͸� ������->����������� �����ϸ鼭 ����1�� �ùٸ��� ����, ���� �������� ����1�� TOP��
														// �������
					}
					while (st1.isEmpty() != true) { // ����1�� �����Ͱ� ���������� �ݺ�
						mc = (MazeCell) st1.pop(); // ����1 TOP�� ��ġ�� �����͸� mc�� ����
						System.out.println(mc); // �ùٸ� ��� ���(toString�żҵ�� �ڵ� ȣ��ǹǷ� mc�� �ᵵ ��)
						maze[mc.i][mc.j] = 2; // �ùٸ���θ� �����ϱ� ���� 2�� �ٲ���
					}
					displayMaze(); // ��θ� ����ȭ�Ͽ� ���
					return;
				}
				if (maze[nextI][nextJ] == 0 && mark[nextI][nextJ] == 0) { // �̵������ϰ� �湮���� ���� ��ġ�� ������ ����
					mark[nextI][nextJ] = 1; // �湮�ߴٴ� ���� ǥ��
					st.push(new MazeCell(mc.i, mc.j, mc.dir)); // �����°�θ� ���ÿ� ����
					// mc = new MazeCell(nextI,nextJ,0); //���ο� ��ġ, ���� ���� ������ �ʱ�ȭ
					mc.i = nextI;
					mc.j = nextJ;
					mc.dir = 0;
				} else {
					mc.dir++; // �������� �ƴϰ� �̵������ϸ鼭 �湮���� ���� ��ġ�� �ƴ϶�� ������ȯ
				}
			}
		}
		System.out.println("��θ� �߰����� ���߽��ϴ�");

	}

	public void displayMaze() { // �̷ο��� 0���� �Ǿ��ִ� �� �� �ִ� �κ��� �� �׸�, 1�� �Ǿ��ִ� ���� ���� �׸�, �ùٸ� ��δ� 2�̹Ƿ� ȭ��ǥó����
		String[] str = { "��", "��", "��" };
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(str[(maze[i][j])]);
			}
			System.out.println(""); // �� �ึ�� �����
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