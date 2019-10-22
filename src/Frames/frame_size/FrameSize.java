/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.frame_size;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

public class FrameSize {
    public static Map<String,Integer> getSizeLocation(JFrame jFrame){
        Map<String,Integer> sizeLocation=new HashMap<>();
        sizeLocation.put("sizex", jFrame.getWidth());
        sizeLocation.put("sizeY", jFrame.getHeight());
        sizeLocation.put("locx", jFrame.getX());
        sizeLocation.put("locy", jFrame.getY());
        return sizeLocation;
    }
}
