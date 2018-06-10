package lviv.iot.ua;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoricalMovieManagerTest {
    private List<HistoricalMovie> staff = new LinkedList<>();
    HistoricalMovie lamp = new Lamp("DualKEE", 12, "CeenOn", "Spring", 150, 25, BrandType.PIONEER);
    HistoricalMovie camera = new Camera("Lowa", "Spring", 1500, 15, BrandType.LG, "2k-pro", "Superpower");
    HistoricalMovie microphone = new Microphone("Ultra", 7, "Rare_sound", "Spring",
            1200, 5, BrandType.REALTEC);
    HistoricalMovieManager historicalMovieManager = new HistoricalMovieManager();

    @BeforeEach
    public void setUp() {

        historicalMovieManager.addGoods(lamp);
        historicalMovieManager.addGoods(camera);
        historicalMovieManager.addGoods(microphone);


    }

    @Test
    public void sortByPrice() {
       List<HistoricalMovie> sortedByPrice = historicalMovieManager.sortByPrice();

        assertEquals(150,sortedByPrice.get(0).getCost());
        assertEquals(1200,sortedByPrice.get(1).getCost());
        assertEquals(1500,sortedByPrice.get(2).getCost());

    }

    @Test
    public void findByGroup() {
       List<HistoricalMovie> result = historicalMovieManager.findByGroup(BrandType.LG);
       assertEquals(1, result.size());
       assertEquals(result.get(0).getBrandType().toString(), "LG");


    }
}

