/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.danielkvasnicka.neo4jtest;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.EmbeddedGraphDatabase;

/**
 *
 * @author daniel
 */
@Named
@RequestScoped
public class Dao {

    private GraphDatabaseService dbs;
    private Transaction transaction;
    
    @PostConstruct
    public void openDb() {
        this.dbs = new EmbeddedGraphDatabase("var/graphdb");
        this.transaction = this.dbs.beginTx();
    }

    public void addNode() {
        Node node = this.dbs.createNode();
        Node node2 = this.dbs.createNode();
        node.setProperty("number", Math.random());
        node2.setProperty("number", Math.random());
        node.createRelationshipTo(node2, Relationships.knows);
    }
    
    public Collection getNodes() {
        final Iterator<Node> i = this.dbs.getAllNodes().iterator();
        Set s = new HashSet();
        
        while (i.hasNext()) {
            s.add(new NodeEntity(i.next()));
        }
        
        return s;
    }

    @PreDestroy
    public void close() {
        this.transaction.success();
        this.transaction.finish();
        this.dbs.shutdown();
    }
}
