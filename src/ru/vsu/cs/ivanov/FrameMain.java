package ru.vsu.cs.ivanov;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class FrameMain extends JFrame{
    private JPanel panelMain;
    private JPanel boardPanel;
    private JButton setFirstQueenMyStackButton;
    private JComboBox<Integer> setFirstQueenBox;
    private JPanel setFirstQueenPanel;
    private JLabel setFirstQueenLabel;
    private JButton setFirstQueenStandardStackButton;

    public FrameMain() {
        super("Application");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 850);
        this.setLocationRelativeTo(null);

        BoardDrawing boardDrawing = new BoardDrawing();
        boardPanel.add(boardDrawing);

        for (int i = 1; i < 9; i++) {
            setFirstQueenBox.addItem(i);
        }

        setFirstQueenMyStackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = (int) setFirstQueenBox.getSelectedItem() - 1;
                BoardWithQueensWithMyStack board = new BoardWithQueensWithMyStack();
                try {
                    board.setQueens(x);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                MyStack<Point> queens = board.getQueens();
                boardDrawing.setQueensMyStack(queens);
                boardPanel.repaint();
            }
        });

        setFirstQueenStandardStackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = (int) setFirstQueenBox.getSelectedItem() - 1;
                BoardWithQueensWithStandardStack board = new BoardWithQueensWithStandardStack();
                try {
                    board.setQueens(x);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                Stack<Point> queens = board.getQueens();
                boardDrawing.setQueensStStack(queens);
                boardPanel.repaint();
            }
        });
    }
}
