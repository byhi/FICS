package com.byhi.fics.controller;

import com.byhi.fics.domain.Modul;
import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.service.ModulService;
import com.byhi.fics.service.ModulServiceImpl;
import com.byhi.fics.service.RendszerService;
import com.byhi.fics.service.RendszerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class HomeController implements WebMvcConfigurer {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    private RendszerService rendszerService;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
    @Autowired
    public void setRendszerService(RendszerServiceImpl rendszerServiceImpl) {
        this.rendszerService = rendszerServiceImpl;
    }

    private ModulService modulService;

    @Autowired
    public void setModulService(ModulServiceImpl modulServiceImpl) {
        this.modulService = modulServiceImpl;
    }


    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("rendszerek", this.rendszerService.getAllSystemUnit ());
        logger.info("Welcome in home");
        return "index";
    }

    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }

    @GetMapping("/add-new-modul")
    public String addNewSystemWithModul(Model model) {
        model.addAttribute("allsystemname",  this.rendszerService.getAllRendszerNev());
        model.addAttribute("modul",  new Modul("",""));
        logger.info("shortenerForm");
        return "add-new-modul";
    }

    @PostMapping(path = "/add-new-modul")
    public String redirecAddNeúwSystemWithNewModul(@ModelAttribute @Valid  Modul modul, Model model,
                                                         BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            logger.error(bindingResult.toString());
            return "error";
        }
        this.rendszerService.save(modul);
        return "redirect:/";
    }

    @RequestMapping(value={"/add-new-system"})
    public String addNewSystemWithNewModul(Model model) {
        model.addAttribute("newsystem",  new Rendszer("",""));
        logger.info("shortenerForm");
        return "add-new-system";
    }
    //Edit
    @PostMapping(path = "/add-new-system")
    public String redirecAddNewSystemWithNewModul(@ModelAttribute @Valid  Rendszer rendszer, Model model,
                                                  BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            logger.error(bindingResult.toString());
            return "error";
        }
        this.rendszerService.saveRendszer(rendszer);
        return "redirect:/";
    }

    @GetMapping("/edit-data/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("systemmodul",  this.modulService.getModulByID(id));
        logger.info("shortenerForm");
        return "edit-data";
    }

    @PostMapping(path = "/edit-data")
    public String redirectEdit(@ModelAttribute @Valid  Modul modul, Model model,
                                    BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            logger.error(bindingResult.toString());
            return "error";
        }
        this.rendszerService.save(modul);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttrs) {

        redirectAttrs.addAttribute("msg", "");
        this.modulService.deleteModul(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/{msg}");
        return redirectView;
    }

    @GetMapping("error/")
    public String errorPage() {
        return "error";
    }
}
