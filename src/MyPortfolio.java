import comp127graphics.*;

import java.util.ArrayList;
import java.util.List;
public class MyPortfolio implements StockWidget{
    private static final double BOX_WIDTH = 20, BOX_HEIGHT = 30, BOX_GAP = 10;
    private double size;
    private GraphicsGroup group;
    private double scaledBoxWidth, scaledBoxHeight, scaledBoxGap;
    private GraphicsGroup boxGroup;
    private GraphicsText date, netWorth, stockName, sharesOwned, profit, loss, ticker;
    private List<StockBox> boxes = new ArrayList<>();

    public MyPortfolio(double size) {
        this.size = size;
        this.scaledBoxWidth = BOX_WIDTH * (size / 500.0);
        this.scaledBoxHeight = BOX_HEIGHT * (size / 500.0);
        this.scaledBoxGap = BOX_GAP * (size / 500.0);
        group = new GraphicsGroup();

        date = new GraphicsText();
        date.setFont(FontStyle.BOLD, size * 0.02);
        group.add(date);

        ticker = new GraphicsText();
        ticker.setFont(FontStyle.PLAIN, size * 0.02);
        group.add(ticker);

        netWorth = new GraphicsText();
        netWorth.setFont(FontStyle.BOLD, size * 0.02);
        group.add(netWorth);

        stockName = new GraphicsText();
        stockName.setFont(FontStyle.BOLD, size * 0.02);
        group.add(stockName);

        sharesOwned = new GraphicsText();
        sharesOwned.setFont(FontStyle.BOLD, size * 0.02);
        group.add(sharesOwned);

        profit = new GraphicsText();
        profit.setFont(FontStyle.BOLD, size * 0.02);
        group.add(profit);

        loss = new GraphicsText();
        loss.setFont(FontStyle.BOLD, size * 0.02);
        group.add(loss);


        new StockBoxManager(size);
//        canvas.add(group);

        update();

    }
    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    @Override
    public void update() {
        date.setText("Date ");
        netWorth.setText("Net Worth");
        stockName.setText("Stock Symbol");
        sharesOwned.setText("Number of Shares Owned ");
        profit.setText("Total Profit ");
        loss.setText("Total Loss ");

        updateLayout();

    }

    private void updateLayout() {
        date.setCenter(size * 0.1, size * 0.05);
        netWorth.setCenter(size * 0.9, size * 0.05);
        stockName.setCenter(size * 0.5, size * 0.15);
        sharesOwned.setCenter(size * 0.5, size * 0.25);
        profit.setCenter(size * 0.5, size * 0.45);
        loss.setCenter(size * 0.5, size * 0.55);
    }

    @Override
    public void onHover(Point position) {

    }

    @Override
    public void setActive(boolean b) {

    }


    @Override
    public String toString() {
        return "MyPortfolio{" +
                "size=" + size +
                ", group=" + group +
                ", scaledBoxWidth=" + scaledBoxWidth +
                ", scaledBoxHeight=" + scaledBoxHeight +
                ", scaledBoxGap=" + scaledBoxGap +
                ", boxGroup=" + boxGroup +
                ", date=" + date +
                ", netWorth=" + netWorth +
                ", stockName=" + stockName +
                ", sharesOwned=" + sharesOwned +
                ", profit=" + profit +
                ", loss=" + loss +
                ", ticker=" + ticker +
                ", boxes=" + boxes +
                '}';
    }
}