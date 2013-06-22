/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.danielkvasnicka.neo4jtest;

import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import org.neo4j.graphdb.Node;

/**
 *
 * @author daniel
 */
@ManagedBean
public class WebBean {
    
    @Inject
    private Dao dao;
    
    public Collection<Node> getNodes() {
        return this.dao.getNodes();
    }
    
    public void addNode() {
        this.dao.addNode();
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
    
    
}
