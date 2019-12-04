import com.nizhegorodtsev.Stock;
import comp127graphics.*;

import java.util.ArrayList;
import java.util.List;
public class MyPortfolio implements StockWidget{
    private static final double BOX_WIDTH = 20, BOX_HEIGHT = 30, BOX_GAP = 10;
    private double size;
    private GraphicsGroup group;
    private double scaledBoxWidth, scaledBoxHeight, scaledBoxGap;
    private GraphicsGroup boxGroup;
    private GraphicsText date, netWorth, stockName, sharesOwned, profit, loss;
    private List<StockBox> boxes = new ArrayList<>();
    public MyPortfolio(double size) {
        this.size = size;
        this.scaledBoxWidth = BOX_WIDTH * (size / 500.0);
        this.scaledBoxHeight = BOX_HEIGHT * (size / 500.0);
        this.scaledBoxGap = BOX_GAP * (size / 500.0);
        group = new GraphicsGroup();

        date = new GraphicsText();
        date.setFont(FontStyle.BOLD, size * 0.04);
        group.add(date);

        netWorth = new GraphicsText();
        netWorth.setFont(FontStyle.BOLD, size * 0.04);
        group.add(netWorth);

        stockName = new GraphicsText();
        stockName.setFont(FontStyle.BOLD, size * 0.04);
        group.add(stockName);

        sharesOwned = new GraphicsText();
        sharesOwned.setFont(FontStyle.BOLD, size * 0.04);
        group.add(sharesOwned);

        profit = new GraphicsText();
        profit.setFont(FontStyle.BOLD, size * 0.04);
        group.add(profit);

        loss = new GraphicsText();
        loss.setFont(FontStyle.BOLD, size * 0.04);
        group.add(loss);

    }
    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    @Override
    public void update(Stock stock) {
      //  date.setText(stock.getDate());
      //  netWorth.setText(stock.get);
        stockName.setText(stock.getStockExchange());
        sharesOwned.setText("Shares Owned " + stock.getDayHigh().toString());
        profit.setText("Profit  " + stock.getDayLow().toString());
        loss.setText("/ Loss " + stock.getOpen().toString());


        updateLayout();

    }

    private void updateLayout() {
        date.setCenter(size * 0.45, size * 0.1);
        netWorth.setCenter(size * 0.55, size * 0.4);

        stockName.setCenter(size * 0.5, size * 0.45);

       sharesOwned.setCenter(size * 0.45, size * 0.5);
         profit.setCenter(size * 0.50, size * 0.5);
        loss.setCenter(size * 0.55, size * 0.5);

    }

    @Override
    public void onHover(Point position) {

    }



}