import java.awt.*;

import com.nizhegorodtsev.Stock;
import comp127graphics.Rectangle;

public class StockBox extends Rectangle {
    public static final Color BOX_COLOR = new Color(50, 120, 23);
    private Stock stockInfo;
    private double centerX;
    private double centerY;

    /**
     * a constructor that creates a StockBox
     * @param centerX position x of a StockBox
     * @param centerY position y of a StockBox
     * @param width the width of a Stock
     * @param height the height of a StockBox
     */
    public StockBox(double centerX, double centerY, double width, double height) {
        super(centerX, centerY, width, height);
        this.setFillColor(BOX_COLOR);
        this.setFilled(true);
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public void setActive(boolean active) {
        setFillColor(active
                ? new Color(0x3ba634)
                : new Color(0xD9D9D9));
    }

}

