import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.ui.Button;

import java.util.ArrayList;
import java.util.List;

public class MarketIndexWidget implements StockWidget {
    private final double size;
    private GraphicsGroup group;

    private GraphicsGroup boxGroup;

    private List<StockBox> boxes = new ArrayList<>();

    private GraphicsText moneyAvailable;
    private GraphicsText ticker;
    private GraphicsText name;
    private GraphicsText currPrice;

    private GraphicsText peRatio;
    private GraphicsText eps;
    private GraphicsText divYield;
    private GraphicsText marketCap;


    @Override
    public String toString() {
        return "MarketIndexWidget{" +
                "size=" + size +
                ", group=" + group +
                ", boxGroup=" + boxGroup +
                ", boxes=" + boxes +
                ", moneyAvailable=" + moneyAvailable +
                ", ticker=" + ticker +
                ", name=" + name +
                ", currPrice=" + currPrice +
                ", peRatio=" + peRatio +
                ", eps=" + eps +
                ", divYield=" + divYield +
                ", marketCap=" + marketCap +
                '}';
    }

    public MarketIndexWidget(double size, CanvasWindow canvas) {
        this.size = size;

        group = new GraphicsGroup();

        name = new GraphicsText();
        name.setFont(FontStyle.BOLD, size * 0.03);
        group.add(name);

        ticker = new GraphicsText();
        ticker.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(ticker);

        currPrice = new GraphicsText();
        currPrice.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(currPrice);

        peRatio = new GraphicsText();
        peRatio.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(peRatio);

        eps = new GraphicsText();
        eps.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(eps);

        divYield = new GraphicsText();
        divYield.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(divYield);

        marketCap = new GraphicsText();
        marketCap.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(marketCap);

        moneyAvailable = new GraphicsText();
        moneyAvailable.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(moneyAvailable);

        Button buyButton = new Button("Buy Stock");
        buyButton.setPosition(size * 0.15, size * 0.15);
        group.add(buyButton);

        Button sellButton = new Button("Sell Stock");
        sellButton.setPosition(size * 0.65, size * 0.15);
        group.add(sellButton);

        Button advanceTime = new Button("Next Quarter");
        advanceTime.setPosition(size * 0.65, size * 0.05);
        group.add(advanceTime);

        group.add(new StockBoxManager(canvas).getStockGroup());


        update();

    }

    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    @Override
    public void update() {
        name.setText("Stock Name");
        ticker.setText("Stock Symbol");
        currPrice.setText("Stock Price");
        peRatio.setText("P/E Ratio ");
        eps.setText("EPS ");
        divYield.setText("Div Yield ");
        marketCap.setText("Market Cap (In Bln)");
        moneyAvailable.setText("Cash: ");
        updateLayout();
    }

    private void updateLayout() {
        name.setCenter(size * 0.47, size * 0.15);
        ticker.setCenter(size * 0.5, size * 0.2);
        moneyAvailable.setCenter(size * 0.05, size*0.05);
        currPrice.setCenter(size * 0.5, size * 0.25);

        peRatio.setCenter(size * 0.2, size * 0.45);
        eps.setCenter(size * 0.2, size * 0.55);
        divYield.setCenter(size * 0.6, size * 0.45);
        marketCap.setCenter(size * 0.6, size * 0.55);
    }


//    private StockBox getBoxAt(Point location) {
//        GraphicsObject obj = group.getElementAt(location);
//        if (obj instanceof StockBox) {
//            return (StockBox) obj;
//        }
//        return null;
//    }
//

        @Override
        public void onHover (Point position){
        }
    }