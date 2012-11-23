// Luke Stanley
// THe Game class: mainly for GUI & gameplay mechanisms; this class
// puts the rest together in order to play the game.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.security.*;

public class Game
{
	long beginning;										// makes needed variables and such
	long delayTime;
	boolean canSwitchCard = true;
	boolean betMatched = false;
	Scanner in = new Scanner(System.in);
	SecureRandom rand = new SecureRandom();
	int mainPot = 0;
	int sabaccPot = 0;
	int numToDeal = 2;
	int numPlayers = 4;
	int roundNum = 0;
	boolean lastRound = false;
	int cardNum = 0;
	DeckList<Card> gameDeck;
	AIPlayer cpu1 = new AIPlayer("1",100,1,true);
	AIPlayer cpu2 = new AIPlayer("2",100,1,true);
	AIPlayer cpu3 = new AIPlayer("3",100,1,true);
	AIPlayer cpu4 = new AIPlayer("4",100,1,true);
	AIPlayer cpu5 = new AIPlayer("5",100,1,true);
	Font font = new Font("monospaced",Font.BOLD,16);
	Player player = new Player();


	JFrame playerHand = new JFrame("Player Hand");				// makes GUI
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
	JLabel sabaccPotLabel = new JLabel();
	JLabel mainPotLabel = new JLabel();
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

	JTextArea cpu1Card1 = new JTextArea();
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

	JFrame gameWindow = new JFrame("Sabacc Main Menu");
	JPanel gameWindowTop = new JPanel();
	JPanel gameWindowBottom = new JPanel();
	JPanel gameWindowCenter = new JPanel();
	JButton newGameButton = new JButton("New Game    ");
	JButton exitProgramButton = new JButton("Exit Program");
	JButton optionsButton = new JButton("Options          ");
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


	JFrame gameCalled = new JFrame("The game has been called");
	JPanel gameCalledTop = new JPanel();
	JPanel gameCalledBottom = new JPanel();
	JLabel gameCalledLabel = new JLabel();
	JButton gameCalledButton = new JButton("OK");


	JFrame ante = new JFrame("Buy-in price?");
	JPanel anteTop = new JPanel();
	JPanel anteBottom = new JPanel();
	JLabel anteLabel = new JLabel("Please enter a buy-in price");
	JTextField anteAmount = new JTextField(12);
	JButton anteButton = new JButton("OK");


	JFrame makeBet = new JFrame("Bet how much?");
	JPanel betTop = new JPanel();
	JPanel betBottom = new JPanel();
	JLabel betLabel = new JLabel("Please enter an amount to bet");
	JTextField betAmount = new JTextField(7);
	JButton betButton = new JButton("Bet");


	JFrame card1Frame = new JFrame("Do what with card?");
	JPanel card1Top = new JPanel();
	JPanel card1Bottom = new JPanel();
	JButton putStatic1 = new JButton("Put in Static Field");
	JButton swapCard1 = new JButton("Swap Card");
	JButton cancelButton1 = new JButton("Cancel");

	JFrame card2Frame = new JFrame("Do what with card?");
	JPanel card2Top = new JPanel();
	JPanel card2Bottom = new JPanel();
	JButton putStatic2 = new JButton("Put in Static Field");
	JButton swapCard2 = new JButton("Swap Card");
	JButton cancelButton2 = new JButton("Cancel");

	JFrame card3Frame = new JFrame("Do what with card?");
	JPanel card3Top = new JPanel();
	JPanel card3Bottom = new JPanel();
	JButton putStatic3 = new JButton("Put in Static Field");
	JButton swapCard3 = new JButton("Swap Card");
	JButton cancelButton3 = new JButton("Cancel");

	JFrame card4Frame = new JFrame("Do what with card?");
	JPanel card4Top = new JPanel();
	JPanel card4Bottom = new JPanel();
	JButton putStatic4 = new JButton("Put in Static Field");
	JButton swapCard4 = new JButton("Swap Card");
	JButton cancelButton4 = new JButton("Cancel");

	JFrame card5Frame = new JFrame("Do what with card?");
	JPanel card5Top = new JPanel();
	JPanel card5Bottom = new JPanel();
	JButton putStatic5 = new JButton("Put in Static Field");
	JButton swapCard5 = new JButton("Swap Card");
	JButton cancelButton5 = new JButton("Cancel");

	JFrame card6Frame = new JFrame("Do what with card?");
	JPanel card6Top = new JPanel();
	JPanel card6Bottom = new JPanel();
	JButton putStatic6 = new JButton("Put in Static Field");
	JButton swapCard6 = new JButton("Swap Card");
	JButton cancelButton6 = new JButton("Cancel");

	JFrame card7Frame = new JFrame("Do what with card?");
	JPanel card7Top = new JPanel();
	JPanel card7Bottom = new JPanel();
	JButton putStatic7 = new JButton("Put in Static Field");
	JButton swapCard7 = new JButton("Swap Card");
	JButton cancelButton7 = new JButton("Cancel");

	JFrame card8Frame = new JFrame("Do what with card?");
	JPanel card8Top = new JPanel();
	JPanel card8Bottom = new JPanel();
	JButton putStatic8 = new JButton("Put in Static Field");
	JButton swapCard8 = new JButton("Swap Card");
	JButton cancelButton8 = new JButton("Cancel");

