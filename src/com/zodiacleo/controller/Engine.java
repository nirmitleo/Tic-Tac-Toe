package com.zodiacleo.controller;

import com.zodiacleo.event.Game;
import com.zodiacleo.event.TurnEvent;
import com.zodiacleo.event.TurnListener;
import com.zodiacleo.view.Tile;

import javax.swing.*;
import java.util.Arrays;

public class Engine implements TurnListener
{
    private int left = 9;
    private final State[] state;
    private final static ImageIcon CHECKED = new ImageIcon("resources/checked.png");
    
    public Engine()
    {
        state = new State[left];
        Arrays.fill(state, State.BLANK);
    }
    
    @Override
    public void turnPerformed(TurnEvent turnEvent)
    {
        Tile tile = turnEvent.getTile();
        Player player = Game.getPlayer();
        
        State now = tile.getState();
        if (now == State.BLANK)
        {
            left--;
            if (player == Player.PLAYER1)
            {
                tile.putX();
                state[tile.getID()] = State.X;
            }
            else
            {
                tile.putO();
                state[tile.getID()] = State.O;
            }
            Result result = getResult(player);
            if (result == Result.PENDING)
            {
                Game.play();
                return;
            }
            String message = null;
            JOptionPane optionPane = null;
            if (result == Result.END)
            {
                message = player + " wins!";
                optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_OPTION, CHECKED);
            }
            else
            {
                message = "Draw!";
                optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_OPTION);
            }
            JDialog dialog = optionPane.createDialog("Alert!");
            dialog.setAlwaysOnTop(true); // to show top of all other application
            dialog.setVisible(true);
            System.exit(0);
        }
    }
    
    private Result getResult(Player player)
    {
        //Checking rows//
        for (int i = 0; i <= 6; i += 3)
        {
            if (player == Player.PLAYER1)
            {
                if (state[i] == State.X && state[i + 1] == State.X && state[i + 2] == State.X)
                {
                    return Result.END;
                }
            }
            else
            {
                if (state[i] == State.O && state[i + 1] == State.O && state[i + 2] == State.O)
                {
                    return Result.END;
                }
            }
        }
        
        //Checking cols//
        for (int i = 0; i <= 2; i++)
        {
            if (player == Player.PLAYER1)
            {
                if (state[i] == State.X && state[i + 3] == State.X && state[i + 6] == State.X)
                {
                    return Result.END;
                }
            }
            else
            {
                if (state[i] == State.O && state[i + 3] == State.O && state[i + 6] == State.O)
                {
                    return Result.END;
                }
            }
        }
        
        //Checking Diagonals//
        if (player == Player.PLAYER1)
        {
            if (state[0] == State.X && state[4] == State.X && state[8] == State.X)
            {
                return Result.END;
            }
            
            if (state[2] == State.X && state[4] == State.X && state[6] == State.X)
            {
                return Result.END;
            }
        }
        else
        {
            if (state[0] == State.O && state[4] == State.O && state[8] == State.O)
            {
                return Result.END;
            }
            if (state[2] == State.O && state[4] == State.O && state[6] == State.O)
            {
                return Result.END;
            }
        }
        return left == 0 ? Result.DRAW : Result.PENDING;
    }
}
