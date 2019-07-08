package com.ifi.profile.service;

import static org.neo4j.driver.Values.parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.neo4j.driver.StatementResult;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Value;
import org.neo4j.driver.types.MapAccessor;

import com.ifi.profile.model.Field;
import com.ifi.profile.model.Node;

public class NeoService {

	// Driver objects are thread-safe and are typically made available application-wide.
    Driver driver;

    public NeoService(String uri, String user, String password)
    {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }
    
    public void addNode(Node node)
    {
        // Sessions are lightweight and disposable connection wrappers.
        try (Session session = driver.session())
        {
        	String tmpQuery = "MERGE ("+node.getLabelNode()+" :"+node.getTypeNode();
        	if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
        		tmpQuery += " {";
        		for (Field field : node.getListFields()) {
        			if((field.getKey()!=null)&&(!"".equals(field.getKey()))&&(field.getValue()!=null)){
        				String tmpStr = field.getKey() + ": " + field.getValue() + ",";
        				try {  
        				    Double.parseDouble(field.getValue());      				    
        				} catch(NumberFormatException e){  
        					tmpStr = field.getKey() + ": \'" + field.getValue() + "\',";
        				}
        				tmpQuery += tmpStr;
        			}
            		
    			}
        		if(",".equals(tmpQuery.substring(tmpQuery.length() - 1))){
        			tmpQuery = tmpQuery.substring(0, tmpQuery.length() - 1);
        		}
        		
        		tmpQuery += "}";
        	}
        	
        	tmpQuery += ")";
        	System.out.println("tmpQuery:"+tmpQuery);
            // Wrapping Cypher in an explicit transaction provides atomicity
            // and makes handling errors much easier.
            try (Transaction tx = session.beginTransaction())
            {
                tx.run(tmpQuery);
                tx.success();  // Mark this write as successful.
            }
        }
    }
    
    // delete node
    public void deleteNode(Node node){
    	try(Session session = driver.session()){
    		String tmpQuery = "MATCH (n :"+node.getTypeNode();
        	if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
        		tmpQuery += " {";
        		for (Field field : node.getListFields()) {
        			if((field.getKey()!=null)&&(!"".equals(field.getKey()))&&(field.getValue()!=null)){
        				String tmpStr = field.getKey() + ": " + field.getValue() + ",";
        				try {  
        				    Double.parseDouble(field.getValue());      				    
        				} catch(NumberFormatException e){  
        					tmpStr = field.getKey() + ": \'" + field.getValue() + "\',";
        				}
        				tmpQuery += tmpStr;
        				// condition for selecting a key to break the loop 
        				if(field.getKey().equals("name")||field.getKey().equals("chargeid")||field.getKey().equals("id")){
        					break;
        				}
        			}
    			}
        		if(",".equals(tmpQuery.substring(tmpQuery.length() - 1))){
        			tmpQuery = tmpQuery.substring(0, tmpQuery.length() - 1);
        		}	
        		tmpQuery += "}";
        	} 	
        	tmpQuery += ")";
        	String tmpDelete = " DETACH DELETE n";
        	tmpQuery += tmpDelete;
        	System.out.println("tmpQuery: "+tmpQuery);
    		try(Transaction tx = session.beginTransaction()){
    			tx.run(tmpQuery);
    			tx.success();
    		}
    	}
    }
    
    // update node 
    // match (n: Person{name: "Dao Quang Hung"})
    // set n.tuoi = 35, n.email = 'abc@gmail.com'
    public void updateNode(Node node){
    	try(Session session = driver.session()){
    		String tmpQuery = "MATCH (n :"+node.getTypeNode();
        	if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
        		tmpQuery += " {";
        		for (Field field : node.getListFields()) {
        			if((field.getKey()!=null)&&(!"".equals(field.getKey()))&&(field.getValue()!=null)){
        				String tmpStr = field.getKey() + ": " + field.getValue() + ",";
        				try {  
        				    Double.parseDouble(field.getValue());      				    
        				} catch(NumberFormatException e){  
        					tmpStr = field.getKey() + ": \'" + field.getValue() + "\',";
        				}
        				tmpQuery += tmpStr;
        				// condition for selecting a key to break the loop 
        				if(field.getKey().equals("name")||field.getKey().equals("chargeid")||field.getKey().equals("id")){
        					break;
        				}
        			}
    			}
        		if(",".equals(tmpQuery.substring(tmpQuery.length() - 1))){
        			tmpQuery = tmpQuery.substring(0, tmpQuery.length() - 1);
        		}
        		tmpQuery += "}";
        	}
        	tmpQuery += ")";
        	String tmpUpdate = "SET ";
        	for (Field field : node.getListFields()){
        		if((field.getKey()!=null)&&(!"".equals(field.getKey()))&&(field.getValue()!=null)){
        			String str = "n." + field.getKey() + "=" + field.getValue() + ",";
        			try {  
    				    Double.parseDouble(field.getValue());      				    
    				} catch(NumberFormatException e){  
    					str = "n." + field.getKey() + "=\'" + field.getValue() + "\',";
    				}
        			tmpUpdate += str;
        		}
        	}
        	if(",".equals(tmpUpdate.substring(tmpUpdate.length() - 1))){
        		tmpUpdate = tmpUpdate.substring(0, tmpUpdate.length() - 1);
    		}
        	tmpQuery += tmpUpdate;
        	System.out.println(tmpQuery);
    		try(Transaction tx = session.beginTransaction()){
    			tx.run(tmpQuery);
    			tx.success();
    		}
    	}
    }
    
    // Add relationship
    // Cypher code :
    // match (n:label),(m:label)
    // where n.key = value and m.key = value
    // create (n)-[:relation]->(m)
    
    public void addRelationship(Node node){
    	try(Session session = driver.session()){
    		// select the node that we want to create relationship
    		String tmpSource = "MATCH (n :"+node.getTypeNode().substring(0, node.getTypeNode().indexOf(","));
    		tmpSource += "),";
    		// select the destination node
    		String tmpDestination = "(m :"+node.getTypeNode().substring(node.getTypeNode().indexOf(",")+1, node.getTypeNode().length());
    		tmpDestination += ")";
    		// create the condition 
    		String tmpCondition = " WHERE n.";
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			for(Field field : node.getListFields()){
    				String tmpStr = field.getKey() + "= \'" + field.getValue()+ "\'";
    				tmpCondition += tmpStr;
    				if(field.getKey().equals("name")||field.getKey().equals("chargeid")||field.getKey().equals("id")){
    					break;
    				}
    			}		
    		}
    		tmpCondition += " AND m.";
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			for(Field field : node.getListFields().subList(1, node.getListFields().size())){
    				String tmpStr = field.getKey() + "= \'" + field.getValue() + "\'";	
    				tmpCondition += tmpStr;
    				if(field.getKey().equals("name")||field.getKey().equals("chargeid")||field.getKey().equals("id")){
    					break;
    				}
    			}		
    		}
    		// create the relationship 
    		String tmpRelation = " CREATE (n)-[r:";
    		if((node.getRelation()!=null)&&(!"".equals(node.getRelation()))){
    			String tmpStr = ""+node.getRelation()+"]->(m)";
    			tmpRelation += tmpStr;
    		}
    		// create properties for relationship
    		String tmpProperties = "SET ";
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			for(Field field: node.getListFields()){
        			if((field.getKey()!=null)&&(!"".equals(field.getKey()))&&(field.getValue()!=null)){
        				String str = "r." + field.getKey() + "=" + field.getValue() + ",";
            			try {  
        				    Double.parseDouble(field.getValue());      				    
        				} catch(NumberFormatException e){  
        					str = "r." + field.getKey() + "=\'" + field.getValue() + "\',";
        				}
            			if(field.getKey().equals("name")||field.getKey().equals("chargeid")||field.getKey().equals("id")){
        					continue;
        				}
            			tmpProperties += str;
          			}
    		    }
    		}
    		
	    	if(",".equals(tmpProperties.substring(tmpProperties.length() - 1))){
	    		tmpProperties = tmpProperties.substring(0, tmpProperties.length() - 1);
			} 
    		String tmpQuery = tmpSource + tmpDestination + tmpCondition + tmpRelation + tmpProperties;
    		if("SET ".equals(tmpQuery.substring(tmpQuery.length()-4))){
    			tmpQuery = tmpSource + tmpDestination + tmpCondition + tmpRelation;
    		}
    		System.out.println(tmpQuery);
    		try(Transaction tx = session.beginTransaction()){
    			tx.run(tmpQuery);
    			tx.success();
    		}
    	}
    }
    
    
    
    // search by relationship
    // search query:
