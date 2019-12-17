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

    /**
     * This constructor for MarketIndex class, it creates new graphics group objects as well as graphics text objects
     * to depict the information about each stock
     * this constructor also makes new buttons
     * @param size a double size variable for buttons
     * @param buttonActive a variable that checks if the buttonGroup is active
     */
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

    /**
     * A method that returns the stockGroup that contains information about each stock
     * @return
     */
    public GraphicsGroup getStockGroup() {
        return stockGroup;
    }

    /**
     * A method to create boxes of a certain size
     * This method used to create boxes and assign each a box from the the Graphicsgroup a stock which is also
     * an instance of the data class
     *
     */
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

    /**
     * A method that returns existing buttons as a buttonGroup
     * @return
     */
    public GraphicsObject getButtons() {
        return buttonGroup;
    }

    /**
     * A method that modifies the position of the buttons
     * @param buttonActive a boolean that checks if the buttonGroup is active
     */
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

    /**
     * A method that inputs the text for the Graphicstext objects that represent the stocks
     */
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

    /**
     * A method that positions the Graphicstext objects on the canvas
     */
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

    /**
     * Given a position in the widget, this returns the StockBox at that position if one exists
     * @param location ra variable that represents  the position of a box
     * @return
     */
    private StockBox getBoxAt(Point location) {
        GraphicsObject obj = group.getElementAt(location);
        if (obj instanceof StockBox) {
            return (StockBox) obj;
        }
        return null;
    }

    /**
     * A method that implements the assignment of the stock to the stockbox
     * @param box
     */
    private void selectStock(StockBox box) {
        for (StockBox box1 : stocks) {
            box1.setActive(false);
        }
        box.setActive(true);
        updateQuarterStockInfo(box);
        updateLayout();
    }

    /**
     * A method that is responsible for updating the information about the stocks;
     * it is used when the button next quarter is clicked
     * @param box a Graphics object, ans instance of the Stockbox class
     */
    private void updateQuarterStockInfo(StockBox box) {
        Data stock = box.getStock();
        name.setText(stock.getName());
        currPrice.setText("Stock Price " + stock.getPrice().get(quarter));
        peRatio.setText("P/E Ratio " + stock.getPe().get(quarter/4));
        eps.setText("EPS " + stock.getEps().get(quarter/4));
        divYield.setText("Div Yield " + stock.getDivYield().get(quarter/4));
        marketCap.setText("Market Cap (In Bln) " + stock.getMarketCapInBillions().get(quarter/4));
    }

    /**
     * A method that updates the cash value when a stock is bought
     * @param box a Graphics object, ans instance of the Stockbox class
     */
    private void updateBuyStockInfo(StockBox box) {
        Data stock = box.getStock();
        moneyAvailable.setText("Cash : " + (cash-stock.getPrice().get(quarter)));
        cash -= stock.getPrice().get(quarter);
    }

    /**
     * A method that updates the cash value when a stock is bought
     * @param box a Graphics object, ans instance of the Stockbox class
     */
    private void updateSellStockInfo(StockBox box) {
        Data stock = box.getStock();
        moneyAvailable.setText("Cash : " + (cash+stock.getPrice().get(quarter)));
        cash += stock.getPrice().get(quarter);
    }

    /**
     * A method that dets the number of decimals to two
     * @param number
     * @return
     */
    public Double decimalPoint(Double number)  {
        DecimalFormat df = new DecimalFormat("#.##");
        return (Double.parseDouble(df.format(number)));
    }

    /**
     * Updates the currently displayed forecast information as the mouse moves over the widget.
     *  If there is not a StockBox at that position, the display does not change.
     * @param position A location in the widget’s local coordinates.
     */
    @Override
    public void onHover(Point position) {
        StockBox selectBox = getBoxAt(position);
        if (selectBox == null) return;
        selectStock(selectBox);
    }

    /**
     * A method that sets the button active
     * @param b
     */
    @Override
    public void setActive(boolean b) {
        setButtonActive(b);
    }
}