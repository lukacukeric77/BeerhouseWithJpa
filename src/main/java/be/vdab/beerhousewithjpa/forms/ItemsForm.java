package be.vdab.beerhousewithjpa.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ItemsForm {

    @NotNull @Positive
    private final Long items;

    public ItemsForm(Long items) {
        this.items = items;
    }

    public Long getItems() {
        return items;
    }

}
