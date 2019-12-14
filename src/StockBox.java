import java.awt.*;

import comp127graphics.Rectangle;

public class StockBox extends Rectangle {
    public static final Color BOX_COLOR = new Color(122, 67, 106);
    private double centerX;
    private double centerY;
    private Data stock;

    /**
     * a constructor that creates a StockBox
     * @param centerX position x of a StockBox
     * @param centerY position y of a StockBox
     * @param width the width of a Stock
     * @param height the height of a StockBox
     */
    public StockBox(double centerX, double centerY, double width, double height, Data stock) {
        super(centerX, centerY, width, height);
        this.setFillColor(BOX_COLOR);
        this.setFilled(true);
        this.centerX = centerX;
        this.centerY = centerY;
        this.stock = stock;
        setStrokeWidth(Math.rint((width + height) / 40 + 1) * 0.5);
        setActive(false);
    }

    public void setActive(boolean active) {
        setFillColor(active
                ? new Color(0x3ba634)
                : new Color(0xD9D9D9));
    }

    public Data getStock() {
        return stock;
    }
}

