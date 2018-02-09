package com.zodiacleo.event;

import com.zodiacleo.controller.Player;

public class Game
{
    private static Player player;
    
    public static Player getPlayer()
    {
        if (player == null)
        {
            player = Player.PLAYER1;
            return player;
        }
        return player;
    }
    
    public static void play()
    {
        Player now = getPlayer();
        if (now.equals(Player.PLAYER1))
        {
            player = Player.PLAYER2;
            return;
        }
        player = Player.PLAYER1;
    }
}
