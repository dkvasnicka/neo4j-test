/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.danielkvasnicka.neo4jtest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ReturnableEvaluator;
import org.neo4j.graphdb.StopEvaluator;
import org.neo4j.graphdb.Traverser;
import org.neo4j.graphdb.Traverser.Order;

/**
 *
 * @author daniel
 */
public class NodeEntity implements Node, Map<String, Object> {

    private Node n;

    public NodeEntity(Node n) {
        this.n = n;
    }
    
    @Override
    public long getId() {
        return this.n.getId();
    }

    @Override
    public void delete() {
        this.n.delete();
    }

    @Override
    public Iterable<Relationship> getRelationships() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasRelationship() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<Relationship> getRelationships(RelationshipType... rts) {
        return this.n.getRelationships(rts);
    }

    @Override
    public boolean hasRelationship(RelationshipType... rts) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<Relationship> getRelationships(Direction drctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasRelationship(Direction drctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<Relationship> getRelationships(RelationshipType rt, Direction drctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasRelationship(RelationshipType rt, Direction drctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Relationship getSingleRelationship(RelationshipType rt, Direction drctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Relationship createRelationshipTo(Node node, RelationshipType rt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Traverser traverse(Order order, StopEvaluator se, ReturnableEvaluator re, RelationshipType rt, Direction drctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Traverser traverse(Order order, StopEvaluator se, ReturnableEvaluator re, RelationshipType rt, Direction drctn, RelationshipType rt1, Direction drctn1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Traverser traverse(Order order, StopEvaluator se, ReturnableEvaluator re, Object... os) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public GraphDatabaseService getGraphDatabase() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean hasProperty(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getProperty(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getProperty(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setProperty(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object removeProperty(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<String> getPropertyKeys() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterable<Object> getPropertyValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsKey(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object get(Object o) {
        final String key = o.toString();
        if (this.n.hasProperty(key)) {
            return this.n.getProperty(key);
        }
        
        if (Relationships.exists(key) && 
            this.n.hasRelationship(Relationships.valueOf(key))) {
            Iterable<Relationship> relationships = this.getRelationships(Relationships.valueOf(key));
            final Iterator<Relationship> rIterator = relationships.iterator();
            Relationship first = rIterator.next();
            final NodeEntity firstNodeEntity = new NodeEntity(first.getOtherNode(this.n));
            
            if (rIterator.hasNext()) {
                Set relatedNodes = new HashSet();
                relatedNodes.add(firstNodeEntity);
                
                while(rIterator.hasNext()) {
                    relatedNodes.add(new NodeEntity(rIterator.next().getOtherNode(this.n)));
                }
                
                return relatedNodes;
            } else {
                return firstNodeEntity;
            }
        }
        
        return null;
    }
    
    @Override
    public Object put(String k, Object v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> map) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Object> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
