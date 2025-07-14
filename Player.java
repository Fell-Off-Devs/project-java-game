package Entity;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keys;

    pubic Player(GamePanel gp, KeyHandler keys) {
        this.gp = gp;
        this.keys = keys;
        getplayerImage();
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down"; 
        
    }
    public void getplayerImage() {
        try {
            /*image input */=ImageIO.read(getClass().getResourceAsStream("//images/player.png"));
            //add images

        } catch{(IOException e) {
            e.printStackTrace();

        }
        
    }

    public void update() {
        if(keys.upPressed==true || keys.downPressed==true || keys.leftPressed==true || keys.rightPressed==true) 
        {
           
             if(keys.upPressed==true) {
                    direction="up";
                    y -= speed;
             } else if(keys.downPressed==true) {
                    direction="down";
                    y += speed;
             } else if(keys.leftPressed==true) {
                    direction="left";
                    x -= speed;
             } else if(keys.rightPressed==true) {
                    direction="right";
                    x += speed;
            }
         spritecounter++;
         if(spritecounter>12) {
            if(spriteroll==1) {
                spriteroll=2;
            } else if(spriteroll==2) {
                spriteroll=1;
            }
            spritecounter=0;
         }
        }
    }
    public void draw(Graphics2D g2) {
         /*g2.setColor(Color.white);
        g2.fillRect(x,y,gp.tileSize,gp.tileSize);*/
        BufferedImage image = null;
        switch(direction)
        {
            case "up":
            if(spriteroll==1){
                image = ;//input image
            }
            if(spriteroll==2){
             image = ;//input image
            }
            break;
            case "down":
            if(spriteroll==1){
                image = ;//input image
            }
            if(spriteroll==2){
             image = ;//input image
            }
            break;   
            case "left":
            if(spriteroll==1){
                image = ;//input image
            }
            if(spriteroll==2){
             image = ;//input image
            }
            break;
            case "right":
            if(spriteroll==1){
                image = ;//input image
            }
            if(spriteroll==2){
             image = ;//input image
            }
            break;  
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }




}
