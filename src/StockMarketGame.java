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

    public StockMarketGame(double largeWidgetSize) {
        this.largeWidgetSize = largeWidgetSize;
        largeWidgets = createWidgets(largeWidgetSize);

        miniWidgetSize = largeWidgetSize / largeWidgets.size();  // so they stack along one edge
        miniWidgets = createWidgets(miniWidgetSize);

        canvas = new CanvasWindow("Stock Market Game",
                800, 800);
        canvas.setBackground(new Color(255, 253, 208));
        createWidgets(700);

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
        });

        canvas.onClick(event -> {
            if (event.getPosition().getX() >= largeWidgetSize) {
                selectWidgetAtIndex(
                        (int) (event.getPosition().getY() / largeWidgetSize * miniWidgets.size()));
            }
        });

    }

    private List<StockWidget> createWidgets(double size) {
        return List.of(
                new MarketIndexWidget(size, canvas),
                new MyPortfolio(size, canvas));
    }

    private void selectWidgetAtIndex(int index) {
        if (index >= largeWidgets.size() || index < 0) {
            return;
        }

        if (displayedLargeWidget != null) {
            canvas.remove(displayedLargeWidget.getGraphics());
        }

        displayedLargeWidget = largeWidgets.get(index);
        canvas.add(displayedLargeWidget.getGraphics());

        selectionHighlight.setPosition(largeWidgetSize, miniWidgetSize * index);
    }


    public static void main(String[] args){
        new StockMarketGame(600);
    }

}
