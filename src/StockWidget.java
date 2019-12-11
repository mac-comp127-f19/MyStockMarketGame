import comp127graphics.GraphicsObject;
import comp127graphics.Point;

public interface StockWidget {

    /**
     * A square widget that graphically presents weather conditions.
     */

        /**
         * This widget’s visual interface, which you can add to a CanvasWindow or GraphicsGroup.
         */
        GraphicsObject getGraphics();

        /**
         * Displays the given weather data in the widget, writing over any information the widget was
         * previously displaying.
         */
        void update();

        /**
         * Called when the mouse moves over the widget.
         *
         * @param position A location in the widget’s local coordinates.
         */
        void onHover(Point position);
    }