//  "MATCH (t:Technology)-[r]->(p:Project{chargeid :$chargeid}) " +
//	"WHERE type(r) = $r " +
//	"RETURN t.name AS name, t.description AS description, t.category AS category, t.domain AS domain",
    // query:
//    MATCH (n :Person)-[r]->(t :Technology {name: 'Java'}) WHERE type(r) = 'HAS_EXPERIENCE'
//    		 MATCH (t)-[]->(p:Project)
//    		 MATCH (n)-[]->(p) RETURN n AS obj, count(p) AS count
    public List<Node> searchByRelationship(Node node){
    	List<Node> list = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpSource = "MATCH (n :"+node.getTypeNode().substring(0, node.getTypeNode().indexOf(","));
    		tmpSource += ")-[r]->";
    		String tmpDestination = "(t :"+node.getTypeNode().substring(node.getTypeNode().indexOf(",")+1, node.getTypeNode().length());
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			tmpDestination += " {";
    			for(Field field : node.getListFields()){
    				String tmpStr = field.getKey() + ": \'" + field.getValue() + "\',";
    				tmpDestination += tmpStr;
    			}
    			if(",".equals(tmpDestination.substring(tmpDestination.length() - 1))){
    				tmpDestination = tmpDestination.substring(0, tmpDestination.length() - 1);
        		}
    			tmpDestination += "}";
        	}
    		tmpDestination += ")";
    		String tmpCondition = " WHERE type(r) = \'" + node.getRelation() + "\' RETURN n AS obj" ;
    		String tmpQuery = tmpSource + tmpDestination + tmpCondition;
    		
    		System.out.println("tmpQuery: "+tmpQuery);
    		StatementResult result = session.run(tmpQuery);
    		while(result.hasNext()){
    			Node tmpNode = new Node();
    			
    			Record record = result.next();
    			// Values can be extracted from a record by index or name.
    			try {
    				
    				// add info taken from record to tmpMap
    				Map<String, Object> tmpMap = record.get("obj").asMap();
					if(tmpMap.get("name") != null){
						tmpNode.setLabelNode(tmpMap.get("name").toString());
					}
					List<Field> listFields = new ArrayList<Field>();
					//Converting to Map.Entry so that we can get key and value separately so Elements can traverse in any order  
					for(Map.Entry entry:tmpMap.entrySet()){
						// create object field and set value for field
						Field tmpField = new Field();
						tmpField.setKey(entry.getKey().toString());
						tmpField.setValue(entry.getValue().toString());
						listFields.add(tmpField);
					}
					tmpNode.setListFields(listFields);
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			
    			list.add(tmpNode);
    		}
    	}
    	return list;
    }
    
    // get information of two relationship, advance search node by relationship
    // Query:
