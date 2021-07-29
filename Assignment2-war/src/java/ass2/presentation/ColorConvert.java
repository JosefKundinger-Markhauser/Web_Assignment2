/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.presentation;

import java.awt.Color;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 * @version 2.0
 * 
 * This class is used to convert a string to a Color object and to convert a
 * Color to a string.
 */
@FacesConverter(forClass = Color.class)
public class ColorConvert implements Converter {
   
    /**
     * 
     * @param context The context for the request being processed.
     * @param component The UI component that this model value is associated with.
     * @param value The model Object that will be converted to string.
     * @return null if the value to convert is null, otherwise the resulting converted string.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent  component, Object value) {
        if (value == null){
            return null;
        }
        if (value instanceof Color) {
            
            int redValue    = ((Color)value).getRed();
            int greenValue  = ((Color)value).getGreen();
            int blueValue   = ((Color)value).getBlue();
            
            String returnString = "#";
            returnString += String.format("%02X", redValue);
            returnString += String.format("%02X", greenValue);
            returnString += String.format("%02X", blueValue);

            return returnString;
        } else {
            throw new IllegalArgumentException("Expected Color object, Get: " + Color.class.getName());
        }
    }
    
    /**
     * 
     * @param context The context for the request being processed.
     * @param component The UI component that this model value is associated with.
     * @param value The String that will be converted to a Color Object.
     * @return null if the value to convert is null, otherwise the resulting converted Object.
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent  component, String value) {
        if (value == null || value.length() == 0){
            return null;
        }
        
        if (value.length() != 7){
            throw new IllegalArgumentException("Colour must be in the format of '#000000', where the 0's can be from 0-F in HEX");
        }
        
        String redString = value.substring(1,3);
        String greenString = value.substring(3,5);
        String blueString = value.substring(5,7);
        
        int redValue = Integer.parseInt(redString, 16);
        int greenValue = Integer.parseInt(greenString, 16);
        int blueValue = Integer.parseInt(blueString, 16);
        
        Color returnColour = new Color(redValue, greenValue, blueValue);
        
        return returnColour;
    }
}
