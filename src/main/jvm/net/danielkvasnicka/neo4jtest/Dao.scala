package net.danielkvasnicka.neo4jtest

import javax.inject.Named
import javax.enterprise.context.RequestScoped
import org.neo4j.graphdb.{Node, Transaction, GraphDatabaseService}
import org.neo4j.kernel.EmbeddedGraphDatabase
import javax.annotation.{PostConstruct, PreDestroy}
import collection.JavaConversions._

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 22.06.13
 * Time: 15:35
 */
@Named
@RequestScoped
class Dao {

    private var dbs: EmbeddedGraphDatabase = _
    private var transaction: Transaction = _

    @PostConstruct
    def setupDb(): Unit = {
        dbs = new EmbeddedGraphDatabase("var/graphdb")
        transaction = dbs.beginTx()
    }

    def addNode(): Unit = {

        val node = dbs.createNode()
        val node2 = dbs.createNode()
        node.setProperty("number", Math.random())
        node2.setProperty("number", Math.random())
        node.createRelationshipTo(node2, Relationships.knows)
    }

    def getNodes(): Seq[Node] = dbs.getAllNodes().iterator().toSeq map (new NodeEntity(_))

    @PreDestroy
    def close(): Unit = {
        transaction.success()
        transaction.finish()
        dbs.shutdown()
    }
}
