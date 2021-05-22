package ru.vsu.cs.ivanov;

public class BoardWithQueensWithMyStack {
    private final int BOARD_SIZE = 8;
    private final int NUMBER_OF_QUEENS = 8;
    private MyStack<Point> queens = new MyStack<>();
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public MyStack<Point> getQueens() {
        return queens;
    }

    public void setQueens(int x) throws Exception {
        int y = 0;
        while (queens.size() < NUMBER_OF_QUEENS) {
            if (queens.size() > 0) {
                Point lastQueen = removeLastQueen();
                x = lastQueen.getX() + 1;
                y = lastQueen.getY();
            }

            for (; y < BOARD_SIZE; y++) {
                for (; x < BOARD_SIZE; x++) {
                    if (board[y][x] == 0) {
                        putQueen(x, y);
                        x = 0;
                        break;
                    }
                }
                if (x == BOARD_SIZE) {
                    break;
                }
            }
        }
    }

    private void putQueen(int x, int y) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[y][i] += 1;
            board[i][x] += 1;

            if ((0 <= y - x + i) && (y - x + i < 8)) {
                board[y - x + i][i] += 1;
            }

            if ((0 <= y + x - i) && (y + x - i < 8)) {
                board[y + x - i][i] += 1;
            }
        }
        queens.push(new Point(x, y));
    }

    private Point removeLastQueen() throws Exception {
        Point lastQueen = queens.pop();
        int x = lastQueen.getX();
        int y = lastQueen.getY();
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[y][i] -= 1;
            board[i][x] -= 1;

            if ((0 <= y - x + i) && (y - x + i < 8)) {
                board[y - x + i][i] -= 1;
            }

            if ((0 <= y + x - i) && (y + x - i < 8)) {
                board[y + x - i][i] -= 1;
            }
        }
        board[y][x] = 0;
        return new Point(x, y);
    }
}
