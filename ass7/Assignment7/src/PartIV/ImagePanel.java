package PartIV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ImagePanel extends JPanel {
    private Image[] images = new Image[6];
    private int dice1, dice2;
    private Random random = new Random();
    private ActionListener actionListener;

    public ImagePanel(ActionListener actionListener) {
        this.actionListener = actionListener;
        try {
            // adding all the images to the array resources/die1.png die1.png
            for (int i = 0; i < images.length; i++) {
                File file = new File("die" + (i + 1) + ".png");
                if (file.exists()) {
                    images[i] = new ImageIcon(file.getAbsolutePath()).getImage();
                } else {
                    System.err.println("File not found: " + file.getAbsolutePath());
                    System.exit(1);
                }
            }
            
            int imageWidth = images[0].getWidth(null);
            int imageHeight = images[0].getHeight(null);
            int padding = 10; 
            Dimension size = new Dimension(2 * imageWidth + padding, imageHeight);
            setPreferredSize(size);
            setLayout(null);
            
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int xAxis = e.getX();
                    int yAxis = e.getY();
                    int imageWidth = images[0].getWidth(null);
                    int imageHeight = images[0].getHeight(null);

                    if (xAxis <= imageWidth && yAxis <= imageHeight) {
                        rollSingleDie(0);
                    } else if (xAxis >= imageWidth + 10 && xAxis <= (imageWidth * 2 + 10) && yAxis <= imageHeight) {
                        rollSingleDie(1);
                    }
                }
            });

        } catch (Exception e) {
            System.err.println("Error loading dice images: " + e.getMessage());
            System.exit(1);
        }
    }

    private void rollSingleDie(int dice) {
        if(dice == 0){
            dice1 = random.nextInt(6);
        } else {
            dice2 = random.nextInt(6);
        }
        if (actionListener != null) {
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Single die rolled"));
        }
        repaint();
    }
    
    public void setDiceValues(int dice1, int dice2) {
        this.dice1 = dice1 - 1; 
        this.dice2 = dice2 - 1; 
        repaint(); 
    }

    public int getDice1() {
        return this.dice1;
    }

    public int getDice2() {
        return this.dice2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int imageWidth = images[0].getWidth(this);
        int padding = 10; 
        
        g.drawImage(images[dice1], 0, 0, this);
        g.drawImage(images[dice2], imageWidth + padding, 0, this);
    }

    // public ImagePanel(Image img) {
    //     img = new ImageIcon("die" + 1 + ".png").getImage();
    //     Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    //     setPreferredSize(size);
    //     setMinimumSize(size);
    //     setMaximumSize(size);
    //     setSize(size);
    //     setLayout(null);
	// }

    // public void updateImage(Integer diceNumber) {

    //     this.img = new ImageIcon("die" + diceNumber + ".png").getImage();
    //     repaint();

    // }

}
