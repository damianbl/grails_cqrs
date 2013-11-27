package grails.cqrs.spring

import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
/**
 * Created by IntelliJ IDEA.
 * User: damian.blazejewski
 * Date: 21.11.13
 */
class SpringBeanResolver {
    static Object resolve(String beanId) {
        def ctx = ServletContextHolder.servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT)
        return ctx."$beanId"
    }
}
