import java.awt.*;
import java.awt.event.*;
public class LoadGameWindow
{
    private Frame mainMenu;
    private Label infoLabel;
    private Panel buttonPanel;
    private Button loadGame; 
    private TextField fileName;
    
    public LoadGameWindow(){
        prepareGUI();
    }
    
    private void prepareGUI(){
        mainMenu = new Frame("LoadGame");
        mainMenu.setSize(400,400);
        mainMenu.setLayout(new GridLayout(2,1));
        mainMenu.setResizable(false);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowevent){
                System.exit(0);
            }
        });
        buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(2,1));
        loadGame = new Button("Load game");
        loadGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LoadSavedGame load = new LoadSavedGame(fileName.getText());
                PlayerProfile player = load.loadGame();
                ChoseLevel choseLevel = new ChoseLevel(player);
                mainMenu.dispose();
            }
        });
        buttonPanel.add(loadGame);
        infoLabel = new Label("Enter file name:", Label.CENTER);
        fileName = new TextField(6);
        buttonPanel.add(fileName);
        mainMenu.add(infoLabel);
        mainMenu.add(buttonPanel);
        mainMenu.setVisible(true);
    }
    
}
