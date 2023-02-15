import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Score implements Serializable{
	int score;
	int temps;
	
	public Score() {
		
	}
	
	@Override
	public String toString() {
		return "score: "+this.score+" | temps: "+this.temps;
	}
	
	public Score(int s, int a) {
		this.score=s;
		this.temps=a;
	}

	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
}
