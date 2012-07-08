/**
 * Created with IntelliJ IDEA.
 * User: antoniopagano
 * Date: 7/3/12
 * Time: 10:25 PM
 */

import domain.utils.TestsDomain;
import grails.test.mixin.*
import org.junit.Test
import org.junit.Before;

public class UtilsDomainTests extends GroovyTestCase{
  TestsDomain domain

  @Before
  public void createSampleModel(){
    domain = new TestsDomain(name:  "Simple")
    domain.save(flush: true)
  }

  @Test
  public void firstMethodTest(){
    assert TestsDomain.first().equals(domain);
  }

  @Test
  public void lastMethodTest(){
    assert TestsDomain.last().equals(domain) ;
  }

  @Test
  public void updateAttribute(){
    def newDomain = new TestsDomain(name:  "Juan");
    newDomain.save();
    newDomain.updateAttribute( "name", "updated" );

    def domainLookup = TestsDomain.get( newDomain.id )
    assert domainLookup.name == "updated"
  }

  @Test
  public void updateLongAttribute(){
    def domain = TestsDomain.last();
    domain.updateAttribute("otherDomainProperty", "wi!");

    assert TestsDomain.get( domain.id ).otherDomainProperty.equals("wi!");
  }

  @Test
  public void updateAttributes(){
    def newDomain = new TestsDomain(name:  "Juan");
    newDomain.save();

    newDomain.updateAttributes( 'name': 'New Juan', 'otherDomainProperty': 'free' )
    def lookupDomain = TestsDomain.get( newDomain.id )

    assert lookupDomain.name.equals( 'New Juan' )
    assert lookupDomain.otherDomainProperty.equals( 'free' )
  }


  protected void tearDown() {
    super.tearDown()
  }

}
