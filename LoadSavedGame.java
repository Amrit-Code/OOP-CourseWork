import java.io.*;
import java.util.*;
public class LoadSavedGame
{
    private String fileName;
    private PlayerProfile player;
    public LoadSavedGame(String fileName){
        this.fileName = fileName;
    }
    public PlayerProfile loadGame(){
        int levelsUnlocked = 1;
        String currentLine = null;
        ArrayList<Character> tempList = new ArrayList<Character>();
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            levelsUnlocked = Integer.parseInt(bufferedReader.readLine());
            while((currentLine = bufferedReader.readLine()) != null){
                String[] currentArray = currentLine.split(" ");
                if(currentArray[0].equals("Assassin")){
                    Character tempCharacter = new Assassin(Integer.parseInt(currentArray[1]));
                    tempList.add(tempCharacter);
                    System.out.println("1");
                }else if(currentArray[0].equals("Mage")){
                    Character tempCharacter = new Mage(Integer.parseInt(currentArray[1]));
                    tempList.add(tempCharacter);
                    System.out.println("2");
                }else if(currentArray[0].equals("Warrior")){
                    Character tempCharacter = new Warrior(Integer.parseInt(currentArray[1]));
                    tempList.add(tempCharacter);
                    System.out.println("3");
                }else if(currentArray[0].equals("Boss")){
                    Character tempCharacter = new Boss(Integer.parseInt(currentArray[1]));
                    tempList.add(tempCharacter);
                    System.out.println("4");
                }
            }
        }catch(Exception e){
            System.out.println("Opps, Something whent wrong...");
        }
        System.out.println(tempList);
        System.out.println(levelsUnlocked);
        player = new PlayerProfile(tempList, levelsUnlocked);
        return player;
    }
}