	JFrame creditFrame = new JFrame("Lame Credits");

																	//	 mmm    	good to go
	JFrame log = new JFrame("Log");									// d 0_0 b	<-------------
	JPanel logPanel = new JPanel(new FlowLayout());					//  \ | /
	JTextArea logText = new JTextArea(22,34);						//    |
	JScrollPane logBar= new JScrollPane(logText);					//   /^\
																	// _/   \_


    public Game()
    {

    }
	public void play(DeckList d)				// starts game, puts all the GUI together
	{
		gameDeck = d;
		makeLog();
		makeCalled();
		makePlayerFrame();
		makeGameWindow();
		makeCPU1();
		makeCPU2();
		makeCPU3();
		makeCPU4();
		makeCPU5();
		makeOptions();
		makeBetWindow();
		makeAnte();
		makeBet();
		makeCard1();
		makeCard2();
		makeCard3();
		makeCard4();
		makeCard5();
		makeCard6();
		makeCard7();
		makeCard8();
//		deal();
//		updatePlayerFrame();
//		updateCPU1Hand();
//		updateCPU2Hand();
//		updateCPU3Hand();
//		updateCPU4Hand();
//		updateCPU5Hand();
//		showMatchBetWindow(true);
//		showPlayerHand(true);
		showGameWindow(true);
//		showOptions(true);
//		showCPU1Hand(true);
//		showCPU2Hand(true);
//		showCPU3Hand(true);
//		showCPU4Hand(true);
//		showCPU5Hand(true);
//		sabaccShift();
//		updatePlayerFrame();
//		showCalled("Luke");
		gameWindow.requestFocus();
	}

	public void makeCard1()
	{
		card1Frame.getContentPane().add(BorderLayout.NORTH, card1Top);
		card1Frame.getContentPane().add(BorderLayout.SOUTH, card1Bottom);
		card1Frame.setSize(300,101);
		card1Top.add(putStatic1);
		card1Top.add(swapCard1);
		card1Bottom.add(cancelButton1);
		putStatic1.addActionListener(new PutStatic1Listener());
		swapCard1.addActionListener(new SwapCard1Listener());
		cancelButton1.addActionListener(new CancelCard1Listener());
	}

	public void showCard1(boolean t)
	{
		card1Frame.setVisible(t);
	}

	public void makeCard2()
	{
		card2Frame.getContentPane().add(BorderLayout.NORTH, card2Top);
		card2Frame.getContentPane().add(BorderLayout.SOUTH, card2Bottom);
		card2Frame.setSize(300,101);
		card2Top.add(putStatic2);
		card2Top.add(swapCard2);
		card2Bottom.add(cancelButton2);
		putStatic2.addActionListener(new PutStatic2Listener());
		swapCard2.addActionListener(new SwapCard2Listener());
		cancelButton2.addActionListener(new CancelCard2Listener());
	}

	public void showCard2(boolean t)
	{
		card2Frame.setVisible(t);
	}

	public void makeCard3()
	{
		card3Frame.getContentPane().add(BorderLayout.NORTH, card3Top);
		card3Frame.getContentPane().add(BorderLayout.SOUTH, card3Bottom);
		card3Frame.setSize(300,101);
		card3Top.add(putStatic3);
		card3Top.add(swapCard3);
		card3Bottom.add(cancelButton3);
		putStatic3.addActionListener(new PutStatic3Listener());
		swapCard3.addActionListener(new SwapCard3Listener());
		cancelButton3.addActionListener(new CancelCard3Listener());
	}

	public void showCard3(boolean t)
	{
		card3Frame.setVisible(t);
	}

	public void makeCard4()
	{
		card4Frame.getContentPane().add(BorderLayout.NORTH, card4Top);
		card4Frame.getContentPane().add(BorderLayout.SOUTH, card4Bottom);
		card4Frame.setSize(300,101);
		card4Top.add(putStatic4);
		card4Top.add(swapCard4);
		card4Bottom.add(cancelButton4);
		putStatic4.addActionListener(new PutStatic4Listener());
		swapCard4.addActionListener(new SwapCard4Listener());
		cancelButton4.addActionListener(new CancelCard4Listener());
	}

	public void showCard4(boolean t)
	{
		card4Frame.setVisible(t);
	}

	public void makeCard5()
	{
		card5Frame.getContentPane().add(BorderLayout.NORTH, card5Top);
		card5Frame.getContentPane().add(BorderLayout.SOUTH, card5Bottom);
		card5Frame.setSize(300,101);
		card5Top.add(putStatic5);
		card5Top.add(swapCard5);
		card5Bottom.add(cancelButton5);
		putStatic5.addActionListener(new PutStatic5Listener());
		swapCard5.addActionListener(new SwapCard5Listener());
		cancelButton5.addActionListener(new CancelCard5Listener());
	}

	public void showCard5(boolean t)
	{
		card5Frame.setVisible(t);
	}

