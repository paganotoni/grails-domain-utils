import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication

/**
 * Created with IntelliJ IDEA.
 * User: antoniopagano
 * Date: 7/4/12
 * Time: 1:33 PM
 *
 * Adds some util methods to grails domain classes
 */
class DomainUtilsAggregator {

  public void addInstanceMethods( DefaultGrailsApplication application ){
    application.domainClasses.each { GrailsDomainClass domainClassWrapper ->
      metaClass = domainClassWrapper.clazz.metaClass

      metaClass.overrideAttribute = { attributeName, value ->
        delegate."set${attributeName.capitalize()}"( value )
      }

      metaClass.updateAttribute =  { String attributeName, value ->
        delegate.overrideAttribute( attributeName, value );
        delegate.save()
      }

      metaClass.updateAttributes = { LinkedHashMap attributes ->
        for( Map.Entry it in attributes.entrySet() ){
          delegate.overrideAttribute( it.key, it.value );
        }

        delegate.save();
      }
    }
  }

  public void addStaticMethods( DefaultGrailsApplication application ){
    application.domainClasses.each { GrailsDomainClass domainClassWrapper ->
      metaClass = domainClassWrapper.clazz.metaClass

      metaClass.static.first = {
        def result = list( max: 1, sort: 'id', order: 'asc' )
        return result.isEmpty() ? null : result.first()
      }

      metaClass.static.last = {
        def result = list( max: 1, sort: 'id', order: 'desc' )
        return result.isEmpty() ? null : result.first()
      }
    }
  }

}
