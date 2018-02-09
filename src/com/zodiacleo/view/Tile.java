package com.zodiacleo.view;

import com.zodiacleo.controller.State;
import com.zodiacleo.event.TurnEvent;
import com.zodiacleo.event.TurnListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel implements MouseListener
{
    private int id;
    private State state;
    private JLabel tile;
    private TurnListener turnListener;
    
    private final static ImageIcon X_IMAGE = new ImageIcon("resources/X.png");
    private final static ImageIcon O_IMAGE = new ImageIcon("resources/O.png");
    private final static ImageIcon BLANK_IMAGE = new ImageIcon("resources/blank.png");
    
    public Tile(int id)
    {
        this.id = id;
        this.state = State.BLANK;
        this.tile = new JLabel(BLANK_IMAGE);
        
        this.setLayout(new GridBagLayout());
        this.add(tile);
        
        this.addMouseListener(this);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
    }
    
    public void putX()
    {
        this.tile.setIcon(X_IMAGE);
    }
    
    public void putO()
    {
        this.tile.setIcon(O_IMAGE);
    }
    
    public void setTurnListener(TurnListener turnListener)
    {
        this.turnListener = turnListener;
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        TurnEvent event = new TurnEvent(this);
        turnListener.turnPerformed(event);
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        setBorder(BorderFactory.createLineBorder(Color.RED, 10));
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        setBorder(BorderFactory.createLineBorder(Color.RED, 10));
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
    }
    
    public int getID()
    {
        return id;
    }
    
    public void setState(State state)
    {
        this.state = state;
    }
    
    public State getState()
    {
        return state;
    }
}
