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
        for (int i = 0; i < 2; i++) {
            StockBox stockBox = new StockBox(x, y, size * 0.03, size * 0.04);
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
     * Given a position in the widget, this returns the ForecastBox at that position if one exists
     *
     * @param location pos to check
     * @return null if not over a forecast box
     */
    private StockBox getBoxAt(Point location) {
        GraphicsObject obj = stockGroup.getElementAt(location);
        if (obj instanceof StockBox) {
            return (StockBox) obj;
        }
        return null;
    }

    /**
     * Updates the currently displayed forecast information as the mouse moves over the widget.
     * If there is not a ForecastBox at that position, the display does not change.
     */
//    @Override
//    public void onHover(Point position) {
//        StockBox selectBox = getBoxAt(position);
//        if (selectBox == null) return;
//        selectForecast(selectBox);
//
//    }


}

