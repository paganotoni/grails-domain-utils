import org.springframework.orm.hibernate3.HibernateTemplate
import org.codehaus.groovy.grails.commons.GrailsDomainClass

class DomainUtilsGrailsPlugin {
  def version = "1.0"
  def grailsVersion = "2.0 > *"

  def loadAfter = ['core', 'controllers', 'domainClass']
  def dependsOn = [ core: "2.0 > *", domainClass: '2.0 > *']

  def pluginExcludes = [
    "grails-app/views/error.gsp",
    "grails-app/controllers/**", // they exist only for testing purposes
    "grails-app/conf/Config.groovy",
    "web-app/**",
    "grails-app/views",
    "grails-app/controllers"
  ]

  def title = "Domain Utils" // Headline display name of the plugin
  def author = "Antonio PAgano"
  def authorEmail = ""
  def description = '''\
This plugins adds some utility methods to domain classes, basically it adds first, last, updateAttributes and updateAttribute
my idea is to add another methods that can help our grails experience to get better than it is.

You can get the sourcecode at github. https://github.com/apaganobeleno/grails-domain-utils

Also if you got some ideas let me comments, or issues there.
'''

  // URL to the plugin's documentation
  def documentation = "http://grails.org/plugin/domain-utils"
  def license = "APACHE"
  def organization = [name: "Antonio Pagano", url: "http://blog.antonio-pagano.com/"]
  def developers = [[name: "Antonio Pagano", email: "apagano.bbl@gmail.com"]]


  def doWithApplicationContext = { applicationContext ->
    def domainUtilsAggregator = new DomainUtilsAggregator();

    domainUtilsAggregator.addStaticMethods(  application );
    domainUtilsAggregator.addInstanceMethods( application );
  }
}
