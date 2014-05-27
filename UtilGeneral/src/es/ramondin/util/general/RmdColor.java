package es.ramondin.util.general;

import java.awt.Color;

public class RmdColor {
    public RmdColor() {
        super();
    }
    
    /**
     * Decodifica una cadena de texto conteniendo un color con su color. Versión que amplía a la de java.awt.Color para tener en cuenta transparencias
     * @param colorTxt Cadena a decodificar
     * @return Color obtenido o null en caso de error
     */
    public static Color decode(String colorTxt) {
        Color res = null;

        colorTxt = colorTxt.trim();

        try {
            if (colorTxt.length() > 7) {
                int length = colorTxt.length();

                res = Color.decode("#" + colorTxt.substring(length - 6));
                res = new Color(res.getRed(), res.getGreen(), res.getBlue(), Integer.valueOf(colorTxt.substring(length - 8, length - 6), 16));
            } else
                res = Color.decode(colorTxt);
        } catch (NumberFormatException e2) {
            res = null;
        }

        return res;
    }
}
