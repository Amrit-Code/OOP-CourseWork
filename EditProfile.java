import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class EditProfile
{
    private Frame mainMenu;
    private Label current;
    private Label possible;
    private Panel selectionPanel;
    private JComboBox<String> options;
    private Button confirm;
    private Button cancel;
    private ChoseLevel choseLevel;
    private PlayerProfile player;
    private String changeTo;
    public EditProfile( PlayerProfile player){
        this.choseLevel = choseLevel;
        this.player = player;
        prepareGUI();
    }
    
    private void prepareGUI(){
        mainMenu = new Frame("Edit Profile");
        mainMenu.setSize(400,400);
        mainMenu.setLayout(new GridLayout(4,1));
        mainMenu.setResizable(false);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowevent){
                System.exit(0);
            }
        });
        options = new JComboBox<String>();
        setUpOptions();
        options.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                possible.setText("Change To: " + ((JComboBox) e.getSource()).getSelectedItem());
                changeTo = (String)((JComboBox) e.getSource()).getSelectedItem();
            }
        });
        selectionPanel = new Panel(new GridLayout(1,2));
        current = new Label("Your current character is a : " + player.getActiveCharacter().getName() +
        " Lv" + player.getActiveCharacter().getLevel()); 
        possible = new Label("Change To: ");
        confirm = new Button("Change");
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                change();
                goBack();
            }
        });
        cancel = new Button("Cancel");
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                goBack();
            }
        });
        selectionPanel.add(confirm);
        selectionPanel.add(cancel);
        mainMenu.add(current);
        mainMenu.add(possible);
        mainMenu.add(options);
        mainMenu.add(selectionPanel);
        mainMenu.setVisible(true);
    }
    
    public void setUpOptions(){
        ArrayList<Character> optionList = player.getPossibleCharacters();
        for(Character i : optionList){
            options.addItem(i.getName() + " Lv" + i.getLevel());
        }
    } 
    public void change(){
        ArrayList<Character> optionList = player.getPossibleCharacters();
        ArrayList<Character> tempList = new ArrayList<Character>();
        String[] temp = changeTo.split(" ");
        changeTo = temp[0];
        if(changeTo.equals("Assassin")){
            tempList.add(player.getActiveCharacter());
            System.out.println("1234");
            for(Character i : optionList){
                if (i.getName().equals("Assassin")){
                    player.setActiveCharacter(i);
                }else if(i.getName().equals("Warrior")){
                    tempList.add(i);
                    System.out.println("1");
                }else if(i.getName().equals("Mage")){
                    tempList.add(i);
                    System.out.println("2");
                }else if(i.getName().equals("Boss")){
                    tempList.add(i);
                    System.out.println("3");
                }
            }
        }else if(changeTo.equals("Warrior")){
            tempList.add(player.getActiveCharacter());
            for(Character i : optionList){
                if (i.getName().equals("Warrior")){
                    player.setActiveCharacter(i);
                }else if(i.getName().equals("Assassin")){
                    tempList.add(i);
                }else if(i.getName().equals("Mage")){
                    tempList.add(i);
                }else if(i.getName().equals("Boss")){
                    tempList.add(i);
                }
            }
        }else if(changeTo.equals("Mage")){
            tempList.add(player.getActiveCharacter());
            for(Character i : optionList){
                if (i.getName().equals("Mage")){
                    player.setActiveCharacter(i);
                }else if(i.getName().equals("Warrior")){
                    tempList.add(i);
                }else if(i.getName().equals("Assassin")){
                    tempList.add(i);
                }else if(i.getName().equals("Boss")){
                    tempList.add(i);
                }
            }
        }else if (changeTo.equals("Boss")){
            tempList.add(player.getActiveCharacter());
            for(Character i : optionList){
                if (i.getName().equals("Boss")){
                    player.setActiveCharacter(i);
                }else if(i.getName().equals("Warrior")){
                    tempList.add(i);
                }else if(i.getName().equals("Assassin")){
                    tempList.add(i);
                }else if(i.getName().equals("Mage")){
                    tempList.add(i);
                }
            }
        }else{
            tempList = optionList;
        }
        player.setPossibleCharacterList(tempList);
    }
    public void goBack(){
        ChoseLevel choseLevel = new ChoseLevel(player);
        mainMenu.dispose();
    }
}
