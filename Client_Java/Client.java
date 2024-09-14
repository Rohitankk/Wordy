package Client_Java;
import Client_Java.GUI.*;
import Client_Java.WordyApp.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Client implements ActionListener, Runnable {

    static Wordy wordyImpl;
    private LoginPage loginPage;
    private HomePage wordyHomeInterface;
    private Instructions instructionsPage;
    private Game gamePage;
    private WinnerPage winnerPage;
    private String username;
    private Thread thread;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ss.SSS");
    private RoundWinnerPage roundWinnerPage;
    private LoadGameFor5Seconds loadGameFor5Seconds;
    private LeaderBoardsPage leaderBoardsPage;

    public void initializeClient(String[] args){
        try{
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Wordy";
            wordyImpl = (Wordy) WordyHelper.narrow(ncRef.resolve_str(name));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addWordyHomeActionListeners(){
        wordyHomeInterface.getInstructionsBT().addActionListener(this);
        wordyHomeInterface.getStartGameBT().addActionListener(this);
        wordyHomeInterface.getLeaderBoardsButton().addActionListener(this);
        wordyHomeInterface.getLogoutButton().addActionListener(this);
    }
    public void addInstructionsPageListeners(){
        instructionsPage.getBackBT().addActionListener(this);
    }
    public void addLoginActionListeners(){
        loginPage.getLoginButton().addActionListener(this);
    }
    public void addGamePageActionListeners(){
        gamePage.getClearButton().addActionListener(this);
        gamePage.getSendWordButton().addActionListener(this);}
    public void addWinnerPageActionListeners(){winnerPage.getHomeButton().addActionListener(this);}
    public void addLeaderBoardsActionListeners(){leaderBoardsPage.getBackButton().addActionListener(this);}
    public void addRoundWinnerActionListeners(){roundWinnerPage.getNextRoundBT().addActionListener(this);}

    public void initializeHome(){
        loginPage.dispose();
        wordyHomeInterface = new HomePage();
        instructionsPage= new Instructions();
        gamePage= new Game();
        wordyHomeInterface.displayHome(username);
        addWordyHomeActionListeners();

    }
    public void initializeInstructions(){
        wordyHomeInterface.dispose();
        instructionsPage.displayInstructions();
        addInstructionsPageListeners();
    }
    public void initializeGame(){
        loadGameFor5Seconds.dispose();
        gamePage.displayGame(username);
        addGamePageActionListeners();

    }
    public void initializeLogin(){
        loginPage= new LoginPage();
        loginPage.displayLogin();
        addLoginActionListeners();
    }
    public void initializeLeaderBoards(String[][] wins, String[][] words){
        leaderBoardsPage = new LeaderBoardsPage();
        leaderBoardsPage.fillTables(wins, words);
        leaderBoardsPage.initComponents();
        leaderBoardsPage.displayLeaderBoards();
        addLeaderBoardsActionListeners();
    }
    public void initializeWinnerPage(String username){
        gamePage.dispose();
        winnerPage= new WinnerPage();
        winnerPage.displayWinnerPage(username);
        addWinnerPageActionListeners();
    }
    public void initializeRoundWinner(String username){
        gamePage.dispose();
        roundWinnerPage = new RoundWinnerPage();
        roundWinnerPage.displayRoundWinner(username);
        addRoundWinnerActionListeners();
    }

    public void initializeDraw(){
        gamePage.dispose();
        roundWinnerPage = new RoundWinnerPage();
        roundWinnerPage.Draw();
        addRoundWinnerActionListeners();
    }
    public void  initializeLoadGame(){
        wordyHomeInterface.dispose();
        loadGameFor5Seconds = new LoadGameFor5Seconds();
        loadGameFor5Seconds.displayLoadingGame();
    }

    public void initializeLoadGame2(){
        loadGameFor5Seconds.dispose();
        loadGameFor5Seconds = new LoadGameFor5Seconds();
        loadGameFor5Seconds.displayLoadingGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // LOGIN
        if (e.getSource().equals(loginPage.getLoginButton())){
            String username = loginPage.getUserNameTF().getText();
            String password = String.valueOf(loginPage.getPasswordTF().getPassword());
            String result = " ";
            try {
                result = wordyImpl.login(username, password);
                if(Objects.equals(result, "Success")){
                    this.username = username;
                    System.out.println(username + " logged in successfully. Welcome!");
                    initializeHome();
                }
                else if (Objects.equals(result, "UsernameMismatch")){
                    throw new usernameMismatch();
                }
                else{
                    throw new alreadyLoggedIn();
                }
            } catch (usernameMismatch ex) {
                JOptionPane.showMessageDialog(new Frame(),"User does not exist!",
                        "No Such User", JOptionPane.INFORMATION_MESSAGE);
            } catch (alreadyLoggedIn ex){
                JOptionPane.showMessageDialog(new Frame(),"User already online!",
                        "Already Online", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if (e.getSource().equals(wordyHomeInterface.getInstructionsBT())){
            initializeInstructions();

        }else if (e.getSource().equals(wordyHomeInterface.getStartGameBT())){
            try {
                wordyHomeInterface.getStartGameBT().setEnabled(false);
                JPanel glassPane = new JPanel();
                glassPane.setLayout(null);
                glassPane.setBackground(new Color(30,19,70,225));
                JLabel WaitingLabel= new JLabel();
                WaitingLabel.setIcon(new ImageIcon("res/WaitingLabel.png"));
                glassPane.add(WaitingLabel);
                WaitingLabel.setBounds(440, 315,560,80);
                wordyHomeInterface.setGlassPane(glassPane);
                glassPane.setVisible(true);

                initializeLoadGame();
                if(!wordyImpl.startGame(username)){
                    loadGameFor5Seconds.dispose();
                    initializeHome();
                    throw new playersNotFound();
                }

                else {
                        initializeLoadGame2();
                        while (true) {
                            if (wordyImpl.checkTime(username, 5)) {
                                break;
                            }
                        }
                        thread = new Thread(this, "TimerThread");
                        thread.start();

                        initializeGame();

                        JButton[] letterButtons = gamePage.getLetterButtons();
                        String[] temp = wordyImpl.requestLetters(username);
                        for (int i = 0; i < temp.length; i++) {
                            String letter = temp[i];

                            ImageIcon imageIcon = new ImageIcon("res/" + letter + ".png");

                            letterButtons[i].setIcon(imageIcon);
                            letterButtons[i].setText(letter);

                            int finalI = i;
                            letterButtons[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    gamePage.getjTextField1().setText(gamePage.getjTextField1().getText() + letterButtons[finalI].getText());

                                }
                            });
                        }
                    //}
                }
            }catch (playersNotFound ex) {
                JOptionPane.showMessageDialog(new Frame(),"No players found! Try again.",
                        "No Players Found", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if (e.getSource().equals(instructionsPage.getBackBT())){
            instructionsPage.dispose();
            initializeHome();
        }else if (e.getSource().equals(gamePage.getClearButton())){
            JButton[] letterButtons= gamePage.getLetterButtons();
            gamePage.getjTextField1().setText("");
            for (int i=0; i<letterButtons.length;i++){
                letterButtons[i].setEnabled(true);
            }
        }
        else if(e.getSource().equals(gamePage.getSendWordButton())){
            System.out.println(username + "submitted the word: " + gamePage.getjTextField1().getText().toLowerCase());
            String result = "";
            try {
                result = wordyImpl.sendWord(username, gamePage.getjTextField1().getText().toLowerCase());

                if(Objects.equals(result, "InvalidWordLength")){
                    throw new invalidWordLength();
                }
                else if(Objects.equals(result, "InvalidWord")){
                    throw new invalidWord();
                }

            } catch (invalidWordLength ex) {
                JOptionPane.showMessageDialog(new Frame(),"Word must be equal to or greater than 5! Try again.",
                        "Invalid Word Length", JOptionPane.INFORMATION_MESSAGE);
            } catch (invalidWord ex) {
                JOptionPane.showMessageDialog(new Frame(),"Invalid word! Try again.",
                        "Invalid Word", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if (e.getSource().equals(wordyHomeInterface.getLeaderBoardsButton())){
            wordyHomeInterface.dispose();
            initializeLeaderBoards(wordyImpl.getTopPlayers(), wordyImpl.getTopWords());

        } else if(e.getSource().equals(wordyHomeInterface.getLogoutButton())){
            wordyImpl.signOut(username);
            wordyHomeInterface.dispose();
            initializeLogin();
        }
//        else if (e.getSource().equals(leaderBoardsPage.getBackButton())){
//            leaderBoardsPage.dispose();
//            initializeHome();
//        }
        else if (e.getSource().equals(roundWinnerPage.getNextRoundBT())){
            loadGameFor5Seconds.displayLoadingGame();
            roundWinnerPage.dispose();
            while(true) {
                if(wordyImpl.checkReadyStatus(username)){
                    break;
                }
            }
            gamePage = new Game();

            thread = new Thread(this, "TimerThread");
            thread.start();
            initializeGame();

            JButton[] letterButtons = gamePage.getLetterButtons();
            String[] temp = wordyImpl.requestLetters(username);
            for (int i = 0; i < temp.length; i++) {
                String letter = temp[i];

                ImageIcon imageIcon = new ImageIcon("res/" + letter + ".png");

                letterButtons[i].setIcon(imageIcon);
                letterButtons[i].setText(letter);

                int finalI = i;
                letterButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gamePage.getjTextField1().setText(gamePage.getjTextField1().getText() + letterButtons[finalI].getText());

                    }
                });
            }
        } else if(e.getSource().equals(winnerPage.getHomeButton())){
            winnerPage.dispose();
            //wordyHomeInterface.getStartGameBT().setEnabled(true);
            initializeHome();
        }
    }


    public void run() {
        try {
            while (true) {
                if (wordyImpl.checkTime(username, 15)) {
                    String winner = wordyImpl.getGameWinner(username);
                    if(!Objects.equals(winner, "None")){
                        initializeWinnerPage(winner);
                        break;
                    }
                    winner = wordyImpl.getRoundWinner(username);
                    if(winner.equals("Tie")){
                        initializeDraw(); //REPLACE WITH DRAW INTERFACE
                    }
                    else{
                        initializeRoundWinner(winner);
                    }
                    break;
                }
                else{
                }
            }
            Thread.sleep(50);
        } catch (java.lang.InterruptedException e){
            e.printStackTrace();
        }
    }




    //                SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
//                    @Override
//                    protected Void doInBackground() throws Exception {
//                        Thread.sleep(10000);
//                        glassPane.setVisible(false);
//                        initializeLoadGame();
//                        Thread.sleep(5000);
//                        return null;
//                    }
//
//                    @Override
//                    protected void done() {
//                        initializeGame();
//                        int numVowels = 0;
//                        Random random = new Random();
//                        JButton[] letterButtons = gamePage.getLetterButtons();
//                        for (int i = 0; i <= NUM_LETTERS; i++) {
//                            String letter;
//                            if (numVowels < NUM_VOWELS) {
//                                letter = VOWELS[random.nextInt(VOWELS.length)];
//                                numVowels++;
//                            } else {
//                                letter = ALPHABET[random.nextInt(ALPHABET.length)];
//                            }
//                            ImageIcon imageIcon = new ImageIcon("res/" + letter + ".png");
//
//                            letterButtons[i].setIcon(imageIcon);
//                            letterButtons[i].setText(letter);
//
//                            int finalI = i;
//                            letterButtons[i].addActionListener(new ActionListener() {
//                                @Override
//                                public void actionPerformed(ActionEvent e) {
//                                    letterButtons[finalI].setEnabled(false);
//                                    gamePage.getjTextField1().setText(gamePage.getjTextField1().getText() + letterButtons[finalI].getText());
//
//                                }
//                            });
//                        }
//                    }
//                };
//                worker.execute();

    public static void main(String[] args) {
        Client client = new Client();
        client.initializeClient(args);
        client.initializeLogin();
    }
}