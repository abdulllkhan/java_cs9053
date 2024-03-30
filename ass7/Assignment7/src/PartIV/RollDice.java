package PartIV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RollDice extends JFrame {
    private ImagePanel dicePanel;
    private JButton rollDiceButton;
    private JLabel resultLabel;
    private Random random = new Random();

    public RollDice() {
		
        setTitle("Roll Dice");
		setSize(400, 400);

        dicePanel = new ImagePanel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateResult();
            }
        });
        add(dicePanel, BorderLayout.CENTER);

        resultLabel = new JLabel("Result: 0", SwingConstants.CENTER);
        rollDiceButton = new JButton("Roll Dice");
        rollDiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollBothDice();
            }
        });
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(resultLabel, BorderLayout.CENTER);
        buttonPanel.add(rollDiceButton, BorderLayout.SOUTH);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true); 
    }

    private void rollBothDice() {

		for(int i = 0; i < 10; i++) {
			dicePanel.setDiceValues(random.nextInt(6) + 1, random.nextInt(6) + 1);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
			// updateResult();
			update(getGraphics());
		}
		int diec1 = random.nextInt(6) + 1;
		int diec2 = random.nextInt(6) + 1;
        dicePanel.setDiceValues(diec1, diec2);
        updateResult();

    }

    private void updateResult() {

		int dice1 = dicePanel.getDice1();
		int dice2 = dicePanel.getDice2();
        int total = dice1 + dice2 + 2;
        resultLabel.setText("Result: " + total);

    }

    public static void main(String[] args) {

		JFrame rollDice = new RollDice();
		rollDice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rollDice.setVisible(true);

    }
}
// private void createPanel() {
		
	// 	JPanel panel = new JPanel();
	// 	panel.setLayout(new BorderLayout());

	// 	// GridLayout images = new GridLayout(1, 2);
	// 	JPanel imagesPanel = new JPanel();
	// 	imagesPanel.setLayout(new GridLayout(1, 2));
	// 	imagesPanel.add("Dice 1", imagePanel1);
	// 	imagesPanel.add("Dice 2", imagePanel2);
	// 	panel.add(imagesPanel, BorderLayout.CENTER);

	// 	JPanel buttonPanel = new JPanel();
	// 	buttonPanel.setLayout(new BorderLayout());
	// 	buttonPanel.add(resultLabel, BorderLayout.NORTH);
	// 	buttonPanel.add(rollDiceButton, BorderLayout.SOUTH);

	// 	panel.add(buttonPanel, BorderLayout.SOUTH);
	// 	this.add(panel);
	// }

	// private void createResultLabel() {

	// 	resultLabel = new JLabel("Result: " + diceTotal);

	// }

	// private void createImage2Panel() {

	// 	imagePanel2 = new ImagePanel();

	// 	imagePanel2.updateImage(1);
	// 	imagePanel2.repaint();

	// 	class MouseRollDiceListener implements MouseListener {

	// 		public void mouseClicked(java.awt.event.MouseEvent evt) {
	// 			int randomCycles = (int) (Math.random() * 10) + 1;
	// 			for (int i = 0; i < randomCycles; i++) {
	// 				dice2 = (int) (Math.random() * 6) + 1;
	// 				imagePanel2.removeAll();
	// 				imagePanel2.updateImage(dice2);
	// 				imagePanel2.repaint();
	// 				try {
	// 					Thread.sleep(200);
	// 				} catch (InterruptedException ex) {
	// 					ex.printStackTrace();
	// 				}
	// 			}
	// 			updateTotal();
	// 			imagePanel2.repaint();
	// 		}

	// 		@Override
	// 		public void mousePressed(MouseEvent e) {
	// 			int randomCycles = (int) (Math.random() * 10) + 1;
	// 			for (int i = 0; i < randomCycles; i++) {
	// 				dice2 = (int) (Math.random() * 6) + 1;
	// 				imagePanel2.removeAll();
	// 				imagePanel2.updateImage(dice2);
	// 				imagePanel2.repaint();
	// 				try {
	// 					Thread.sleep(200);
	// 				} catch (InterruptedException ex) {
	// 					ex.printStackTrace();
	// 				}
	// 			}
	// 			updateTotal();
	// 			imagePanel2.repaint();
	// 		}

	// 		@Override
	// 		public void mouseReleased(MouseEvent e) {}

	// 		@Override
	// 		public void mouseEntered(MouseEvent e) {}

	// 		@Override
	// 		public void mouseExited(MouseEvent e) {}
	// 	}

	// 	imagePanel2.addMouseListener(new MouseRollDiceListener());

	// 	this.repaint();

	// }

	// private void createImage1Panel() {

	// 	imagePanel1 = new ImagePanel();

	// 	imagePanel1.updateImage(1);
	// 	imagePanel1.repaint();

	// 	class MouseRollDiceListener implements MouseListener {

	// 		public void mouseClicked(java.awt.event.MouseEvent evt) {
	// 			int randomCycles = (int) (Math.random() * 10) + 1;
	// 			for (int i = 0; i < randomCycles; i++) {
	// 				dice1 = (int) (Math.random() * 6) + 1;
	// 				imagePanel1.removeAll();
	// 				imagePanel1.updateImage(dice1);
	// 				imagePanel1.repaint();
	// 				try {
	// 					Thread.sleep(200);
	// 				} catch (InterruptedException ex) {
	// 					ex.printStackTrace();
	// 				}
	// 			}
	// 			updateTotal();
	// 			imagePanel1.repaint();
	// 		}

	// 		@Override
	// 		public void mousePressed(MouseEvent e) {
	// 			int randomCycles = (int) (Math.random() * 10) + 1;
	// 			for (int i = 0; i < randomCycles; i++) {
	// 				dice1 = (int) (Math.random() * 6) + 1;
	// 				imagePanel1.removeAll();
	// 				imagePanel1.updateImage(dice1);
	// 				imagePanel1.repaint();
	// 				try {
	// 					Thread.sleep(200);
	// 				} catch (InterruptedException ex) {
	// 					ex.printStackTrace();
	// 				}
	// 			}
	// 			updateTotal();
	// 			imagePanel1.repaint();
	// 		}

	// 		@Override
	// 		public void mouseReleased(MouseEvent e) {}

	// 		@Override
	// 		public void mouseEntered(MouseEvent e) {}

	// 		@Override
	// 		public void mouseExited(MouseEvent e) {}
	// 	}

	// 	imagePanel1.addMouseListener(new MouseRollDiceListener());

	// 	this.repaint();

	// }

	// private void createRollDiceButton() {

	// 	rollDiceButton = new JButton("Roll Dice");

	// 	class AddRollDiceListener implements ActionListener{
	// 		public void actionPerformed(ActionEvent e) {
	// 			int randomCycles = (int) (Math.random() * 10) + 1;
	// 			for (int i = 0; i < randomCycles; i++) {
	// 				dice1 = (int) (Math.random() * 6) + 1;
	// 				dice2 = (int) (Math.random() * 6) + 1;
	// 				diceTotal = dice1 + dice2;
	// 				imagePanel1.updateImage(dice1);
	// 				imagePanel2.updateImage(dice2);
	// 				imagePanel1.repaint();
	// 				imagePanel2.repaint();
	// 				try {
	// 					Thread.sleep(200);
	// 				} catch (InterruptedException ex) {
	// 					ex.printStackTrace();
	// 				}
	// 			}
	// 			updateTotal();
	// 			resultLabel.setText("Result: " + diceTotal);
	// 		}
	// 	}

	// 	ActionListener listener = new AddRollDiceListener();
	// 	rollDiceButton.addActionListener(listener);

	// }

	// private void updateTotal() {

	// 	this.diceTotal = this.dice1 + this.dice2;
	// 	resultLabel.setText("Result: " + this.diceTotal);
	// 	this.repaint();

	// }

	// public static void main(String[] args) {
		
	// 	JFrame rollDice = new RollDice();
	// 	rollDice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 	rollDice.setVisible(true);
	
	// }




		// JPanel mainPanel = new JPanel();
        // mainPanel.setLayout(new BorderLayout());
		// setSize(400, 400);

		// createImage1Panel();
		// createImage2Panel();
		// createResultLabel();
		// createRollDiceButton();
		// createPanel();
		// setSize(400, 400);


		// final JPanel gridPanel = new JPanel(new java.awt.GridLayout(1, 2));
		
		// gridPanel.add(imagePanel1);
		// gridPanel.add(imagePanel2);

		// this.add(gridPanel, java.awt.BorderLayout.CENTER);
		// this.add(resultLabel, java.awt.BorderLayout.SOUTH);
		// this.add(rollDiceButton, java.awt.BorderLayout.SOUTH);


	
	// private int dice1 = 0, dice2 = 0, diceTotal = 0;
	// private ImagePanel imagePanel1;
	// // private ImagePanel imagePanel2;
	// private JButton rollDiceButton;
	// private JLabel resultLabel;