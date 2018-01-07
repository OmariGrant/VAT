/**
 * 
 */
package calculator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Omari Grant
 *
 */
public class VAT {
	//set up variables
	boolean vatIncluded;
	double number;
	double answer;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//create a new VAT object and call it vat
		VAT vat = new VAT();
		//create a JFrame called JF
		JFrame JF = new JFrame();
		
		//get the figure from the user
		String n = JOptionPane.showInputDialog(JF, "Whats the figure?");
		//set the figure using the setter
		vat.setNumber(Integer.parseInt(n));
		//ask user if VAT is already included 
		int c = JOptionPane.showConfirmDialog(JF, "Is VAT already included in the figure?");
		//sets whether VAT is included in the figure - if cancel is selected - program closes
		if(c==JOptionPane.YES_OPTION) {
			vat.setVatIncluded(true);
		} else if (c == JOptionPane.NO_OPTION) {
			vat.setVatIncluded(false);
		} else if (c == JOptionPane.CANCEL_OPTION) {
			System.exit(1);
		}
		//show a dialog box with the answer
		JOptionPane.showMessageDialog(JF, vat.calculate());
	}
	
	//function to calculate VAT
	public double calculate() {
		double n = getNumber();
		if(isVatIncluded()==true) { //if VAT is included take 20% off 
			answer = n / 1.2;
		} else { // if VAT needs adding on - add 20%
			answer = n * 1.2;
		}
		return answer;
	}

	//all getters and setters
	private boolean isVatIncluded() {
		return vatIncluded;
	}

	public void setVatIncluded(boolean vatIncluded) {
		this.vatIncluded = vatIncluded;
	}

	private double getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
