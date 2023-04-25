package NumberCruncher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Track {
	
	Random num = new Random();
	private int counter=0;																			//I declare private int the variable counter.	
	private int guessNumber;																		// I declare private int the variable guessNumber.
	private int attempts=0;																			// I declare private int the variable attempts.
	private int mode=0;																				// I declare private int the variable mode.
	private static int range=0;																		// I declare private int the variable range.
	private Vector<Integer> inputNumberList = new Vector<Integer>();								// I declare private int Vector of the variable inputNumberList.
	private Vector<Integer> randomNumberList = new Vector<Integer>();								// I declare private int Vector of the variable randomNumberList.	
	private Vector<JLabel> attemptList = new Vector<JLabel>();										// I declare private Vector JLabel attemptList.
	private LinkedHashMap<Integer, Integer> histogram = new LinkedHashMap<Integer, Integer>();		// I declare private int HashMap of  the variable histogram.
	private JTextField textInput = new JTextField();												// I declare private Vector JTextField textInput.
	private Vector<Integer> wrongGuessNum = new Vector<Integer>(); 									// I declare private Vector Integer wrongGuessNum.
	private JLabel checkmark, arrows, attemtpsLbl;													// I declare private  JLabel checkmark, arrows, attemtpsLbl.

	public Track(int limit) {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	Track()
	//
	// Method parameters	:	limit
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows has the initial logic of the tracks creates the random number, the histogram, the mode, the multimode, and the greatest number.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=	
		for (int i=0; i < 5;i++) {	
            attemptList.add(new JLabel ());			
		}	
		textInput.addKeyListener(new KeyAdapter() {                                                                                        // key listener to control the inputs
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();                                                                                                     // if it's not a number or to delete a number, ignore the event
                }
            }

        });
		checkmark = new JLabel();							// For initialize checkmark.
		arrows =  new JLabel();								// For initialize arrows.
		attemtpsLbl =  new JLabel();						// For initialize attemtpsLbl.
		boolean modeValidator = false;						// boolean in false.
		while(!modeValidator) {								// For check the mode and limit in the range of 1000 numbers
			createNumberList(limit, 1000);					// For call the method createNumberList.
			createHistogram();								// For call the method createHistogram.
			if(!isMultimode()) {							// For check and set the mode.
				modeValidator =true;
				setMode();
			}
		}		
	}		
	
	public JLabel getAttemtpsLbl() {						// For set of getAttemtpsLbl.
		return attemtpsLbl;
	}
	public void setAttemtpsLbl(JLabel attemtpsLbl) {		// For set of setAttemtpsLbl.
		this.attemtpsLbl = attemtpsLbl;
	}	
	public Vector<Integer> getWrongGuessNum() {				// For get of getWrongGuessNum.
		return wrongGuessNum;
	}
	public void setWrongGuessNum(int wrongGuess) {			// For set of setWrongGuessNum.
		this.wrongGuessNum.add(0,wrongGuess);
	}		
	public JLabel getCheckmark() {							// For get of setCheckmark.
		return checkmark;
	}
	public void setCheckmark(JLabel checkmark) {			// For set of setCheckmark.
		this.checkmark = checkmark;
	}
	public JLabel getArrows() {								// For get of setArrows.
		return arrows;
	}

	public void setArrows(JLabel arrows) {					// For set of setArrows.
		this.arrows = arrows;
	}	
	public Vector<Integer> getInputNumberList() {			// For get of setInputNumberList.
		return inputNumberList;
	}
	public void setInputNumberList(int inputNumber) {		// For set of setInputNumberList.
		this.inputNumberList.add(inputNumber);
	}	
	public Vector<JLabel> getAttemptList() {				// For set of getAttemptList.
		return attemptList;
	}
	public void setAttemptList(Vector<JLabel> attemptList) {// For set of setAttemptList.
		this.attemptList = attemptList;
	}	
	public JTextField getTextInput() {						// For set of getTextInput.
		return textInput;
	}		
	public void setTextInput(JTextField textInput) {		// For set of setTextInput.
		this.textInput = textInput;
	}
	public void setCounter(int counter) {					// For set of setCounter.
		this.counter = counter;
	}
	public int getCounter() {								// For get of getCounter.
		return counter;
	}	
	public void setGuessNumber(int guessNumber) {			// For set of setGuessNumber.
		this.guessNumber= guessNumber;
	}
	public int getGuessNumber() {							// For get of getGuessNumber.
		return guessNumber;
	}
	public void setAttempts(int attempts) {					// For set of setAttempts.
		this.attempts= attempts;
	}
	public int getAttempts() {								// For get of getAttempts.
		return attempts;
	}	
	public static void setRange(int ran) {					// For set of setRange.
		range= ran;
	}
	public static int getRange() {							// For get of getRange.
		return range;
	}
	public void setRandomNumberList(Vector<Integer> randomNumber) {			// For set of setRandomNumberList.
		this.randomNumberList= randomNumber;
	}
	public Vector<Integer> getRandomNumberList() {							// For get of getRandomNumberList.
		return randomNumberList;
	}		
	
	public void createNumberList(int topRange, int amountNumbers) {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	createNumberList()
	//
	// Method parameters	:	int topRange, int amountNumbers.
	//
	// Method return		:	void.
	//
	// Synopsis				:   This method allows to create a list of random numbers.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		Random number = new Random();									//To initialize the method Random called number.
		this.randomNumberList.clear();									// For clear the list.
		for(int i = 0; i < amountNumbers; i++)							// For create and fill the randomList.
			this.randomNumberList.add(number.nextInt(topRange-1)+1);	
		
	}
	
	public void createHistogram() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	createHistogram()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows to creates a histogram.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		histogram.clear();											//For clear the histogram.
		for(int i = 0; i < randomNumberList.size(); i++) {			// For check the size of the randomlist, and get the key.
			int key = randomNumberList.get(i); 						// key is a number of the map.
			if(histogram.get(key) == null) {
				histogram.put(key, 1);
			}
			else {
				histogram.put(key, histogram.get(key)+1);
			}
		}	
	}
	
	public boolean isMultimode() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	isMultimode()
	//
	// Method parameters	:	none
	//
	// Method return		:	isMultimode
	//
	// Synopsis				:   This method allows return if is multimode.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		boolean isMultimode = false;							// boolean is Multimode = false.

		AtomicInteger counter = new AtomicInteger(0);			// It is a counter.
		histogram.forEach((key,value) ->{
			if(value == upperNumber(histogram)) counter.getAndIncrement();   //For check it is upperNumber of the histogram and count.
		});
		
		if (counter.get() > 1) {							// For get the how many times of the counter.
			//System.out.println("it was multimode");
			isMultimode = true;
		}
		
		return isMultimode;									//return Multimode
	}
	
	public int getMode() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	getMode()
	//
	// Method parameters	:	none
	//
	// Method return		:	mode
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
		
													// return the mode.
		return this.mode;
	}
	
	public void setMode() {
		AtomicInteger mode = new AtomicInteger(0);							// It is a counter.
		histogram.forEach((key,value) ->{									//
			if(value == upperNumber(histogram)) mode.getAndSet(key);		//For check it is upperNumber of the histogram, set and get the key.
		});
		
		this.mode = mode.get();		
		
	}	
	
	private int upperNumber(LinkedHashMap<Integer,Integer> map) {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	upperNumber()
	//
	// Method parameters	:	map.
	//
	// Method return		:	upper.
	//
	// Synopsis				:   This method allows has the upperNumber.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		AtomicInteger upper = new AtomicInteger(-10000);		// It is a counter.
		map.forEach((key,value) ->{								// For check and get the upperNumber.
			if(upper.get() < value)								// For get and set the value.
				upper.getAndSet(value);	
		});
		return upper.get();										// return the upperNumber.
	}		
}
