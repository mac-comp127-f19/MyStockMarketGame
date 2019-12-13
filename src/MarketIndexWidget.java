import comp127graphics.*;
import comp127graphics.ui.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketIndexWidget implements StockWidget {
    private final double size;
    private GraphicsGroup group;

    private GraphicsGroup buttonGroup;

    private List<StockBox> boxes = new ArrayList<>();

    private GraphicsText moneyAvailable;
    private GraphicsText ticker;
    private GraphicsText name;
    private GraphicsText currPrice;

    private GraphicsText peRatio;
    private GraphicsText eps;
    private GraphicsText divYield;
    private GraphicsText marketCap;
    private Button buyButton;
    private Button sellButton;
    private Button advanceTime;
    private boolean buttonActive = false;
    public static double cash = 10000;
    private Data data;

    @Override
    public String toString() {
        return "MarketIndexWidget{" +
                "size=" + size +
                ", group=" + group +
                ", boxes=" + boxes +
                ", boxGroup=" + buttonGroup +
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

    public MarketIndexWidget(double size, boolean buttonActive) {
        this.size = size;

        group = new GraphicsGroup();
        buttonGroup = new GraphicsGroup();

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

        buyButton = new Button("Buy Stock");
        buttonGroup.add(buyButton);

        sellButton = new Button("Sell Stock");
        buttonGroup.add(sellButton);

        advanceTime = new Button("Next Quarter");
        buttonGroup.add(advanceTime);


        group.add(new StockBoxManager(size).getStockGroup());
        setButtonActive(buttonActive);
        update();

//        nextQuarterButton = //;
//        nextQuarterButton.onClick(this::infoUpdate);
    }


    public GraphicsObject getButtons() {
        return buttonGroup;
    }

    public void setButtonActive(boolean buttonActive) {
        if (this.buttonActive == buttonActive) return;
        this.buttonActive = buttonActive;
        if (!buttonActive) {
            group.remove(getButtons());
        } else {
            group.add(getButtons());
        }
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
        moneyAvailable.setCenter(size * 0.05, size * 0.05);
        currPrice.setCenter(size * 0.5, size * 0.25);
        peRatio.setCenter(size * 0.2, size * 0.45);
        eps.setCenter(size * 0.2, size * 0.55);
        divYield.setCenter(size * 0.6, size * 0.45);
        marketCap.setCenter(size * 0.6, size * 0.55);
        buyButton.setCenter(size * 0.15, size * 0.15);
        sellButton.setCenter(size * 0.65, size * 0.15);
        advanceTime.setCenter(size * 0.65, size * 0.05);

    }

        private StockBox getBoxAt(Point location) {
        GraphicsObject obj = group.getElementAt(location);
        if (obj instanceof StockBox) {
            return (StockBox) obj;
        }
        return null;
    }
    private void selectForecast(StockBox box) {
        for (StockBox box1 : boxes) {
            box1.setActive(false);
        }
        box.setActive(true);
        update();

        updateLayout();
    }
    //Please Do not touch this method or at least tell me that you are going to do that


    public void updateCash (double cash, Data data){
        this.data = data;
       //  if(buyButton.onClick() && data.getAdbePrice()< cash)
    }


//    private StockBox getBoxAt(Point location) {
//        GraphicsObject obj = group.getElementAt(location);
//        if (obj instanceof StockBox) {
//            return (StockBox) obj;
//        }
//        return null;
//    }
    private int i = 0;
    public void infoUpdate(){
//        int i = 0;
        i++;

        System.out.println("I'm clicked!");
            for (Data stock : Data.STOCKS) {
                stock.getPrice().get(i);
            }
            List<Double> prices = Data.STOCKS.stream().map(stock -> stock.getPrice().get(i)).collect(Collectors.toList());
            System.out.println(prices);
            Data.ADBE.getPrice();
//            data.adbePrice.get(i);
//            data.axpPrice.get(i);
//            data.unhPrice.get(i);
//            data.aflacPrice.get(i);
//            data.allstatePrice.get(i);
//            data.gapPrice.get(i);
//            data.fordPrice.get(i);
//            data.wfcPrice.get(i);

            int shortListi = i / 5;
//            if (i % 4 == 1){
//                data.adbeDivYield.get(shortListi);
//                data.adbePe.get(shortListi);
//                data.adbeEps.get(shortListi);
//                data.adbeMarketCapInBillions.get(shortListi);

//                data.axpDivYield.get(shortListi);
//                data.axpPe.get(shortListi);
//                data.axpEps.get(shortListi);
//                data.axpMarketCapInBillions.get(shortListi);

//                data.unhDivYield.get(shortListi);
//                data.unhPe.get(shortListi);
//                data.unhEps.get(shortListi);
//                data.unhMarketCapInBillions.get(shortListi);
//
//                data.aflacDivYield.get(shortListi);
//                data.aflacPe.get(shortListi);
//                data.aflacEPS.get(shortListi);
//                data.aflacMarketCapInBillions.get(shortListi);
//
//                data.allstateDivYield.get(shortListi);
//                data.allstatePe.get(shortListi);
//                data.allstateEPS.get(shortListi);
//                data.allstateMarketCapInBillions.get(shortListi);
//
//                data.gapDivYield.get(shortListi);
//                data.gapPe.get(shortListi);
//                data.gapEPS.get(shortListi);
//                data.gapMarketCapInBillions.get(shortListi);
//
//                data.fordDivYield.get(shortListi);
//                data.fordPe.get(shortListi);
//                data.fordEPS.get(shortListi);
//                data.fordMarketCapInBillions.get(shortListi);
//            }

    }

    @Override
    public void onHover(Point position) {
        StockBox selectBox = getBoxAt(position);
        if (selectBox == null) return;
        selectForecast(selectBox);
    }

    @Override
    public void setActive(boolean b) {
        setButtonActive(b);
    }
}