/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusement.park.model;

import amusement.park.model.buildings.Path;
import amusement.park.model.buildings.gardens.Trash;

/**
 *
 * @author PC
 */
public class Cleaner extends Person {

    //int startx;
    //int starty;
    //int radius;
    private String destination;


    public Cleaner() {
        super("cleaner.jpeg");
    }

    public void pickUpTrash(Trash trash) {
        //if()
    }

    public void findTrash(Path path) {
        
    }
    
    public void leaveThePark() {
        this.setDestination("PoliceStation");
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return this.destination;
    }
}
