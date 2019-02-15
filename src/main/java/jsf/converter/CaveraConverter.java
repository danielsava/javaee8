package jsf.converter;

import bean.CaveraBean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "fooConverter", managed = true)
public class CaveraConverter implements Converter<CaveraBean> {


    //@Inject
    // ...


    @Override
    public CaveraBean getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) throws ConverterException {
        return CaveraBean.of(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, CaveraBean caveraBean) throws ConverterException {
        return caveraBean.getNome();
    }

}
