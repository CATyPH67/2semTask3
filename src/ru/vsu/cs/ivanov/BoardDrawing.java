package ru.vsu.cs.ivanov;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class BoardDrawing extends JPanel {
    private final int BOARD_SIZE = 800;
    private MyStack<Point> queensMyStack = new MyStack<>();
    private Stack<Point> queensStStack = new Stack<>();

    public BoardDrawing() {
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
    }

    public void setQueensMyStack(MyStack<Point> queens) {
        this.queensMyStack = queens;
    }

    public void setQueensStStack(Stack<Point> queens) {
        this.queensStStack = queens;
    }

    @Override
    public void paint(Graphics g) {
        int cellSize = BOARD_SIZE / 8;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if ((x + y) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }

        while (queensMyStack.size() > 0) {
            try {
                if (queensMyStack.size() == 1) {
                    g.setColor(Color.PINK);
                } else {
                    g.setColor(Color.BLACK);
                }
                Point queen = queensMyStack.pop();
                int x = queen.getX();
                int y = queen.getY();
                g.fillOval(x * cellSize, y * cellSize, cellSize, cellSize);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (queensStStack.size() > 0) {
            try {
                if (queensStStack.size() == 1) {
                    g.setColor(Color.PINK);
                } else {
                    g.setColor(Color.BLACK);
                }
                Point queen = queensStStack.pop();
                int x = queen.getX();
                int y = queen.getY();
                g.fillOval(x * cellSize, y * cellSize, cellSize, cellSize);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
