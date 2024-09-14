package Server_Java;

import Server_Java.WordyApp.WordyPOA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WordyImpl extends WordyPOA {
    static Connection con;
    static HashMap<String, GameRoom> rooms = new HashMap<>();
    static HashMap<String, User> players = new HashMap<>();
    Set<String> words = new HashSet<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss");

    public WordyImpl(){
        setConnection();
        fillWordsSet();
    }

    public static void setConnection() {
        try{
            String conStr = "jdbc:mysql://localhost:3306/wordy_db?user=root&password=";
            con = DriverManager.getConnection(conStr);
        } catch (Exception e) {
            System.out.println("|--------------------------------------------------------------------------------------------------|");
            System.out.println("| CONNECTION PROBLEM TO DATABASE                                                                   |");
            System.out.println("|--------------------------------------------------------------------------------------------------|");
            System.out.println("| To troubleshoot, either check the following:                                                     |");
            System.out.println("| a. Ensure the server is on.                                                                      |");
            System.out.println("| b. Check if the right mysql connector is added to the project's library.                         |");
            System.out.println("| c. Check if the database exist on the server.                                                    |");
            System.out.println("| d. Check the url that the DriverManager is accessing or getting.                                 |");
            System.out.println("|     e.g. -> jdbc:mysql://[host]:[port]/[database][?user][=username]&[password][=password_value]  |");
            System.out.println("|--------------------------------------------------------------------------------------------------|");
            System.out.println();
            System.exit(0);
        }
    }

    public void fillWordsSet() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Server_Java/res/words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String login(String username, String password) {
        boolean isValid = false;
        String status = null;
        try{
            String query = "SELECT * FROM user WHERE user.username = ? AND user.password = ?";
            PreparedStatement statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("userID");
                String uname = resultSet.getString("username");
                String pword = resultSet.getString("password");
                if(Objects.equals(resultSet.getString("status"), "Offline")) {
                    status = "Online";
                }
                else{
                    return "AlreadyOnline";
                }

                User user = new User(id, uname, pword, "Default");
                players.put(uname, user);
                //ADD CODE TO SET USER AS ONLINE IN DATABASE
                query = "UPDATE user SET status = ? WHERE user.userID = ?";
                try{
                    statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    statement.setString(1, "Online");
                    statement.setInt(2, id);
                    statement.execute();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            else {
                return "UsernameMismatch";
            }

            resultSet.close();
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(username + "logged in successfully!");
        return "Success";
    }

    @Override
    public void signOut(String username){
        User user = players.get(username);
        int userID = user.getUserID();
        String query = "UPDATE user SET status = ? WHERE user.userID = ?";
        try{
            PreparedStatement statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setString(1, "Offline");
            statement.setInt(2, userID);
            statement.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean checkReadyStatus(String username){
        String creator = getCreator(username);
        ArrayList<User> users = rooms.get(creator).getListOfPlayers();
        for(User user: users){
            if(Objects.equals(user.getUsername(), username)){
                user.setStatus("Ready");
            }
        }
        rooms.get(creator).setLetters(rooms.get(creator).generateLetters());
        rooms.get(creator).setListOfPlayers(users);
        while(true){
            if(rooms.get(creator).checkStatus()){
                if(creator.equals(username)){
                    resetTime(creator);
                    rooms.get(creator).setRoundScores(rooms.get(creator).fillHash());
                }
                return true;
            }
        }
    }

    //LOADING
    @Override
    public boolean startGame(String username){
        boolean gameStarted = false;
        User user = players.get(username);
        GameRoom newRoom = null;
        String key = "";
        for (Map.Entry<String, GameRoom> room : rooms.entrySet()) {
            if (room.getValue().getGameRoomStatus().equals("FindingPlayers")) {
                key = room.getKey();
                System.out.println(username + " has joined " + room.getKey() + " 's  game room.");
                room.getValue().getListOfPlayers().add(user);
                gameStarted = true;
                while (true) {
                    if (Objects.equals(rooms.get(key).getGameRoomStatus(), "GameOngoing")) {
                        return gameStarted;
                    }
                }
            }
        }
        newRoom = new GameRoom(user);
        rooms.put(user.getUsername(), newRoom);
        System.out.println(username + " has created a new game room.");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = now.plusSeconds(10);
        while(true){
            if(formatter.format(LocalDateTime.now()).equals(formatter.format(later))){
                if(rooms.get(user.getUsername()).getListOfPlayers().size() >= 2) {
                    rooms.get(user.getUsername()).setRoundScores(rooms.get(user.getUsername()).fillHash());
                    System.out.println(username + "'s game room is now ongoing.");
                    rooms.get(user.getUsername()).setGameRoomStatus("GameOngoing");
                    rooms.get(user.getUsername()).setPlayerWins(rooms.get(user.getUsername()).fillHash());
                    rooms.get(user.getUsername()).setRoomTime();
                    return true;
                }
                else{
                    rooms.remove(username);
                    System.out.println(username + "'s game room has been destroyed.");
                    return false;
                }
            }
        }
    }

    public String getCreator(String username){
        for (Map.Entry<String, GameRoom> room : rooms.entrySet()){
            for(User user: room.getValue().getListOfPlayers()){
                if(Objects.equals(user.getUsername(), username)){
                    return room.getKey();
                }
            }
        }
        return null;
    }

    @Override
    public boolean checkTime(String username, int interval){
        String creator = getCreator(username);
        LocalDateTime start = rooms.get(creator).getGameStart();
        return formatter.format(LocalDateTime.now()).
                equals(formatter.format(start.plusSeconds(interval)));
    }

    public void resetTime(String creator){
        rooms.get(creator).setRoomTime();
    }

    public void removePlayer(String player){
        String creator = getCreator(player);
        ArrayList<User> players = rooms.get(creator).getListOfPlayers();
        for(User user: players){{
            if(Objects.equals(user.getUsername(), player)){
                players.remove(user);
                rooms.get(creator).setListOfPlayers(players);
                break;
            }
        }}
    }
    @Override
    public String getRoundWinner(String username) {
        String creator = getCreator(username);
        rooms.get(creator).resetStatus();
        String winner = rooms.get(creator).getRoundWinner();
        if(Objects.equals(username, creator) && !Objects.equals(winner, "Tie")){
            rooms.get(creator).addToWins(winner);
        }
        return winner;
    }

    @Override
    public String getGameWinner(String username) {
        String creator = getCreator(username);
        String winner = rooms.get(creator).checkWins();
        rooms.get(creator).resetStatus();
        if(!Objects.equals(winner, "None")) {
            removePlayer(username);
            if (Objects.equals(username, creator)) {
                while (true) {
                    if (rooms.get(creator).getListOfPlayers().isEmpty()) {
                        rooms.remove(creator);
                        updateWins(winner);
                        break;
                    }
                }
            }
        }
        return winner;
    }

    @Override
    public String[][] getTopPlayers() {
        String[][] topPlayers = new String[5][2];
        try {
            String query = "SELECT user.username, userwins.wins FROM userwins " +
                    "NATURAL JOIN user ORDER BY userwins.wins DESC LIMIT 5";
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(query);
            rs.beforeFirst();

            int i = 0;
            while(rs.next()){
                topPlayers[i][0] = rs.getString(1);
                topPlayers[i][1] = rs.getString(2);
                i++;
            }
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return topPlayers;
    }


    @Override
    public String[][] getTopWords() {
        String[][] topWords = new String[5][2];
        try {
            String query = "SELECT user.username, longestwords.word FROM longestwords " +
                    "NATURAL JOIN user ORDER BY LENGTH(longestwords.word) DESC LIMIT 5";
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(query);
            rs.beforeFirst();

            int i = 0;
            while(rs.next()){
                topWords[i][0] = rs.getString(1);
                topWords[i][1] = rs.getString(2);
                i++;
            }
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return topWords;
    }

    @Override
    public String[] requestLetters(String username) {
        String[] letters = new String[17];
        for (Map.Entry<String, GameRoom> room : rooms.entrySet()){
            if(room.getValue().checkExistence(username)){
                letters = room.getValue().getLetters();
            }
        }
        return letters;
    }

    @Override
    public String sendWord(String username, String word) {
        checkLongestWord(username, word);
        if(words.contains(word) && word.length() >= 5){
            String creator = getCreator(username);
            if(rooms.get(creator).getRoundScores().get(username) < word.length()){
                rooms.get(creator).getRoundScores().replace(username, word.length());
            }
            System.out.println(word);
            return "Success";
        }
        else if(!words.contains(word)){
            return "InvalidWord";
        }
        return "InvalidWordLength";
    }

    public void checkLongestWord(String username, String word) {
        User user = players.get(username);
        String query = "SELECT * FROM longestwords WHERE longestwords.userID = ?";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, user.getUserID());

            ResultSet resultSet = statement.executeQuery();
            resultSet.beforeFirst();
            while(resultSet.next()) {
                if (resultSet.getString(2) == null || resultSet.getString(2).length() < word.length()) {
                    query = "UPDATE longestwords SET longestwords.word = ? WHERE longestwords.userID = ?";
                    try {
                        statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        statement.setString(1, word);
                        statement.setInt(2, user.getUserID());
                        statement.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWins(String username){
        User user = players.get(username);
        String query = "UPDATE userwins SET wins = wins + 1 WHERE userID = ?";

        try{
            PreparedStatement statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, user.getUserID());
            statement.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WordyImpl wr = new WordyImpl();
        String[][] wins = wr.getTopWords();
        for(int i = 0; i < wins.length; i++){
            for(int j = 0; j < wins[i].length; j++){
                System.out.print(wins[i][j] + ", ");
            }
        }
    }
}