//    match (a:Person)-[]->(t:Technology{name:"Java"})
//    match (t)-[]->(p:Project)
//    match (a)-[]->(p)
//    return p, count(p)
    public List<Node> getNode(Node node){
    	List<Node> list = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpSource = "MATCH (n :"+node.getTypeNode().substring(0, node.getTypeNode().indexOf(","));
    		tmpSource += ")-[r]->";
    		String tmpDestination = "(t :"+node.getTypeNode().substring(node.getTypeNode().indexOf(",")+1, node.getTypeNode().length());
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			tmpDestination += " {";
    			for(Field field : node.getListFields()){
    				String tmpStr = field.getKey() + ": \'" + field.getValue() + "\',";
    				tmpDestination += tmpStr;
    			}
    			if(",".equals(tmpDestination.substring(tmpDestination.length() - 1))){
    				tmpDestination = tmpDestination.substring(0, tmpDestination.length() - 1);
        		}
    			tmpDestination += "}";
        	}
    		tmpDestination += ")";
    		String tmpCondition = " WHERE type(r) = \'" + node.getRelation() + "\'" ;
    		String tmpQuery = tmpSource + tmpDestination + tmpCondition;
    		String tmpDetail = "\n MATCH (t)-[]->(p:Project)";
    		tmpDetail += "\n MATCH (n)-[]->(p) RETURN n AS obj, count(p) AS count";
    		tmpQuery += tmpDetail;
    		System.out.println("tmpQuery: "+tmpQuery);
    		StatementResult result = session.run(tmpQuery);
    		while(result.hasNext()){
    			Node tmpNode = new Node();
    			
    			Record record = result.next();
    			// Values can be extracted from a record by index or name.
    			try {
    				// add count - count number of project that the person joined
    				tmpNode.setCount(record.get("count").asInt());
    				// add info taken from record to tmpMap
    				Map<String, Object> tmpMap = record.get("obj").asMap();
					if(tmpMap.get("name") != null){
						tmpNode.setLabelNode(tmpMap.get("name").toString());
					}
					List<Field> listFields = new ArrayList<Field>();
					//Converting to Map.Entry so that we can get key and value separately so Elements can traverse in any order  
					for(Map.Entry entry:tmpMap.entrySet()){
						// create object field and set value for field
						Field tmpField = new Field();
						tmpField.setKey(entry.getKey().toString());
						tmpField.setValue(entry.getValue().toString());
						listFields.add(tmpField);
					}
					tmpNode.setListFields(listFields);
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			
    			list.add(tmpNode);
    		}
    	}
    	return list;
    }
    
    // ADVANCE search by relationship: get project info and show the person who worked with the staff in project
    // query:
