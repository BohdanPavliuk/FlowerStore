package flower.store;

import java.util.ArrayList;
import java.util.List;

import filters.SearchFilter;

public class Store {
    private final List<Item> items = new ArrayList<>(); 

    public List<Item> search(SearchFilter filter) {
        List<Item> found = new ArrayList<>();
        
        for (Item item: items){
            if (filter.match(item)) {
                found.add(item);
            }
        }
        return found;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public int getNumberOfItems() {
        return this.items.size();
    }
}
