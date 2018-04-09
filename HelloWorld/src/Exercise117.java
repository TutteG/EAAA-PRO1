import javax.swing.JOptionPane;

public class Exercise117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog("What is your name?");

		JOptionPane.showMessageDialog(null, "hi " + name + "\nMy name is hal");
		JOptionPane.showInputDialog("What would you like me to do?");
		JOptionPane.showMessageDialog(null, "i'm sorry i can't do that");
	}

}
