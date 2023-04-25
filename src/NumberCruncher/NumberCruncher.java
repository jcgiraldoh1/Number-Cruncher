package NumberCruncher;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;
import java.util.Random;

public class NumberCruncher extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;												
	private JPanel contentPane = new JPanel();												// I declare private JPanel panel.	
	private JPanel historyContainer;														// I declare private JPanel historyContainer.
	private Player player;																	// I declare private Player from player.
	private int lost = 0;																	// I declare private int lost.
	private int round = 0;																	// I declare private int round.
	private int range=0;																	// I declare private int range.	
	private JLabel lblBackEasy;																// I declare private JLabel lblBackEasy.
	private JLabel lblBackModerate;															// I declare private JLabel lblBackModerate.
	private JLabel lblBackDifficult;														// I declare private JLabel lblBackDifficult.
	private JLabel lblAttempts;																// I declare private JLabel lblAttempts.
	private JLabel lblTextAttempts;															// I declare private JLabel lblTextAttempts.
	private Image wrong;																	// I declare private Image wrong.		
	private Image ok; 																		// I declare private Image ok.
	private Image arrowUp;																	// I declare private Image arrowUp.
	private Image arrowDown; 																// I declare private Image arrowDown.
	private Vector<Track> trackList;														// I declare private Vector trackList.
	private int[] attemptList = {0,0,0,0,0,0,0};											// I declare private Array attemptList.
	private JLabel lblNumberRange;															// I declare JPanel lblNumberRange.
	private JLabel lblBackground;															// I declare JPanel lblBackground.
	private JLabel lblNumRange;																// I declare JPanel lblNumRange.
	private JLabel lblScore;																// I declare JPanel lblScore.	
	private JLabel lblNumScore;																// I declare JPanel lblNumScore.
	private String playerInitials;															// I declare String playerInitials.
	private JButton btnSubmit;																// I declare JButton btnSubmit.
	private JButton btnEasy;																// I declare JButton btnEasy.
	private JButton btnModerate;															// I declare JButton btnModerate.
	private JButton btnDifficult;															// I declare JButton btnDifficult.
	private JButton btnExit;																// I declare JButton btnExit.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberCruncher frame = new NumberCruncher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NumberCruncher() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	NumberCruncher()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows show graphics items
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
						
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 				
		setBounds(100, 100, 800, 800);									// For set the bounds.
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));				// For set the border.
		setContentPane(contentPane);									// For set the ContentPane.
		contentPane.setLayout(null);									// For set the layout.		
		
		startGame();													// For call the method startGame().
		welcomeMsg();													// For call the method welcomeMsg().
			
	}
	
	public void startGame() {	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	startGame()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows show graphics items
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		historyContainer = new JPanel();
		historyContainer.setOpaque(false);								// For set the preset Opaque
		historyContainer.setBounds(0, 0, 800, 800);						// For set the bounds.
		historyContainer.setLayout(null);								// For set the layout.
		contentPane.add(historyContainer);								// For add in the contentPane.
		
		wrong =Toolkit.getDefaultToolkit().getImage("Images\\X.PNG");// I declare private Vector JLabel wrong.
		ok = Toolkit.getDefaultToolkit().getImage("Images\\Ok.PNG");// I declare private Vector JLabel ok.
		arrowUp = Toolkit.getDefaultToolkit().getImage("Images\\UpArrow.PNG");	// I declare private Vector JLabel arrowUp.
		arrowDown = Toolkit.getDefaultToolkit().getImage("Images\\ArrowDown.PNG");// I declare private Vector JLabel arrowDown.		
		
		lblBackEasy = new JLabel();										// For create the label lblBackEasy.
		lblBackEasy.setBounds(165, 187, 198, 325);						// For set the bounds lblBackEasy.		
		lblBackEasy.setBackground(new Color(255, 255, 255));			// For set the background lblBackEasy.
		lblBackEasy.setIcon(new ImageIcon("Images/Easy.png"));			// For set the Icon lblBackEasy.
		contentPane.add(lblBackEasy);									// For add in the contentPane.
		
		lblBackModerate = new JLabel();									// For create the label lblBackModerate.
		lblBackModerate.setBounds(169, 187, 319, 325);					// For set the bounds lblBackModerate.
		lblBackModerate.setLayout(new BorderLayout());// 				// For set the borderlayout.
		lblBackModerate.setIcon(new ImageIcon("Images/Moderate.png"));	// For set the Icon lblBackModerate.	
		contentPane.add(lblBackModerate);								// For add in the contentPane.
		
		lblBackDifficult = new JLabel();								// For create the label lblBackDifficult.
		lblBackDifficult.setBounds(185, 187, 517, 325);					// For set the borderlayout.
		lblBackDifficult.setLayout(new BorderLayout());					// For set the bounds lblBackDifficult.
		lblBackDifficult.setIcon(new ImageIcon("Images/Difficult.png"));// For set the Icon lblBackDifficult.			
		contentPane.add(lblBackDifficult);								// For add in the contentPane.		
		
		lblNumberRange = new JLabel("Number Range: 1 -");				// For create the label lblNumberRange.
		lblNumberRange.setFont(new Font("Tahoma", Font.BOLD, 16));		// For set the font lblNumberRange.
		lblNumberRange.setBounds(297, 660, 162, 30);					// For set the bounds lblNumberRange.
		contentPane.add(lblNumberRange);								// For add in the contentPane.
		
		lblNumRange = new JLabel();										// For create the label lblNumRange.
		lblNumRange.setFont(new Font("Tahoma", Font.BOLD, 16));			// For set the font lblNumRange.
		lblNumRange.setBounds(459, 660, 61, 33);						// For set the bounds lblNumRange.		
		contentPane.add(lblNumRange);									// For add in the contentPane.
		
		lblScore = new JLabel("Score:");								// For create the label lblScore.
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 16));			// For set the font lblScore.
		lblScore.setBounds(530, 665, 60, 14);							// For set the bounds lblScore.
		contentPane.add(lblScore);										// For add in the contentPane.
		
		lblNumScore = new JLabel();										// For create the label lblNumScore.
		lblNumScore.setFont(new Font("Tahoma", Font.BOLD, 16));			// For set the font lblNumScore.
		lblNumScore.setBounds(592, 655, 52, 33);						// For set the bounds lblNumScore.		
		contentPane.add(lblNumScore);									// For add in the contentPane.
		
		lblAttempts= new JLabel();
		lblAttempts.setFont(new Font("Tahoma", Font.BOLD, 16));			// For set the font lblAttempts.
		lblAttempts.setBounds(178, 627, 120, 33);						// For set the bounds lblAttempts.		
		contentPane.add(lblAttempts);									// For add in the contentPane.		
		
		lblTextAttempts= new JLabel("Attempts: ");
		lblTextAttempts.setFont(new Font("Tahoma", Font.BOLD, 16));			// For set the font lblAttempts.
		lblTextAttempts.setBounds(90, 627, 120, 33);						// For set the bounds lblAttempts.		
		contentPane.add(lblTextAttempts);									// For add in the contentPane.			
		
		btnSubmit = new JButton("Submit");								// For create the JButton btnSubmit.
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				submitGuessNumbers();									// For call the method submitGuessNumbers().
				
			}
		});
		btnSubmit.setBounds(178, 660, 109, 37);							// For set the bounds btnSubmit.
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));			// For set the font btnSubmit.
		contentPane.add(btnSubmit);										// For add in the contentPane.
		
		btnExit = new JButton ("Exit");									// For create the JButton btnExit.
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				dispose();												// For call the method dispose.
			}
		});
		btnExit.setBounds(650, 30, 109, 37);							// For set the bounds btnExit.
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));				// For set the font btnExit.		
		contentPane.add(btnExit);										//// For add in the contentPane.
		
		if(round <1) {													// For validate the round less than 1.
			
			 player= new Player();										// I declare private for instantiate the class Player.	
			 trackList = new Vector<Track>();							// I declare private Vector JLabel trackList.
			
			
		btnEasy = new JButton();										// For create the JButton btnEasy.
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				range = range + 10;										// For the range per each level
				player.setLevel(0);										// For call the method player.setLevel(0).					
				createTracks();											// For call the method that create the logic of the tracks.		
				createTextFields();										// For call the method that create the textfields.
				guiEasy();												// For call the method guiEasy().
				startNewRound();										// For call the method startNewRound().				
				
			}
		});
		btnEasy.setIcon(new ImageIcon("Images/EasyLevel.png"));			// For set the Icon btnEasy.
		btnEasy.setBounds(262, 218, 250, 53);							// For set the bounds btnEasy.
		contentPane.add(btnEasy);										// For add in the contentPane.
		
		btnModerate = new JButton();									// For create the JButton btnModerate.
		btnModerate.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				range = range + 100;									// For the range per each level
				player.setLevel(1);										// For call the method player.setLevel(1).				
				createTracks();											// For call the method that create the logic of the tracks.		
				createTextFields();										// For call the method that create the textfields.
				guiModerate();											// For call the method guiModerate().
				startNewRound();										// For call the method startNewRound().
				
				
			}
		});
		btnModerate.setIcon(new ImageIcon("Images/MediumLevel.png"));	// For set the Icon btnModerate.
		btnModerate.setBounds(262, 307, 250, 53);						// For set the bounds btnModerate.
		contentPane.add(btnModerate);									// For add in the contentPane.
		
		btnDifficult = new JButton();									// For create the JButton btnDifficult.
		btnDifficult.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				range = range + 1000;									// For the range per each level
				player.setLevel(2);										// For call the method player.setLevel(2).						
				createTracks();											// For call the method that create the logic of the tracks.		
				createTextFields();										// For call the method that create the textfields.	
				guiDifficult();											// For call the method guiDifficult().
				startNewRound();										// For call the method startNewRound().
				
			}
		});
		btnDifficult.setIcon(new ImageIcon("Images/HardLevel.png"));	// For set the Icon btnDifficult.
		btnDifficult.setBounds(262, 394, 250, 53);						// For set the bounds btnDifficult.
		contentPane.add(btnDifficult);									// For add in the contentPane.
	
		
		}else {
			switch (player.getLevel()) {
			case 0: {
				
				player.setLevel(0);										// For call the method player.setLevel(0).					
				createTracks();											// For call the method that create the logic of the tracks.		
				createTextFields();										// For call the method that create the textfields.
				guiEasy();												// For call the method guiEasy().
				startNewRound();										// For call the method startNewRound().
				break;
			}
			case 1: {
				
				player.setLevel(1);										// For call the method player.setLevel(1).				
				createTracks();											// For call the method that create the logic of the tracks.		
				createTextFields();										// For call the method that create the textfields.
				guiModerate();											// For call the method guiModerate().
				startNewRound();										// For call the method startNewRound().
				break;
			
			}
			case 2: {
				
				player.setLevel(2);										// For call the method player.setLevel(2).						
				createTracks();											// For call the method that create the logic of the tracks.		
				createTextFields();										// For call the method that create the textfields.	
				guiDifficult();											// For call the method guiDifficult().
				startNewRound();										// For call the method startNewRound().
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + player.getLevel());
			}			
		}													
		
		lblBackground = new JLabel("");									// New JLabel for the lblBackground
		lblBackground.setFont(new Font("Tahoma", Font.PLAIN, 16));		// For set the font. 
		lblBackground.setBounds(0, 0, 784, 761);						// For set the bounds.
		lblBackground.setIcon(new ImageIcon("Images/1.png"));			// For set the Icon.
		contentPane.add(lblBackground);									// For add in the contentPane.
		
		lost =0;														// For reset lost.
	}
	
	private void createTextFields() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	createTextFields()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows create the textfields.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int posX = 178, gapX = 65, posY = 570; 											// The location on the screen.
		int width = 42, height = 43;		
		
		AtomicInteger counter = new AtomicInteger(0); 									//int counter;
		trackList.forEach( (track) -> {
			JTextField field = track.getTextInput();
			field.setBounds(posX + (gapX * counter.get()), posY, width, height);		// For set the bounds.
			field.setDisabledTextColor(new Color(30, 144, 255));						// For disable the color text.
			field.setBackground(new Color(169, 169, 169));								// For set the background.
			field.setHorizontalAlignment(SwingConstants.CENTER);						// For set the alignment.
			field.setFont(new Font("Tahoma", Font.PLAIN, 16));							// For set the font.
			field.setColumns(10);														// For set the columns.
			contentPane.add(field);														// For add in the contentPane.
			counter.getAndIncrement(); 													// counter++;
			field.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume(); 													// if it's not a number, ignore the event
                    }
                }

            });
		});
	}		
	
	public void welcomeMsg() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	welcomeMsg()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows return the mode.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		playerInitials = JOptionPane.showInputDialog(null, "Welcome to Number Cruncher. \nPlease enter the initials of your name:  ");											// Show message for the player);
		boolean done = false;																																					//boolean
		while(!done){																																							// For check if the player typed just the initials.
		
		        if(playerInitials.matches("[a-zA-Z]+")){
		            if(playerInitials.length() ==3){
		               
		                done = true;
		            }else{
		              
		                playerInitials = JOptionPane.showInputDialog(null, "Please type no more than 3 characters: ", playerInitials);											// Show message for the player
		            }

		        }else{
		           
		            playerInitials = JOptionPane.showInputDialog(null, "Please enter a valid initials containing: ‘a-z’ or ‘A-Z’ lower or upper case", playerInitials);			// Show message for the player
		        }
		}	
		
		guiDifficulty();																																						// For call the method guiDifficulty().
	}
	
	public void guiDifficulty() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	guiDifficulty()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows showing the difficulty options.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		trackList.forEach( (track) -> {track.getTextInput().setVisible(false);});					// set not visible for this option.			
		lblBackEasy.setVisible(false);																// set not visible for this option.
		lblBackModerate.setVisible(false);															// set not visible for this option.
		lblBackDifficult.setVisible(false);															// set not visible for this option.		
		btnSubmit.setVisible(false);																// set not visible for this option.
		lblScore.setVisible(false);																	// set not visible for this option.
		lblNumScore.setVisible(false);																// set not visible for this option.
		lblNumberRange.setVisible(false);															// set not visible for this option.
		lblNumRange.setVisible(false);																// set not visible for this option.
		lblAttempts.setVisible(false);																// set not visible for this option.
		lblTextAttempts.setVisible(false);															// set not visible for this option.
		lblBackground.setVisible(true);																// set  visible for this option.

		}
	
	public void guiEasy() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	guiEasy()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows showing the easy mode.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		for(int index = 0 ; index < 3; index++)														
			trackList.get(index).getTextInput().setVisible(true);									// set visible for this option.
		for(int index = 3 ; index < 7; index++)	
			trackList.get(index).getTextInput().setVisible(false);									// set not visible for this option.
		for(int index = 0 ; index < 3; index++)														
			trackList.get(index).getAttemtpsLbl().setVisible(true);									// set visible for this option.
		for(int index = 3 ; index < 7; index++)
			trackList.get(index).getAttemtpsLbl().setVisible(false);								// set not visible for this option.
		lblBackEasy.setVisible(true);																// set  visible for this option.
		lblBackModerate.setVisible(false);															// set not visible for this option.
		lblBackDifficult.setVisible(false);															// set not visible for this option.
		btnSubmit.setVisible(true);																	// set  visible for this option.
		lblScore.setVisible(true);																	// set  visible for this option.
		lblNumScore.setVisible(true);																// set  visible for this option.
		lblNumberRange.setVisible(true);															// set  visible for this option.
		lblNumRange.setVisible(true);																// set  visible for this option.
		lblAttempts.setVisible(true);																// set  visible for this option.
		lblTextAttempts.setVisible(true);															// set  visible for this option.
		lblBackground.setVisible(true);																// set  visible for this option.
		btnEasy.setVisible(false);																	// set not visible for this option.
		btnModerate.setVisible(false);																// set not visible for this option.
		btnDifficult.setVisible(false);																// set not visible for this option.
		

	}
	
	public void guiModerate() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	guiModerate()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows showing the moderate mode.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		for(int index = 0 ; index < 5; index++)
			trackList.get(index).getTextInput().setVisible(true);									// set  visible for this option.
		for(int index = 5 ; index < 7; index++)	
			trackList.get(index).getTextInput().setVisible(false);									// set not visible for this option.	
		for(int index = 0 ; index < 5; index++)														
			trackList.get(index).getAttemtpsLbl().setVisible(true);									// set visible for this option.
		for(int index = 5 ; index < 7; index++)
			trackList.get(index).getAttemtpsLbl().setVisible(false);								// set not visible for this option.
		lblBackEasy.setVisible(true);																// set  visible for this option.
		lblBackModerate.setVisible(true);															// set  visible for this option.
		lblBackDifficult.setVisible(false);															// set not visible for this option.
		btnSubmit.setVisible(true);																	// set  visible for this option.
		lblScore.setVisible(true);																	// set  visible for this option.
		lblNumScore.setVisible(true);																// set  visible for this option.
		lblNumberRange.setVisible(true);															// set  visible for this option.
		lblNumRange.setVisible(true);																// set  visible for this option.
		lblAttempts.setVisible(true);																// set visible for this option.
		lblTextAttempts.setVisible(true);															// set visible for this option.
		lblBackground.setVisible(true);																// set  visible for this option.
		btnEasy.setVisible(false);																	// set not visible for this option.
		btnModerate.setVisible(false);																// set not visible for this option.
		btnDifficult.setVisible(false);																// set not visible for this option.

	}
	
	public void guiDifficult() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	guiDifficult()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows showing the difficult mode.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		for(int index = 0 ; index < 7; index++)
			trackList.get(index).getTextInput().setVisible(true);									// set  visible for this option.
		for(int index = 0 ; index < 7; index++)
			trackList.get(index).getAttemtpsLbl().setVisible(true);									// set  visible for this option.
		lblBackEasy.setVisible(true);																// set  visible for this option.
		lblBackModerate.setVisible(true);															// set  visible for this option.
		lblBackDifficult.setVisible(true);															// set  visible for this option.
		btnSubmit.setVisible(true);																	// set  visible for this option.
		lblScore.setVisible(true);																	// set  visible for this option.
		lblNumScore.setVisible(true);																// set  visible for this option.
		lblNumberRange.setVisible(true);															// set  visible for this option.
		lblNumRange.setVisible(true);																// set  visible for this option.
		lblAttempts.setVisible(true);																// set visible for this option.
		lblTextAttempts.setVisible(true);															// set visible for this option.
		lblBackground.setVisible(true);																// set  visible for this option.
		btnEasy.setVisible(false);																	// set not  visible for this option.
		btnModerate.setVisible(false);																// set not  visible for this option.
		btnDifficult.setVisible(false);																// set not  visible for this option.		
	}	
	
	public void startNewRound() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	startNewRound()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows star a new round.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		int attempt=0;													//int variable attempt in a cero value.
		int setTracks=0;												//int variable setTracks in a cero value.
		switch(player.getLevel()) {										// switch for with a case per level.
		case 0: 														// Easy
			attempt = 5;												// number of attempts.				
			setTracks = 3;												// number of tracks
			Track.setRange(Track.getRange()+10);						// the range
			break;
		case 1: 														// Moderate
			attempt = 7;												// number of attempts.
			setTracks = 5;												// number of tracks
			Track.setRange(Track.getRange()+100);						// the range
			break;
		case 2: 														// Difficult
			attempt = 11;												// number of attempts.
			setTracks = 7;												// number of tracks
			Track.setRange(Track.getRange()+1000);						// the range
			break;				
			
		}
		
		for(int index = 0; index < setTracks; index++) {				// This for allows one to go through the tracks and obtain their value.
			Track track = trackList.get(index);
			boolean done = false;										// boolean done = false.
			
			while(!done){												// While not 
				done = false;											// Done equal false.
				track.createNumberList(Track.getRange()+1, 1000);		// Call the range
				track.createHistogram();								// Call the method histogram.
				if(!track.isMultimode()) done = true;					// For check if is multimode
				track.setCounter(track.getCounter()+1);					// For count how many times is multimode.
				
			}
			
			track.setGuessNumber(track.getMode());											// For set the number to guess.
			track.setAttempts(attempt + attemptList[index]);								// For get the attempts.
			track.getAttemtpsLbl().setText(Integer.toString(track.getAttempts()));			// For get the lblAttempts.
			lblNumRange.setText(String.valueOf(range));										// For get the range.
			lblNumScore.setText(String.valueOf(player.getScore()));							// For get the score.			
		}		
	}
	
	public void disableElements(int level) {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	disableElements()
	//
	// Method parameters	:	level
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows hide graphics items relate with the levels
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-06-06		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		if(level ==1) {
			trackList.get(5).getTextInput().setEnabled(false);
			trackList.get(6).getTextInput().setEnabled(false);
		}else if(level ==0) {
			trackList.get(3).getTextInput().setEnabled(false);
			trackList.get(4).getTextInput().setEnabled(false);
			trackList.get(5).getTextInput().setEnabled(false);
			trackList.get(6).getTextInput().setEnabled(false);
		}		
	}
	
	public void createTracks() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	createTracks()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows create the logic of the tracks.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		trackList.clear();
		for(int index = 0; index < 7; index++) {																		// For create the tracks.
			trackList.add(new Track(range));			
			int posXArrow = 178, gapX = 65, posYArrow = 519;															// The location on the screen.
			int widthArrow = 35, heightArrow = 40;
			trackList.get(index).getArrows().setBounds(posXArrow + (gapX * index), posYArrow, widthArrow, heightArrow);
			contentPane.add(trackList.get(index).getArrows());															// For add in the contentPane.			
			
			int posXAtp = 190, gapXAtp = 65, posYAtp = 620;															// The location on the screen.
			int widthAtp = 35, heightAtp = 40;
			trackList.get(index).getAttemtpsLbl().setFont(new Font("Tahoma", Font.BOLD, 16));
			trackList.get(index).getAttemtpsLbl().setForeground((Color.BLACK));
			trackList.get(index).getAttemtpsLbl().setBounds(posXAtp + (gapXAtp * index), posYAtp, widthAtp, heightAtp);
			trackList.get(index).getAttemtpsLbl().setText(Integer.toString(trackList.get(index).getAttempts()));
			contentPane.add(trackList.get(index).getAttemtpsLbl());
			
			int posXchm = 178, gapXchm = 65, posYchm = 131;																// The location on the screen.
			int widthchm = 42, heightchm = 43;			
			trackList.get(index).getCheckmark().setBounds(posXchm + (gapXchm * index), posYchm, widthchm, heightchm);		
			contentPane.add(trackList.get(index).getCheckmark());													
			System.out.println("Track: " + index + " " + trackList.get(index).getMode());
		}	
		disableElements(player.getLevel());																				// For call the method disableElements.
		
	}	
	public void submitGuessNumbers() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	submitGuessNumbers()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows get the info per each track, and check no empty values per each track.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-06-06		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        int validator = 0;
        int temp1 = 3 + (player.getLevel()*2);
        for(int i = 0; i < trackList.size(); i++) {
            if(trackList.get(i).getTextInput().isEnabled()) {									 // For check if the TextInput is enabled.
            	
            		if(trackList.get(i).getTextInput().getText().isBlank()) {					//For check if the textinput is blank or empty.
            			validator++;
            			}
            		}
            }
        
        if(validator==0) {
        	int counter = 0;
            for (int i = 0; i < temp1; i++) {
                if(trackList.get(i).getTextInput().isEnabled()) {
                	int temp;																	// I declare temp variable.
                	if(trackList.get(i).getTextInput().getText().equals("")) {					// For check if the text is "".
                		temp = 0;
                	} else {
                		temp = Integer.parseInt(trackList.get(i).getTextInput().getText());
                		} 
                    
                    evaluate(i, temp);
                    }
                if(trackList.get(i).getTextInput().isEnabled()) {								// For check if the TextInput is enabled.
                	counter ++;																	// For increase the counter.
                	}
                if (lost > 0){
                    i = temp1;
                }
            }

            if(counter==0) {																	// For check if counter is equals 0
                nextLevel();																	// For call the method nextLevel().
            }
            if(lost >0) {																		//For reset the default values.
            	round = 0;	
            	player.setScore(0);
        		this.setVisible(false);
        		trackList.clear();
        		range = 0;
        		for(int i = 0; i < attemptList.length;i++) {
        			attemptList[i] = 0;
        		}
        		startGame();																				// For call the method startGame.
        		welcomeMsg();																				// For call the method welcomeMsg.
        		this.setVisible(true);																		// For set contentPane visible.
        		
            }

        }    else {
            JOptionPane.showMessageDialog(null, "Missing to fill track(s).");								// For show a message.
        }
    }	
	
	public void evaluate(int track, int number) {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	evaluate()
	//
	// Method parameters	:	int track, int number
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows evaluate if the mode and numbers are corrects or not.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-06-06		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		if(trackList.get(track).getMode()==number) {			// For compare mode and number.
			correctGuessNumbers(track);							// For call the method correctGuessNumbers.
		}
		else {
			if(trackList.get(track).getAttempts()-1 >0) {
				wrongGuessNumbers(track, number);					// For call the method wrongGuessNumbers
			}else {
				JOptionPane.showMessageDialog(null, "You have no more attempts, you lose the game.");	// For show a message.
				endGame();
			}			
		}		
	}
	
	public void correctGuessNumbers(int track) {	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	correctGuessNumbers()
	//
	// Method parameters	:	int track.
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows get the score, bonus score, show the checkmarck and set the inputtext for each track not enable.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-06-06		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		trackList.get(track).getTextInput().setEnabled(false);																					// For set not enable the textInput.
		player.setScore(player.getScore()+(10*trackList.get(track).getAttempts())+((int)(trackList.get(track).getAttempts()/3)*50));			// For get the score.
		trackList.get(track).getCheckmark().setVisible(true);																					// For show the checkmark.
		trackList.get(track).getCheckmark().setIcon(new ImageIcon(ok));																			// For set the Icon.	
		attemptList[track]= Integer.parseInt(trackList.get(track).getAttemtpsLbl().getText());													// For get the text in the label.
	}
	
	public void nextLevel() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	nextLevel()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows manage the levels.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-06-06		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		if(player.getLevel() == 0)  {			// For check the level.
			contentPane.removeAll();			// For remove the panel
			contentPane.revalidate();			// For revalidate the panel.
			contentPane.repaint();				// For repaint the panel.
			round++;							// For increase the round.
			range = range+10;					// For increase the range.			
			if(range ==100) {					// Set the level per range.
				player.setLevel(1);
			}			
			startGame();						// For call the method startGame.
			JOptionPane.showMessageDialog(null, "Congratulations, keep going.");		// For show the message.
			
		}else if(player.getLevel() == 1) {		// For check the level.
			this.contentPane.removeAll();		// For remove the panel
			contentPane.revalidate();			// For revalidate the panel.
			contentPane.repaint();				// For repaint the panel.
			round++;							// For increase the round.
			range = range+100;					// For increase the range.
			if(range ==1000) {					// Set the level per range.
				player.setLevel(2);				
			}			
			startGame();						// For call the method startGame.
			JOptionPane.showMessageDialog(null, "Congratulations, keep going.");		// For show the message.
		
		}else if(player.getLevel() == 2) {		// For check the level.	
			contentPane.removeAll();			// For remove the panel
			contentPane.revalidate();			// For revalidate the panel.
			contentPane.repaint();				// For repaint the panel.
			round++;							// For increase the round.
			range = range+1000;					// For increase the range.
			startGame();						// For call the method startGame.
			JOptionPane.showMessageDialog(null, "Congratulations, keep going.");		// For show the message.	
		}		
	}	
	public void wrongGuessNumbers(int track, int number) {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	wrongGuessNumbers()
	//
	// Method parameters	:	int track, int number.
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows show graphics items
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-06-06		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		trackList.get(track).setWrongGuessNum(number);											// For set the number in wrongguessnum.
		historyContainer.removeAll();															// For remove all in historyContainer
		for(int index = 0; index < 7; index++) {												// For create the tracks.			
			for(int counter=0; counter < trackList.get(index).getWrongGuessNum().size() && counter < 5;counter++) {			//For check the wrongguessnum size or the counter less than 5.
				JLabel attempt = trackList.get(index).getAttemptList().get(counter);			// For get the counter.
				historyContainer.add(attempt);													// For add in the contentPane.				
				int posX = 160, gapY = 65, posY = 480;			 								// The location on the screen.
				int width = 60, height = 25;											
				attempt.setBounds(posX + (gapY * index) , posY- (gapY * counter), width, height);		// For set the bounds.
				attempt.setHorizontalAlignment(JLabel.CENTER);									// For set the alignment.
				attempt.setFont(new Font("Tahoma", Font.BOLD, 20));								// For set the font.
				attempt.setForeground(Color.WHITE);												// For set the foreground.
				attempt.setHorizontalTextPosition(JLabel.CENTER);								// For set the position.
				attempt.setVerticalAlignment(JLabel.TOP);										// For set the alignment.
				attempt.setText(Integer.toString(trackList.get(index).getWrongGuessNum().get(counter)));			// For get the counter.				
			}										
		}	
		if(trackList.get(track).getMode() > number) {												// For check if the mode is grater than number.
			trackList.get(track).getArrows().setIcon(new ImageIcon(arrowUp));						// For set the imageicon.
		}else {
			trackList.get(track).getArrows().setIcon(new ImageIcon(arrowDown));						// For set the imageicon.
		}
		trackList.get(track).setAttempts(trackList.get(track).getAttempts()-1);         			// For reduce an attempts.
		trackList.get(track).getAttemtpsLbl().setText(String.valueOf(trackList.get(track).getAttempts()));	// For get the attempts in the label.
		trackList.get(track).getCheckmark().setIcon(new ImageIcon(wrong));							// For set the imageicon.		
		}
	
	public void saveGame() {	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	saveGame()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows save the player data.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-06-06		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		String playerData = playerInitials+".txt";
		
		try {				
			FileWriter myWriter = new FileWriter(playerData);																//For create a file and save the information in a txt file.
		      myWriter.write("Score: " + String.valueOf(player.getScore()) + " " + "Level" + player.getLevel() + " " );
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
	}
	
	public void endGame() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	endGame()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows finishing the game because the player lost.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		lost++;
		saveGame();																					// For call the method saveGame.
		contentPane.removeAll();																	// For remove all in contentPane.
		contentPane.revalidate();																	// For revalidate all in contentPane.
		contentPane.repaint();																		// For repaint in contentePane.						
	}	
}

