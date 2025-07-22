package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    // Screen settings
    final int originalTileSize = 16; // 16x16 tile switch to 32x32 in future
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12; // 4 by 3 
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    final int fps = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    int playerX = 100;      //part wont be necessary in the future 
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void runSleepMode() {
        double drawInterval = 1000000000 / fps; // 1 billion nano seconds / 60 fps = 0.16666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            // 1 Update: Character position
            update();
            // 2 Draw: Screen with updated information
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000; // Convert time to milliseconds

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval; 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void runDeltaMode() {
        double drawInterval = 1000000000 / fps; // 1 billion nano seconds / 60 fps = 0.16666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            if (Config.DEBUG) {
                timer += (currentTime - lastTime);
            }
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                if (Config.DEBUG) {
                    drawCount++;
                }
            }

            if (Config.DEBUG) {
                if (timer > 1000000000) { // 1 second
                    System.out.println("FPS: " + drawCount);
                    drawCount = 0;
                    timer = 0;
                }
            }
        }
    }

    @Override
    public void run() {
        if (Config.TIME_SYSTEM == Config.TIME_DELTA) {
            runDeltaMode();
        } else {
            runSleepMode();
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    };
}