//    match (n:Person)-[:HAS_EXPERIENCE]->(t:Technology{name:"Java"})
//    match (t)-[]->(p:Project)
//    match (n:Person)-[]->(p)
//    return p, collect(n.name) as name
    public List<Node> advanceSearch(Node node){
    	List<Node> lists = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpSource = "MATCH (n :"+node.getTypeNode().substring(0, node.getTypeNode().indexOf(","));
    		tmpSource += ")-[r]->";
    		String tmpDestination = "(t :"+node.getTypeNode().substring(node.getTypeNode().indexOf(",")+1, node.getTypeNode().length());
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			tmpDestination += " {";
    			for(Field field : node.getListFields()){
    				String tmpStr = field.getKey() + ": \'" + field.getValue() + "\',";
    				tmpDestination += tmpStr;
    			}
    			if(",".equals(tmpDestination.substring(tmpDestination.length() - 1))){
    				tmpDestination = tmpDestination.substring(0, tmpDestination.length() - 1);
        		}
    			tmpDestination += "}";
        	}
    		tmpDestination += ")";
    		String tmpCondition = " WHERE type(r) = \'" + node.getRelation() + "\'" ;
    		String tmpQuery = tmpSource + tmpDestination + tmpCondition;
    		String tmpDetail = "\n MATCH (t)-[]->(p:Project)";
    		tmpDetail += "\n MATCH (n)-[]->(p) RETURN p AS obj, collect(n.name) AS name";
    		tmpQuery += tmpDetail;
    		System.out.println("tmpQuery: "+tmpQuery);
    		StatementResult result = session.run(tmpQuery);
    		while(result.hasNext()){
    			Node tmpNode = new Node();
    			
    			Record record = result.next();
    			// Values can be extracted from a record by index or name.
    			try {
    				// add info to map
    				//Map<String, Object> getInfo = 
    				// add info taken from record to tmpMap
    				Map<String, Object> tmpMap = record.get("obj").asMap();
					if(tmpMap.get("name") != null){
						tmpNode.setLabelNode(tmpMap.get("name").toString());
					}
					List<Field> listFields = new ArrayList<Field>();
					//Converting to Map.Entry so that we can get key and value separately so Elements can traverse in any order  
					for(Map.Entry entry:tmpMap.entrySet()){
						// create object field and set value for field
						Field tmpField = new Field();
						tmpField.setKey(entry.getKey().toString());
						tmpField.setValue(entry.getValue().toString());
						listFields.add(tmpField);
					}
					tmpNode.setListFields(listFields);
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			
    			lists.add(tmpNode);
    		}
    	}
    	return lists;
    }
    
    // get list nodes
    public List<Node> getListNodes()
    {
    	List<Node> ret = new ArrayList<Node>();
        try (Session session = driver.session())
        {
            // Auto-commit transactions are a quick and easy way to wrap a read.
            StatementResult result = session.run(
                    "MATCH (n) RETURN n as obj");
            // Each Cypher execution returns a stream of records.
            while (result.hasNext())
            {
            	Node tmpUser = new Node();
                Record record = result.next();
                // Values can be extracted from a record by index or name.
                try {
                	Map<String, Object> tmMap = record.get("obj").asMap();
                	if (tmMap.get("name") != null){
                		tmpUser.setLabelNode(tmMap.get("name").toString());
                	}
                	
                	List<Field> listFields = new ArrayList<Field>();
                	for(Map.Entry entry:tmMap.entrySet()){
                		Field tmpField = new Field();
                		tmpField.setKey(entry.getKey().toString());
                        tmpField.setValue(entry.getValue().toString());
                        listFields.add(tmpField);
                	}
                	tmpUser.setListFields(listFields);
                } catch (Exception ex) {
                	System.out.println("Error:"+ex.getMessage());
                }
                
                ret.add(tmpUser);
            }
        }
        
        return ret;
    }
    
    // get list labels
    public List<Node> getLabels(){
    	List<Node> labels = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		StatementResult result = session.run("MATCH (n) RETURN distinct labels(n) as typeNode");
    		while(result.hasNext()){
    			Node tmpLabels = new Node();
    			Record record = result.next();
    			String test = record.get("typeNode").toString();
    			// replace all special character in string because it existed in the label when call from database 
 				test = test.replace("[\"","");	
    			test = test.replace("\"]","");
    			test = test.replace("[","");
    			test = test.replace("]","");
    			tmpLabels.setTypeNode(test);
    			
    			labels.add(tmpLabels);
    		}
    	}
    	return labels;
    }
    
    // search person: show profile of the person searched 
    // match (n:Person{name:"Nguyen Hoang Hiep"})-[]->(t:Technology)
