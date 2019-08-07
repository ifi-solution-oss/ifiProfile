package com.ifi.profile.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        				String str = field.getKey();
        				// condition for selecting a key to break the loop 
        				if("name".equals(str)||"chargeid".equals(str)||"id".equals(str)){
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
        	String tmpUpdate = " SET ";
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
    
    // get list Person
    public List<Node> getListPerson(){
    	List<Node> ret = new ArrayList<Node>();
        try (Session session = driver.session()){
            // Auto-commit transactions are a quick and easy way to wrap a read.
            StatementResult result = session.run(
                    "MATCH (n: Person) RETURN distinct labels(n) AS label, n AS person");
            // Each Cypher execution returns a stream of records.
            while (result.hasNext()){
            	Node tmpNode = new Node();
                Record record = result.next();
                // Values can be extracted from a record by index or name.
                try {
                	String type = record.get("label").toString();
                	type = type.replace("[\"","");	
                	type = type.replace("\"]","");
    				tmpNode.setTypeNode(type);
                	Map<String, Object> tmPerson = record.get("person").asMap();

                	if (tmPerson.get("name") != null){
                		tmpNode.setLabelNode(tmPerson.get("name").toString());
                	}
                	
                	List<Field> listFields = new ArrayList<Field>();
                	for(Map.Entry entry:tmPerson.entrySet()){
                		Field tmpField = new Field();
                		tmpField.setKey(entry.getKey().toString());
                        tmpField.setValue(entry.getValue().toString());
                        listFields.add(tmpField);
                	}
                	tmpNode.setListFields(listFields);
                } catch (Exception ex) {
                	System.out.println("Error:"+ex.getMessage());
                }
                ret.add(tmpNode);
            }
        }
        return ret;
    }
    
    // get list projects
    public List<Node> getListProjects(){
    	List<Node> ret = new ArrayList<Node>();
        try (Session session = driver.session()){
            // Auto-commit transactions are a quick and easy way to wrap a read.
            StatementResult result = session.run(
                    "MATCH (n: Project) RETURN distinct labels(n) AS label, n AS project");
            // Each Cypher execution returns a stream of records.
            while (result.hasNext()){
            	Node tmpNode = new Node();
                Record record = result.next();
                // Values can be extracted from a record by index or name.
                try {
                	String type = record.get("label").toString();
                	type = type.replace("[\"","");	
                	type = type.replace("\"]","");
    				tmpNode.setTypeNode(type);
                	Map<String, Object> tmProject = record.get("project").asMap();
                	
                	if (tmProject.get("name") != null){
                		tmpNode.setLabelNode(tmProject.get("name").toString());
                	}
                	
                	List<Field> listFields = new ArrayList<Field>();
                	for(Map.Entry entry:tmProject.entrySet()){
                		Field tmpField = new Field();
                		tmpField.setKey(entry.getKey().toString());
                        tmpField.setValue(entry.getValue().toString());
                        listFields.add(tmpField);
                	}
                	tmpNode.setListFields(listFields);
                } catch (Exception ex) {
                	System.out.println("Error:"+ex.getMessage());
                }
                ret.add(tmpNode);
            }
        }
        return ret;
    }
    
    // get list technologies
    public List<Node> getListTechs(){
    	List<Node> ret = new ArrayList<Node>();
        try (Session session = driver.session()){
            // Auto-commit transactions are a quick and easy way to wrap a read.
            StatementResult result = session.run(
                    "MATCH (n: Technology) RETURN distinct labels(n) AS label, n AS technologies");
            // Each Cypher execution returns a stream of records.
            while (result.hasNext()){
            	Node tmpNode = new Node();
                Record record = result.next();
                // Values can be extracted from a record by index or name.
                try {
                	String type = record.get("label").toString();
                	type = type.replace("[\"","");	
                	type = type.replace("\"]","");
    				tmpNode.setTypeNode(type);
                	Map<String, Object> tmTech = record.get("technologies").asMap();
                	
                	if (tmTech.get("name") != null){
                		tmpNode.setLabelNode(tmTech.get("name").toString());
                	}
                	
                	List<Field> listFields = new ArrayList<Field>();
                	for(Map.Entry entry:tmTech.entrySet()){
                		Field tmpField = new Field();
                		tmpField.setKey(entry.getKey().toString());
                        tmpField.setValue(entry.getValue().toString());
                        listFields.add(tmpField);
                	}
                	tmpNode.setListFields(listFields);
                } catch (Exception ex) {
                	System.out.println("Error:"+ex.getMessage());
                }
                ret.add(tmpNode);
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
    public List<Node> getInfo(String personName){
    	List<Node> nodeInfo = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpStr = "MATCH (n: Person),(t: Technology) WHERE ";
    		String str =  "n.name =" + "\'" + personName + "\'";
    		tmpStr += str;
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
    public List<Node> getProject(String nameNode){
    	List<Node> nodeInfor = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpStr = "MATCH (n: Person),(p:Project) WHERE ";
    		String str =  "n.name =" + "\'" + nameNode + "\'";
    		tmpStr += str;
    		tmpStr += "\n MATCH (n)-[]->(p)";
    		tmpStr += "\n MATCH (t: Technology)-[]->(p)";
    		tmpStr += "\n RETURN p.name AS project, collect(t.name) AS technologies";
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
    
    // search person work in project and project info
    public List<Node> searchPerson(String  projectName){
    	List<Node> nodeInfo = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpStr = "MATCH (n: Person),(p:Project) WHERE ";
//    		if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
//    			for(Field field : node.getListFields()){
//    				String str =  "p.project =" + "\'" + field.getValue() + "\'";
//    				tmpStr += str;
//    			}
//			}
    		tmpStr += "p.name =" + "\'" + projectName + "\'";
    		
    		tmpStr += " MATCH (n)-[r]->(p)";
    		tmpStr += " RETURN p as project, collect(n.name) as person";
    		String tmpQuery = tmpStr;
    		StatementResult rs = session.run(tmpQuery);
    		while(rs.hasNext()){
    			Node tmpNode = new Node();
    			Record record = rs.next();
    			
    			try {
    				// get person
    				String test = record.get("person").toString();
    				// remove special character
					test = test.replace("[\"","");	
	    			test = test.replace("\"]","");
	    			test = test.replace("\"","");
    				tmpNode.setLabelNode(test);
					// get list project
    				Map<String, Object> tmpMap = record.get("project").asMap();
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
    			nodeInfo.add(tmpNode);
    		}
    	}
    	return nodeInfo;
    }
    
    // Advance view profile: calculate the experience of person bases on project
    public List<Node> expTech(String nameNode){
    	List<Node> listExp = new ArrayList<Node>();
    	
    	try(Session session = driver.session()){
    		String tmpQuery = "MATCH (n: Person),(t:Technology) WHERE ";
    		String tmpStr =  "n.name =" + "\'" + nameNode + "\'";
    		tmpQuery += tmpStr;
    		tmpQuery += "\n MATCH (t)-[]->(p:Project)";
    		tmpQuery += "\n MATCH (n)-[r]->(p)";
    		tmpQuery += "\n RETURN t.name AS technologies,p.name AS project ,r.from AS from, r.to AS to";
    		StatementResult rs = session.run(tmpQuery);
    		System.out.println(tmpQuery);
    		while(rs.hasNext()){
    			Node tmNode = new Node();
    			Record record = rs.next();
    			try {
    				tmNode.setLabelNode(record.get("project").asString());
    				List<Field> listTech = new ArrayList<Field>();
    				Field tmTech = new Field();
    				tmTech.setKey(record.get("technologies").asString());
    				listTech.add(tmTech);

    				// get date from database
					String workFrom = record.get("from").asString();
					String workTo = record.get("to").toString();
					workTo = workTo.replaceAll("\"", "");
					if("null".equals(workTo)){
						break;
					}
					String format = "yyyy-MM-dd";
					
					// format date and add date get from database to object date
					SimpleDateFormat sdf = new SimpleDateFormat(format);
					Date from = sdf.parse(workFrom);
					Date to = sdf.parse(workTo);
					
					// calculate time between two date (from ... to ...)
					long diff = Math.abs(to.getTime()-from.getTime());
					// exchange time between two date to month
					long month = Math.round(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)/30);
					
					String totalMonth = Long.toString(month);
					List<Field> listExpTech = new ArrayList<Field>();
					Field tmListExp = new Field();
					tmListExp.setValue(totalMonth);
					listExpTech.add(tmListExp);
					
					List<Field> combinedList = Stream.of(listTech, listExpTech).flatMap(x -> x.stream()).collect(Collectors.toList());
				//	listTech.addAll(listExpTech);
				
					tmNode.setListFields(combinedList);
					
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			listExp.add(tmNode);
    			
    		}
    	}
    	
    	return listExp;
    }
   
    // search person has more than 4 year experience
    // query:
//    with 1 as experience
//    match (n:Person),(t:Technology)
//    where t.name = "HTML"
//    match (n)-[r]->(t)
//    where r.exp > experience
//    return n.name as name, r.exp as experience, t.name as TechName
//    order by experience
    public List<Node> searchPersonExp(Node node){
    	List<Node> listExp = new ArrayList<Node>();
    		try(Session session = driver.session()){
    			String tmpStr = " WITH ";
    			if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
        			for(Field field : node.getListFields()){
        				tmpStr +=  field.getKey() + " AS experience";
        			}
    			}
    			tmpStr += "\n MATCH (n:Person),(t:Technology)";
    			tmpStr += "\n WHERE";
    			if((node.getListFields()!=null)&&(!"".equals(node.getListFields()))){
        			for(Field field : node.getListFields()){
        				tmpStr +=  " t.name = " + "\'" + field.getValue() + "\'";
        			}
    			}
    			tmpStr += "\n MATCH (n)-[r]->(t)";
    			tmpStr += "\n WHERE r.exp > experience";
    			tmpStr += "\n RETURN n.name as personName, r.exp as experience, t.name as techName";
   				tmpStr += "\n ORDER BY experience";
    			String tmpQuery = tmpStr;
    			System.out.println(tmpQuery);
    			StatementResult rs = session.run(tmpQuery);
    			while(rs.hasNext()){
    				Node tmpNode = new Node();
    				Record record = rs.next();
    				try {
						tmpNode.setLabelNode(record.get("nameNode").asString());

						List<Field> listExperience = new ArrayList<Field>();
						Field tmpExp = new Field();
						tmpExp.setKey(record.get("experience").toString());
						listExperience.add(tmpExp);
						
						List<Field> listTech = new ArrayList<Field>();
						Field tmpTech = new Field();
						tmpTech.setValue(record.get("techName").asString());
						listTech.add(tmpTech);
						
						listExperience.add(tmpTech);
						System.out.println(listExperience);
						tmpNode.setListFields(listExperience);
					} catch (Exception e) {
						System.out.println("Error: "+e.getMessage());
					}
    				listExp.add(tmpNode);
    			}
    		}
    	return listExp;
    }
    
    // search function
    // search query:"MATCH (n) WHERE n.name contains $x RETURN n"
    public List<Node> searchNode(String nameNode){
    	List<Node> list = new ArrayList<Node>();
    		
    	try(Session session = driver.session()){
    		String tmpQuery = "MATCH (n) WHERE ";
    		
    		String tmpStr =  "n.name contains" + "\'" + nameNode + "\'";
    		tmpStr +=  " OR n.domain contains" + "\'" + nameNode + "\'";
    		tmpStr +=  " OR n.title contains" + "\'" + nameNode + "\'";
    		tmpQuery += tmpStr;
    		tmpQuery += "RETURN distinct labels(n) AS label, n AS obj";

       		StatementResult result = session.run(
       				tmpQuery);
       		
      		// Each Cypher execution returns a stream of records.
    		while(result.hasNext()){
    			Node tmpNode = new Node();
    			
    			Record record = result.next();
    			// Values can be extracted from a record by index or name.
    			try {
    				// get label
    				String type = record.get("label").toString();
                	type = type.replace("[\"","");	
                	type = type.replace("\"]","");
    				tmpNode.setTypeNode(type);
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
						String tmpValue = entry.getValue().toString();
						tmpValue = tmpValue.replace("[","");
						tmpValue = tmpValue.replace("]","");
						if("null".equals(tmpValue)){
							tmpValue = tmpValue.replace("null","");
							tmpValue += "-----------";
						}
						tmpField.setValue(tmpValue);
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
   
    // get list nodes for search function (auto complete)
    public List<Node> autocompleSearch(){
    	List<Node> ret = new ArrayList<Node>();
        try (Session session = driver.session()){
            // Auto-commit transactions are a quick and easy way to wrap a read.
            StatementResult result = session.run(
                    "MATCH (n) RETURN n as obj");
            // Each Cypher execution returns a stream of records.
            while (result.hasNext()){
            	Node tmpUser = new Node();
                Record record = result.next();
                // Values can be extracted from a record by index or name.
                try {
                	Map<String, Object> tmMap = record.get("obj").asMap();
                	
                	List<Field> listFields = new ArrayList<Field>();
                	for(Map.Entry entry:tmMap.entrySet()){
                		Field tmpField = new Field();
                		String tmpKey = entry.getKey().toString();
                		if(("name").equals(tmpKey)||("domain").equals(tmpKey)||("title").equals(tmpKey)){
                			tmpField.setKey(tmpKey);
                			String tmpValue = entry.getValue().toString();
                            tmpField.setValue(tmpValue);
                            listFields.add(tmpField);
                		}
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
   
    // Span detail of Technology: get Person
    // Query: 
//    match (n:Person),(t:Technology) where t.name = "Java"
//    match (n)-[r]->(t)
//    return n
    public List<Node> techDetail(String projectName){
    	List<Node> list = new ArrayList<Node>();
    	try(Session session = driver.session()){
    		String tmpQery = "MATCH (n:Person),(t:Technology) WHERE ";
    		tmpQery += "t.name =" + "\'" + projectName + "\'";
    		tmpQery += " MATCH (n)-[r]->(t) RETURN n.name AS person, r.exp AS experience";
    		StatementResult sr = session.run(tmpQery);
    		while(sr.hasNext()){
    			Node tmpPerson = new Node();
    			Record record = sr.next();
    			try {
					List<Field> listPerson = new ArrayList<Field>();
					Field fieldPerson = new Field();
					fieldPerson.setKey(record.get("person").toString());
					listPerson.add(fieldPerson);
					
					List<Field> listExperience = new ArrayList<Field>();
					Field fieldExp = new Field();
					String exp = record.get("experience").toString();
					if("NULL".equals(exp)){
						exp = exp.replace("NULL","");
						exp += "0";
					}
					fieldExp.setValue(exp);
					listExperience.add(fieldExp);
					
					listPerson.addAll(listExperience);
					tmpPerson.setListFields(listPerson);
					
				} catch (Exception e) {
					System.out.println("Error: "+e.getMessage());
				}
    			list.add(tmpPerson);
    		}
    	}
    	return list;
    }
    // Span detail of Technology : get Project
    
    // Span detail of Project
    
    // get list node
//    public List<Node> getListNode(){
//    	List<Node> listNode = new ArrayList<Node>();
//    	try(Session session = driver.session()){
//    		StatementResult result = session.run("match (n) return  distinct labels(n) AS label, n AS obj");
//    		while(result.hasNext()){
//    			Node tmNode = new Node();
//    			Record record = result.next();
//    			try {
//    				String labelNode = record.get("label").asString();
//    				labelNode = labelNode.replace("[\"","");	
//    				labelNode = labelNode.replace("\"]","");
//    				tmNode.setTypeNode(labelNode);
//					Map<String, Object> tmMap = record.get("obj").asMap();
//                	if (tmMap.get("name") != null){
//                		tmNode.setLabelNode(tmMap.get("name").toString());
//                	}
//                	List<Field> listFields = new ArrayList<Field>();
//                	for(Map.Entry entry:tmMap.entrySet()){
//                		Field tmpField = new Field();
//                		tmpField.setKey(entry.getKey().toString());
//                        tmpField.setValue(entry.getValue().toString());
//                        listFields.add(tmpField);
//                	}
//                	tmNode.setListFields(listFields);
//                } catch (Exception ex) {
//                	System.out.println("Error:"+ex.getMessage());
//                }
//    			listNode.add(tmNode);
//            }
//        }
//        return listNode;
//    }
//    
    public void close()
    {
        // Closing a driver immediately shuts down all open connections.
        driver.close();
    }
}
