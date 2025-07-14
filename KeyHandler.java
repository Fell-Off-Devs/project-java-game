package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class KeyHandler implements KeyListener
{   
     @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) 
    {
        int getCode = e.getKeyCode();

        if(getCode == KeyEvent.VK_W)
        {
            upPressed=true;
        } 
         if(getCode == KeyEvent.VK_A) 
        {
            leftPressed=true;
        }  
        if(getCode == KeyEvent.VK_S) 
        {
            downPressed=true;
        }  
        if(getCode == KeyEvent.VK_D) 
        {
            rightPressed=true;
        }
        if(getCode == KeyEvent.VK_UP) 
        {
            upPressed=true;
        } 
         if(getCode == KeyEvent.VK_DOWN) 
         {
            downPressed=true;
        } 
         if(getCode == KeyEvent.VK_LEFT)
        {
            leftPressed=true;
        } 
         if(getCode == KeyEvent.VK_RIGHT) 
        {
            rightPressed=true;
        }

        @Override
    public void keyReleased(KeyEvent e) 
    {
        int getCode = e.getKeyCode();
        if(getCode == KeyEvent.VK_W)
        {
            upPressed=false;
        } 
         if(getCode == KeyEvent.VK_A) 
        {
            leftPressed=false;
        }  
        if(getCode == KeyEvent.VK_S) 
        {
            downPressed=false;
        }  
        if(getCode == KeyEvent.VK_D) 
        {
            rightPressed=false;
        }
        if(getCode == KeyEvent.VK_UP) 
        {
            upPressed=false;
        } 
         if(getCode == KeyEvent.VK_DOWN) 
         {
            downPressed=false;
        } 
         if(getCode == KeyEvent.VK_LEFT)
        {
            leftPressed=false;
        } 
         if(getCode == KeyEvent.VK_RIGHT) 
        {
            rightPressed=false;
        }

       
    
















}