//    match (t)-[]->(p:Project)
//    return  p.project as project, collect(t.name) as technologies
    public List<Node> getInfo(String initial){
    	List<Node> nodeInfo = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpStr = "MATCH (n: Person),(t: Technology) WHERE n.name = $x ";
    		tmpStr += "\n MATCH (n)-[]->(t)";
    		tmpStr += "\n RETURN t.name AS technologies";
    		String tmpQuery = tmpStr;
    		System.out.println(tmpQuery);
    		StatementResult result = session.run(tmpQuery, parameters("x",initial));
    		while(result.hasNext()){
    			Node tmNode = new Node();
    			Record record = result.next();
    			try {
					Map<String, Object> tmpMap = record.get("technologies").asMap();
					List<Field> listFields = new ArrayList<Field>();
					for(Map.Entry entry : tmpMap.entrySet()){
						Field tmpField = new Field();
						tmpField.setKey(entry.getValue().toString());
						listFields.add(tmpField);
					}
					tmNode.setListFields(listFields);
					
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    		}
    	}
    	return nodeInfo;
    }
    
    // search query:"MATCH (n) WHERE n.name contains $x RETURN n"
    public List<Node> searchNode(String initial){
    	List<Node> list = new ArrayList<Node>();
    		
    	try(Session session = driver.session()){
    		
       		StatementResult result = session.run(
       				"MATCH (n) WHERE n.name contains $x RETURN n AS obj", parameters("x",initial));
       		
       		String str = "MATCH (n) WHERE n.name contains $x RETURN n AS obj";
       		System.out.println(str);
    		// Each Cypher execution returns a stream of records.
    		while(result.hasNext()){
    			Node tmpNode = new Node();
    			
    			Record record = result.next();
    			// Values can be extracted from a record by index or name.
    			try {
    				
    				// add info taken from record to tmpMap
					Map<String, Object> tmpMap = record.get("obj").asMap();
					if(tmpMap.get("name") != null){
						tmpNode.setLabelNode(tmpMap.get("name").toString());
					}
					List<Field> listFields = new ArrayList<Field>();
					//Converting to Map.Entry so that we can get key and value separately so Elements can traverse in any order  
					for(Map.Entry entry:tmpMap.entrySet()){
						// create object field and set value for field
						Field tmpField = new Field();
						tmpField.setKey(entry.getKey().toString());
						tmpField.setValue(entry.getValue().toString());
						listFields.add(tmpField);
					}
					tmpNode.setListFields(listFields);
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			
    			list.add(tmpNode);
    		}
    	}
    	
    	return list;
    }
   
    public void close()
    {
        // Closing a driver immediately shuts down all open connections.
        driver.close();
    }
}
