package com.zodiacleo.event;

import com.zodiacleo.view.Tile;

public class TurnEvent
{
    private Tile tile;
    
    public TurnEvent(Tile tile)
    {
        this.tile = tile;
    }
    
    public Tile getTile()
    {
        return tile;
    }
}
