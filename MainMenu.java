import java.awt.*;
import java.awt.event.*;
public class MainMenu
{
    private Frame mainMenu;
    private Label infoLabel;
    private Panel buttonPanel;
    private Button newGame; 
    private Button loadGame;
    
    public MainMenu(){
        prepareGUI();
    }
    
    private void prepareGUI(){
        mainMenu = new Frame("Main Menu");
        mainMenu.setSize(400,400);
        mainMenu.setLayout(new GridLayout(2,1));
        mainMenu.setResizable(false);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowevent){
                System.exit(0);
            }
        });
        
        infoLabel = new Label("Welcome!", Label.CENTER);
        buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());
        mainMenu.add(infoLabel);
        mainMenu.add(buttonPanel);
        mainMenu.setVisible(true);
    }
    
    public void showButtons(){
        newGame = new Button("New Game");
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PlayerProfile player = new PlayerProfile();
                ChoseLevel choseLevel = new ChoseLevel(player);
                mainMenu.dispose();
            }
        });
        loadGame = new Button("Load Game");
        loadGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                LoadGameWindow newWindow = new LoadGameWindow();
                mainMenu.dispose();
            }
        });
        buttonPanel.add(newGame);
        buttonPanel.add(loadGame);
        mainMenu.setVisible(true);
    }
}
