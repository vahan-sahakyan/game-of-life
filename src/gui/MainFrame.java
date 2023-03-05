package gui;

import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame {
  private static final long serialVersionUID = 1L;

  private GamePanel gamePanel = new GamePanel(this);

  private static final String defaultFileName = "gameoflife.gol";

  public MainFrame() {
    super("Game of Life");

    setLayout(new BorderLayout());
    add(gamePanel, BorderLayout.CENTER);

    MenuItem openItem = new MenuItem("Open");
    MenuItem saveItem = new MenuItem("Save");

    Menu fileMenu = new Menu("File");
    fileMenu.add(openItem);
    fileMenu.add(saveItem);

    MenuBar menuBar = new MenuBar();
    menuBar.add(fileMenu);

    setMenuBar(menuBar);

    JFileChooser fileChooser = new JFileChooser();
    var filter = new FileNameExtensionFilter("Game Of Life Files", "gol");
    fileChooser.addChoosableFileFilter(filter);
    fileChooser.setFileFilter(filter);

    openItem.addActionListener((e) -> {
      int userOption = fileChooser.showOpenDialog(MainFrame.this);

      if (userOption == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        gamePanel.open(selectedFile);
      }
    });
    saveItem.addActionListener((e) -> {
      fileChooser.setSelectedFile(new File(defaultFileName));
      int userOption = fileChooser.showSaveDialog(MainFrame.this);

      if (userOption == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        gamePanel.save(selectedFile);
      }
    });

    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
        case 32:
          gamePanel.next();
          break;
        case 8:
          gamePanel.clear();
          break;
        case 10:
          gamePanel.randomize();
          break;

        default:
          break;
        }

      }
    });

    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }
}