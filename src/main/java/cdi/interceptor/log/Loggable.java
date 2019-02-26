package cdi.interceptor.log;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 *
 * Basta anotar a classe ou o méthodo que deseja seja interceptado pelo Logger
 *
 */


@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Loggable { }
