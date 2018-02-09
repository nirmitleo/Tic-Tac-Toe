package com.zodiacleo.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private final static int WIDTH = 500;
    private final static int HEIGHT = WIDTH;
    private final static Board board = new Board();
    
    public MainFrame()
    {
        super("Fun game!");
        
        this.setLayout(new GridBagLayout());
        this.add(board);
        
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
