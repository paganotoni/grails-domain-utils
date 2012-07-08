import org.junit.Test
import domain.utils.TestsDomain
/**
 * Created with IntelliJ IDEA.
 * User: antoniopagano
 * Date: 7/7/12
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
class UtilsDomainEmptyTests extends GroovyTestCase {

  @Test
  public void firstShouldReturnNullOnEmpty(){
    assert TestsDomain.first().equals(null);
  }

  @Test
  public void lastShouldReturnNullOnEmpty(){
    assert TestsDomain.last().equals(null);
  }
}
