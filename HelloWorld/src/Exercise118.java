import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Exercise118 {
	public static void main(String[] args) throws Exception {
		URL imageLocation = new URL(
				"https://stickershop.line-scdn.net/stickershop/v1/product/1027527/LINEStorePC/main@2x.png;compress=true");
		JOptionPane.showMessageDialog(null, "FUCK YOU!", "Title", JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(imageLocation));
	}
}