/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.colourconverter;

import java.awt.Color;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 * @version 2.0
 * 
 * This class is used for converting colors to and from XML for the REST API. 
 */
public class ColorAdapter extends XmlAdapter<ColorAdapter.ColorValueType, Color> {
    
    @Override 
    public Color unmarshal(ColorValueType v) throws Exception {
        return new Color(v.red, v.green, v.blue);
    }
    
    @Override
    public ColorValueType marshal(Color v) throws Exception {
        return new ColorValueType(v.getRed(), v.getRed(), v.getBlue());
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ColorValueType{
        private int red;
        private int green;
        private int blue;
        public ColorValueType() {}
        public ColorValueType(int red, int green, int blue) 
        {
            this.red= red;
            this.green= green;
            this.blue= blue;
        }
    } 
}
