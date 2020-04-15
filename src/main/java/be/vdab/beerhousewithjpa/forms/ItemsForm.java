package be.vdab.beerhousewithjpa.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemsForm {

    private final Long items;

    public ItemsForm(Long items) {
        this.items = items;
    }

    @NotNull @Positive
    public Long getItems() {
        return items;
    }

}
