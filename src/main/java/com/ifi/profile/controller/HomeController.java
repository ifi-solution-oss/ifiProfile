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
	
	@RequestMapping(value= "/home")
	public String redirect(){
		return "redirect:home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		// connect to Neo4j database
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
				
		// list nodes
		List<Node> listPersons = neoService.getListPerson();
		List<Node> listProjects = neoService.getListProjects();
		List<Node> listTechs = neoService.getListTechs();
		// list label
		List<Node> listLabels = neoService.getLabels();
		// list node for search function
		List<Node> listNodeForSearch = neoService.autocompleSearch();
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("home");
		// list nodes
        modelRet.addObject("listPersons", listPersons);
        modelRet.addObject("listProjects", listProjects);
        modelRet.addObject("listTechs", listTechs);
        // list label
        modelRet.addObject("listLabels", listLabels);
        // list node for search function
        modelRet.addObject("listNodeForSearch", listNodeForSearch);
		return modelRet;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@Validated Node node) {
				
		// connect to Neo4j database
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		if((!"".equals(node.getTypeNode()))&&(node.getTypeNode()!=null)){
			neoService.addNode(node);
		} else {
			System.out.println("error: node empty");
		}
		
		// get list nodes
		List<Node> listPersons = neoService.getListPerson();
		List<Node> listProjects = neoService.getListProjects();
		List<Node> listTechs = neoService.getListTechs();
		// list label
		List<Node> listLabels = neoService.getLabels();
		// list node for search function
		List<Node> listNodeForSearch = neoService.autocompleSearch();
        neoService.close();
        
        // render view
        ModelAndView modelRet = new ModelAndView("home");
     // list nodes
        modelRet.addObject("listPersons", listPersons);
        modelRet.addObject("listProjects", listProjects);
        modelRet.addObject("listTechs", listTechs);
        // list label
        modelRet.addObject("listLabels", listLabels);
        // list node for search function
        modelRet.addObject("listNodeForSearch", listNodeForSearch);
		return modelRet;
	}
	
	// Search
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(HttpServletRequest req){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		String nameNode = req.getParameter("nameNode");
		List<Node> lists = neoService.searchNode(nameNode);
		// list node for search function
		List<Node> listNodeForSearch = neoService.autocompleSearch();
		// list label
		List<Node> listLabels = neoService.getLabels();
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("search");
		modelRet.addObject("listSearch", lists);
		modelRet.addObject("listNodeForSearch", listNodeForSearch);
        // list label
        modelRet.addObject("listLabels", listLabels);
		return modelRet;
	}
	
	// Advance search: View detail
	@RequestMapping(value = "/nodeDetail", method = RequestMethod.GET)
	public ModelAndView viewDetail(HttpServletRequest req){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		String nameNode = req.getParameter("nameNode");
		List<Node> lists = neoService.getNode(nameNode);
		// Technology detail
		List<Node> listDetailTechPerson = neoService.techDetail(nameNode);
		List<Node> listDetailTechProject = neoService.techDetailProjetInfo(nameNode);
		// Project detail
		List<Node> listDetailProjectPerson = neoService.projectDetailPerson(nameNode);
		List<Node> listDetailProjectTech = neoService.projectDetailTech(nameNode);
		// Person detail
		List<Node> listTech = neoService.getInfo(nameNode);
		List<Node> listProject = neoService.getProject(nameNode);
		// list node for search function
		List<Node> listNodeForSearch = neoService.autocompleSearch();
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("search");
		modelRet.addObject("node", lists);
		// tech detail
		modelRet.addObject("listDetailTechPerson", listDetailTechPerson);
		modelRet.addObject("listDetailTechProject", listDetailTechProject);
		// project detail
		modelRet.addObject("listDetailProjectPerson", listDetailProjectPerson);
		modelRet.addObject("listDetailProjectTech", listDetailProjectTech);
		// person detail
		modelRet.addObject("listTech", listTech);
		modelRet.addObject("listProject", listProject);
		// list node for search function
        modelRet.addObject("listNodeForSearch", listNodeForSearch);
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
		
		// get list nodes
		List<Node> listPersons = neoService.getListPerson();
		List<Node> listProjects = neoService.getListProjects();
		List<Node> listTechs = neoService.getListTechs();
		// list label
		List<Node> listLabels = neoService.getLabels();
		// list node for search function
		List<Node> listNodeForSearch = neoService.autocompleSearch();
		
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("home");
		// list nodes
        modelRet.addObject("listPersons", listPersons);
        modelRet.addObject("listProjects", listProjects);
        modelRet.addObject("listTechs", listTechs);
        // list label
        modelRet.addObject("listLabels", listLabels);
        // list node for search function
        modelRet.addObject("listNodeForSearch", listNodeForSearch);
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
		
		// get list nodes
		List<Node> listPersons = neoService.getListPerson();
		List<Node> listProjects = neoService.getListProjects();
		List<Node> listTechs = neoService.getListTechs();
		// list label
		List<Node> listLabels = neoService.getLabels();
		// list node for search function
		List<Node> listNodeForSearch = neoService.autocompleSearch();
		neoService.close();
		ModelAndView modelRet = new ModelAndView("home");
		// list nodes
        modelRet.addObject("listPersons", listPersons);
        modelRet.addObject("listProjects", listProjects);
        modelRet.addObject("listTechs", listTechs);
        // list label
        modelRet.addObject("listLabels", listLabels);
        // list node for search function
        modelRet.addObject("listNodeForSearch", listNodeForSearch);
		return modelRet;
	}
	
	@RequestMapping(value = "/relation", method = RequestMethod.POST)
	public ModelAndView relation(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		neoService.addRelationship(node);
		List<Node> listLabels = neoService.getLabels();
		// get list nodes
		List<Node> listPersons = neoService.getListPerson();
		List<Node> listProjects = neoService.getListProjects();
		List<Node> listTechs = neoService.getListTechs();
		// list node for search function
		List<Node> listNodeForSearch = neoService.autocompleSearch();
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("home");
		modelRet.addObject("listLabels", listLabels);
		// list nodes
        modelRet.addObject("listPersons", listPersons);
        modelRet.addObject("listProjects", listProjects);
        modelRet.addObject("listTechs", listTechs);
        // list node for search function
        modelRet.addObject("listNodeForSearch", listNodeForSearch);
		return modelRet;
	}
	
	@RequestMapping(value = "/searchByRelation", method = RequestMethod.POST)
	public ModelAndView searchByRelation(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		List<Node> lists = neoService.searchByRelationship(node);
		List<Node> listNodes = neoService.getNode(node);
		List<Node> listProject = neoService.advanceSearch(node);
		neoService.close();
		
		
		ModelAndView modelRet = new ModelAndView("searchByRelation");
		modelRet.addObject("lists", lists);
		modelRet.addObject("listNodes", listNodes);
		modelRet.addObject("listProject", listProject);
		return modelRet;
	}
	
	@RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
	public ModelAndView viewProfile(@Validated Node node, HttpServletRequest req){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		// use servlet to pass data from front end
		String nameNode = req.getParameter("nameNode");
		List<Node> nodeInfo = neoService.getNode(nameNode);
		//get Person detail
		List<Node> listTech = neoService.getInfo(nameNode);
		List<Node> listProject = neoService.getProject(nameNode);
		// get Technology detail
		
		// get Project detail
		
		// list node for search function
		List<Node> listNodeForSearch = neoService.autocompleSearch();
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("viewProfile");
		modelRet.addObject("listTech", listTech);
		modelRet.addObject("nodeInfo", nodeInfo);
		modelRet.addObject("listProject", listProject);
		// list node for search function
        modelRet.addObject("listNodeForSearch", listNodeForSearch);
		return modelRet;
	}
	
	// redirect from view profile. To search project info by click to project name
	@RequestMapping(value="/projectDetail", method = RequestMethod.GET)
	public ModelAndView projectDetail(HttpServletRequest req){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		// use servlet to pass data from front end
		String projectName = req.getParameter("projectName");
		List<Node> listPerson = neoService.searchPerson(projectName);
		
		ModelAndView modelRet = new ModelAndView("projectDetail");
		
		modelRet.addObject("listPerson", listPerson); 
		return modelRet;
	}
	
	@RequestMapping(value="/personExperience", method = RequestMethod.GET)
	public ModelAndView personExperience(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		List<Node> personExperience = neoService.searchPersonExp(node);
	
		ModelAndView modelRet = new ModelAndView("personExperience");

		modelRet.addObject("personExperience", personExperience);
		return modelRet;
	}
	
}
