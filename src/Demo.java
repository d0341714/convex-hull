import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 50;
		Random ran = new Random();
		
		Rand[] r = new Rand[max];
		for(int i = 0 ; i < max ; i++){
			r[i] = new Rand(ran.nextInt(660)+20,ran.nextInt(660)+20);
		}
		Judgment j = new Judgment(r);
	}

}