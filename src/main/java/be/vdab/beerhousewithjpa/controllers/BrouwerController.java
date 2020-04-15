package be.vdab.beerhousewithjpa.controllers;

import be.vdab.beerhousewithjpa.services.BierService;
import be.vdab.beerhousewithjpa.services.BrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("brouwers")
class BrouwerController {

    private final BrouwerService brouwerService;
    private final BierService bierService;

    public BrouwerController(BrouwerService brouwerService, BierService bierService) {
        this.brouwerService = brouwerService;
        this.bierService = bierService;
    }

    @GetMapping
    public ModelAndView brouwers(){
        return new ModelAndView("brouwers", "brouwers", brouwerService.findAllBrouwers());
    }

    @GetMapping("{id}")
    public ModelAndView beerFinder(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("bieren");
        if(!bierService.findAllBierByBrouwerId(id).isEmpty()){
            modelAndView.addObject("bieren", bierService.findAllBierByBrouwerId(id));
        } else {
            modelAndView.addObject("bieren", null);
        }
        return modelAndView;

    }

}
