package com.oracle.controller;

import com.oracle.entity.Admins;
import com.oracle.service.AdminService;
import com.oracle.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/manager")
public class ManagerController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Admins> al=this.adminService.getList();
        model.addAttribute("adminList",al);
        return "/admin/manager/list";
    }

    @RequestMapping("/addView")
    public String addView(Model model){
        model.addAttribute("roleList",this.roleService.list());
        return "/admin/manager/edit";
    }

    @RequestMapping("/edit")
    public String edit(Integer id,Model model){
        Admins admin=this.adminService.selectAdminById(id);
        model.addAttribute("admin",admin);
        model.addAttribute("roleList",this.roleService.list());
        return "/admin/manager/edit";
    }

    @RequestMapping("/saveOrUpdate")
    public String save(Admins admin, RedirectAttributes redirectAttributes){
        boolean result=false;
        if (!(admin.getId()==null)){
            //  调用修改方法
            result=this.adminService.updateById(admin);
        }else {
            // 添加
            result=this.adminService.add(admin);
        }
        if (result){
            redirectAttributes.addAttribute("editMessage","操作成功");
        }else{
            redirectAttributes.addAttribute("editMessage","操作失败");
        }
        return "redirect:/admin/manager/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String edit(Integer id){
        this.adminService.deleteAdminById(id);
        return "200";
    }
}
