import javax.swing.*;
import java.awt.*;

public class MazeApp extends JFrame {
    private MazePanel mazePanel;

    public MazeApp() {
        super("Maze Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Layout pentru a așeza componentele N/S/E/W/Center

        // Inițializare Canvas (aici folosim clasa din fișierul separat)
        mazePanel = new MazePanel();

        // Inițializare și adăugare Panouri
        add(createConfigPanel(), BorderLayout.NORTH);
        add(mazePanel, BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);

        // Setări fereastră
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrează fereastra pe ecran
    }

    // Crearea panoului de sus (Config Panel)
    private JPanel createConfigPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(new JLabel("Rows:"));
        JSpinner rowSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 50, 1));
        panel.add(rowSpinner);

        panel.add(new JLabel("Cols:"));
        JSpinner colSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 50, 1));
        panel.add(colSpinner);

        JButton drawBtn = new JButton("Draw Grid");
        drawBtn.addActionListener(e -> {
            int rows = (Integer) rowSpinner.getValue();
            int cols = (Integer) colSpinner.getValue();
            mazePanel.initGrid(rows, cols);
        });
        panel.add(drawBtn);

        return panel;
    }

    // Crearea panoului de jos (Control Panel)
    private JPanel createControlPanel() {
        JPanel panel = new JPanel();

        JButton createBtn = new JButton("Create");
        createBtn.addActionListener(e -> mazePanel.createRandomMaze());

        JButton resetBtn = new JButton("Reset");
        resetBtn.addActionListener(e -> mazePanel.resetMaze());

        JButton exitBtn = new JButton("Exit");
        exitBtn.addActionListener(e -> System.exit(0));

        panel.add(createBtn);
        panel.add(resetBtn);
        panel.add(exitBtn);

        return panel;
    }

    public static void main(String[] args) {
        // Rularea interfeței grafice pe thread-ul specific Swing
        SwingUtilities.invokeLater(() -> new MazeApp().setVisible(true));
    }
}