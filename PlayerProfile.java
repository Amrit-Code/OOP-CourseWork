import java.util.*;
public class PlayerProfile
{
    private ArrayList<Character> playersCharacters;
    private ArrayList<Character> PossiblePlayerCharacters;
    private Character activeCharacter;
    private int levelsUnlocked;
    
    public PlayerProfile(){
        playersCharacters = new ArrayList<Character>();
        levelsUnlocked = 1;
        PossiblePlayerCharacters = new ArrayList<Character>();
        setUpPossiblePlayerCharacters();
        activeCharacter = playersCharacters.get(0);
    }
    public PlayerProfile(ArrayList<Character> playersCharacters, int levelsUnlocked){
        this.playersCharacters = playersCharacters;
        this.levelsUnlocked = levelsUnlocked;
        PossiblePlayerCharacters = new ArrayList<Character>();
        for(int i = 0; i < playersCharacters.size(); i++){
            if(i == 0){
                activeCharacter = playersCharacters.get(0);
            }else{
                PossiblePlayerCharacters.add(playersCharacters.get(i));
            }
        }
    }
    private void setUpPossiblePlayerCharacters(){
        playersCharacters.add((Character)new Warrior());
        PossiblePlayerCharacters.add((Character)new Assassin());
        PossiblePlayerCharacters.add((Character)new Mage());
        PossiblePlayerCharacters.add((Character)new Boss());
    }
    public void addCharacter(Character minion){
        playersCharacters.add(minion);
    }
    public void changeUnlockedLevels(int levelsUnlocked){
        this.levelsUnlocked = levelsUnlocked;
    }
    public ArrayList<Character> getPlayesCharacters(){
        return playersCharacters;
    }
    public int getLevelsUnlocked(){
        return levelsUnlocked;
    }
    public ArrayList<Character> getPossibleCharacters(){
        return PossiblePlayerCharacters;
    }
    public Character getActiveCharacter(){
        return activeCharacter;
    }
    public void setActiveCharacter(Character c){
        activeCharacter = c;
    }
    public void setPossibleCharacterList(ArrayList<Character> list){
        PossiblePlayerCharacters = list;
    }
    public void setLevelsUnlocked(int no){
        levelsUnlocked = no;
    }
}
