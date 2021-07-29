package ass2.game;

import ass2.entity.Sprite;
import ass2.entity.SpriteFacade;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 *
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 * @version 2.0
 * 
 * This class sets up the sprite game, and then continuously updates the sprite's
 * dx and dy values.
 */
@Singleton
public class SpriteGame {

    public static final int HEIGHT = 500;
    public static final int WIDTH = 500;

    List<Sprite> sprites;  // the list of Sprites in the game
    @EJB
    private SpriteFacade spriteFacade;

    public List<Sprite> getSpriteList() {
        return sprites;
    }

    public void newSprite(MouseEvent event, Color color) {
        Sprite newSprite = new Sprite(HEIGHT, WIDTH, color);
        spriteFacade.create(newSprite);
        System.out.println("New sprite created");
    }

    @PostConstruct
    public void go() {
        new Thread(new Runnable() {
            public void run() {

                while (true) {
                    //move all the sprites and update them in the database
                    sprites = spriteFacade.findAll();
                    for (Sprite sprite : sprites) {
                        sprite.move();
                        spriteFacade.edit(sprite);
                    }
                    //sleep while waiting to display the next frame of the animation
                    try {
                        Thread.sleep(100);  // wake up roughly 10 frames per second
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }).start();
    }
}