package be.vdab.beerhousewithjpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("mandje")
class MandjeController {

    @GetMapping
    public ModelAndView showBasket(){
        ModelAndView modelAndView = new ModelAndView("mandje");
        return modelAndView;
    }

}
