package com.ifi.profile.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.neo4j.driver.StatementResult;
import org.neo4j.driver.Transaction;



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
    // query: match (n: Person{name: 'Nguyen Van A'}) detach delete n
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
    // create (n)-[r:relation]->(m)
    // set r.key = value (create properties for relationship)
    
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
    
    // get information of two relationship, advance search node by relationship (advance search relationship)
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
    
    // view profile
    // search person: show profile of the person searched (show list technologies)
    // match (n:Person{name:"Nguyen Hoang Hiep"})-[]->(t:Technology)
    // MATCH (n)-[]->(t)
    // RETURN t.name AS technologies, r.exp AS experience
    public List<Node> getInfo(Node node){
    	List<Node> nodeInfo = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpStr = "MATCH (n: Person),(t: Technology) WHERE ";
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			for(Field field : node.getListFields()){
    				String str =  "n.name =" + "\'" + field.getValue() + "\'";
    				tmpStr += str;
    			}
			}
    		tmpStr += "\n MATCH (n)-[r]->(t)";
    		tmpStr += "\n RETURN t.name AS technologies, r.exp AS experience";
    		String tmpQuery = tmpStr;
    	
    		StatementResult result = session.run(tmpQuery);
    		while(result.hasNext()){
    			Node tmpNode = new Node();
    			
    			Record record = result.next();
    			try {
    				List<Field> listTechs = new ArrayList<Field>();
					Field tmField = new Field();
					tmField.setKey(record.get("technologies").asString());
					listTechs.add(tmField);
					
					// get list technologies
					List<Field> listExp = new ArrayList<Field>();
					Field tmpExp = new Field();
					String test = record.get("experience").toString();
					if("NULL".equals(test)){
						test = test.replace("NULL","");
						test += "0";
					}
					System.out.println(test);
					tmpExp.setValue(test);
					listExp.add(tmpExp);
					
					// merge two lists 
					listTechs.addAll(listExp);
					tmpNode.setListFields(listTechs);
					

				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			nodeInfo.add(tmpNode);
    		}
    	}
    	return nodeInfo;
    }
    
    // show project and technologies used
    // query:
//    MATCH (n: Person),(p:Project) WHERE n.name ='Nguyen Huu Huong'
//    MATCH (n)-[]->(p)
//    MATCH (t: Technology)-[]->(p)
//    RETURN p.project AS project, collect(t.name) AS technologies
    public List<Node> getProject(Node node){
    	List<Node> nodeInfor = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpStr = "MATCH (n: Person),(p:Project) WHERE ";
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			for(Field field : node.getListFields()){
    				String str =  "n.name =" + "\'" + field.getValue() + "\'";
    				tmpStr += str;
    			}
			}
    		tmpStr += "\n MATCH (n)-[]->(p)";
    		tmpStr += "\n MATCH (t: Technology)-[]->(p)";
    		tmpStr += "\n RETURN p.project AS project, collect(t.name) AS technologies";
    		String tmpQuery = tmpStr;
    		StatementResult rs = session.run(tmpQuery);
    		while(rs.hasNext()){
    			Node tmpNode = new Node();
    			Record record = rs.next();
    			try {
    				// get list project
					List<Field> listFields = new ArrayList<Field>();
					Field tmField = new Field();
					tmField.setValue(record.get("project").asString());
					listFields.add(tmField);
					
					// get list technologies
					List<Field> listTech = new ArrayList<Field>();
					Field tmTech = new Field();
					String test = record.get("technologies").toString();
					// remove special character
					test = test.replace("[\"","");	
	    			test = test.replace("\"]","");
	    			test = test.replace("\"","");
					tmTech.setKey(test);
					listTech.add(tmTech);
					
					// merge two lists 
					listFields.addAll(listTech);
					tmpNode.setListFields(listFields);
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			nodeInfor.add(tmpNode);
    		}
    	}
    	
    	return nodeInfor;
    }
    
    // show project and persons take part in project
    // query:
