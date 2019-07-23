package com.ifi.profile.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.ifi.profile.model.Node;
import com.ifi.profile.service.NeoService;
import com.ifi.profile.utils.Constants;

@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		// connect to Neo4j database
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
				
		// list nodes
		List<Node> listNodes = neoService.getListNodes();
		// list label
		List<Node> listLabels = neoService.getLabels();

		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("home");
        modelRet.addObject("lists", listNodes);
        modelRet.addObject("listLabels", listLabels);
		return modelRet;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@Validated Node node) {
				
		// connect to Neo4j database
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		if((!"".equals(node.getTypeNode()))&&(node.getTypeNode()!=null)&&(node.getLabelNode()!=null)&&(!"".equals(node.getLabelNode()))){
			neoService.addNode(node);
		} else {
			System.out.println("error: node empty");
		}
		
		// get list nodes
		List<Node> listNodes = neoService.getListNodes();
		// list label
		List<Node> listLabels = neoService.getLabels();
        neoService.close();
        
        // render view
        ModelAndView modelRet = new ModelAndView("home");
        modelRet.addObject("lists", listNodes);
        modelRet.addObject("listLabels", listLabels);
		return modelRet;
	}
	
	// Search
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		List<Node> lists = neoService.searchNode(node);
		
		neoService.close();
		ModelAndView modelRet = new ModelAndView("search");
		modelRet.addObject("listSearch", lists);
		return modelRet;
	}

	@RequestMapping(value = "/updateNode", method = RequestMethod.POST)
	public ModelAndView updateNode(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		//update data
		if((!"".equals(node.getTypeNode()))&&(node.getTypeNode()!=null)){
			neoService.updateNode(node);
		} else {
			System.out.println("error: node empty");
		}
		
		List<Node> listNodes = neoService.getListNodes();
		// list label
		List<Node> listLabels = neoService.getLabels();
		neoService.close();
		ModelAndView modelRet = new ModelAndView("home");
		modelRet.addObject("lists", listNodes);
		modelRet.addObject("listLabels", listLabels);
		return modelRet;
	}
	
	@RequestMapping(value = "/deleteNode", method = RequestMethod.POST)
	public ModelAndView deleteNode(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		if((!"".equals(node.getTypeNode()))&&(node.getTypeNode()!=null)){
			neoService.deleteNode(node);
		} else {
			System.out.println("error: node empty");
		}
		
		List<Node> listNodes = neoService.getListNodes();
		// list label
		List<Node> listLabels = neoService.getLabels();
		neoService.close();
		ModelAndView modelRet = new ModelAndView("home");
		modelRet.addObject("lists", listNodes);
		modelRet.addObject("listLabels", listLabels);
		return modelRet;
	}
	
	@RequestMapping(value = "/relation", method = RequestMethod.GET)
	public ModelAndView relation(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		neoService.addRelationship(node);
		List<Node> listLabels = neoService.getLabels();
		List<Node> listNode = neoService.getListNodes();
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("home");
		modelRet.addObject("listLabels", listLabels);
		modelRet.addObject("listNode", listNode);
		return modelRet;
	}
	
	@RequestMapping(value = "/searchByRelation", method = RequestMethod.POST)
	public ModelAndView searchByRelation(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		List<Node> lists = neoService.searchByRelationship(node);
		List<Node> listNodes = neoService.getNode(node);
		List<Node> listNode = neoService.getListNodes();
		List<Node> listProject = neoService.advanceSearch(node);
		neoService.close();
		
		
		ModelAndView modelRet = new ModelAndView("searchByRelation");
		modelRet.addObject("lists", lists);
		modelRet.addObject("listNodes", listNodes);
		modelRet.addObject("listNode", listNode);
		modelRet.addObject("listProject", listProject);
		return modelRet;
	}
	
	@RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
	public ModelAndView viewProfile(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		List<Node> listTech = neoService.getInfo(node);
		List<Node> nodeInfo = neoService.searchNode(node);
		List<Node> listProject = neoService.getProject(node);
//		List<Node> listPerson = neoService.getPersons(node);
		List<Node> listExperience = neoService.expTech(node);
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("viewProfile");
		modelRet.addObject("listTech", listTech);
		modelRet.addObject("nodeInfo", nodeInfo);
		modelRet.addObject("listProject", listProject);
//		modelRet.addObject("listPerson", listPerson);
		modelRet.addObject("listExperience", listExperience);
		
		return modelRet;
	}
	
	// redirect from view profile. To search project info by click to project name
	@RequestMapping(value="/projectDetail", method = RequestMethod.GET)
	public ModelAndView projectDetail(HttpServletRequest req){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		String projectName = req.getParameter("projectName");
		List<Node> listPerson = neoService.searchPerson(projectName);
		
		ModelAndView modelRet = new ModelAndView("projectDetail");
		
		modelRet.addObject("listPerson", listPerson); 
		return modelRet;
	}
	
	@RequestMapping(value="/personExperience", method = RequestMethod.GET)
	public ModelAndView personExperience(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		List<Node> personExperience = neoService.expTech(node);
		
		ModelAndView modelRet = new ModelAndView("personExperience");
		
		modelRet.addObject("personExperience", personExperience);
		return modelRet;
	}
	
}
