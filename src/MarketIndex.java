import com.nizhegorodtsev.Stock;
import comp127graphics.Rectangle;

import java.awt.*;

public class MarketIndex extends Rectangle {
    private Stock stockInfo;

    public MarketIndex(Stock stockInfo, double x, double y, double width, double height) {
        super(x, y, width, height);
        this.stockInfo = stockInfo;
        setStrokeWidth(Math.rint((width + height) / 40 + 1) * 0.5);
//        setActive(false);
    }


}