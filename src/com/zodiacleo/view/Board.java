package com.zodiacleo.view;

import com.zodiacleo.controller.Engine;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private final static int MAX_TILE = 9;
    private final Engine engine = new Engine();
    private Tile[] blankTiles = new Tile[MAX_TILE];
    
    public Board()
    {
        init();
        this.setLayout(new GridLayout(3, 3));
        GridBagConstraints gc = new GridBagConstraints();
        for (int i = 0; i < MAX_TILE; i++)
        {
            gc.fill = GridBagConstraints.BOTH;
            this.add(blankTiles[i], gc);
        }
    }
    
    private void init()
    {
        for (int i = 0; i < MAX_TILE; i++)
        {
            blankTiles[i] = new Tile(i);
            blankTiles[i].setTurnListener(engine);
        }
    }
}
