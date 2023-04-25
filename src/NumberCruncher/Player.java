package NumberCruncher;

public class Player {
	
	private int score;													//I declare private int the variable score.
	private int level=0;												//I declare private int the variable level.	
	
	public Player() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	Player()
	//
	// Method parameters	:	none
	//
	// Method return		:	void
	//
	// Synopsis				:   This method allows has the level, hiscore, and score for the player.
	//						
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-30-05		Juan Giraldo			
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		

		this.score = 0;					//The value of the variable.
	}	
	public void setScore(int score) {	// For set of setScore
		this.score = score;				
	}	
	public int getScore() {				// For get of getScore
		return score;
	}		
	public void setLevel(int level) {	// For set of setLevel
		this.level = level;
	}
	public int getLevel() {				// For get of getLevel
		return level;
	}
}
