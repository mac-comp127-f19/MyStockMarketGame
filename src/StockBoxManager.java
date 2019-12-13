import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.Point;

import java.util.ArrayList;
import java.util.List;

public class StockBoxManager {
    final private double size;
    private GraphicsGroup stockGroup;
    private List<StockBox> stocks = new ArrayList<>();


    /**
     * Constructor which creates a brickGroup graphicsGroup, calls createBricks method
     * to build a wall and adds it to canvas.
     *
     */
    StockBoxManager(double size) {
        this.size = size;
        stockGroup = new GraphicsGroup();
        createStockBoxes();
//        canvas.add(stockGroup);

    }

    /**
     * Takes in canvas as a parameter and creates lines of stock boxers.
     *
     */
    private void createStockBoxes() {
        double margin = size * 0.05;
        double spacing = size * 0.01;
        double y = size * 0.85;
        double x = margin;
        double length = 0;
        for (int i = 0; i < 10; i++) {
            StockBox stockBox = new StockBox(x, y, size * 0.05, size * 0.05);
            length = length + stockBox.getWidth() + spacing;
            if (length < size - 2 * margin) {
                x = x + stockBox.getWidth() + spacing;
            } else {
                x = margin;
                length = 0;
                y = y + spacing + stockBox.getHeight();
            }
            stockGroup.add(stockBox);
            stocks.add(stockBox);
        }
    }

    private void assignStockBoxValues() {

    }

    public GraphicsGroup getStockGroup() {
        return stockGroup;
    }


    /**
     * Updates the currently displayed forecast information as the mouse moves over the widget.
     * If there is not a ForecastBox at that position, the display does not change.
     */


}