	public void makeCard6()
	{
		card6Frame.getContentPane().add(BorderLayout.NORTH, card6Top);
		card6Frame.getContentPane().add(BorderLayout.SOUTH, card6Bottom);
		card6Frame.setSize(300,101);
		card6Top.add(putStatic6);
		card6Top.add(swapCard6);
		card6Bottom.add(cancelButton6);
		putStatic6.addActionListener(new PutStatic6Listener());
		swapCard6.addActionListener(new SwapCard6Listener());
		cancelButton6.addActionListener(new CancelCard6Listener());
	}

	public void showCard6(boolean t)
	{
		card6Frame.setVisible(t);
	}

	public void makeCard7()
	{
		card7Frame.getContentPane().add(BorderLayout.NORTH, card7Top);
		card7Frame.getContentPane().add(BorderLayout.SOUTH, card7Bottom);
		card7Frame.setSize(300,101);
		card7Top.add(putStatic7);
		card7Top.add(swapCard7);
		card7Bottom.add(cancelButton7);
		putStatic7.addActionListener(new PutStatic7Listener());
		swapCard7.addActionListener(new SwapCard7Listener());
		cancelButton7.addActionListener(new CancelCard7Listener());
	}

	public void showCard7(boolean t)
	{
		card7Frame.setVisible(t);
	}
	public void makeCard8()
	{
		card8Frame.getContentPane().add(BorderLayout.NORTH, card8Top);
		card8Frame.getContentPane().add(BorderLayout.SOUTH, card8Bottom);
		card8Frame.setSize(300,101);
		card8Top.add(putStatic8);
		card8Top.add(swapCard8);
		card8Bottom.add(cancelButton8);
		putStatic8.addActionListener(new PutStatic8Listener());
		swapCard8.addActionListener(new SwapCard8Listener());
		cancelButton8.addActionListener(new CancelCard8Listener());
	}

	public void showCard8(boolean t)
	{
		card8Frame.setVisible(t);
	}

	public void makeAnte()
	{
		ante.setSize(300,100);
		ante.getContentPane().add(BorderLayout.NORTH, anteTop);
		ante.getContentPane().add(BorderLayout.SOUTH, anteBottom);
		anteTop.add(anteLabel);
		anteBottom.add(anteAmount);
		anteBottom.add(anteButton);
		anteButton.addActionListener(new AnteButton());
		anteTop.setSize(300,100);
		anteBottom.setSize(300,100);
	}
	public void showAnte(boolean t)
	{
		anteAmount.requestFocus();
		ante.setVisible(t);
	}

	public void makeBet()
	{
		makeBet.setSize(300,100);
		makeBet.getContentPane().add(BorderLayout.NORTH, betTop);
		makeBet.getContentPane().add(BorderLayout.SOUTH, betBottom);
		betTop.add(betLabel);
		betBottom.add(betAmount);
		betBottom.add(betButton);
		betButton.addActionListener(new BetOkButton());
		betTop.setSize(300,100);
		betBottom.setSize(300,100);
	}
	public void showBet(boolean t)
	{
		betAmount.requestFocus();
		makeBet.setVisible(t);
	}

	public void makeCalled()												// makes the GameCalled window
	{
		gameCalled.setSize(200,125);
		gameCalled.getContentPane().add(BorderLayout.NORTH, gameCalledTop);
		gameCalled.getContentPane().add(BorderLayout.SOUTH, gameCalledBottom);
		gameCalledBottom.add(gameCalledButton);
		gameCalledButton.addActionListener(new GameCalledListener());
		gameCalledTop.add(gameCalledLabel);
	}

