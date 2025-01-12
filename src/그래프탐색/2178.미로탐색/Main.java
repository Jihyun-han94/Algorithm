

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 미로탐색
 * https://www.acmicpc.net/problem/2178
 */
public class Main {
  static int N, M;
  static int[][] board;
  static boolean[][] visited;
  static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  static int[] distance; //이동거리
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    board = new int[N+1][M+1];
    distance = new int[N * M]; //길이를 어떻게 설정해야될지 모르겠음
    for (int i = 1; i <= N; i++) {
        String[] str = sc.nextLine().split("");
        for (int j = 1; j <= M; j++) {
            board[i][j] = Integer.parseInt(str[i-1]);
        }
    }
  }
  static void bfs() {
    // (1,1)에서 출발
    Queue<Integer> q = new LinkedList<>();
    // x,y를 queue에 넣어야할 때는 x, y 각각 넣어주면 됨
    q.add(1);
    q.add(1);
    visited[1][1] = true;
    int index = 0;
    distance[++index] = 1;
    while(!q.isEmpty()) {
      int x = q.poll();
      int y = q.poll();

      for(int i = 0; i < 1; i ++) {
        int dx = x + dir[i][0];
        int dy  = y + dir[i][1];
        if (dx < 1 || dy < 1 || dx > N || dy > M) continue; // 탐색범위 벗어남
        if (visited[dx][dy]) continue; // 이미 탐색한 점
        if (board[dx][dy] == 0) continue; // 0은 이동할 수 없는 칸

        q.add(dx);
        q.add(dy);
        visited[dx][dy] = true;
        distance[index + 1] = distance[index] + 1;
        index++;
      }
    }
  }

}
