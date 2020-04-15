package be.vdab.beerhousewithjpa.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Component
@SessionScope
public class Basket implements Serializable {
    public static final long serialVersionUID=1L;
    public final Map<Long, Long> idsAndItems = new LinkedHashMap<>();

public void fillIn(long id, long item){
    idsAndItems.put(id, item);
}

public boolean isFilled(){
    return !idsAndItems.isEmpty();
}

public Set<Long> getKeys(){
    return idsAndItems.keySet();
}

public Long getItem(long id){
    return idsAndItems.get(id);
}

}
