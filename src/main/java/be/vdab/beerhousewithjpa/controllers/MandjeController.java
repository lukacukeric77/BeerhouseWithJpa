package be.vdab.beerhousewithjpa.controllers;

import be.vdab.beerhousewithjpa.domain.Adres;
import be.vdab.beerhousewithjpa.domain.Bestelbon;
import be.vdab.beerhousewithjpa.domain.Bestelbonlijn;
import be.vdab.beerhousewithjpa.domain.Bier;
import be.vdab.beerhousewithjpa.services.BestelbonService;
import be.vdab.beerhousewithjpa.services.BierService;
import be.vdab.beerhousewithjpa.sessions.Basket;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("mandje")
class MandjeController {

    private final Basket basket;
    private final BierService bierService;
    private final BestelbonService bestelbonService;
    private Set<Bestelbonlijn> bestelbonlijnSet;


    public MandjeController(Basket basket, BierService bierService, BestelbonService bestelbonService) {
        this.basket = basket;
        this.bierService = bierService;
        this.bestelbonService = bestelbonService;
    }

    @GetMapping
    public ModelAndView defaultView() {
        ModelAndView modelAndView = showingBasketDetails();
        modelAndView.addObject(new Bestelbon("", new Adres("", "", 0, "")));
        return modelAndView;
    }


    @PostMapping("/form")
    public ModelAndView creationOfBestelbonAndBestelbonlijn(@Valid Bestelbon bestelbon,
                                                            BindingResult bindingResult,
                                                            Errors errors,
                                                            HttpSession session,
                                                            RedirectAttributes attributes){

        if (errors.hasErrors()){
            return showingBasketDetails();
        }

        if (basket.isFilled()){
            for (Bestelbonlijn bestelbonlijn : bestelbonlijnSet){
            bestelbon.addBestelbonlijn(bestelbonlijn);
            bierService.addToBesteld(bestelbonlijn.getBier().getId(), bestelbonlijn.getAantal());
            }
            bestelbonService.create(bestelbon);
            attributes.addAttribute("bestelbonID", bestelbon.getId());
            session.invalidate();
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("redirect:/");
    }

    @InitBinder("bestelbon")
    void initBinder (DataBinder binder){
        binder.initDirectFieldAccess();
    }

    private ModelAndView showingBasketDetails(){
        ModelAndView modelAndView = new ModelAndView("mandje");
        Set<Long> keysThatAreBierIds = basket.getKeys();
        Map<Bier, Long> biersWithItems = new LinkedHashMap<>();
        Set<Bestelbonlijn> workingSetBestelbonlijn = new LinkedHashSet<>();
        for (Long key : keysThatAreBierIds) {
            Optional<Bier> optionalBier = bierService.findById(key);
            optionalBier.ifPresent(bier -> {
                        biersWithItems.put(bier, basket.getItem(key));
                        workingSetBestelbonlijn.add(new Bestelbonlijn(bier, basket.getItem(key), bier.getPrijs()));
                        bestelbonlijnSet= new HashSet<>(workingSetBestelbonlijn);
                    });
        }
        modelAndView.addObject("biersWithItems", biersWithItems);
        return modelAndView;
    }

}
