import java.util.List;

public class Data {

    private String name;
    private final List<Double> price, eps, marketCapInBillions, pe, divYield;


    public Data(String name, List<Double> price, List<Double> eps, List<Double> marketCapInBillions,
                List<Double> pe, List<Double> divYield) {
        this.price = price;
        this.eps = eps;
        this.marketCapInBillions = marketCapInBillions;
        this.pe = pe;
        this.divYield = divYield;
        this.name = name;
    }

    public List<Double> getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", eps=" + eps +
                ", marketCapInBillions=" + marketCapInBillions +
                ", pe=" + pe +
                ", divYield=" + divYield +
                '}';
    }

    public List<Double> getEps() {
        return eps;
    }

    public List<Double> getMarketCapInBillions() {
        return marketCapInBillions;
    }

    public List<Double> getPe() {
        return pe;
    }

    public List<Double> getDivYield() {
        return divYield;
    }
    public String getName() {
        return name;
    }

    public List<Data> getSTOCKS() {
        return STOCKS;
    }

    public String getName() {
        return name;
    }

    // Adobe

    public static final Data ADBE = new Data("Adobe", List.of(19.31, 18.68, 29.98, 32.95,
            37.34, 32.30, 35.16, 31.59,
            32.78, 28.79, 32.49, 34.61, 33.27, 24.15, 28.20, 28.72, 33.64, 29.82, 33.83, 37.56,
            38.13, 41.50, 44.12, 52.31, 60.89), List.of(1.91, 1.10, 1.92, 1.85, 1.73),
            List.of(9.41, 21.02, 17.57, 15.12, 18.97), List.of(12.51, 49.38, 26.67, 25.21, 25.89),
            List.of(0.05, 0.04, 0.04, 0.03, 0.03));

    //American Express

    public static final Data AXM = new Data("American Express", List.of(16.73, 14.45, 25.16, 34.77, 40.52,
            37.66, 40.33, 38.41, 41.37,
            44.88, 46.00, 44.17, 49.28, 47.28, 47.95, 50.04, 53.20, 56.79, 57.73, 57.65, 61.24, 64.70,
            72.97, 75.89, 83.68), List.of(2.53, 1.14, 2.25, 3.96, 3.54), List.of(31.24, 46.89, 55.78, 60.45, 76.89),
            List.of(4.87, 39.01, 17.82, 18.21, 16.09), List.of(4.91, 1.70, 1.59, 1.48, 1.35));

    //UnitedHealth Group

    public static final Data UNH = new Data("UnitedHealth Group", List.of(25.50, 20.63, 25.43, 28.58, 31.54,
            32.70, 34.39, 31.33, 34.13, 35.05, 38.45, 42.60,
            49.96, 50.76, 49.00, 52.78, 55.59, 58.90, 54.25, 53.87,
            56.04, 53.81, 62.57, 74.06, 74.69), List.of(2.68, 2.97, 4.45, 5.08, 5.89),List.of(28.97, 43.09, 45.24,
            57.12, 50.03), List.of(11.92, 10.42, 9.11, 11.79, 9.42),List.of(0.14, 0.09, 1.22, 1.18, 1.41));

    // Aflac Incorporated

    public static final Data AFL = new Data("Aflac Inc",  List.of(9.19, 16.76, 21.38, 23.4, 24.55, 26.35
            ,21.8, 25.47, 27.78, 28.84, 28.71, 22.43, 15.73, 21.89, 24.52, 23.44, 21.3
            ,24.83, 26.91, 25.74, 28.33, 31.11, 32.98, 28.33), List.of(9.02,30.11,24.01,21.09,18.87,19.33),
            List.of(10.23,42.11,50.67,42.55,49.11),
            List.of(1.5, 1.8, 3.0, 2.0, 4.0),
            List.of(2.69, 2.33, 3.12, 2.87, 2.46));

    //AllState

    public static final Data ALL = new Data ("AllState", List.of(28.77, 20.40, 24.07, 28.92, 30.23,
            30.91,31.26, 29.98, 29.87, 31.31, 31.35, 31.15, 29.65, 24.94,
            26.44, 28.98, 32.51, 34.15, 39.86, 40.31, 42.96, 48.22, 48.12,
            48.4,53.77), List.of(20.21 ,20.34 ,19.22 ,21.09 ,10.12), List.of(18.11, 16.03, 15.56, 16.11, 21.24),
    List.of(1.52,2.53, 0.55, 1.03, 5.01), List.of(3.41, 2.83, 3.12, 2.53, 1.92));

    //Gap Inc.

    public static final Data GPS = new Data("Gap", List.of(14.07,11.98, 16.33, 17.65, 20.71,
            18.86, 22.8, 20.20, 17.63, 21.19, 20.41, 21.59, 17.72,
            16.31, 18.85, 18.93, 25.39, 25.26, 35.20, 31.37, 32.96,
            36.23,41.32, 40.67, 38.49),
    List.of(7.11,15.43,12.03, 10.32, 18.12),
    List.of(8.32,15.35, 13.14, 10.68, 16.56),
     List.of(1.44, 1.65, 1.87, 1.55, 2.19),
    List.of(2.37, 1.55, 2.28, 1.74, 1.28));

    // Ford Corporation (F)

    public static final Data F = new Data("Ford",  List.of(1.87, 2.75, 6.36,6.94,10.13, 10.52,
            13.34, 10.75, 16.80, 18.65, 14.42, 13.35, 9.86, 11.03, 11.71,
            12.51, 9.59, 10.53, 11.86, 14.11, 12.98, 15.00, 17.05, 16.59),
   List.of(15.45, 17.05, 9.46, 5.23, 3.27),
  List.of(2.52, 30.07, 57.07, 48.02, 47.07),
   List.of(-2.5, -1.0, 2.5, 1.0,1.5),
  List.of(2.78, 1.84, 0.99, 1.62, 2.06));

    //Wells Fargo

    public static final Data WFC = new Data("Wells Fargo",List.of(25.14, 15.59, 25.48, 28.49, 26.99,
            27.26, 30.38, 27.78 , 25.75, 30.99, 32.75,
            32.38, 27.33, 24.20, 25.98, 28.94, 33.53, 31.43, 34.97, 33.23, 35.14, 38.20, 41.27, 42.19, 44.96),
List.of(9.7, 44.5, 16.1, 14.3, 9.9),
 List.of(29.67, 144.32, 181.22, 187.89, 190.11),
 List.of(0.69, 0.81, 2.11, 2.90, 3.44),
    List.of(2.75, 0.71, 1.49, 2.29, 2.45));


    public static final List<Data> STOCKS = List.of(ADBE, AXM, UNH, AFL, ALL, GPS, F, WFC);


}

