package jsf.locale;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
public class LocaleBean implements Serializable {

    // Java EE 8
    @Inject
    private FacesContext facesContext;

    @Inject
    private Locale locale;

    @Produces
    public Locale getLocale() {
        return facesContext.getViewRoot().getLocale(); // != EE 8 : FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        facesContext.getViewRoot().setLocale(locale);
    }

}
