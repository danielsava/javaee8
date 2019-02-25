package cdi.interceptor;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;


//@Interceptor
public class ExceptionInterceptor implements Serializable {

    //@Inject
    private FacesContext facesContext;

    //@AroundInvoke
    public Object catchException(InvocationContext invocationContext) {
        try {
            invocationContext.proceed();
        }catch (Exception e) {
            addErrorMessage(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private void addErrorMessage(String message) {
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));

    }

}
