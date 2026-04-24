import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MazePanel extends JPanel {
    private Cell[][] grid;
    private int rows, cols;
    private final int CELL_SIZE = 40; // Dimensiunea unui pătrat

    public void initGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
        repaint(); // Forțează redesenarea panoului
    }

    public void createRandomMaze() {
        if (grid == null) return; // Protecție dacă nu a fost desenat grid-ul

        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Eliminăm ziduri aleatoriu, asigurându-ne că și celula vecină își pierde zidul comun
                if (j < cols - 1 && rand.nextBoolean()) {
                    grid[i][j].right = false;
                    grid[i][j + 1].left = false;
                }
                if (i < rows - 1 && rand.nextBoolean()) {
                    grid[i][j].bottom = false;
                    grid[i + 1][j].top = false;
                }
            }
        }
        repaint();
    }

    public void resetMaze() {
        if (grid == null) return;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j].resetWalls();
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (grid == null) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2)); // Grosimea liniilor

        // Calculăm offset-ul pentru a centra labirintul pe ecran
        int xOffset = (getWidth() - cols * CELL_SIZE) / 2;
        int yOffset = (getHeight() - rows * CELL_SIZE) / 2;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = xOffset + j * CELL_SIZE;
                int y = yOffset + i * CELL_SIZE;
                Cell cell = grid[i][j];

                // Desenăm interiorul celulei
                g2.setColor(new Color(240, 248, 255)); // Alice Blue
                g2.fillRect(x, y, CELL_SIZE, CELL_SIZE);

                // Desenăm zidurile (dacă există)
                g2.setColor(Color.DARK_GRAY);
                if (cell.top)    g2.drawLine(x, y, x + CELL_SIZE, y);
                if (cell.bottom) g2.drawLine(x, y + CELL_SIZE, x + CELL_SIZE, y + CELL_SIZE);
                if (cell.left)   g2.drawLine(x, y, x, y + CELL_SIZE);
                if (cell.right)  g2.drawLine(x + CELL_SIZE, y, x + CELL_SIZE, y + CELL_SIZE);
            }
        }
    }
}
