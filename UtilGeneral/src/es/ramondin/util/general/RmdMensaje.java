package es.ramondin.util.general;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class RmdMensaje {
    public RmdMensaje() {
        super();
    }

    public static void muestraMensaje(FacesContext fctx, FacesMessage.Severity severity, java.lang.String summary, java.lang.String detail) {
        FacesMessage msg = new FacesMessage(severity, summary, detail);
        fctx.addMessage(null, msg);
    }

    public static void muestraError(FacesContext fctx, java.lang.String summary, java.lang.String detail) {
        muestraMensaje(fctx, FacesMessage.SEVERITY_ERROR, summary, detail);
    }
    
    public static void muestraExcepcion(FacesContext fctx, Exception e, java.lang.String summary, java.lang.String detail) {
        e.printStackTrace();
        muestraMensaje(fctx, FacesMessage.SEVERITY_ERROR, summary, detail);
    }

    public static void muestraExcepcion(FacesContext fctx, Exception e) {
        muestraExcepcion(fctx, e, e.getMessage(), "");
    }
}
