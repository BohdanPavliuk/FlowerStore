package filters;

import flower.store.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PriceFilter implements SearchFilter {
    private double minPrice = 0;
    private double maxPrice = 0;

    public PriceFilter(double minPrice, double maxPrice){
        if (minPrice > maxPrice){
            double temp = minPrice;
            minPrice = maxPrice;
            maxPrice = temp;
        }
        if (minPrice < 0){
            this.minPrice = 0;
        }
        else{
            this.minPrice = minPrice;
        }
        if (maxPrice < 0){
            this.maxPrice = 0;
        }
        else{
            this.maxPrice = maxPrice;
        }

    }

    public boolean match(Item item){
        double price = item.getPrice();
        if (maxPrice >= price && price >= minPrice){
            return true;
        }
        return false;
    }
}
