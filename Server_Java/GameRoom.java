package Server_Java;

import java.time.LocalDateTime;
import java.util.*;

public class GameRoom {
    private ArrayList<User> listOfPlayers = new ArrayList<>();
    private HashMap<String, Integer> playerWins = new HashMap<>();
    private HashMap<String, Integer> roundScores = new HashMap<>();
    private String gameRoomStatus = null;
    private String[] letters;
    private LocalDateTime gameStart;

    public GameRoom(User user){
        this.listOfPlayers.add(user);
        this.gameRoomStatus = "FindingPlayers";
        letters = generateLetters();
    }

    public String checkWins(){
        String winner = "None";

        for(Map.Entry<String, Integer> entry: playerWins.entrySet()){
            if (entry.getValue() >= 3){
                winner = entry.getKey();
                return winner;
            }
        }
        return winner;
    }

    public boolean checkStatus(){
        for(User user: listOfPlayers){
            if(Objects.equals(user.getStatus(), "Default")){
                return false;
            }
        }
        return true;
    }

    public void resetStatus(){
        for(User user: listOfPlayers){
            user.setStatus("Default");
        }
    }

    public HashMap<String, Integer> fillHash(){
        HashMap<String, Integer> map = new HashMap<>();
        for(User user: listOfPlayers){
            map.put(user.getUsername(), 0);
        }
        return map;
    }

    public String[] generateLetters(){
        final String[] vowels = {"A", "E", "I", "O", "U"};
        final String[] consonants = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z"};
        String[] generatedLetters = new String[17];
        int vowelCount = 0;
        Random random = new Random();
        for (int i = 0; i <= 16; i++) {
            String letter;
            if (vowelCount < 5) {
                letter = vowels[random.nextInt(vowels.length)];
                vowelCount++;
            } else {
                letter = consonants[random.nextInt(consonants.length)];
            }
            generatedLetters[i] = letter;
        }
        return generatedLetters;
    }

    public String getRoundWinner(){
        String winner = "";
        int highestScore = 0;
        boolean tie = false;

        for(Map.Entry<String, Integer> entry: roundScores.entrySet()){
            int value = entry.getValue();
            if (value > highestScore){
                highestScore = value;
                winner = entry.getKey();
                tie = false;
            } else if (value == highestScore) {
                tie = true;
            }
        }
        if (tie) {
            return "Tie";
        } else {
            return winner;
        }
    }

    public void addToWins(String winner){
        playerWins.replace(winner, playerWins.get(winner) + 1);
    }

    public boolean checkExistence(String username){
        for(User user: listOfPlayers){
            if(Objects.equals(user.getUsername(), username)){
                return true;
            }
        }
        return false;
    }

    public void setRoomTime() {
        gameStart = LocalDateTime.now();
    }

    public LocalDateTime getGameStart() {
        return gameStart;
    }

    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

    public ArrayList<User> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(ArrayList<User> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public HashMap<String, Integer> getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(HashMap<String, Integer> playerWins) {
        this.playerWins = playerWins;
    }

    public String getGameRoomStatus() {
        return gameRoomStatus;
    }

    public void setGameRoomStatus(String gameRoomStatus) {
        this.gameRoomStatus = gameRoomStatus;
    }

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public HashMap<String, Integer> getRoundScores() {
        return roundScores;
    }

    public void setRoundScores(HashMap<String, Integer> roundScores) {
        this.roundScores = roundScores;
    }

}
