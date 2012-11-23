import javax.swing.*;
import java.awt.*;
public class Game
{
	int mainPot = 0;
	int sabaccPot = 0;
	int numToDeal = 2;
	int numPlayers = 4;
	int roundNum = 0;
	int cardNum = 0;
	DeckList gameDeck;
	AIPlayer cpu1 = new AIPlayer();
	AIPlayer cpu2 = new AIPlayer();
	AIPlayer cpu3 = new AIPlayer();
	AIPlayer cpu4 = new AIPlayer();
	AIPlayer cpu5 = new AIPlayer();
	Font font = new Font("monospaced",Font.BOLD,16);
	Player player = new Player();
	JFrame playerHand = new JFrame("Player Hand");
	JPanel playerBase = new JPanel(new BorderLayout());
	JPanel playerTop = new JPanel(new FlowLayout());
	JPanel playerCenter = new JPanel();
	JPanel playerBottom = new JPanel(new FlowLayout());
	JTextArea playerCard1 = new JTextArea();
	JTextArea playerCard2 = new JTextArea();
	JTextArea playerCard3 = new JTextArea();
	JTextArea playerCard4 = new JTextArea();
	JTextArea playerCard5 = new JTextArea();
	JTextArea playerCard6 = new JTextArea();
	JTextArea playerCard7 = new JTextArea();
	JTextArea playerCard8 = new JTextArea();
	JLabel playerCash = new JLabel();
	JLabel playerPoints = new JLabel();
	JButton bet = new JButton("Bet");
	JButton fold = new JButton("Fold");
	JButton end = new JButton("End Turn");
	JButton call = new JButton("Call Hand");
	JButton draw = new JButton("Draw Card");
	JFrame comHand1 = new JFrame(cpu1.getName() + "'s Hand");
	JPanel comHand1Panel = new JPanel();
	JFrame comHand2 = new JFrame(cpu2.getName() + "'s Hand");
	JPanel comHand2Panel = new JPanel();
	JFrame comHand3 = new JFrame(cpu3.getName() + "'s Hand");
	JPanel comHand3Panel = new JPanel();
	JFrame comHand4 = new JFrame(cpu4.getName() + "'s Hand");
	JPanel comHand4Panel = new JPanel();
	JFrame comHand5 = new JFrame(cpu5.getName() + "'s Hand");
	JPanel comHand5Panel = new JPanel();
	JTextArea cpu1Card1 = new JTextArea();				// Makes cards
	JTextArea cpu1Card2 = new JTextArea();
	JTextArea cpu1Card3 = new JTextArea();
	JTextArea cpu1Card4 = new JTextArea();
	JTextArea cpu1Card5 = new JTextArea();
	JTextArea cpu1Card6 = new JTextArea();
	JTextArea cpu1Card7 = new JTextArea();
	JTextArea cpu1Card8 = new JTextArea();
	JLabel cpu1Cash = new JLabel("Credits: " + cpu1.getCredits());
	JTextArea cpu2Card1 = new JTextArea();
	JTextArea cpu2Card2 = new JTextArea();
	JTextArea cpu2Card3 = new JTextArea();
	JTextArea cpu2Card4 = new JTextArea();
	JTextArea cpu2Card5 = new JTextArea();
	JTextArea cpu2Card6 = new JTextArea();
	JTextArea cpu2Card7 = new JTextArea();
	JTextArea cpu2Card8 = new JTextArea();
	JLabel cpu2Cash = new JLabel("Credits: " + cpu2.getCredits());
	JTextArea cpu3Card1 = new JTextArea();
	JTextArea cpu3Card2 = new JTextArea();
	JTextArea cpu3Card3 = new JTextArea();
	JTextArea cpu3Card4 = new JTextArea();
	JTextArea cpu3Card5 = new JTextArea();
	JTextArea cpu3Card6 = new JTextArea();
	JTextArea cpu3Card7 = new JTextArea();
	JTextArea cpu3Card8 = new JTextArea();
	JLabel cpu3Cash = new JLabel("Credits: " + cpu3.getCredits());
	JTextArea cpu4Card1 = new JTextArea();
	JTextArea cpu4Card2 = new JTextArea();
	JTextArea cpu4Card3 = new JTextArea();
	JTextArea cpu4Card4 = new JTextArea();
	JTextArea cpu4Card5 = new JTextArea();
	JTextArea cpu4Card6 = new JTextArea();
	JTextArea cpu4Card7 = new JTextArea();
	JTextArea cpu4Card8 = new JTextArea();
	JLabel cpu4Cash = new JLabel("Credits: " + cpu4.getCredits());
	JTextArea cpu5Card1 = new JTextArea();
	JTextArea cpu5Card2 = new JTextArea();
	JTextArea cpu5Card3 = new JTextArea();
	JTextArea cpu5Card4 = new JTextArea();
	JTextArea cpu5Card5 = new JTextArea();
	JTextArea cpu5Card6 = new JTextArea();
	JTextArea cpu5Card7 = new JTextArea();
	JTextArea cpu5Card8 = new JTextArea();
	JLabel cpu5Cash = new JLabel("Credits: " + cpu5.getCredits());
	JFrame gameWindow = new JFrame("Sabacc, by Luke Stanley");
	JPanel gameWindowTop = new JPanel();
	JPanel gameWindowBottom = new JPanel();
	JPanel gameWindowCenter = new JPanel();
	JButton newGameButton = new JButton("New Game    ");
	JButton exitProgramButton = new JButton("Exit Program");
	JButton optionsButton = new JButton("Options     ");
	JButton creditsButton = new JButton("Game Credits");
	String[] listEntries = {"Four players","Five players","Six players",};
	JComboBox playerNumBox = new JComboBox(listEntries);
	JFrame options = new JFrame("Options");
	JPanel optionsTop = new JPanel();
	JPanel optionsBottom = new JPanel();
	JPanel optionsTopLayer1 = new JPanel();
	JPanel optionsTopLayer2 = new JPanel();
	JPanel optionsTopLayer3 = new JPanel();
	JPanel optionsTopLayer4 = new JPanel();
	JPanel optionsTopLayer5 = new JPanel();
	JPanel optionsTopLayer6 = new JPanel();
	JPanel optionsTopLayer7 = new JPanel();
	String[] cardsToDealStr = {"2","3","4","5"};
	String[] riskOptions = {"Cautious","Normal","Risky"};
	JComboBox cardsToDealBox = new JComboBox(cardsToDealStr);
	JLabel optionsLabelCardDeal = new JLabel("Number of cards to deal");
	JLabel playerNameLabel = new JLabel("Player name:");
	JLabel cpuNameLabel1 = new JLabel("CPU1 name:");
	JLabel cpuNameLabel2 = new JLabel("CPU2 name:");
	JLabel cpuNameLabel3 = new JLabel("CPU3 name:");
	JLabel cpuNameLabel4 = new JLabel("CPU4 name:");
	JLabel cpuNameLabel5 = new JLabel("CPU5 name:");
	JLabel riskLabel = new JLabel(" RISK: ");
	JLabel playerCashLabel = new JLabel("            Player Credits:");
	JLabel cpu1CashLabel = new JLabel("CPU1 Credits:");
	JLabel cpu2CashLabel = new JLabel("CPU2 Credits:");
	JLabel cpu3CashLabel = new JLabel("CPU3 Credits:");
	JLabel cpu4CashLabel = new JLabel("CPU4 Credits:");
	JLabel cpu5CashLabel = new JLabel("CPU5 Credits:");
	JTextField playerNameField = new JTextField(10);
	JTextField cpu1NameField = new JTextField(10);
	JTextField cpu2NameField = new JTextField(10);
	JTextField cpu3NameField = new JTextField(10);
	JTextField cpu4NameField = new JTextField(10);
	JTextField cpu5NameField = new JTextField(10);
	JTextField playerCashField = new JTextField(10);
	JTextField cpu1CashField = new JTextField(10);
	JTextField cpu2CashField = new JTextField(10);
	JTextField cpu3CashField = new JTextField(10);
	JTextField cpu4CashField = new JTextField(10);
	JTextField cpu5CashField = new JTextField(10);
	JComboBox cpu1RiskBox = new JComboBox(riskOptions);
	JComboBox cpu2RiskBox = new JComboBox(riskOptions);
	JComboBox cpu3RiskBox = new JComboBox(riskOptions);
	JComboBox cpu4RiskBox = new JComboBox(riskOptions);
	JComboBox cpu5RiskBox = new JComboBox(riskOptions);
	JButton apply = new JButton("Apply");
	JButton close = new JButton("Close");
	JFrame matchBetWindow = new JFrame("Match bet?");
	JPanel matchBetTop = new JPanel();
	JPanel matchBetBottom = new JPanel();
	JLabel matchBetLabel = new JLabel();
	JButton matchBetYes = new JButton("Match");
	JButton matchBetNo = new JButton("Forfeit Game");
	JFrame creditFrame = new JFrame("Lame Credits");																	//	 mmm    	good to go
	JFrame log = new JFrame("Log");									// d 0_0 b	<-------------
	JPanel logPanel = new JPanel(new FlowLayout());					//  \ | /
	JTextArea logText = new JTextArea(22,34);						//    |
	JScrollPane logBar= new JScrollPane(logText);					//   /^\																	// _/   \_
    public Game()
    {
    }
	public void play(DeckList d)
	{
		gameDeck = d;
		makeLog();
		makePlayerFrame();
		makeGameWindow();
		makeCPU1();
		makeCPU2();
		makeCPU3();
		makeCPU4();
		makeCPU5();
		makeOptions();
		makeBetWindow();
		deal();
		updatePlayerFrame();
		updateCPU1Hand();
		updateCPU2Hand();
		updateCPU3Hand();
		updateCPU4Hand();
		updateCPU5Hand();
		showPlayerHand(true);
		showGameWindow(true);
		showOptions(true);
		showCPU1Hand(true);
		showCPU2Hand(true);
		showCPU3Hand(true);
		showCPU4Hand(true);
		showCPU5Hand(true);
	}
	public void makeLog()
	{
		logBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		logBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		logPanel.add(logText);
		log.setResizable(false);
		log.getContentPane().add(BorderLayout.CENTER,logPanel);
		log.setSize(400,400);
		logText.setEditable(false);
		logText.setAutoscrolls(true);
		logText.setLineWrap(true);
		logText.setWrapStyleWord(true);
	}
	public void showLog(boolean t)
	{
		log.setVisible(t);
	}
	public void putLog(String s)
	{
		logText.append(s+ "\n");
	}
	public void makePlayerFrame()
	{
		playerHand.setSize(1000,215);
		playerTop.setSize(1000,125);
		playerCenter.setSize(1000,50);
		playerCenter.add(playerPoints);
		playerPoints.setText("Points: "+String.valueOf(player.getPoints()));
		playerBottom.setSize(1000,50);
		playerHand.getContentPane().add(BorderLayout.NORTH, playerTop);
		playerHand.getContentPane().add(BorderLayout.SOUTH, playerBottom);
		playerHand.getContentPane().add(BorderLayout.CENTER, playerCenter);
		playerCard1.setEditable(false);
		playerCard1.setBackground(player.cardMainColor(1));
		playerCard1.setForeground(player.cardTextColor(1));
		playerCard1.setFont(font);
		playerCard1.setText(player.getCardText(1));
		playerCard2.setText(player.getCardText(2));
		playerCard2.setEditable(false);
		playerCard2.setBackground(player.cardMainColor(2));
		playerCard2.setForeground(player.cardTextColor(2));
		playerCard2.setFont(font);
		playerCard3.setText(player.getCardText(3));
		playerCard3.setEditable(false);
		playerCard3.setBackground(player.cardMainColor(3));
		playerCard3.setForeground(player.cardTextColor(3));
		playerCard3.setFont(font);
		playerCard4.setText(player.getCardText(4));
		playerCard4.setEditable(false);
		playerCard4.setBackground(player.cardMainColor(4));
		playerCard4.setForeground(player.cardTextColor(4));
		playerCard4.setFont(font);
		playerCard5.setText(player.getCardText(5));
		playerCard5.setEditable(false);
		playerCard5.setBackground(player.cardMainColor(5));
		playerCard5.setForeground(player.cardTextColor(5));
		playerCard5.setFont(font);
		playerCard6.setText(player.getCardText(6));
		playerCard6.setEditable(false);
		playerCard6.setBackground(player.cardMainColor(6));
		playerCard6.setForeground(player.cardTextColor(6));
		playerCard6.setFont(font);
		playerCard7.setText(player.getCardText(7));
		playerCard7.setEditable(false);
		playerCard7.setBackground(player.cardMainColor(7));
		playerCard7.setForeground(player.cardTextColor(7));
		playerCard7.setFont(font);
		playerCard8.setText(player.getCardText(8));
		playerCard8.setEditable(false);
		playerCard8.setBackground(player.cardMainColor(8));
		playerCard8.setForeground(player.cardTextColor(8));
		playerCard8.setFont(font);
		playerTop.add(playerCard1);
		playerTop.add(playerCard2);
		playerTop.add(playerCard3);
		playerTop.add(playerCard4);
		playerTop.add(playerCard5);
		playerTop.add(playerCard6);
		playerTop.add(playerCard7);
		playerTop.add(playerCard8);
		playerBottom.add(playerCash);
		playerBottom.add(bet);
		playerBottom.add(fold);
		playerBottom.add(end);
		playerBottom.add(call);
		playerBottom.add(draw);
		playerCash.setText("Credits: "+ String.valueOf(player.getCredits()));
	}
	public void updatePlayerFrame()
	{
		playerCard1.setBackground(player.cardMainColor(1));
		playerCard1.setForeground(player.cardTextColor(1));
		playerCard2.setBackground(player.cardMainColor(2));
		playerCard2.setForeground(player.cardTextColor(2));
		playerCard3.setBackground(player.cardMainColor(3));
		playerCard3.setForeground(player.cardTextColor(3));
		playerCard4.setBackground(player.cardMainColor(4));
		playerCard4.setForeground(player.cardTextColor(4));
		playerCard5.setBackground(player.cardMainColor(5));
		playerCard5.setForeground(player.cardTextColor(5));
		playerCard6.setBackground(player.cardMainColor(6));
		playerCard6.setForeground(player.cardTextColor(6));
		playerCard7.setBackground(player.cardMainColor(7));
		playerCard7.setForeground(player.cardTextColor(7));
		playerCard8.setBackground(player.cardMainColor(8));
		playerCard8.setForeground(player.cardTextColor(8));
		playerCash.setText("Credits: "+ String.valueOf(player.getCredits()));
		playerPoints.setText("Points: "+ String.valueOf(player.getPoints()));
		playerCard1.setText(player.getCardText(1));
		playerCard2.setText(player.getCardText(2));
		playerCard3.setText(player.getCardText(3));
		playerCard4.setText(player.getCardText(4));
		playerCard5.setText(player.getCardText(5));
		playerCard6.setText(player.getCardText(6));
		playerCard7.setText(player.getCardText(7));
		playerCard8.setText(player.getCardText(8));
	}
	public void showPlayerHand(boolean t)
	{
			playerHand.setVisible(t);
	}
	public void makeGameWindow()
	{
		gameWindow.setSize(300,150);
		gameWindowTop.setSize(300,100);
		gameWindowBottom.setSize(300,100);
		gameWindowCenter.setSize(300,100);
		gameWindowTop.add(playerNumBox);
		gameWindowCenter.add(newGameButton);
		gameWindowCenter.add(exitProgramButton);
		gameWindowBottom.add(optionsButton);
		gameWindowBottom.add(creditsButton);
		gameWindow.getContentPane().add(BorderLayout.NORTH, gameWindowTop);
		gameWindow.getContentPane().add(BorderLayout.CENTER, gameWindowCenter);
		gameWindow.getContentPane().add(BorderLayout.SOUTH, gameWindowBottom);
	}
	public void showGameWindow(boolean t)
	{
		gameWindow.setVisible(t);
	}
	public void makeCPU1()		// setSelectedTextColor(Color.blue);  for the cards, to disallow cheating setSelectionColor(Color.blue);
	{
		comHand1.setSize(1000,154);
		comHand1.add(comHand1Panel);
		comHand1Panel.add(cpu1Cash);
		comHand1Panel.add(cpu1Card1);
		comHand1Panel.add(cpu1Card2);
		comHand1Panel.add(cpu1Card3);
		comHand1Panel.add(cpu1Card4);
		comHand1Panel.add(cpu1Card5);
		comHand1Panel.add(cpu1Card6);
		comHand1Panel.add(cpu1Card7);
		comHand1Panel.add(cpu1Card8);
		cpu1Card1.setEditable(false);
		cpu1Card1.setBackground(cpu1.cardMainColor(1));
		cpu1Card1.setForeground(cpu1.cardTextColor(1));
		cpu1Card1.setFont(font);
		cpu1Card1.setText(cpu1.getCardText(1));
		cpu1Card1.setSelectedTextColor(Color.blue);
		cpu1Card1.setSelectionColor(Color.blue);
		cpu1Card2.setText(cpu1.getCardText(2));
		cpu1Card2.setEditable(false);
		cpu1Card2.setBackground(cpu1.cardMainColor(2));
		cpu1Card2.setForeground(cpu1.cardTextColor(2));
		cpu1Card2.setFont(font);
		cpu1Card2.setSelectedTextColor(Color.blue);
		cpu1Card2.setSelectionColor(Color.blue);
		cpu1Card3.setText(cpu1.getCardText(3));
		cpu1Card3.setEditable(false);
		cpu1Card3.setBackground(cpu1.cardMainColor(3));
		cpu1Card3.setForeground(cpu1.cardTextColor(3));
		cpu1Card3.setFont(font);
		cpu1Card3.setSelectedTextColor(Color.blue);
		cpu1Card3.setSelectionColor(Color.blue);
		cpu1Card4.setText(cpu1.getCardText(4));
		cpu1Card4.setEditable(false);
		cpu1Card4.setBackground(cpu1.cardMainColor(4));
		cpu1Card4.setForeground(cpu1.cardTextColor(4));
		cpu1Card4.setFont(font);
		cpu1Card4.setSelectedTextColor(Color.blue);
		cpu1Card4.setSelectionColor(Color.blue);
		cpu1Card5.setText(cpu1.getCardText(5));
		cpu1Card5.setEditable(false);
		cpu1Card5.setBackground(cpu1.cardMainColor(5));
		cpu1Card5.setForeground(cpu1.cardTextColor(5));
		cpu1Card5.setFont(font);
		cpu1Card5.setSelectedTextColor(Color.blue);
		cpu1Card5.setSelectionColor(Color.blue);
		cpu1Card6.setText(cpu1.getCardText(6));
		cpu1Card6.setEditable(false);
		cpu1Card6.setBackground(cpu1.cardMainColor(6));
		cpu1Card6.setForeground(cpu1.cardTextColor(6));
		cpu1Card6.setFont(font);
		cpu1Card6.setSelectedTextColor(Color.blue);
		cpu1Card6.setSelectionColor(Color.blue);
		cpu1Card7.setText(cpu1.getCardText(7));
		cpu1Card7.setEditable(false);
		cpu1Card7.setBackground(cpu1.cardMainColor(7));
		cpu1Card7.setForeground(cpu1.cardTextColor(7));
		cpu1Card7.setFont(font);
		cpu1Card7.setSelectedTextColor(Color.blue);
		cpu1Card7.setSelectionColor(Color.blue);
		cpu1Card8.setText(cpu1.getCardText(8));
		cpu1Card8.setEditable(false);
		cpu1Card8.setBackground(cpu1.cardMainColor(8));
		cpu1Card8.setForeground(cpu1.cardTextColor(8));
		cpu1Card8.setFont(font);
		cpu1Card8.setSelectedTextColor(Color.blue);
		cpu1Card8.setSelectionColor(Color.blue);
	}
	public void updateCPU1Hand()
	{
		cpu1Cash.setText("Credits: "+ String.valueOf(cpu1.getCredits()));
		cpu1Card1.setText(cpu1.getCardText(1));
		cpu1Card2.setText(cpu1.getCardText(2));
		cpu1Card3.setText(cpu1.getCardText(3));
		cpu1Card4.setText(cpu1.getCardText(4));
		cpu1Card5.setText(cpu1.getCardText(5));
		cpu1Card6.setText(cpu1.getCardText(6));
		cpu1Card7.setText(cpu1.getCardText(7));
		cpu1Card8.setText(cpu1.getCardText(8));
	}
	public void showCPU1Hand(boolean t)
	{
		comHand1.setVisible(t);
	}
	public void makeCPU2()
	{
		comHand2.setSize(1000,154);
		comHand2.add(comHand2Panel);
		comHand2Panel.add(cpu2Cash);
		comHand2Panel.add(cpu2Card1);
		comHand2Panel.add(cpu2Card2);
		comHand2Panel.add(cpu2Card3);
		comHand2Panel.add(cpu2Card4);
		comHand2Panel.add(cpu2Card5);
		comHand2Panel.add(cpu2Card6);
		comHand2Panel.add(cpu2Card7);
		comHand2Panel.add(cpu2Card8);
		cpu2Card1.setEditable(false);
		cpu2Card1.setBackground(cpu2.cardMainColor(1));
		cpu2Card1.setForeground(cpu2.cardTextColor(1));
		cpu2Card1.setFont(font);
		cpu2Card1.setText(cpu2.getCardText(1));
		cpu2Card1.setSelectedTextColor(Color.blue);
		cpu2Card1.setSelectionColor(Color.blue);
		cpu2Card2.setText(cpu2.getCardText(2));
		cpu2Card2.setEditable(false);
		cpu2Card2.setBackground(cpu2.cardMainColor(2));
		cpu2Card2.setForeground(cpu2.cardTextColor(2));
		cpu2Card2.setFont(font);
		cpu2Card2.setSelectedTextColor(Color.blue);
		cpu2Card2.setSelectionColor(Color.blue);
		cpu2Card3.setText(cpu2.getCardText(3));
		cpu2Card3.setEditable(false);
		cpu2Card3.setBackground(cpu2.cardMainColor(3));
		cpu2Card3.setForeground(cpu2.cardTextColor(3));
		cpu2Card3.setFont(font);
		cpu2Card3.setSelectedTextColor(Color.blue);
		cpu2Card3.setSelectionColor(Color.blue);
		cpu2Card4.setText(cpu2.getCardText(4));
		cpu2Card4.setEditable(false);
		cpu2Card4.setBackground(cpu2.cardMainColor(4));
		cpu2Card4.setForeground(cpu2.cardTextColor(4));
		cpu2Card4.setFont(font);
		cpu2Card4.setSelectedTextColor(Color.blue);
		cpu2Card4.setSelectionColor(Color.blue);
		cpu2Card5.setText(cpu2.getCardText(5));
		cpu2Card5.setEditable(false);
		cpu2Card5.setBackground(cpu2.cardMainColor(5));
		cpu2Card5.setForeground(cpu2.cardTextColor(5));
		cpu2Card5.setFont(font);
		cpu2Card5.setSelectedTextColor(Color.blue);
		cpu2Card5.setSelectionColor(Color.blue);
		cpu2Card6.setText(cpu2.getCardText(6));
		cpu2Card6.setEditable(false);
		cpu2Card6.setBackground(cpu2.cardMainColor(6));
		cpu2Card6.setForeground(cpu2.cardTextColor(6));
		cpu2Card6.setFont(font);
		cpu2Card6.setSelectedTextColor(Color.blue);
		cpu2Card6.setSelectionColor(Color.blue);
		cpu2Card7.setText(cpu2.getCardText(7));
		cpu2Card7.setEditable(false);
		cpu2Card7.setBackground(cpu2.cardMainColor(7));
		cpu2Card7.setForeground(cpu2.cardTextColor(7));
		cpu2Card7.setFont(font);
		cpu2Card7.setSelectedTextColor(Color.blue);
		cpu2Card7.setSelectionColor(Color.blue);
		cpu2Card8.setText(cpu2.getCardText(8));
		cpu2Card8.setEditable(false);
		cpu2Card8.setBackground(cpu2.cardMainColor(8));
		cpu2Card8.setForeground(cpu2.cardTextColor(8));
		cpu2Card8.setFont(font);
		cpu2Card8.setSelectedTextColor(Color.blue);
		cpu2Card8.setSelectionColor(Color.blue);
	}
	public void updateCPU2Hand()
	{
		cpu2Cash.setText("Credits: "+ String.valueOf(cpu2.getCredits()));
		cpu2Card1.setText(cpu2.getCardText(1));
		cpu2Card2.setText(cpu2.getCardText(2));
		cpu2Card3.setText(cpu2.getCardText(3));
		cpu2Card4.setText(cpu2.getCardText(4));
		cpu2Card5.setText(cpu2.getCardText(5));
		cpu2Card6.setText(cpu2.getCardText(6));
		cpu2Card7.setText(cpu2.getCardText(7));
		cpu2Card8.setText(cpu2.getCardText(8));
	}
	public void showCPU2Hand(boolean t)
	{
		comHand2.setVisible(t);
	}
	public void makeCPU3()
	{
		comHand3.setSize(1000,154);
		comHand3.add(comHand3Panel);
		comHand3Panel.add(cpu3Cash);
		comHand3Panel.add(cpu3Card1);
		comHand3Panel.add(cpu3Card2);
		comHand3Panel.add(cpu3Card3);
		comHand3Panel.add(cpu3Card4);
		comHand3Panel.add(cpu3Card5);
		comHand3Panel.add(cpu3Card6);
		comHand3Panel.add(cpu3Card7);
		comHand3Panel.add(cpu3Card8);
		cpu3Card1.setEditable(false);
		cpu3Card1.setBackground(cpu3.cardMainColor(1));
		cpu3Card1.setForeground(cpu3.cardTextColor(1));
		cpu3Card1.setFont(font);
		cpu3Card1.setText(cpu3.getCardText(1));
		cpu3Card1.setSelectedTextColor(Color.blue);
		cpu3Card1.setSelectionColor(Color.blue);
		cpu3Card2.setText(cpu3.getCardText(2));
		cpu3Card2.setEditable(false);
		cpu3Card2.setBackground(cpu3.cardMainColor(2));
		cpu3Card2.setForeground(cpu3.cardTextColor(2));
		cpu3Card2.setFont(font);
		cpu3Card2.setSelectedTextColor(Color.blue);
		cpu3Card2.setSelectionColor(Color.blue);
		cpu3Card3.setText(cpu3.getCardText(3));
		cpu3Card3.setEditable(false);
		cpu3Card3.setBackground(cpu3.cardMainColor(3));
		cpu3Card3.setForeground(cpu3.cardTextColor(3));
		cpu3Card3.setFont(font);
		cpu3Card3.setSelectedTextColor(Color.blue);
		cpu3Card3.setSelectionColor(Color.blue);
		cpu3Card4.setText(cpu3.getCardText(4));
		cpu3Card4.setEditable(false);
		cpu3Card4.setBackground(cpu3.cardMainColor(4));
		cpu3Card4.setForeground(cpu3.cardTextColor(4));
		cpu3Card4.setFont(font);
		cpu3Card4.setSelectedTextColor(Color.blue);
		cpu3Card4.setSelectionColor(Color.blue);
		cpu3Card5.setText(cpu3.getCardText(5));
		cpu3Card5.setEditable(false);
		cpu3Card5.setBackground(cpu3.cardMainColor(5));
		cpu3Card5.setForeground(cpu3.cardTextColor(5));
		cpu3Card5.setFont(font);
		cpu3Card5.setSelectedTextColor(Color.blue);
		cpu3Card5.setSelectionColor(Color.blue);
		cpu3Card6.setText(cpu3.getCardText(6));
		cpu3Card6.setEditable(false);
		cpu3Card6.setBackground(cpu3.cardMainColor(6));
		cpu3Card6.setForeground(cpu3.cardTextColor(6));
		cpu3Card6.setFont(font);
		cpu3Card6.setSelectedTextColor(Color.blue);
		cpu3Card6.setSelectionColor(Color.blue);
		cpu3Card7.setText(cpu3.getCardText(7));
		cpu3Card7.setEditable(false);
		cpu3Card7.setBackground(cpu3.cardMainColor(7));
		cpu3Card7.setForeground(cpu3.cardTextColor(7));
		cpu3Card7.setFont(font);
		cpu3Card7.setSelectedTextColor(Color.blue);
		cpu3Card7.setSelectionColor(Color.blue);
		cpu3Card8.setText(cpu3.getCardText(8));
		cpu3Card8.setEditable(false);
		cpu3Card8.setBackground(cpu3.cardMainColor(8));
		cpu3Card8.setForeground(cpu3.cardTextColor(8));
		cpu3Card8.setFont(font);
		cpu3Card8.setSelectedTextColor(Color.blue);
		cpu3Card8.setSelectionColor(Color.blue);
	}
	public void updateCPU3Hand()
	{
		cpu3Cash.setText("Credits: "+ String.valueOf(cpu3.getCredits()));
		cpu3Card1.setText(cpu3.getCardText(1));
		cpu3Card2.setText(cpu3.getCardText(2));
		cpu3Card3.setText(cpu3.getCardText(3));
		cpu3Card4.setText(cpu3.getCardText(4));
		cpu3Card5.setText(cpu3.getCardText(5));
		cpu3Card6.setText(cpu3.getCardText(6));
		cpu3Card7.setText(cpu3.getCardText(7));
		cpu3Card8.setText(cpu3.getCardText(8));
	}
	public void showCPU3Hand(boolean t)
	{
		comHand3.setVisible(t);
	}
	public void makeCPU4()
	{
		comHand4.setSize(1000,154);
		comHand4.add(comHand4Panel);
		comHand4Panel.add(cpu4Cash);
		comHand4Panel.add(cpu4Card1);
		comHand4Panel.add(cpu4Card2);
		comHand4Panel.add(cpu4Card3);
		comHand4Panel.add(cpu4Card4);
		comHand4Panel.add(cpu4Card5);
		comHand4Panel.add(cpu4Card6);
		comHand4Panel.add(cpu4Card7);
		comHand4Panel.add(cpu4Card8);
		cpu4Card1.setEditable(false);
		cpu4Card1.setBackground(cpu4.cardMainColor(1));
		cpu4Card1.setForeground(cpu4.cardTextColor(1));
		cpu4Card1.setFont(font);
		cpu4Card1.setText(cpu4.getCardText(1));
		cpu4Card1.setSelectedTextColor(Color.blue);
		cpu4Card1.setSelectionColor(Color.blue);
		cpu4Card2.setText(cpu4.getCardText(2));
		cpu4Card2.setEditable(false);
		cpu4Card2.setBackground(cpu4.cardMainColor(2));
		cpu4Card2.setForeground(cpu4.cardTextColor(2));
		cpu4Card2.setFont(font);
		cpu4Card2.setSelectedTextColor(Color.blue);
		cpu4Card2.setSelectionColor(Color.blue);
		cpu4Card3.setText(cpu4.getCardText(3));
		cpu4Card3.setEditable(false);
		cpu4Card3.setBackground(cpu4.cardMainColor(3));
		cpu4Card3.setForeground(cpu4.cardTextColor(3));
		cpu4Card3.setFont(font);
		cpu4Card3.setSelectedTextColor(Color.blue);
		cpu4Card3.setSelectionColor(Color.blue);
		cpu4Card4.setText(cpu4.getCardText(4));
		cpu4Card4.setEditable(false);
		cpu4Card4.setBackground(cpu4.cardMainColor(4));
		cpu4Card4.setForeground(cpu4.cardTextColor(4));
		cpu4Card4.setFont(font);
		cpu4Card4.setSelectedTextColor(Color.blue);
		cpu4Card4.setSelectionColor(Color.blue);
		cpu4Card5.setText(cpu4.getCardText(5));
		cpu4Card5.setEditable(false);
		cpu4Card5.setBackground(cpu4.cardMainColor(5));
		cpu4Card5.setForeground(cpu4.cardTextColor(5));
		cpu4Card5.setFont(font);
		cpu4Card5.setSelectedTextColor(Color.blue);
		cpu4Card5.setSelectionColor(Color.blue);
		cpu4Card6.setText(cpu4.getCardText(6));
		cpu4Card6.setEditable(false);
		cpu4Card6.setBackground(cpu4.cardMainColor(6));
		cpu4Card6.setForeground(cpu4.cardTextColor(6));
		cpu4Card6.setFont(font);
		cpu4Card6.setSelectedTextColor(Color.blue);
		cpu4Card6.setSelectionColor(Color.blue);
		cpu4Card7.setText(cpu4.getCardText(7));
		cpu4Card7.setEditable(false);
		cpu4Card7.setBackground(cpu4.cardMainColor(7));
		cpu4Card7.setForeground(cpu4.cardTextColor(7));
		cpu4Card7.setFont(font);
		cpu4Card7.setSelectedTextColor(Color.blue);
		cpu4Card7.setSelectionColor(Color.blue);
		cpu4Card8.setText(cpu4.getCardText(8));
		cpu4Card8.setEditable(false);
		cpu4Card8.setBackground(cpu4.cardMainColor(8));
		cpu4Card8.setForeground(cpu4.cardTextColor(8));
		cpu4Card8.setFont(font);
		cpu4Card8.setSelectedTextColor(Color.blue);
		cpu4Card8.setSelectionColor(Color.blue);
	}
	public void updateCPU4Hand()
	{
		cpu4Cash.setText("Credits: "+ String.valueOf(cpu4.getCredits()));
		cpu4Card1.setText(cpu4.getCardText(1));
		cpu4Card2.setText(cpu4.getCardText(2));
		cpu4Card3.setText(cpu4.getCardText(3));
		cpu4Card4.setText(cpu4.getCardText(4));
		cpu4Card5.setText(cpu4.getCardText(5));
		cpu4Card6.setText(cpu4.getCardText(6));
		cpu4Card7.setText(cpu4.getCardText(7));
		cpu4Card8.setText(cpu4.getCardText(8));
	}
	public void showCPU4Hand(boolean t)
	{
		comHand4.setVisible(t);
	}
	public void makeCPU5()
	{
		comHand5.setSize(1000,154);
		comHand5.add(comHand5Panel);
		comHand5Panel.add(cpu5Cash);
		comHand5Panel.add(cpu5Card1);
		comHand5Panel.add(cpu5Card2);
		comHand5Panel.add(cpu5Card3);
		comHand5Panel.add(cpu5Card4);
		comHand5Panel.add(cpu5Card5);
		comHand5Panel.add(cpu5Card6);
		comHand5Panel.add(cpu5Card7);
		comHand5Panel.add(cpu5Card8);
		cpu5Card1.setEditable(false);
		cpu5Card1.setBackground(cpu5.cardMainColor(1));
		cpu5Card1.setForeground(cpu5.cardTextColor(1));
		cpu5Card1.setFont(font);
		cpu5Card1.setText(cpu5.getCardText(1));
		cpu5Card1.setSelectedTextColor(Color.blue);
		cpu5Card1.setSelectionColor(Color.blue);
		cpu5Card2.setText(cpu5.getCardText(2));
		cpu5Card2.setEditable(false);
		cpu5Card2.setBackground(cpu5.cardMainColor(2));
		cpu5Card2.setForeground(cpu5.cardTextColor(2));
		cpu5Card2.setFont(font);
		cpu5Card2.setSelectedTextColor(Color.blue);
		cpu5Card2.setSelectionColor(Color.blue);
		cpu5Card3.setText(cpu5.getCardText(3));
		cpu5Card3.setEditable(false);
		cpu5Card3.setBackground(cpu5.cardMainColor(3));
		cpu5Card3.setForeground(cpu5.cardTextColor(3));
		cpu5Card3.setFont(font);
		cpu5Card3.setSelectedTextColor(Color.blue);
		cpu5Card3.setSelectionColor(Color.blue);
		cpu5Card4.setText(cpu5.getCardText(4));
		cpu5Card4.setEditable(false);
		cpu5Card4.setBackground(cpu5.cardMainColor(4));
		cpu5Card4.setForeground(cpu5.cardTextColor(4));
		cpu5Card4.setFont(font);
		cpu5Card4.setSelectedTextColor(Color.blue);
		cpu5Card4.setSelectionColor(Color.blue);
		cpu5Card5.setText(cpu5.getCardText(5));
		cpu5Card5.setEditable(false);
		cpu5Card5.setBackground(cpu5.cardMainColor(5));
		cpu5Card5.setForeground(cpu5.cardTextColor(5));
		cpu5Card5.setFont(font);
		cpu5Card5.setSelectedTextColor(Color.blue);
		cpu5Card5.setSelectionColor(Color.blue);
		cpu5Card6.setText(cpu5.getCardText(6));
		cpu5Card6.setEditable(false);
		cpu5Card6.setBackground(cpu5.cardMainColor(6));
		cpu5Card6.setForeground(cpu5.cardTextColor(6));
		cpu5Card6.setFont(font);
		cpu5Card6.setSelectedTextColor(Color.blue);
		cpu5Card6.setSelectionColor(Color.blue);
		cpu5Card7.setText(cpu5.getCardText(7));
		cpu5Card7.setEditable(false);
		cpu5Card7.setBackground(cpu5.cardMainColor(7));
		cpu5Card7.setForeground(cpu5.cardTextColor(7));
		cpu5Card7.setFont(font);
		cpu5Card7.setSelectedTextColor(Color.blue);
		cpu5Card7.setSelectionColor(Color.blue);
		cpu5Card8.setText(cpu5.getCardText(8));
		cpu5Card8.setEditable(false);
		cpu5Card8.setBackground(cpu5.cardMainColor(8));
		cpu5Card8.setForeground(cpu5.cardTextColor(8));
		cpu5Card8.setFont(font);
		cpu5Card8.setSelectedTextColor(Color.blue);
		cpu5Card8.setSelectionColor(Color.blue);
	}
	public void updateCPU5Hand()
	{
		cpu5Cash.setText("Credits: "+ String.valueOf(cpu5.getCredits()));
		cpu5Card1.setText(cpu5.getCardText(1));
		cpu5Card2.setText(cpu5.getCardText(2));
		cpu5Card3.setText(cpu5.getCardText(3));
		cpu5Card4.setText(cpu5.getCardText(4));
		cpu5Card5.setText(cpu5.getCardText(5));
		cpu5Card6.setText(cpu5.getCardText(6));
		cpu5Card7.setText(cpu5.getCardText(7));
		cpu5Card8.setText(cpu5.getCardText(8));
	}
	public void showCPU5Hand(boolean t)
	{
		comHand5.setVisible(t);
	}
	public void makeOptions()
	{
		options.getContentPane().add(BorderLayout.NORTH,optionsTop);
		options.getContentPane().add(BorderLayout.SOUTH,optionsBottom);
		optionsTop.setLayout(new BoxLayout(optionsTop,BoxLayout.Y_AXIS));
		optionsTop.add(optionsTopLayer1);
		optionsTop.add(optionsTopLayer2);
		optionsTop.add(optionsTopLayer3);
		optionsTop.add(optionsTopLayer4);
		optionsTop.add(optionsTopLayer5);
		optionsTop.add(optionsTopLayer6);
		optionsTop.add(optionsTopLayer7);
		optionsTopLayer1.add(cardsToDealBox);
		optionsTopLayer1.add(optionsLabelCardDeal);
		optionsTopLayer2.add(playerNameLabel);
		optionsTopLayer2.add(playerNameField);
		optionsTopLayer2.add(riskLabel);
		optionsTopLayer2.add(playerCashLabel);
		optionsTopLayer2.add(playerCashField);
		optionsTopLayer3.add(cpuNameLabel1);
		optionsTopLayer3.add(cpu1NameField);
		optionsTopLayer3.add(cpu1RiskBox);
		optionsTopLayer3.add(cpu1CashLabel);
		optionsTopLayer3.add(cpu1CashField);
		optionsTopLayer4.add(cpuNameLabel2);
		optionsTopLayer4.add(cpu2NameField);
		optionsTopLayer4.add(cpu2RiskBox);
		optionsTopLayer4.add(cpu2CashLabel);
		optionsTopLayer4.add(cpu2CashField);
		optionsTopLayer5.add(cpuNameLabel3);
		optionsTopLayer5.add(cpu3NameField);
		optionsTopLayer5.add(cpu3RiskBox);
		optionsTopLayer5.add(cpu3CashLabel);
		optionsTopLayer5.add(cpu3CashField);
		optionsTopLayer6.add(cpuNameLabel4);
		optionsTopLayer6.add(cpu4NameField);
		optionsTopLayer6.add(cpu4RiskBox);
		optionsTopLayer6.add(cpu4CashLabel);
		optionsTopLayer6.add(cpu4CashField);
		optionsTopLayer7.add(cpuNameLabel5);
		optionsTopLayer7.add(cpu5NameField);
		optionsTopLayer7.add(cpu5RiskBox);
		optionsTopLayer7.add(cpu5CashLabel);
		optionsTopLayer7.add(cpu5CashField);
		optionsBottom.add(apply);
		optionsBottom.add(close);
		options.setSize(500,330);
		optionsTop.setSize(500,310);
		optionsBottom.setSize(500,20);
	}
	public void showOptions(boolean t)
	{
		options.setVisible(t);
	}
	public void makeBetWindow()
	{
		matchBetWindow.getContentPane().add(BorderLayout.NORTH, matchBetTop);
		matchBetWindow.getContentPane().add(BorderLayout.SOUTH, matchBetBottom);
		matchBetTop.add(matchBetLabel);
		matchBetBottom.add(matchBetYes);
		matchBetBottom.add(matchBetNo);
		matchBetWindow.setSize(200,100);
		matchBetTop.setSize(200,50);
		matchBetBottom.setSize(200,50);
	}
	public void showBetWindow(boolean t)
	{
		matchBetWindow.setVisible(t);
	}
	public void setBetWindow(String name, String amount)
	{
		matchBetLabel.setText(name+ " bet "+amount+". Match bet?");
	}
	public void deal()
	{
		System.out.println("dealing..");

		for(int x = 5; x>0; x--)
		{
			player.addCard((Card)gameDeck.get(cardNum));
			cardNum++;
			System.out.println(player.hand.toString());
		}
		if(cpu1.isPlaying())
		{
			for(int x = 5; x>0; x--)
			{
				cpu1.addCard((Card)gameDeck.get(cardNum));
				cardNum++;
				System.out.println(cpu1.hand.toString());
			}
		}
		if(cpu2.isPlaying())
		{
			for(int x = 5; x>0; x--)
			{
				cpu2.addCard((Card)gameDeck.get(cardNum));
				cardNum++;
				System.out.println(cpu2.hand.toString());
			}
		}
		if(cpu3.isPlaying())
		{
			for(int x = 5; x>0; x--)
			{
				cpu3.addCard((Card)gameDeck.get(cardNum));
				cardNum++;
				System.out.println(cpu3.hand.toString());
			}
		}
		if(cpu4.isPlaying())
		{
			for(int x = 5; x>0; x--)
			{
				cpu4.addCard((Card)gameDeck.get(cardNum));
				cardNum++;
				System.out.println(cpu4.hand.toString());
			}
		}
		if(cpu5.isPlaying())
		{
			for(int x = 5; x>0; x--)
			{
				cpu5.addCard((Card)gameDeck.get(cardNum));
				cardNum++;
				System.out.println(cpu5.hand.toString());
			}
		}
	}
}
import java.util.*;
import java.awt.*;
import java.applet.*;
public class Tester extends Applet
{
	static DeckList<Card> preDeck = new DeckList<Card>();
	static Random rand = new Random();
	static Game game;
	static int ugh = 0;											// There is a reason for 'ugh'... When I looked at the FinalProject.doc, I realized the program had to be an applet, so I converted this file to one. But then for some reason it ran through the paint() method twice [looking back, this is likely because applets refresh their display when something moves over them], and since I could not track down why or where it did this, I put a conditional statement inside the paint() method to ensure it only did the contained statements once. This is probably bad program design, but it WORKS. SO THERE!!! (hence the name)
	static DeckList<Card> shuffledDeck = new DeckList<Card>();
	static DeckList<Card> discard = new DeckList<Card>();
public void paint(Graphics g)
	{
		if (ugh == 0)
		{
			makeDeck(preDeck);
			shuffledDeck = shuffle(preDeck);
			game = new Game();
			game.play(shuffledDeck);
			ugh++;
		}
	}
	public static void makeDeck(DeckList deck)
	{
		for(int suit = 0; suit <4; suit++)
		{
			for(int num = 2; num < 12; num++)
			{
				deck.add(new Card(suit,num, String.valueOf(num),"Sabacc",true));
			}
		}
		System.out.println("Regular cards made.");
		System.out.println(deck.size());
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,1,"One","Sabacc",true));
		}
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,12,"Commander","Sabacc",true));
		}
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,13,"Mistress","Sabacc",true));
		}
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,14,"Master","Sabacc",true));
		}
		for(int s = 0; s<4; s++)
		{
			deck.add(new Card(s,15,"Ace","Sabacc",true));
		}
		System.out.println("High cards made");
		System.out.println(deck.size());
		deck.add(new Card(4,-17,"The Star","Sabacc",true));						// makine Stars
		deck.add(new Card(4,-17,"The Star","Sabacc",true));
		deck.add(new Card(4,-15,"The Evil One","Sabacc",true));					// making Evil Ones
		deck.add(new Card(4,-15,"The Evil One","Sabacc",true));
		deck.add(new Card(4,-14,"Moderation","Sabacc",true));					// making Moderations
		deck.add(new Card(4,-14,"Moderation","Sabacc",true));
		deck.add(new Card(4,-13,"Demise","Sabacc",true));						// making Demises
		deck.add(new Card(4,-13,"Demise","Sabacc",true));
		deck.add(new Card(4,-11,"Balance","Sabacc",true));						// making Balance
		deck.add(new Card(4,-11,"Balance","Sabacc",true));
		deck.add(new Card(4,-8,"Endurance","Sabacc",true));						// making Endurance
		deck.add(new Card(4,-8,"Endurance","Sabacc",true));
		deck.add(new Card(4,-2,"Queen of A & D","Sabacc",true));		// making Queens
		deck.add(new Card(4,-2,"Queen of A & D","Sabacc",true));
		deck.add(new Card(4,0,"Idiot","Sabacc",true));							// making Idiots
		deck.add(new Card(4,0,"Idiot","Sabacc",true));
		System.out.println("Done with face cards");
		System.out.println(deck.size());
		System.out.println(deck.toString());
	}
	public static DeckList shuffle(DeckList deck)
	{
		int x = 0;
		while(x < 200)
		{
			int a = rand.nextInt(deck.size());
			int b = rand.nextInt(deck.size());
			while(a==b)
				b = rand.nextInt(deck.size());
			deck.swap(a,b);
			x++;
		}
		System.out.println("Shuffle done.");
		System.out.println(deck.size());
		System.out.println(deck.toString());
		return deck;
	}
}
import java.util.*;
public class AIPlayer extends Player
{
	double risk;
	boolean isPlaying = true;
	Random rand = new Random();
	public AIPlayer()
	{
		name = "UnNamed";
		credits = 100;
		risk = 1;
		isPlaying = true;
	}
    public AIPlayer(String n, int c, int r, boolean t)
    {
		name = n;
		credits = c;
		risk = r;
		isPlaying = t;
    }
	public boolean isPlaying()
	{
		return isPlaying;
	}
    public void setPlaying(boolean t)
    {
    	isPlaying = t;
    }
	public boolean putCardInField()
	{
		int x = rand.nextInt(20);
		if(points == 23 || points == -23 || idiotArray() || x == 20)
			return true;
		else
			return false;
	}
	public boolean callGame()
	{
		if(idiotArray() || points == 23 || points == -23 || (points > 20 && points < 23) || (points < -20 && points > -23))
			return true;
		else
			return false;
	}
	public boolean drawCard()
	{
		if((points < 15 && points > -15) && (numCards < 5))
			return true;
		else
			return false;
	}
	public double getBet(Game game)
	{
		int r = rand.nextInt(9)+1;

		return risk*.25*points+r;
	}
	public void setRisk(int r)
	{
		risk = r;
	}
}
import java.awt.*;
public class Player
{
	String name;
	DeckList hand = new DeckList();
	int credits;
	int points;
	int numCards;
 public Player()
    {
		name = "UnNamed";
		credits = 100;
    }
    public Player(String n, int c)
    {
		name = n;
		credits = c;
    }
	public String getName()
	{
		return name;
	}
	public Card getCard(int index)
	{
		Card card = new Card();
		card = (Card) hand.get(index);
		return card;
	}
	public int getPoints()
	{
		points = 0;
		Card temp = new Card();
		for(int x = 0; x < hand.size();x++)
		{
			temp = (Card) hand.get(x);
			points += temp.getValue();
		}
		return points;
	}
	public int getCredits()
	{
		return credits;
	}
	public void setName(String s)
	{
		name = s;
	}
	public void setCredits(int a)
	{
		credits = a;
	}
	public void setCard(Card card, int index)
	{
		hand.set(index, card);
	}
	public void addCard(Card card)
	{
		hand.add(card);
	}
	public void payIntoMain(int a, Game game)
	{
		if(credits < a)
		{
			game.mainPot += credits;
			credits = 0;
		}
		else
		{
			 game.mainPot += a;
			 credits -= a;
		}
	}
	public void payIntoSabacc(int a, Game game)
	{
		if(credits < a)
		{
			game.sabaccPot += credits;
			credits = 0;
		}
		else
		{
			 game.sabaccPot += a;
			 credits -= a;
		}
	}
	public boolean idiotArray()
	{
		boolean ret = false;
		if(this.numCards == 3)
		{
			Card temp1 = (Card) hand.get(0);
			Card temp2 = (Card) hand.get(1);
			Card temp3 = (Card) hand.get(2);
			String nam1 = temp1.getName();
			String nam2 = temp2.getName();
			String nam3 = temp3.getName();
			if((temp1.suit == temp2.suit || temp1.suit == temp3.suit || temp2.suit == temp3.suit) && (nam1.equals("Idiot") || nam2.equals("Idiot") || nam3.equals("Idiot")))
				ret = true;
		}
		return ret;
	}
	public Color cardMainColor(int index)
	{
		index = index-1;
		if(index >= hand.size())
		{
			return Color.blue;
		}
		else
		{
			Card temp = this.getCard(index);
			if(temp.inPlay)
				return Color.red;
			else
				return Color.blue;
		}
	}
	public Color cardTextColor(int index)
	{
		index = index - 1;
		if(index >= this.hand.size())
		{
			return Color.blue;
		}
		else
		{
			Card temp = this.getCard(index);
			if(temp.inPlay)
				return Color.black;
			else
				return Color.blue;
		}
	}
	public String getCardText(int index)
	{
		index = index-1;
		if(index >= hand.size())
		{
			return "";
		}
		{
			Card temp = this.getCard(index);
			if(temp.value <0 && temp.value > -10)
				return temp.value + "              \n\n"+temp.getName() + "\n\n"+temp.getSuit();
			if(temp.value <-9)
				return temp.value + "             \n\n"+temp.getName() + "\n\n"+temp.getSuit();
			if(temp.value > 9)
				return temp.value + "              \n\n"+temp.getName() + "\n\n"+temp.getSuit();
			if(temp.value < 10)
				return temp.value + "               \n\n"+temp.getName() + "\n\n"+temp.getSuit();
			else
				return "error";
		}
	}
	public int getNumCards()
	{
		return numCards;
	}
}
import java.util.*;
public class Card
{
	int suit;
	int value;
	String gameName;
	String suitName;
	String name;
	String shortName;
	String longName;
	int user;
	boolean inPlay = false;
	boolean inStatic = false;
	Random rand = new Random();
	public Card()
	{
	}
	public Card(int s, int n, String cardName,String game,boolean t)
	{
		suit =s;
		value = n;
		inPlay = t;
		name = cardName;
		gameName = game;
		if(gameName.equals("Sabacc"))
		{
			if(suit == 0)
				suitName = "Sabers";
			if(suit == 1)
				suitName = "Flasks";
			if(suit == 2)
				suitName = "Coins";
			if(suit == 3)
				suitName = "Staves";
			if(suit == 4)
				suitName = "the Face Cards";
		}
	}
	public String getLongName()
	{
		return name+ " of " + suitName;
	}
	public boolean getStatic()
	{
		return inStatic;
	}
	public void setStatic(boolean t)
	{
		inStatic = t;
	}
	public String getName()
	{
		return name;
	}
	public String getShortName()
	{
		return this.getName();
	}
	public String getSuit()
	{
		return suitName;
	}
	public int getValue()
	{
		return value;
	}
}
import java.util.*;
public class DeckList<E> extends ArrayList<E>
{
	public DeckList()
	{
	}
	public String toString()
    {
    	String ret = "";
    	Object temp = new Object();
    	for(int x =0; x < this.size(); x++)
    	{
    		temp = this.get(x);
    		Card card = (Card) temp;

    		ret += card.getName() + ",  ";
    	}
    	return "[ " +ret+" ]";
    }
    public void swap(int a, int b)
    {
		Card carda = (Card) this.get(a);
		Card cardb = (Card) this.get(b);
		Card cardtemp = new Card();
    	cardtemp = carda;
    	carda = cardb;
    	cardb = cardtemp;
		this.set(a,(E)carda);
		this.set(b,(E)cardb);
    }
}