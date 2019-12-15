import comp127graphics.*;
import comp127graphics.ui.Button;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MarketIndexWidget implements StockWidget {
    private final double size;
    private GraphicsGroup group;

    private GraphicsGroup buttonGroup;
    private GraphicsGroup stockGroup;


    private List<StockBox> stocks = new ArrayList<>();
    private List<Data> myStocks = new ArrayList<>();

    private GraphicsText moneyAvailable;
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
    private double cash = 10000;
    private int quarter = 0;

    @Override
    public String toString() {
        return "MarketIndexWidget{" +
                "size=" + size +
                ", group=" + group +
                ", stockBoxes=" + stocks +
                ", boxGroup=" + buttonGroup +
                ", moneyAvailable=" + moneyAvailable +
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
        stockGroup = new GraphicsGroup();

        name = new GraphicsText();
        name.setFont(FontStyle.BOLD, size * 0.03);
        group.add(name);

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

        buyButton.onClick(() -> {
            for (StockBox box : stocks) {
                if (box.isActive() && (cash > box.getStock().getPrice().get(quarter))) {
                    updateBuyStockInfo(box);
                }
            }
        });

        sellButton = new Button("Sell Stock");
        buttonGroup.add(sellButton);
        sellButton.onClick(() -> {
            for (StockBox box : stocks) {
                if (box.isActive() && (cash > box.getStock().getPrice().get(quarter))) {
                    updateSellStockInfo(box);
                }
            }
        });

        advanceTime = new Button("Next Quarter");
        buttonGroup.add(advanceTime);
        advanceTime.onClick(() -> {
            if (quarter < 20) {
                quarter++;
            }
            for (StockBox box1 : stocks) {
                if (box1.isActive()) {
                    updateQuarterStockInfo(box1);
                }
            }
        });



        createStockBoxes();
        group.add(getStockGroup());
        setButtonActive(buttonActive);
        update();

//        nextQuarterButton = //;
//        nextQuarterButton.onClick(this::infoUpdate);
    }

    public GraphicsGroup getStockGroup() {
        return stockGroup;
    }

    private void createStockBoxes() {
        double margin = size * 0.05;
        double spacing = size * 0.01;
        double y = size * 0.85;
        double x = margin;
        double length = 0;
        for (Data stock : Data.STOCKS) {
            StockBox stockBox = new StockBox(x, y, size * 0.03, size * 0.04, stock);
            length = length + stockBox.getWidth() + spacing;
            if (length < size - 2 * margin) {
                x = x + stockBox.getWidth() + spacing;
            } else {
                x = margin;
                length = 0;
                y = y + spacing + stockBox.getHeight();
            }
            stockGroup.add(stockBox);
            stocks.add(stockBox);
        }
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
        name.setText("");
        currPrice.setText("Stock Price ");
        peRatio.setText("P/E Ratio " );
        eps.setText("EPS " );
        divYield.setText("Div Yield " );
        marketCap.setText("Market Cap (In Bln) ");
        moneyAvailable.setText("Cash: " + cash);
        updateLayout();
    }

    private void updateLayout() {
        name.setCenter(size * 0.4, size * 0.15);
        moneyAvailable.setCenter(size * 0.1, size * 0.05);
        currPrice.setCenter(size * 0.5, size * 0.25);
        peRatio.setCenter(size * 0.2, size * 0.45);
        eps.setCenter(size * 0.2, size * 0.55);
        divYield.setCenter(size * 0.6, size * 0.45);
        marketCap.setCenter(size * 0.6, size * 0.55);
        buyButton.setCenter(size * 0.15, size * 0.15);
        sellButton.setCenter(size * 0.80, size * 0.15);
        advanceTime.setCenter(size * 0.65, size * 0.05);
    }

    private StockBox getBoxAt(Point location) {
        GraphicsObject obj = group.getElementAt(location);
        if (obj instanceof StockBox) {
            return (StockBox) obj;
        }
        return null;
    }

    private void selectStock(StockBox box) {
        for (StockBox box1 : stocks) {
            box1.setActive(false);
        }
        box.setActive(true);
        updateQuarterStockInfo(box);
        updateLayout();
    }

    private void updateQuarterStockInfo(StockBox box) {
        Data stock = box.getStock();
        name.setText(stock.getName());
        currPrice.setText("Stock Price " + stock.getPrice().get(quarter));
        peRatio.setText("P/E Ratio " + stock.getPe().get(quarter/4));
        eps.setText("EPS " + stock.getEps().get(quarter/4));
        divYield.setText("Div Yield " + stock.getDivYield().get(quarter/4));
        marketCap.setText("Market Cap (In Bln) " + stock.getMarketCapInBillions().get(quarter/4));
    }

    private void updateBuyStockInfo(StockBox box) {
        Data stock = box.getStock();
        moneyAvailable.setText("Cash : " + (cash-stock.getPrice().get(quarter)));
        cash -= stock.getPrice().get(quarter);
    }

    private void updateSellStockInfo(StockBox box) {
        Data stock = box.getStock();
        moneyAvailable.setText("Cash : " + (cash+stock.getPrice().get(quarter)));
        cash += stock.getPrice().get(quarter);
    }

//    public void buyStock()  {
//        buyButton.onClick(()->
//                );
//    }


    //Please Do not touch this method or at least tell me that you are going to do that


//    public void updateCash (double cash, Data data){
//        this.data = data;
//          if(buyButton.onClick() && data.getAdbePrice()< cash)
//    }

    //    private StockBox getBoxAt(Point location) {
//        GraphicsObject obj = group.getElementAt(location);
//        if (obj instanceof StockBox) {
//            return (StockBox) obj;
//        }
//        return null;
//    }
//    private int i = 0;
//    public void infoUpdate(Data data) {
//        this.data = data;
//        int i = 0;
//        i++;
//
//        System.out.println("I'm clicked!");
//            for (Data stock : Data.STOCKS) {
//                stock.getPrice().get(i);
//            }
//            List<Double> prices = Data.STOCKS.stream().map(stock -> stock.getPrice().get(i)).collect(Collectors.toList());
//            System.out.println(prices);
//            Data.ADBE.getPrice();
//            data.adbePrice.get(i);
//            data.axpPrice.get(i);
//            data.unhPrice.get(i);
//            data.aflacPrice.get(i);
//            data.allstatePrice.get(i);
//            data.gapPrice.get(i);
//            data.fordPrice.get(i);
//            data.wfcPrice.get(i);
//
//        int shortListi = i / 5;
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
//    }
    public Double decimalPoint(Double number)  {
        DecimalFormat df = new DecimalFormat("#.##");
        return (Double.parseDouble(df.format(number)));
    }

    @Override
    public void onHover(Point position) {
        StockBox selectBox = getBoxAt(position);
        if (selectBox == null) return;
        selectStock(selectBox);
    }

    @Override
    public void setActive(boolean b) {
        setButtonActive(b);
    }
}