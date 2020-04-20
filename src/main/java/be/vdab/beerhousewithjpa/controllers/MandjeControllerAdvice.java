package be.vdab.beerhousewithjpa.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import be.vdab.beerhousewithjpa.sessions.Basket;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MandjeControllerAdvice {

    private final Basket basket;

    public MandjeControllerAdvice(Basket basket) {
        this.basket = basket;
    }

    @ModelAttribute
    void basketAddedToModel(Model model) {
        model.addAttribute(basket);
    }
}
