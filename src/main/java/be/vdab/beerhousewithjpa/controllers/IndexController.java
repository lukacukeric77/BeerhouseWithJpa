package be.vdab.beerhousewithjpa.controllers;

import be.vdab.beerhousewithjpa.services.BierService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {

    private final BierService service;

    public IndexController(BierService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index", "index", service.findAantalBieren());
    }
}
