import java.util.List;

public class Data {
    // Adobe

    List<Double> adbePrice = List.of(19.31, 18.68, 29.98, 32.95, 37.34, 32.30, 35.16, 31.59,
            32.78, 28.79, 32.49, 34.61, 33.27, 24.15, 28.20, 28.72, 33.64, 29.82, 33.83, 37.56,
            38.13, 41.50, 44.12, 52.31, 60.89);
    List<Double> adbeEps = List.of(1.91, 1.10, 1.92, 1.85, 1.73);
    List<Double> adbeMarketCapInBillions = List.of(9.41, 21.02, 17.57, 15.12, 18.97);
    List<Double> adbePe = List.of(12.51, 49.38, 26.67, 25.21, 25.89);

    //American Express

    List<Double> axpPrice = List.of(16.73, 14.45, 25.16, 34.77, 40.52, 37.66, 40.33, 38.41, 41.37,
            44.88, 46.00, 44.17, 49.28, 47.28, 47.95, 50.04, 53.20, 56.79, 57.73, 57.65, 61.24, 64.70,
            72.97, 75.89, 83.68);
    List<Double> axpEps = List.of(2.53, 1.14, 2.25, 3.96, 3.54);
    List<Double> axpMarketCapInBillions = List.of(31.24, 46.89, 55.78, 60.45, 76.89);
    List<Double> axpPe = List.of(4.87, 39.01, 17.82, 18.21, 16.09);

    //United HealthCare

    List<Double> unhPrice = List.of(25.50, 20.63, 25.43, 28.58, 31.54, 32.70, 34.39, 31.33, 34.13, 35.05, 38.45, 42.60,
            49.96, 50.76, 49.00, 52.78, 55.59, 58.90, 54.25, 53.87,
            56.04, 53.81, 62.57, 74.06, 74.69);
    List<Double> unhEps = List.of(2.68, 2.97, 4.45, 5.08, 5.89);
    List<Double> unhMarketCapInBillions = List.of(28.97, 43.09, 45.24, 57.12, 50.03);
    List<Double> unhPe = List.of(11.92, 10.42, 9.11, 11.79, 9.42);

    // Aflac AFL
    private List<Double> aflacPrice = List.of(9.19, 16.76, 21.38, 23.4, 24.55, 26.35
        ,21.8, 25.47, 27.78, 28.84, 28.71, 22.43, 15.73, 21.89, 24.52, 23.44, 21.3
        ,24.83, 26.91, 25.74, 28.33, 31.11, 32.98, 28.33);
    private List<Integer> aflacPe = List.of(9,30,24,21,18,19);
    private List<Integer> aflacMarketCapInBillions = List.of(10,42,50,42,49);
    private List<Double> aflacEPS= List.of(1.5, 1.8, 3.0, 2.0, 4.0);

    //Allstate
    private List<Double> allstatePrice = List.of(28.77, 20.40, 24.07, 28.92, 30.23,
            30.91,31.26, 29.98, 29.87, 31.31, 31.35, 31.15, 29.65, 24.94,
            26.44, 28.98, 32.51, 34.15, 39.86, 40.31, 42.96, 48.22, 48.12,
            48.4,53.77);
    private List<Integer> allstatePe = List.of(20,20,19,21,10);
    private List<Integer> allstateMarketCapInBillions = List.of(18, 16, 15, 16, 21);
    private List<Double> allstateEPS = List.of(1.5, 2.5, 0.5, 1.0, 5.0);

    //Gap Inc.
    private List<Double> gapPrice = List.of(14.07,11.98, 16.33, 17.65, 20.71,
            18.86, 22.8, 20.20, 17.63, 21.19, 20.41, 21.59, 17.72,
            16.31, 18.85, 18.93, 25.39, 25.26, 35.20, 31.37, 32.96,
            36.23,41.32, 40.67, 38.49);
    private List<Integer> gapPe = List.of(7,15,12, 10, 18);
    private List<Integer> gapMarketCapInBillions = List.of(8,15, 13, 10, 16);
    private List<Double> gapEPS = List.of(1.4, 1.6, 1.8, 1.55, 2.19);

    //Ford Motor Company
    private List<Double> fordPrice = List.of(1.87, 2.75, 6.36,6.94,10.13, 10.52,
            13.34, 10.75, 16.80, 18.65, 14.42, 13.35, 9.86, 11.03, 11.71,
            12.51, 9.59, 10.53, 11.86, 14.11, 12.98, 15.00, 17.05, 16.59);
    private List<Integer> fordPe = List.of(15, 17, 9, 5, 3);
    private List<Double> fordMarketCapInBillions = List.of(2.5, 30.0, 57.0, 48.0, 47.0);
    private List<Double> fordEPS = List.of(-2.5, -1.0, 2.5, 1.0,1.5);

    public List getAflacPrice() {
        return aflacPrice;
    }
    public List getAflacPe() {
        return aflacPe;
    }
    public List getAflacMarketCapInBillions() {
        return aflacMarketCapInBillions;
    }
    public List aflacEPS() {
        return aflacEPS;
    }
    public List getAllstatePrice() {
        return allstatePrice;
    }
    public List getAllstatePe() {
        return allstatePe;
    }
    public List getAllstateMarketCapInBillions() {
        return allstateMarketCapInBillions;
    }
    public List getAllstateEPS() {
        return allstateEPS;
    }
    public List getGapPrice() {
        return gapPrice;
    }
    public List getGapPe() {
        return gapPe;
    }
    public List getGapMarketCapInBillions() {
        return gapMarketCapInBillions;
    }
    public List getGapEPS() {
        return gapEPS;
    }
    public List getFordPrice() {
        return fordPrice;
    }
    public List getFordPe() {
        return fordPe;
    }
    public List getFordMarketCapInBillions() {
        return fordMarketCapInBillions;
    }
    public List getFordEPS() {
        return fordEPS;
    }
}
