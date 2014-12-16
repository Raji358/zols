/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zols.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zols.templates.domain.PageRequest;
import org.zols.templates.service.PageService;

@Controller
public class CoreController {
    
    @Autowired
    private PageService pageService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/controlpanel")
    @Secured("ROLE_ADMIN")
    public String controlpanel() {
        return "controlpanel";
    }

    @RequestMapping("/links")
    public String links() {
        return "links";
    }

    @RequestMapping("/datastore")
    public String datastore() {
        return "datastore";
    }

    @RequestMapping("/templates")
    public String templates() {
        return "templates";
    }

    @RequestMapping("/pages/{name}")
    public String pages(@PathVariable(value = "name") String name,Model model) {
        PageRequest pageRequest = pageService.readRequest(name);
        model.addAttribute("data", pageRequest.getData());
        return pageRequest.getTemplate().getName();
    }
    
    @RequestMapping("/create_page/{linkName}")
    public String createPage(@PathVariable(value = "linkName") String linkName,Model model) {
        model.addAttribute("linkName", linkName);
        return "create_page";
    }

}
