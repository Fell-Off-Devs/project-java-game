package main; 
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable 
{
    //screen settings
    public final int originalTileSize = 16;//input tile size
    final int scale = 3 ; //input scale size
    final int tileSize = originalTileSize * scale; //input tile size
    final int ScreenColumns=16; //input screen columns
    final int ScreenRows=12; //input screen rows
    final int ScreenWidth = tileSize * ScreenColumns; 
    final int ScreenHeight= tileSize * ScreenRows; 

    //Frames per second
    final int FPS = 60;

    KeyHandler keys = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keys);

    //player speed edit for future
    int playerSpeed = 4;
    int playerXcords=100;
    int playerYcords=100;

    public GamePanel() 
    {
        this.setPreferredSize(new java.awt.Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keys);
        this.setFocusable(true);
    }


    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
        
    }


    @Override
    public void run()
    {
        double drawInterval = 1000000000/FPS; 
        double nextDrawTime = System.nanoTime() + drawInterval;
        // call .TimeViewer() method to start the game loop
         // call .deltaTimeMethod() method to start the game loop  
    }


    public void update() 
    {
       player.update();
        
    }


    public void paintComponent(Graphics g,Graphics2D g2) 
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        player.draw(g2);
        g2.dispose();
        
    }
}
 public void TimeViewer()
 {
          while (gameThread!=null) {
             update();
             repaint();

             try 
             {   double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000; 
                 Thread.sleep(1000/FPS);  //else use '(long)remainingTime' for condition
                 if(remainingTime<0)
                 {
                     remainingTime = 0;
                 }

                 Thread.sleep((long)remainingTime); 
                 nextDrawTime += drawInterval; 
             }
              catch (InterruptedException e)
             {
                 e.printStackTrace();
             }
         }
 }
 public void deltaTimeMethod()
    {
        delta +=(currentTime - lastTime) / drawInterval;
        timer += (currentTime - lastTime);
        lastTime = currentTime;
        if (delta >= 1) {
            update();
            repaint();
            delta--;
            drawCount++;
        }
        if(timer >= 1000000000) {
            System.out.println("FPS: " + drawCount);
            drawCount = 0;
            timer = 0;
        }
    }