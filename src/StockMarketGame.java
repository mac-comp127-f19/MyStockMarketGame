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

    public StockMarketGame() {
        this.largeWidgetSize = largeWidgetSize;
        largeWidgets = createWidgets(largeWidgetSize);

        miniWidgetSize = largeWidgetSize / largeWidgets.size();
        miniWidgets = createWidgets(miniWidgetSize);

        canvas = new CanvasWindow(
                "Stock Market Game",
                (int) Math.round(largeWidgetSize + miniWidgetSize),
                (int) Math.round(largeWidgetSize));
        canvas.setBackground(new Color(153, 204, 255));

        selectionHighlight = new Rectangle(0, 0, miniWidgetSize, miniWidgetSize);
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

    //    updateWeather();
    }

    private List<StockWidget> createWidgets(double size) {
        return List.of(
                new MarketIndexWidget(size),
                new MyPortfolio(size));
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
        new StockMarketGame();
    }

}
