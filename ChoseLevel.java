import java.awt.*;
import java.awt.event.*;
public class ChoseLevel
{
    private Frame levelWindow;
    private Panel levelPanel;
    private Panel optionsPanel;
    private PlayerProfile player;
    private Label status;
    
    public ChoseLevel(PlayerProfile player){
        prepareGUI();
        this.player = player;
    }
    
    private void prepareGUI(){
        levelWindow = new Frame("Select Level");
        levelWindow.setSize(500,500);
        levelWindow.setLayout(new GridLayout(2,1));
        levelWindow.setResizable(false);
        levelWindow.setLocationRelativeTo(null);
        levelWindow.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowevent){
                System.exit(0);
            }
        });
        levelPanel = new Panel();
        levelPanel.setLayout(new GridLayout(3,3));
        setupButtons();
        optionsPanel = new Panel();
        optionsPanel.setLayout(new GridLayout(2,1));
        setupOptions();
        levelWindow.add(levelPanel);
        levelWindow.add(optionsPanel);
        levelWindow.setVisible(true);
    }
    
    private void setupButtons(){
        int noButtons = 9;
        for(int i = 1; i <= 9; i++){
            Button selectedLevel = new Button("Level " + i);
            selectedLevel.setName(Integer.toString(i));
            selectedLevel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                String level = e.getActionCommand();
                String[] levels = level.split(" ");
                if(Integer.parseInt(levels[1]) <= player.getLevelsUnlocked()){
                    new Window(800,600,e.getActionCommand(),new Game(e.getActionCommand(), player));
                    levelWindow.dispose();
                }else{
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            status.setText("You have not unlocked " + e.getActionCommand());
                        }     
                    });
                    t.start();
                }
            }
            });
            levelPanel.add(selectedLevel);
        }
    }
    private void setupOptions(){
        status = new Label("", Label.CENTER);
        optionsPanel.add(status);
        Button profileButton = new Button("Edit Setup");
        profileButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            EditProfile editProfile = new EditProfile(player);
            levelWindow.dispose();
        }
        });
        optionsPanel.add(profileButton);
    }
}
