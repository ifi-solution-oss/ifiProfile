package com.ifi.profile.controller;

import java.util.List;

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

		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("home");
        modelRet.addObject("lists", listNodes);

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
		
        neoService.close();
        
        // render view
        ModelAndView modelRet = new ModelAndView("home");
        modelRet.addObject("lists", listNodes);
		return modelRet;
	}
	
	// Search
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		List<Node> lists = neoService.searchNode(node.getLabelNode());
		
		neoService.close();
		ModelAndView modelRet = new ModelAndView("search");
		modelRet.addObject("listSearch", lists);
		return modelRet;
	}

	@RequestMapping(value = "/updateNode", method = RequestMethod.POST)
	public ModelAndView updateNode(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		//update data
		if((!"".equals(node.getTypeNode()))&&(node.getTypeNode()!=null)&&(node.getLabelNode()!=null)&&(!"".equals(node.getLabelNode()))){
			neoService.updateNode(node);
		} else {
			System.out.println("error: node empty");
		}
		
		List<Node> listNodes = neoService.getListNodes();
		neoService.close();
		ModelAndView modelRet = new ModelAndView("home");
		modelRet.addObject("lists", listNodes);
		return modelRet;
	}
	
	@RequestMapping(value = "/deleteNode", method = RequestMethod.GET)
	public ModelAndView deleteNode(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		if((!"".equals(node.getTypeNode()))&&(node.getTypeNode()!=null)&&(node.getLabelNode()!=null)&&(!"".equals(node.getLabelNode()))){
			neoService.deleteNode(node);
		} else {
			System.out.println("error: node empty");
		}
		
		List<Node> listNodes = neoService.getListNodes();
		neoService.close();
		ModelAndView modelRet = new ModelAndView("home");
		modelRet.addObject("lists", listNodes);
		return modelRet;
	}
	
	@RequestMapping(value = "/relation", method = RequestMethod.GET)
	public ModelAndView relation(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		neoService.addRelationship(node);
		neoService.close();
		
		ModelAndView modelRet = new ModelAndView("home");
		
		return modelRet;
	}
	
	@RequestMapping(value = "/searchByRelation", method = RequestMethod.POST)
	public ModelAndView searchByRelation(@Validated Node node){
		NeoService neoService = new NeoService(Constants.URL_IFI, Constants.USER_IFI, Constants.PASS_IFI);
		
		List<Node> lists = neoService.searchByRelationship(node);
		List<Node> listNode = neoService.getListNodes();
		neoService.close();
		
		
		ModelAndView modelRet = new ModelAndView("searchByRelation");
		modelRet.addObject("lists", lists);
		modelRet.addObject("listNode", listNode);
		return modelRet;
	}
	
}
