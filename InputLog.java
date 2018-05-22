import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputLog extends JFrame implements KeyListener, ActionListener {

	private JTextField input;
	private JTextArea log;

	public InputLog() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		log = new JTextArea();
		log.setEditable(false);
		add(new JScrollPane(log));
		add(Box.createRigidArea(new Dimension(0, 10)));
		Box field = Box.createHorizontalBox();
		field.add(Box.createRigidArea(new Dimension(5, 0)));
		field.add(new JLabel("Enter Move:"));
		field.add(Box.createRigidArea(new Dimension(5, 0)));
		input = new JTextField();
		input.addKeyListener(this);
		input.setPreferredSize(new Dimension(300, 30));
		input.setMaximumSize(input.getPreferredSize());
		field.add(input);
		field.add(Box.createRigidArea(new Dimension(5, 0)));
		JButton help = new JButton("?");
		help.addActionListener(this);
		field.add(help);
		field.add(Box.createRigidArea(new Dimension(5, 0)));
		add(field);
		add(Box.createRigidArea(new Dimension(0, 5)));

		setTitle("Canadian Checkers");
		this.setVisible(true);
		this.setSize(300, 300);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Ask user if they do wish to exit.
				int choice = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to quit the game?");
				if (choice == 0) {
					JOptionPane.showMessageDialog(null,
							"Good-bye! Thanks for playing.");
					System.exit(0);
				}
			}
		});
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (input.getText().isEmpty()) {
				return;
			}

			// TODO check if it's the players turn.

			String line = input.getText().trim().toUpperCase();

			if (line.indexOf(" ") == -1 || line.length() > 7) {
				input.setText("");
				JOptionPane.showMessageDialog(null, "Invalid move.");
				return;
			}

			String pieceLocation = line.substring(0, line.indexOf(" "));
			String moveLocation = line.substring(line.indexOf(" ") + 1);

			int pieceCol = pieceLocation.charAt(0) - 'A';
			int pieceRow = Integer.parseInt(pieceLocation.substring(1)) - 1;

			int moveCol = moveLocation.charAt(0) - 'A';
			int moveRow = Integer.parseInt(moveLocation.substring(1)) - 1;

			if (pieceCol > 12 || moveCol > 12 || moveRow > 12 || pieceRow > 12
					|| pieceRow == moveRow || pieceCol == moveCol) {
				System.out.println("PIece does not exist bitch");
				input.setText("");
				JOptionPane.showMessageDialog(null, "Invalid move.");
				return;
			}

			// Get the piece at the location
			CheckerPiece myPiece = CanadianCheckers.board[pieceRow][pieceCol];
			if (!myPiece.getExistence()) {
				input.setText("");
				JOptionPane.showMessageDialog(null, "Invalid move.");
				return;
			}
			
			CheckerPiece movePiece = CanadianCheckers.board[moveRow][moveCol];
			
			CanadianCheckers.board[moveRow][moveCol] = myPiece;
			CanadianCheckers.board[pieceRow][pieceCol] = movePiece;
			
			MainMenu.boardPanel.repaint();

			String msg = "";
			if (!log.getText().isEmpty()) {
				msg += "\n";
			}
			msg += "User moved " + pieceLocation + " to " + moveLocation;
			input.setText("");
			log.append(msg);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() != null && e.getSource() instanceof JButton) {
			JOptionPane
					.showMessageDialog(
							null,
							"How To Enter A Move:\n"
									+ "The first coordinate you enter is the piece you would like to move.\n"
									+ "The second coordinate is the location in which the piece will move.\n"
									+ "\nExample: 'A3 B4'");
		}
	}

}
