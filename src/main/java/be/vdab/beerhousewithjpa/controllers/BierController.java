package be.vdab.beerhousewithjpa.controllers;

import be.vdab.beerhousewithjpa.domain.Bier;
import be.vdab.beerhousewithjpa.forms.ItemsForm;
import be.vdab.beerhousewithjpa.services.BierService;
import be.vdab.beerhousewithjpa.sessions.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("bier")
class BierController {

    public final BierService bierService;
    private long mandjeIdOfBier;
    private final Basket basket;

    public BierController(BierService bierService, Basket basket) {
        this.bierService = bierService;
        this.basket = basket;
    }

    @GetMapping("{bierid}")
    public ModelAndView detailsOfBiers(@PathVariable long bierid) {
        mandjeIdOfBier = bierid;
        ModelAndView modelAndView = bierExtraction(bierid);
        modelAndView.addObject(new ItemsForm(null));
        return modelAndView;
    }

    @PostMapping("/form/{bierid}")
    public ModelAndView fillingTheBasket(@Valid ItemsForm itemsForm, Errors errors, @PathVariable long bierid) {
        if (errors.hasErrors()) {
            return bierExtraction(bierid);
        }
        basket.fillIn(mandjeIdOfBier, itemsForm.getItems());
        return new ModelAndView("redirect:/mandje");
    }

    private ModelAndView bierExtraction(long bierid){
        ModelAndView modelAndView = new ModelAndView("bier");
        Optional<Bier> optionalBier = bierService.findById(bierid);
        optionalBier.ifPresent(bier -> modelAndView.addObject("bier", bier));
        return modelAndView;
    }

}


