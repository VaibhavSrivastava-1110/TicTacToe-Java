package TicTacToeJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {

    private Container blocks;
    private String currentPlayer;
    private JButton [] [] tttBoard;
    private Boolean gameWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newGame;
    private JMenuItem quitGame;

    public TicTacToe () {
        super();
        blocks = getContentPane();
        blocks.setLayout(new GridLayout(3,3));
        setTitle("Tic Tac Toe Game");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        currentPlayer = "X";
        tttBoard = new JButton [3] [3];
        gameWinner = false;
        initializeBoard();
        initializeMenuBar();
    }

    private void gameWinner() {
        if (tttBoard[0][0].getText().equals(currentPlayer) && tttBoard[1][0].getText().equals(currentPlayer) && tttBoard[2][0].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won this game.");
            gameWinner = true;
        }
        else if (tttBoard[0][1].getText().equals(currentPlayer) && tttBoard[1][1].getText().equals(currentPlayer) && tttBoard[2][1].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won this game.");
            gameWinner = true;
        }
        else if (tttBoard[0][2].getText().equals(currentPlayer) && tttBoard[1][2].getText().equals(currentPlayer) && tttBoard[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won this game.");
            gameWinner = true;
        }
        else if (tttBoard[0][0].getText().equals(currentPlayer) && tttBoard[0][1].getText().equals(currentPlayer) && tttBoard[0][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won this game.");
            gameWinner = true;
        }
        else if (tttBoard[1][0].getText().equals(currentPlayer) && tttBoard[1][1].getText().equals(currentPlayer) && tttBoard[1][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won this game.");
            gameWinner = true;
        }
        else if (tttBoard[2][0].getText().equals(currentPlayer) && tttBoard[2][1].getText().equals(currentPlayer) && tttBoard[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won this game.");
            gameWinner = true;
        }
        else if (tttBoard[0][0].getText().equals(currentPlayer) && tttBoard[1][1].getText().equals(currentPlayer) && tttBoard[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won this game.");
            gameWinner = true;
        }
        else if (tttBoard[2][0].getText().equals(currentPlayer) && tttBoard[1][1].getText().equals(currentPlayer) && tttBoard[0][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + "has won this game.");
            gameWinner = true;
        }
    }

    private void initializeMenuBar() {
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
            }
        });
        quitGame = new JMenuItem("Quit Game");
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(newGame);
        menu.add(quitGame);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void resetBoard() {
        currentPlayer = "X";
        gameWinner = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tttBoard[i][j].setText("");
            }
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                tttBoard[i][j] = button;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(((JButton)e.getSource()).getText().equals("") && gameWinner == false){
                            button.setText(currentPlayer);
                            gameWinner();
                            changePlayer();
                        }
                    }
                });
                blocks.add(button);
            }
        }
    }
    private void changePlayer() {
        if(currentPlayer.equals("X")){
            currentPlayer = "O";
        }
        else
            currentPlayer = "X";
    }
}
