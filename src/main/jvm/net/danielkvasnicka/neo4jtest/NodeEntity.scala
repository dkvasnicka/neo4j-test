package net.danielkvasnicka.neo4jtest

import org.neo4j.graphdb._
import java.lang.{Iterable, Object}
import scala.collection.immutable.DefaultMap
import org.neo4j.graphdb.Traverser.Order
import collection.JavaConversions._
import java.util

/**
 * Created with IntelliJ IDEA.
 * User: daniel
 * Date: 23.06.13
 * Time: 21:25
 */
class NodeEntity(n: Node) extends util.HashMap[String, Object]
    with Node {

    def getId(): Long = {
        n.getId()
    }

    def delete() {
        n.delete()
    }

    override def get(keyany: Any): Object = {
        val key = keyany.asInstanceOf[String]

        if (n.hasProperty(key)) {
            return n.getProperty(key)
        }

        if (Relationships.exists(key) &&
            n.hasRelationship(Relationships.valueOf(key))) {

            return seqAsJavaList(getRelationships(Relationships.valueOf(key)).iterator().toSeq map
                (r => new NodeEntity(r.getOtherNode(n))))
        }

        null
    }

    def getGraphDatabase: GraphDatabaseService = ???

    def hasProperty(key: String): Boolean = ???

    def getProperty(key: String): AnyRef = ???

    def getProperty(key: String, defaultValue: Any): AnyRef = ???

    def setProperty(key: String, value: Any) {}

    def removeProperty(key: String): AnyRef = ???

    def getPropertyKeys: Iterable[String] = ???

    def getPropertyValues: Iterable[AnyRef] = ???

    def getRelationships: Iterable[Relationship] = ???

    def hasRelationship: Boolean = ???

    def getRelationships(types: RelationshipType*): Iterable[Relationship] = n.getRelationships(types: _*)

    def hasRelationship(types: RelationshipType*): Boolean = ???

    def getRelationships(dir: Direction): Iterable[Relationship] = ???

    def hasRelationship(dir: Direction): Boolean = ???

    def getRelationships(`type`: RelationshipType, dir: Direction): Iterable[Relationship] = ???

    def hasRelationship(`type`: RelationshipType, dir: Direction): Boolean = ???

    def getSingleRelationship(`type`: RelationshipType, dir: Direction): Relationship = ???

    def createRelationshipTo(otherNode: Node, `type`: RelationshipType): Relationship = ???

    def traverse(traversalOrder: Order, stopEvaluator: StopEvaluator, returnableEvaluator: ReturnableEvaluator, relationshipType: RelationshipType, direction: Direction): Traverser = ???

    def traverse(traversalOrder: Order, stopEvaluator: StopEvaluator, returnableEvaluator: ReturnableEvaluator, firstRelationshipType: RelationshipType, firstDirection: Direction, secondRelationshipType: RelationshipType, secondDirection: Direction): Traverser = ???

    def traverse(traversalOrder: Order, stopEvaluator: StopEvaluator, returnableEvaluator: ReturnableEvaluator, relationshipTypesAndDirections: AnyRef*): Traverser = ???
}