//    match (n:Person{name:"Nguyen Huu Huong"})-[]->(p:Project)
//    match (m:Person)-[]->(p)
//    return p.project as project, collect(m.name) as person
    public List<Node> getPersons(Node node){
    	List<Node> nodeInfo = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpStr = "MATCH (n: Person),(p:Project) WHERE ";
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			for(Field field : node.getListFields()){
    				String str =  "n.name =" + "\'" + field.getValue() + "\'";
    				tmpStr += str;
    			}
			}
    		tmpStr += "\n MATCH (n)-[]->(p)";
    		tmpStr += "\n MATCH (m:Person)-[]->(p)";
    		tmpStr += "\n RETURN p.project as project, collect(m.name) as person";
    		String tmpQuery = tmpStr;
    		StatementResult rs = session.run(tmpQuery);
    		while(rs.hasNext()){
    			Node tmpNode = new Node();
    			Record record = rs.next();
    			
    			try {
					// get list project
					List<Field> listProject = new ArrayList<Field>();
					Field tmpProject = new Field();
					tmpProject.setKey(record.get("project").asString());
					listProject.add(tmpProject);
					
					// get list person takes part in project
					List<Field> listPerson = new ArrayList<Field>();
					Field tmpPerson = new Field();
					String test = record.get("person").toString();
					// remove special character
					test = test.replace("[\"","");	
	    			test = test.replace("\"]","");
	    			test = test.replace("\"","");
	    			tmpPerson.setValue(test);
	    			listPerson.add(tmpPerson);
	    			
					// merge two list
					listProject.addAll(listPerson);
					tmpNode.setListFields(listProject);
					
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			nodeInfo.add(tmpNode);
    		}
    	}
    	return nodeInfo;
    }
    
    // Advance view profile: calculate the experience of person bases on project
    public List<Node> expTech(Node node){
    	List<Node> listExp = new ArrayList<Node>();
    	
    	try(Session session = driver.session()){
    		String tmpQuery = "(n: Person),(p:Project) WHERE ";
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			for(Field field : node.getListFields()){
    				String tmpStr =  "n.name contains" + "\'" + field.getValue() + "\'";
    				tmpQuery += tmpStr;
    			}
			}
    		tmpQuery += "\n MATCH (n)-[r]->(p)";
    		tmpQuery += "\n MATCH (t: Technology)-[]->(p)";
    		tmpQuery += "RETURN t.name AS technologies, p.project as project, p.startdate as start, p.finishdate as finish, r.from as from, r.to as to";
    		StatementResult rs = session.run(tmpQuery);
    		while(rs.hasNext()){
    			Node tmNode = new Node();
    			Record record = rs.next();
    			try {
    				// get date from database
					String startDate = record.get("start").asString();
					String finishDate = record.get("finish").toString();
					finishDate = finishDate.replaceAll("\"", "");
					String workFrom = record.get("from").asString();
					String workTo = record.get("to").asString();
					String format = "yyyy-MM-dd";
					Date currentDate = new Date();
					// format date and add date get from database to object date
					SimpleDateFormat sdf = new SimpleDateFormat(format);
					Date start = sdf.parse(startDate);
					Date finish = sdf.parse(finishDate);
					Date from = sdf.parse(workFrom);
					Date to = sdf.parse(workTo);
				//	Date current = sdf.format(currentDate);
					
					// formula calculating month between to date
					long date, month;
					if(start.before(from) && to.before(finish)){
						date = from.getTime() - to.getTime();
						month = date / (30*24*60*60*1000);
					}else if(start.before(from)&&finish.equals(to)){
						date = from.getTime() - finish.getTime();
						month = date / (30*24*60*60*1000);
					}else if(start.equals(from)&& to.before(finish)){
						date = start.getTime() - to.getTime();
						month = date / (30*24*60*60*1000);
					}else if(start.equals(from)&&finish.equals(to)){
						date = start.getTime() - finish.getTime();
						month = date / (30*24*60*60*1000);
					}else if(start.equals(from)&&"NULL".equals(finish)){
						date = start.getTime() - to.getTime();
						month = date / (30*24*60*60*1000);
					}else if(start.equals(from)&&"NULL".equals(finish)&&"NULL".equals(to)){
						date = start.getTime() - to.getTime();
						month = date / (30*24*60*60*1000);
					}
					
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			listExp.add(tmNode);
    		}
    	}
    	
    	return listExp;
    }
   
    // search query:"MATCH (n) WHERE n.name contains $x RETURN n"
    public List<Node> searchNode(Node node){
    	List<Node> list = new ArrayList<Node>();
    		
    	try(Session session = driver.session()){
    		String tmpQuery = "MATCH (n) WHERE ";
    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
    			for(Field field : node.getListFields()){
    				String tmpStr =  "n.name contains" + "\'" + field.getValue() + "\'";
    				tmpQuery += tmpStr;
    			}
			}
    		tmpQuery += "RETURN n AS obj";

       		StatementResult result = session.run(
       				tmpQuery);
       		
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
