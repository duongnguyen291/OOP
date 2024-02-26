import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception{
        int boardWeight = 600;
        int boardHeight = boardWeight;

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWeight,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SnakeGame snakeGame = new SnakeGame(boardWeight,boardHeight);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();
    }
}
