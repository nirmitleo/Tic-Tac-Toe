package com.zodiacleo;

import com.zodiacleo.view.MainFrame;

import javax.swing.*;

public class DemoApplication
{
    public static void main(String[] a)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                go();
            }
        });
    }
    
    private static void go()
    {
        new MainFrame();
    }
}
