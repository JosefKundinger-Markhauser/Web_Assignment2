/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import ass2.entity.AppUser;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 * @version 1.0
 * 
 * This class is used to test the AppUser Entity.
 */
public class AppUserTest {

    public AppUserTest() {
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

    /*
    * This Tests sets and gets the userID.
    */
    @Test
    public void userIdTest() {
        System.out.println("Testing userId");
        AppUser user = new AppUser();
        String setTest = "testUserId";
        user.setUserId(setTest);
        String getTest = user.getUserId();
        assertTrue(setTest == getTest);
    }
    
    /*
    * This Tests sets and gets the groupName.
    */
    @Test
    public void groupNameTest() {
        System.out.println("Testing groupName");
        AppUser user = new AppUser();
        String setTest = "groupName";
        user.setGroupName(setTest);
        String getTest = user.getGroupName();
        assertTrue(setTest == getTest);
    }
}
