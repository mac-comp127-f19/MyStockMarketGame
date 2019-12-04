import com.nizhegorodtsev.Stock;
import comp127graphics.*;
import comp127graphics.Image;
import comp127graphics.Point;

import java.util.ArrayList;
import java.util.List;

public class MarketIndexWidget implements StockWidget {
    private final double size;
    private GraphicsGroup group;

    private GraphicsGroup boxGroup;

    private List<StockBox> boxes = new ArrayList<>();

    private GraphicsText ticker;
    private GraphicsText name;
    private GraphicsText currPrice;
    private GraphicsText dayHigh;
    private GraphicsText dayLow;
    private GraphicsText openPrice;

    private GraphicsText peRatio;
    private GraphicsText eps;
    private GraphicsText divYield;
    private GraphicsText marketCap;



    public MarketIndexWidget(double size) {
        this.size = size;

        group = new GraphicsGroup();

        name = new GraphicsText();
        name.setFont(FontStyle.BOLD, size * 0.1);
        group.add(name);

        ticker = new GraphicsText();
        ticker.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(ticker);

        currPrice = new GraphicsText();
        currPrice.setFont(FontStyle.PLAIN, size * 0.1);
        group.add(currPrice);

        dayHigh = new GraphicsText();
        dayHigh.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(dayHigh);

        dayLow = new GraphicsText();
        dayLow.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(dayLow);

        openPrice = new GraphicsText();
        openPrice.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(openPrice);

        peRatio = new GraphicsText();
        peRatio.setFont(FontStyle.PLAIN, size * 0.03);
        group.add(peRatio);

        eps = new GraphicsText();
        eps.setFont(FontStyle.PLAIN, size * 0.03);
        group.add(eps);

        divYield = new GraphicsText();
        divYield.setFont(FontStyle.PLAIN, size * 0.03);
        group.add(divYield);

        marketCap = new GraphicsText();
        marketCap.setFont(FontStyle.PLAIN, size * 0.05);
        group.add(marketCap);

        updateLayout();

    }


    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    @Override
    public void update(Stock stock) {
        name.setText(stock.getName());
        ticker.setText(stock.getTicker());
        currPrice.setText(stock.getPricePaid().toString());
        dayHigh.setText(stock.getDayHigh().toString());
        dayLow.setText(stock.getDayLow().toString());
        openPrice.setText(stock.getOpen().toString());
        peRatio.setText(stock.getPeRatio().toString());
        eps.setText(stock.getPriceEPSEstimateCurrentYeat().toString());
        divYield.setText(stock.getDividend().toString());
        marketCap.setText(stock.getMarketCapRealTime());

        updateLayout();
    }

    private void updateLayout() {
        name.setCenter(size * 0.5, size * 0.4);
        ticker.setCenter(size * 0.5, size * 0.45);
        currPrice.setCenter(size,size);

    }

    @Override
    public void onHover(Point position) {

    }
}