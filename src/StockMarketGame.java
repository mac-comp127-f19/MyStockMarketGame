import comp127graphics.CanvasWindow;
import comp127graphics.Rectangle;

import java.awt.*;
import java.util.List;

public class StockMarketGame {
    private CanvasWindow canvas;

    public StockMarketGame() {
        canvas = new CanvasWindow("Stock Market Game",
                800, 800);
        canvas.setBackground(new Color(88, 180, 214));
        new StockBoxManager(canvas);
    }

    public static void main(String[] args){
        new StockMarketGame();
    }

}
