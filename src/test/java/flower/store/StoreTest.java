package flower.store;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filters.PriceFilter;

public class StoreTest {
    private static final int ROSEPRICE = 50;
    private static  final int TULIPPRICE = 50;
    private static final int ROSEQUANTITY = 3;
    private static final int NEWQUANTITY = 4;
    private static final int MAXPRICE = 300;
    private static final int MINPRICE = 60;
    private static final int  EXPECTEDFROMFIRST = 3;
    private static final int NEWLENGTH = 1;

    private Flower rose;
    private Flower tulip;
    private Flower newFlower;


    @BeforeEach
    public void init() {
        rose = new Flower();
        rose.setPrice(ROSEPRICE);
        tulip = new Flower();
        tulip.setPrice(TULIPPRICE);
        newFlower = new Flower(rose);
    }

    @Test
    public void testFilterPrice() {


        FlowerPack pack = new FlowerPack(rose, ROSEQUANTITY);
        Store store = new Store();
        FlowerBucket bucket = new FlowerBucket();
        pack.setQuantity(NEWQUANTITY);
        bucket.addPack(pack);
        store.addItem(bucket);
        store.addItem(tulip);
        store.addItem(newFlower);
        Assertions.assertEquals(EXPECTEDFROMFIRST, store.getNumberOfItems());
        Store newStore = new Store();
        newStore.addItem(bucket);
        newStore.addItem(rose);
        newStore.addItem(tulip);
        List<Item> searchResult = store.search(new PriceFilter(MINPRICE, MAXPRICE));
        Assertions.assertEquals(NEWLENGTH, searchResult.size());
        Assertions.assertEquals(bucket, searchResult.get(0));
    }
}

