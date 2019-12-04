import comp127graphics.CanvasWindow;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.List;

public class StockMarketGame {
    private CanvasWindow canvas;
    private StockWidget marketIndexWidget;

//    private double miniWidgetSize, largeWidgetSize;
//    private List<WeatherWidget> miniWidgets, largeWidgets;
//    private WeatherWidget displayedLargeWidget;
//    private Rectangle selectionHighlight;

    public StockMarketGame() {
        canvas = new CanvasWindow("Stock Market Game",
                800, 800);
        canvas.setBackground(new Color(88, 180, 214));
        createWidgets(700);
        new StockBoxManager(canvas);
    }

    private List<StockWidget> createWidgets(double size) {
        return List.of(
                new MarketIndexWidget(size));
    }

    public static void main(String[] args){
        new StockMarketGame();
    }

}
