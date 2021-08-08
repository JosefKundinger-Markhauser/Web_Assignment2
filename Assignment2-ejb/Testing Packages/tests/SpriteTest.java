/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import ass2.entity.Sprite;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 */
public class SpriteTest {

    public SpriteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void panelWidthTest() {
        System.out.println("Testing panelWidth");
        Sprite sprite = new Sprite();
        int setTest = 100;
        sprite.setPanelWidth(setTest);
        int getTest = sprite.getPanelWidth();
        assertEquals(setTest, getTest);
    }

    @Test
    public void panelHeightTest() {
        System.out.println("Testing panelHeight");
        Sprite sprite = new Sprite();
        int setTest = 100;
        sprite.setPanelHeight(setTest);
        int getTest = sprite.getPanelHeight();
        assertEquals(setTest, getTest);
    }

    @Test
    public void xTest() {
        System.out.println("Testing x");
        Sprite sprite = new Sprite();
        int setTest = 100;
        sprite.setX(setTest);
        int getTest = sprite.getX();
        assertEquals(setTest, getTest);
    }

    @Test
    public void yTest() {
        System.out.println("Testing y");
        Sprite sprite = new Sprite();
        int setTest = 100;
        sprite.setY(setTest);
        int getTest = sprite.getY();
        assertEquals(setTest, getTest);
    }

    @Test
    public void dxTest() {
        System.out.println("Testing dx");
        Sprite sprite = new Sprite();
        int setTest = 100;
        sprite.setDx(setTest);
        int getTest = sprite.getDx();
        assertEquals(setTest, getTest);
    }

    @Test
    public void dyTest() {
        System.out.println("Testing dy");
        Sprite sprite = new Sprite();
        int setTest = 100;
        sprite.setDy(setTest);
        int getTest = sprite.getDy();
        assertEquals(setTest, getTest);
    }
    
    @Test
    public void colorTest() {
        System.out.println("Testing dy");
        Sprite sprite = new Sprite();
        Color setTest = Color.RED;
        sprite.setColor(setTest);
        Color getTest = sprite.getColor();
        assertTrue(setTest == getTest);
    }

    @Test
    public void moveTest() {
        System.out.println("Testing move");
        Sprite sprite = new Sprite();
        sprite.setPanelWidth(500);
        sprite.setPanelHeight(500);
        sprite.setX(0);
        sprite.setY(100);
        sprite.setDx(5);
        sprite.setDy(-5);

        sprite.move();
        int x = sprite.getX();
        int y = sprite.getY();

        assertEquals(x, 5);
        assertEquals(y, 95);

        sprite.move();
        x = sprite.getX();
        y = sprite.getY();

        assertEquals(x, 10);
        assertEquals(y, 90);
    }
}
