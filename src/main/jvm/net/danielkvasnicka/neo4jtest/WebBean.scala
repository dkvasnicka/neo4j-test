package net.danielkvasnicka.neo4jtest

import javax.faces.bean.ManagedBean
import javax.inject.Inject
import org.neo4j.graphdb.Node

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 22.06.13
 * Time: 14:14
 */
@ManagedBean
class WebBean {

  @Inject
  var dao: Dao = _

  def getNodes(): java.util.Collection[_] = {
    dao.getNodes()
  }

  def addNode(): Unit = {
    dao.addNode()
  }
}
