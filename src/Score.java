import java.io.Serializable;

public class Score implements Serializable{
	int score;
	double temps;
	
	public Score() {
		
	}
	
	public Score(int s, double a) {
		this.score=s;
		this.temps=a;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getTemps() {
		return temps;
	}
	public void setTemps(double temps) {
		this.temps = temps;
	}
}
