import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsGroup;

import java.util.ArrayList;
import java.util.List;

public class StockBoxManager {
    private GraphicsGroup stockGroup;
    private List<StockBox> stocks = new ArrayList<>();

    /**
     * Constructor which creates a brickGroup graphicsGroup, calls createBricks method
     * to build a wall and adds it to canvas.
     * @param canvas
     */
    StockBoxManager(CanvasWindow canvas) {


        stockGroup = new GraphicsGroup();
        createStockBoxes(canvas);
        canvas.add(stockGroup);
    }

    /**
     * Takes in canvas as a parameter and creates lines of stock boxers.
     * @param canvas
     */
    private void createStockBoxes(CanvasWindow canvas) {
        double margin = canvas.getWidth() * 0.05;
        double spacing = canvas.getWidth() * 0.01;
        double y = canvas.getWidth() * 0.60;
        double x = margin;
        double length = 0;
        for (int i = 0; i < 10; i++) {
            StockBox brick = new StockBox(x, y, canvas.getWidth() * 0.12,
                    canvas.getWidth() * 0.12);
            length = length + brick.getWidth() + spacing;
            if (length < canvas.getWidth() - 8 * margin) {
                x = x + brick.getWidth() + spacing;
            } else {
                x = margin;
                length = 0;
                y = y + spacing + brick.getHeight();

            }
            stockGroup.add(brick);
            stocks.add(brick);
        }
    }
}