	public void showCalled(String name)									// shows the game called window
	{
		gameCalledLabel.setText(name+ " has called the game.");
		gameCalled.setVisible(true);
	}
	public void showCalled(boolean t)
	{
		gameCalled.setVisible(false);
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

	public void delay(long seconds)
	{
		beginning = System.currentTimeMillis();
		seconds = seconds * 1000;
		delayTime = beginning + seconds;
		while (System.currentTimeMillis() < delayTime);
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
		playerCenter.add(playerCash);
		playerCenter.add(mainPotLabel);
		playerCenter.add(sabaccPotLabel);
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
		playerBottom.add(bet);
		playerBottom.add(draw);
		playerBottom.add(end);
		playerBottom.add(call);
		playerBottom.add(fold);
		bet.addActionListener(new BetButtonListener());
		fold.addActionListener(new FoldButtonListener());
		end.addActionListener(new EndTurnListener());
		call.addActionListener(new CallHandListener());
		draw.addActionListener(new DrawCardListener());
		playerCash.setText("Credits: "+ String.valueOf(player.getCredits()));
		mainPotLabel.setText("Main Pot: "+ String.valueOf(mainPot));
		sabaccPotLabel.setText("Sabacc Pot: "+ String.valueOf(sabaccPot));
		playerCard1.addMouseListener(new PlayerCard1Listener());
		playerCard2.addMouseListener(new PlayerCard2Listener());
		playerCard3.addMouseListener(new PlayerCard3Listener());
		playerCard4.addMouseListener(new PlayerCard4Listener());
		playerCard5.addMouseListener(new PlayerCard5Listener());
		playerCard6.addMouseListener(new PlayerCard6Listener());
		playerCard7.addMouseListener(new PlayerCard7Listener());
		playerCard8.addMouseListener(new PlayerCard8Listener());
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
		mainPotLabel.setText("Main Pot: "+ String.valueOf(mainPot));
		sabaccPotLabel.setText("Sabacc Pot: "+ String.valueOf(sabaccPot));
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
		newGameButton.addActionListener(new NewGameListener());
		gameWindowCenter.add(exitProgramButton);
		exitProgramButton.addActionListener(new ExitProgramListener());
		gameWindowBottom.add(optionsButton);
		optionsButton.addActionListener(new OptionsListener());
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
		cpu1Card1.setBackground(cpu1.cardMainColor(1));
		cpu1Card1.setForeground(cpu1.cardTextColor(1));
		cpu1Card2.setBackground(cpu1.cardMainColor(2));
		cpu1Card2.setForeground(cpu1.cardTextColor(2));
		cpu1Card3.setBackground(cpu1.cardMainColor(3));
		cpu1Card3.setForeground(cpu1.cardTextColor(3));
		cpu1Card4.setBackground(cpu1.cardMainColor(4));
		cpu1Card4.setForeground(cpu1.cardTextColor(4));
		cpu1Card5.setBackground(cpu1.cardMainColor(5));
		cpu1Card5.setForeground(cpu1.cardTextColor(5));
		cpu1Card6.setBackground(cpu1.cardMainColor(6));
		cpu1Card6.setForeground(cpu1.cardTextColor(6));
		cpu1Card7.setBackground(cpu1.cardMainColor(7));
		cpu1Card7.setForeground(cpu1.cardTextColor(7));
		cpu1Card8.setBackground(cpu1.cardMainColor(8));
		cpu1Card8.setForeground(cpu1.cardTextColor(8));
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
		cpu2Card1.setBackground(cpu2.cardMainColor(1));
		cpu2Card1.setForeground(cpu2.cardTextColor(1));
		cpu2Card2.setBackground(cpu2.cardMainColor(2));
		cpu2Card2.setForeground(cpu2.cardTextColor(2));
		cpu2Card3.setBackground(cpu2.cardMainColor(3));
		cpu2Card3.setForeground(cpu2.cardTextColor(3));
		cpu2Card4.setBackground(cpu2.cardMainColor(4));
		cpu2Card4.setForeground(cpu2.cardTextColor(4));
		cpu2Card5.setBackground(cpu2.cardMainColor(5));
		cpu2Card5.setForeground(cpu2.cardTextColor(5));
		cpu2Card6.setBackground(cpu2.cardMainColor(6));
		cpu2Card6.setForeground(cpu2.cardTextColor(6));
		cpu2Card7.setBackground(cpu2.cardMainColor(7));
		cpu2Card7.setForeground(cpu2.cardTextColor(7));
		cpu2Card8.setBackground(cpu2.cardMainColor(8));
		cpu2Card8.setForeground(cpu2.cardTextColor(8));
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
		cpu3Card1.setBackground(cpu3.cardMainColor(1));
		cpu3Card1.setForeground(cpu3.cardTextColor(1));
		cpu3Card2.setBackground(cpu3.cardMainColor(2));
		cpu3Card2.setForeground(cpu3.cardTextColor(2));
		cpu3Card3.setBackground(cpu3.cardMainColor(3));
		cpu3Card3.setForeground(cpu3.cardTextColor(3));
		cpu3Card4.setBackground(cpu3.cardMainColor(4));
		cpu3Card4.setForeground(cpu3.cardTextColor(4));
		cpu3Card5.setBackground(cpu3.cardMainColor(5));
		cpu3Card5.setForeground(cpu3.cardTextColor(5));
		cpu3Card6.setBackground(cpu3.cardMainColor(6));
		cpu3Card6.setForeground(cpu3.cardTextColor(6));
		cpu3Card7.setBackground(cpu3.cardMainColor(7));
		cpu3Card7.setForeground(cpu3.cardTextColor(7));
		cpu3Card8.setBackground(cpu3.cardMainColor(8));
		cpu3Card8.setForeground(cpu3.cardTextColor(8));
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
		cpu4Card1.setBackground(cpu4.cardMainColor(1));
		cpu4Card1.setForeground(cpu4.cardTextColor(1));
		cpu4Card2.setBackground(cpu4.cardMainColor(2));
		cpu4Card2.setForeground(cpu4.cardTextColor(2));
		cpu4Card3.setBackground(cpu4.cardMainColor(3));
		cpu4Card3.setForeground(cpu4.cardTextColor(3));
		cpu4Card4.setBackground(cpu4.cardMainColor(4));
		cpu4Card4.setForeground(cpu4.cardTextColor(4));
		cpu4Card5.setBackground(cpu4.cardMainColor(5));
		cpu4Card5.setForeground(cpu4.cardTextColor(5));
		cpu4Card6.setBackground(cpu4.cardMainColor(6));
		cpu4Card6.setForeground(cpu4.cardTextColor(6));
		cpu4Card7.setBackground(cpu4.cardMainColor(7));
		cpu4Card7.setForeground(cpu4.cardTextColor(7));
		cpu4Card8.setBackground(cpu4.cardMainColor(8));
		cpu4Card8.setForeground(cpu4.cardTextColor(8));
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
		cpu5Card1.setBackground(cpu5.cardMainColor(1));
		cpu5Card1.setForeground(cpu5.cardTextColor(1));
		cpu5Card2.setBackground(cpu5.cardMainColor(2));
		cpu5Card2.setForeground(cpu5.cardTextColor(2));
		cpu5Card3.setBackground(cpu5.cardMainColor(3));
		cpu5Card3.setForeground(cpu5.cardTextColor(3));
		cpu5Card4.setBackground(cpu5.cardMainColor(4));
		cpu5Card4.setForeground(cpu5.cardTextColor(4));
		cpu5Card5.setBackground(cpu5.cardMainColor(5));
		cpu5Card5.setForeground(cpu5.cardTextColor(5));
		cpu5Card6.setBackground(cpu5.cardMainColor(6));
		cpu5Card6.setForeground(cpu5.cardTextColor(6));
		cpu5Card7.setBackground(cpu5.cardMainColor(7));
		cpu5Card7.setForeground(cpu5.cardTextColor(7));
		cpu5Card8.setBackground(cpu5.cardMainColor(8));
		cpu5Card8.setForeground(cpu5.cardTextColor(8));
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
		apply.addActionListener(new ApplyButtonListener());
		optionsBottom.add(close);
		close.addActionListener(new CloseOptionsListener());
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
		matchBetYes.addActionListener(new MatchBetListener());
		matchBetBottom.add(matchBetNo);
		matchBetNo.addActionListener(new ForfeitMatchListener());
		matchBetWindow.setSize(200,100);
		matchBetTop.setSize(200,50);
		matchBetBottom.setSize(200,50);
	}
	public void showMatchBetWindow(boolean t)
	{
		matchBetWindow.setVisible(t);
	}
	public void setBetWindow(String name, int amount)
	{
		matchBetLabel.setText(name+ " bet "+amount+". Match bet?");
	}

	public void deal()
	{
		System.out.println("dealing..");

		for(int x = numToDeal; x>0; x--)
		{
			Card temp = (Card)gameDeck.get(cardNum);
			temp.setInPlay(true);
			temp.setIsPlayersCard(true);
			player.addCard(temp);
			cardNum++;
			if(cardNum > 76)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
			System.out.println(player.hand.toString());
		}


		if(cpu1.isPlaying())
		{
			for(int x = numToDeal; x>0; x--)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				cpu1.addCard(temp);
				cardNum++;
				if(cardNum > 76)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				System.out.println(cpu1.hand.toString());
			}
		}
		if(cpu2.isPlaying())
		{
			for(int x = numToDeal; x>0; x--)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				cpu2.addCard(temp);
				cardNum++;
				if(cardNum > 76)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				System.out.println(cpu2.hand.toString());
			}
		}
		if(cpu3.isPlaying())
		{
			for(int x = numToDeal; x>0; x--)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				cpu3.addCard(temp);
				cardNum++;
				if(cardNum > 76)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				System.out.println(cpu3.hand.toString());
			}
		}
		if(cpu4.isPlaying())
		{
			for(int x = numToDeal; x>0; x--)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);;
				cpu4.addCard(temp);
				cardNum++;
				if(cardNum > 76)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				System.out.println(cpu4.hand.toString());
			}
		}
		if(cpu5.isPlaying())
		{
			for(int x = numToDeal; x>0; x--)
			{
				Card temp = (Card) gameDeck.get(cardNum);
				temp.setInPlay(true);
				cpu5.addCard(temp);
				cardNum++;
				if(cardNum > 76)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				System.out.println(cpu5.hand.toString());
			}
		}
	}

	public void sabaccShift()
	{
		System.out.println("OMGGGGGGGGGGGGGGGGGG!!!!!!!!!!!!");
		for(int x = 0; x<player.hand.size(); x++)
		{
			if(player.getCard(x).getStatic() == false)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setIsPlayersCard(true);
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				player.setCard(temp, x);
			}

		}
		for(int x = 0; x < cpu1.hand.size(); x++)
		{
			if(cpu1.getCard(x).getStatic() == false)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setIsPlayersCard(false);
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				cpu1.setCard(temp, x);
			}
		}
		for(int x = 0; x < cpu2.hand.size(); x++)
		{
			if(cpu2.getCard(x).getStatic() == false)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setIsPlayersCard(false);
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				cpu2.setCard(temp, x);
			}
		}
		for(int x = 0; x < cpu3.hand.size(); x++)
		{
			if(cpu3.getCard(x).getStatic() == false)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setIsPlayersCard(false);
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				cpu3.setCard(temp, x);
			}
		}
		for(int x = 0; x < cpu4.hand.size(); x++)
		{
			if(cpu4.getCard(x).getStatic() == false)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setIsPlayersCard(false);
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				cpu4.setCard(temp, x);
			}
		}
		for(int x = 0; x < cpu5.hand.size(); x++)
		{
			if(cpu5.getCard(x).getStatic() == false)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setIsPlayersCard(false);
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				cpu5.setCard(temp, x);
			}
		}
	}

	public void cpuTurn(AIPlayer cpu)
	{
		if(cpu.isPlaying())
		{
			matchNum++;
			cpuBet(cpu, cpu.getName(), (int) cpu.getBet());
			if(cpu.drawCard())
				draw(cpu);
			if(cpu.timeCallGame(this)&& roundNum >4)
				callGame(cpu);
			if(cpu.putCardInField())
			{
				int mrh = rand.nextInt(cpu.hand.size());
				cpu.getCard(mrh).setStatic(!cpu.getCard(mrh).getStatic());
			}
		}
	}

	public void callGame(Player caller)
	{
		lastRound = true;
		showCalled(caller.getName());
	}

	public void cpuBet(AIPlayer cpu, String name, int amount)
	{
		mainPot += amount;
		player.setCredits(player.getCredits() - amount);
		cpu1.setCredits(cpu1.getCredits() - amount);
		cpu2.setCredits(cpu2.getCredits() - amount);
		cpu3.setCredits(cpu3.getCredits() - amount);
		cpu4.setCredits(cpu4.getCredits() - amount);
		cpu5.setCredits(cpu5.getCredits() - amount);
	}

	public void draw(Player drawer)
	{
		if(cardNum > 75)
		{
			cardNum = 0;
			gameDeck = Tester.shuffle(gameDeck);
		}
		drawer.addCard(gameDeck.get(cardNum));
		cardNum++;
	}

	public class NewGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("NewGame pressed!");
			cardNum = 0;
			Tester.shuffle(gameDeck);
			cpu1.setPlaying(true);
			cpu2.setPlaying(true);
			cpu3.setPlaying(true);
			cpu4.setPlaying(false);
			cpu5.setPlaying(false);
			if((String)playerNumBox.getSelectedItem() == "Four players")
			{
				numPlayers = 4;
			}
			if((String)playerNumBox.getSelectedItem() == "Five players")
			{
				numPlayers = 5;
				cpu4.setPlaying(true);
			}
			if((String)playerNumBox.getSelectedItem() == "Six players")
			{
				numPlayers = 6;
				cpu5.setPlaying(true);
			}
			lastRound = false;
			betMatched = false;
			mainPot = 0;
			sabaccPot = 0;
			System.out.println("S pot: "+ sabaccPot);
			System.out.println("M pot: " + mainPot);
			System.out.println("numPlayers:" + numPlayers);
			System.out.println("last round"+ lastRound);
			System.out.println("betMatched: "+ betMatched);
			System.out.println("cardNum: " + cardNum);
			ante.setVisible(true);
			anteAmount.requestFocus();
			showGameWindow(false);
		}
	}

	public class AnteButton implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				String ante = anteAmount.getText();
				int anteNum = Integer.parseInt(ante);
				player.setCredits(player.getCredits() - anteNum);
				sabaccPot += anteNum;
				cpu1.setCredits(cpu1.getCredits() - anteNum);
				sabaccPot += anteNum;
				cpu2.setCredits(cpu2.getCredits() - anteNum);
				sabaccPot += anteNum;
				cpu3.setCredits(cpu3.getCredits() - anteNum);
				sabaccPot += anteNum;
				if(cpu4.isPlaying())
				{
					cpu4.setCredits(cpu4.getCredits() - anteNum);
					sabaccPot += anteNum;
				}
				if(cpu5.isPlaying())
				{
					sabaccPot += anteNum;
					cpu5.setCredits(cpu5.getCredits() - anteNum);
				}
				deal();

				showPlayerHand(true);
				showCPU1Hand(true);
				showCPU2Hand(true);
				showCPU3Hand(true);
				if(cpu4.isPlaying())
					showCPU4Hand(true);
				if(cpu5.isPlaying())
					showCPU5Hand(true);
				updatePlayerFrame();
				updateCPU1Hand();
				updateCPU2Hand();
				updateCPU3Hand();
				updateCPU4Hand();
				updateCPU5Hand();
				showAnte(false);
				anteAmount.setText("");
			}
			catch(Exception ex)
			{
				anteAmount.setText("");
				anteAmount.requestFocus();
			}
		}
	}

	public class ExitProgramListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Exit Program pressed!");
		}
	}

	public class OptionsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Options pressed!");
		}
	}

	public class BetButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			showBet(true);
		}
	}

	public class FoldButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Fold pressed!");
			showPlayerHand(false);
			showCPU1Hand(false);
			showCPU2Hand(false);
			showCPU3Hand(false);
			showCPU4Hand(false);
			showCPU5Hand(false);
			showGameWindow(true);
			playerCard1 = null;
			playerCard2 = null;
			playerCard3 = null;
			playerCard4 = null;
			playerCard5 = null;
			playerCard6 = null;
			playerCard7 = null;
			playerCard8 = null;
			cpu1Card1 = null;
			cpu1Card2 = null;
			cpu1Card3 = null;
			cpu1Card4 = null;
			cpu1Card5 = null;
			cpu1Card6 = null;
			cpu1Card7 = null;
			cpu1Card8 = null;
			cpu2Card1 = null;
			cpu2Card2 = null;
			cpu2Card3 = null;
			cpu2Card4 = null;
			cpu2Card5 = null;
			cpu2Card6 = null;
			cpu2Card7 = null;
			cpu2Card8 = null;
			cpu3Card1 = null;
			cpu3Card2 = null;
			cpu3Card3 = null;
			cpu3Card4 = null;
			cpu3Card5 = null;
			cpu3Card6 = null;
			cpu3Card7 = null;
			cpu3Card8 = null;
			cpu4Card1 = null;
			cpu4Card2 = null;
			cpu4Card3 = null;
			cpu4Card4 = null;
			cpu4Card5 = null;
			cpu4Card6 = null;
			cpu4Card7 = null;
			cpu4Card8 = null;
			cpu5Card1 = null;
			cpu5Card2 = null;
			cpu5Card3 = null;
			cpu5Card4 = null;
			cpu5Card5 = null;
			cpu5Card6 = null;
			cpu5Card7 = null;
			cpu5Card8 = null;

		}
	}

	public class EndTurnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(lastRound)
				checkWin();
			roundNum++;
			canSwitchCard = true;
			System.out.println("EndTurn pressed!");
			cpuTurn(cpu1);
			cpuTurn(cpu2);
			cpuTurn(cpu3);
			cpuTurn(cpu4);
			cpuTurn(cpu5);
			int sababa = rand.nextInt(10);
			if(sababa == 5)
				sabaccShift();
			updatePlayerFrame();
			updateCPU1Hand();
			updateCPU2Hand();
			updateCPU3Hand();
			updateCPU4Hand();
			updateCPU5Hand();
			System.out.println(player.hand.toString());
			System.out.println(cpu1.hand.toString());
			System.out.println(cpu2.hand.toString());
			System.out.println(cpu3.hand.toString());
			System.out.println(cpu4.hand.toString());
			System.out.println(cpu5.hand.toString());
		}
	}

	public class CallHandListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CallHand pressed!");
			lastRound = true;
		}
	}

	public class DrawCardListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Draw card pressed!");
			if(player.hand.size() < 6)
			{
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.addCard(temp);
				cardNum++;
				updatePlayerFrame();
			}
		}
	}

	public class ApplyButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Apply pressed!");
		}
	}

	public class CloseOptionsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CloseOptions pressed!");
		}
	}
	int matchNum = 0;
	public class MatchBetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("MatchBet pressed!");
			if(matchNum == 1)
			{
				cpuTurn(cpu2);
				showMatchBetWindow(false);
			}
			if(matchNum == 2)
			{
				cpuTurn(cpu3);
				showMatchBetWindow(false);
			}
			if(matchNum == 3)
			{
				if(cpu4.isPlaying())
				{
					cpuTurn(cpu4);
					showMatchBetWindow(false);
				}
			}
			if(matchNum == 4)
			{
				if(cpu5.isPlaying())
				{
					cpuTurn(cpu5);
					showMatchBetWindow(false);
				}
			}
			showMatchBetWindow(false);
			updatePlayerFrame();
			updateCPU1Hand();
			updateCPU2Hand();
			updateCPU3Hand();
			updateCPU4Hand();
			updateCPU5Hand();
			showPlayerHand(true);
		}
	}

	public class ForfeitMatchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("ForfeitMatch pressed!");

		}
	}

	public class PlayerCard1Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent event)
		{
			System.out.println("Card1 pressed!");
			showCard1(true);
		}

		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
		public void mouseReleased(MouseEvent e)
		{
		}
	}

	public class PlayerCard2Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent event)
		{
			System.out.println("Card2 pressed!");
			showCard2(true);
		}

		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
		public void mouseReleased(MouseEvent e)
		{
		}
	}

	public class PlayerCard3Listener implements MouseListener
	{
	public void mouseClicked(MouseEvent event)
		{
			System.out.println("Card3 pressed!");
			showCard3(true);
		}

		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
		public void mouseReleased(MouseEvent e)
		{
		}
	}

	public class PlayerCard4Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent event)
		{
			System.out.println("Card4 pressed!");
			showCard4(true);
		}

		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
		public void mouseReleased(MouseEvent e)
		{
		}
	}

	public class PlayerCard5Listener implements MouseListener
	{
	public void mouseClicked(MouseEvent event)
		{
			System.out.println("Card5 pressed!");
			showCard5(true);
		}

		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
		public void mouseReleased(MouseEvent e)
		{
		}
	}

	public class PlayerCard6Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent event)
		{
			System.out.println("Card6 pressed!");
			showCard6(true);
		}

		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
		public void mouseReleased(MouseEvent e)
		{
		}
	}

	public class PlayerCard7Listener implements MouseListener
	{
	public void mouseClicked(MouseEvent event)
		{
			System.out.println("Card7 pressed!");
			showCard7(true);
		}

		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
		public void mouseReleased(MouseEvent e)
		{
		}
	}

	public class PlayerCard8Listener implements MouseListener
	{
		public void mouseClicked(MouseEvent event)
		{
			System.out.println("Card8 pressed!");
			showCard8(true);
		}

		public void mouseEntered(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
		public void mouseReleased(MouseEvent e)
		{
		}
	}

	public class PutStatic1Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard1 pressed!");
			player.getCard(0).switchStatic();
			updatePlayerFrame();
		}
	}
	public class SwapCard1Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("SwapCard1 pressed!");
			if (canSwitchCard)
			{
				canSwitchCard = false;
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.setCard(temp, 0);
				updatePlayerFrame();
			}
		}
	}
	public class CancelCard1Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CancelCard1 pressed!");
			showCard1(false);
		}
	}
	public class PutStatic2Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard2 pressed!");
			player.getCard(1).switchStatic();
			updatePlayerFrame();
		}
	}
	public class SwapCard2Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("SwapCard2 pressed!");
			if (canSwitchCard)
			{
				canSwitchCard = false;
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.setCard(temp, 1);
				updatePlayerFrame();
			}
		}
	}
	public class CancelCard2Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CancelCard2 pressed!");
			showCard2(false);
		}
	}
	public class PutStatic3Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard3 pressed!");
			player.getCard(2).switchStatic();
			updatePlayerFrame();
		}
	}
	public class SwapCard3Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("SwapCard3 pressed!");
			if (canSwitchCard)
			{
				canSwitchCard = false;
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.setCard(temp, 2);
				updatePlayerFrame();
			}
		}
	}
	public class CancelCard3Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard3 pressed!");
			showCard3(false);
		}
	}
	public class PutStatic4Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard4 pressed!");
			player.getCard(3).switchStatic();
			updatePlayerFrame();
		}
	}
	public class SwapCard4Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("SwapCard4 pressed!");
			if (canSwitchCard)
			{
				canSwitchCard = false;
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.setCard(temp, 3);
				updatePlayerFrame();
			}
		}
	}
	public class CancelCard4Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CancelCard4 pressed!");
			showCard4(false);
		}
	}
	public class PutStatic5Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard5 pressed!");
			player.getCard(4).switchStatic();
			updatePlayerFrame();
		}
	}
	public class SwapCard5Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("SwapCard5 pressed!");
			if (canSwitchCard)
			{
				canSwitchCard = false;
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.setCard(temp, 4);
				updatePlayerFrame();
			}
		}
	}
	public class CancelCard5Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CancelCard5 pressed!");
			showCard5(false);
		}
	}
	public class PutStatic6Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard6 pressed!");
			player.getCard(5).switchStatic();
			updatePlayerFrame();
		}
	}
	public class SwapCard6Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("SwapCard6 pressed!");
			if (canSwitchCard)
			{
				canSwitchCard = false;
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.setCard(temp, 5);
				updatePlayerFrame();
			}
		}
	}
	public class CancelCard6Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CancelCard6 pressed!");
			showCard6(false);
		}
	}
	public class PutStatic7Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard7 pressed!");
			player.getCard(6).switchStatic();
			updatePlayerFrame();
		}
	}
	public class SwapCard7Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("SwapCard7 pressed!");
			if (canSwitchCard)
			{
				canSwitchCard = false;
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.setCard(temp, 6);
				updatePlayerFrame();
			}
		}
	}
	public class CancelCard7Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CancelCard7 pressed!");
			showCard7(false);
		}
	}
	public class PutStatic8Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("StaticCard8 pressed!");
			player.getCard(7).switchStatic();
			updatePlayerFrame();
		}
	}
	public class SwapCard8Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("SwapCard8 pressed!");
			if (canSwitchCard)
			{
				canSwitchCard = false;
				cardNum++;
				if(cardNum > 75)
				{
					cardNum = 0;
					gameDeck = Tester.shuffle(gameDeck);
				}
				Card temp = (Card)gameDeck.get(cardNum);
				temp.setInPlay(true);
				temp.setIsPlayersCard(true);
				player.setCard(temp, 7);
				updatePlayerFrame();
			}
		}
	}
	public class CancelCard8Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("CancelCard8 pressed!");
			showCard8(false);
		}
	}


	public class GameCalledListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("GameCalled pressed!");
			showCalled(false);
			if(roundNum > 4)
				lastRound = true;
		}
	}

	public class BetOkButton implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("Button BetOk pushed!");
			try
			{
				String betS = betAmount.getText();
				int betNum = Integer.parseInt(betS);
				player.setCredits(player.getCredits() - betNum);
				mainPot += betNum;
				cpu1.setCredits(cpu1.getCredits() - betNum);
				mainPot += betNum;
				cpu2.setCredits(cpu2.getCredits() - betNum);
				mainPot += betNum;
				cpu3.setCredits(cpu3.getCredits() - betNum);
				mainPot += betNum;
				if(cpu4.isPlaying())
				{
					cpu4.setCredits(cpu4.getCredits() - betNum);
					mainPot += betNum;
				}
				if(cpu5.isPlaying())
				{
					mainPot += betNum;
					cpu5.setCredits(cpu5.getCredits() - betNum);
				}
				updatePlayerFrame();
				updateCPU1Hand();
				updateCPU2Hand();
				updateCPU3Hand();
				updateCPU4Hand();
				updateCPU5Hand();
				showBet(false);
				betAmount.setText("");

			}
			catch(Exception ex)
			{
				betAmount.setText("");
				betAmount.requestFocus();
			}
		}
	}
	public void checkWin()
	{
		
	}
}


