/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.danielkvasnicka.neo4jtest;

import org.neo4j.graphdb.RelationshipType;

/**
 *
 * @author daniel
 */
public enum Relationships implements RelationshipType {
    
    knows;
    
    public static boolean exists(String s) {
        for (Relationships r : Relationships.values()) {
            if (r.name().equals(s)) {
                return true;
            }
        }
        
        return false;
    }
}
