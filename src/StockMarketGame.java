import comp127graphics.CanvasWindow;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.List;

public class StockMarketGame {
    private CanvasWindow canvas;

    private double miniWidgetSize, largeWidgetSize;
    private List<StockWidget> miniWidgets, largeWidgets;
    private StockWidget displayedLargeWidget;
    private Rectangle selectionHighlight;

    /**
     * Opens a window and displays the MyStockMarketGame UI
     * @param largeWidgetSize The height and width of the large widget. The window size is derived
     *
     *                   from this value combined with the number of widget choices.
     */
    public StockMarketGame(double largeWidgetSize) {
        this.largeWidgetSize = largeWidgetSize;
        // !!!2 is the number of largeWidgets!!!
        miniWidgetSize = largeWidgetSize / 2;
        canvas = new CanvasWindow(
                "The Wolf of Wall Street",
                (int) Math.round(largeWidgetSize + miniWidgetSize),
                (int) Math.round(largeWidgetSize));
        canvas.setBackground(new Color(255, 253, 155));

        largeWidgets = createWidgets(largeWidgetSize);
        miniWidgets = createWidgets(miniWidgetSize);


        selectionHighlight = new Rectangle(0, 0, miniWidgetSize, miniWidgetSize);  // selectWidgetAtIndex() will position it
        selectionHighlight.setStroked(false);
        selectionHighlight.setFillColor(new Color(0x7FFFFFFF, true));
        canvas.add(selectionHighlight);

        double y = 0;
        for (StockWidget widget : miniWidgets) {
            canvas.add(widget.getGraphics(), largeWidgetSize, y);
            y += miniWidgetSize;
        }
        selectWidgetAtIndex(0);

        canvas.onMouseMove(event -> {
            if (displayedLargeWidget != null && event.getPosition().getX() < largeWidgetSize) {
                displayedLargeWidget.onHover(event.getPosition());
            }
//            if(displayedLargeWidget!=largeWidgets.get(0)) {
//                largeWidgets.get(0).;
//            }

        });

        canvas.onClick(event -> {
            if (event.getPosition().getX() >= largeWidgetSize) {
                selectWidgetAtIndex(
                        (int) (event.getPosition().getY() / largeWidgetSize * miniWidgets.size()));
            }
        });
    }


    /**
     * A method that creates widgets
     * @param size the size of a widget to be created
     * @return
     */
    private List<StockWidget> createWidgets(double size) {
        return List.of(
                new MarketIndexWidget(size, false)
                );
    }


    /**
     * Checks if selected widget is within the bounds of canvas and checks the displayed widget for null.
     *                 If passed, adds the displayed widget to canvas.
     * @param index a variable that is used for comparison with a widget's size in order to tet whether
     *              a widget is out of bounds
     */
    private void selectWidgetAtIndex(int index) {
        if (index >= largeWidgets.size() || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        if (displayedLargeWidget != null) {
            canvas.remove(displayedLargeWidget.getGraphics());
            createWidgets(largeWidgetSize).get(0).update();
            displayedLargeWidget.setActive(false);
        }
        displayedLargeWidget = largeWidgets.get(index);
        displayedLargeWidget.setActive(true);
        canvas.add(displayedLargeWidget.getGraphics());

        selectionHighlight.setPosition(largeWidgetSize, miniWidgetSize * index);
    }

    public static void main(String[] args){
        new StockMarketGame(600);
    }

}