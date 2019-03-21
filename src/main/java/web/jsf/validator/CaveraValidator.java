package web.jsf.validator;

import bean.CaveraBean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "caveraValidator", managed = true)
public class CaveraValidator implements Validator<CaveraBean> {


    //@Inject
    // ...

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, CaveraBean caveraBean) throws ValidatorException {
        if (caveraBean == null)
            throw new ValidatorException(new FacesMessage("Validação", "Informe o Cavera"));

    }


}
