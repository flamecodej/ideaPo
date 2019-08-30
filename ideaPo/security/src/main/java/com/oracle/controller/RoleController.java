package com.oracle.controller;

import com.oracle.entity.Roles;
import com.oracle.service.PerService;
import com.oracle.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PerService perService;

    @RequestMapping("/list")
    public String roleList(Model model){
        model.addAttribute("roleList",roleService.list());
        return "/admin/role/list";
    }

    @RequestMapping("/edit")
    public String roleEdit(Model model, Roles roles){
        model.addAttribute("role",this.roleService.selectRolesById(roles.getId()));
        model.addAttribute("perList",this.perService.list());
        model.addAttribute("roleInPer",this.roleService.selectRoleInPer(roles.getId()));
        return "/admin/role/edit";
    }

    @RequestMapping("/saveOrUpdate")
    public String roleSave(Roles roles, Integer[] perIds, RedirectAttributes redirectAttributes){
        if(roles.getId()==null){
            this.roleService.add(roles, perIds);
        }else{
            this.roleService.UpdateRoleInPer(roles,perIds);
        }
        redirectAttributes.addAttribute("editMessage","操作成功");
        return "redirect:/admin/role/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String edit(Integer id){
        this.roleService.deleteRoleById(id);
        return "200";
    }

}
