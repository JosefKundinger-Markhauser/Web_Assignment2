/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2.colourconverter;

import java.awt.Color;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

/**
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 * @version 2.0
 * 
 * This class is used for converting colors to JSON for the REST API.
 */
public class JsonColorSerializer implements JsonbSerializer<Color> {

    @Override
    public void serialize(Color c, JsonGenerator jg, SerializationContext ctx) {
        jg.writeStartObject();
        jg.write("red", c.getRed());
        jg.write("green", c.getGreen());
        jg.write("blue", c.getBlue());
        jg.writeEnd();
    }
    
}
