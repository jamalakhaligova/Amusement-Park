/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amusement.park.model.buildings.gardens;

import amusement.park.model.buildings.Building;

/**
 * @author khaligov
 */
public class Garden extends Building {

    public Garden(String pic, int gardenPrice) {
        super(pic, 5, gardenPrice, 5, "Garden");
    }

}
