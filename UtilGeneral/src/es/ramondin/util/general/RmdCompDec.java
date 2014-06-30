package es.ramondin.util.general;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;

public class RmdCompDec {
    public RmdCompDec() {
        super();
    }
    
    public static UIComponent getUIComponent(String componentId, List components) {
        UIComponent res = null;
        try {
            if (components != null) {
                Iterator iterator = components.iterator();
    
                while (iterator.hasNext()) {
                    UIComponent component = (UIComponent)iterator.next();
                    if (component.getId().equalsIgnoreCase(componentId)) {
                        res = component;
                        break;
                    } else {
                        res = getUIComponent(componentId, component.getChildren());
                        
                        if (res != null)
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return res;
    }
}
