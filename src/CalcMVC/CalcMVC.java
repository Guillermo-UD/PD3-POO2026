package CalcMVC;
import controlador.CalcController;
import modelo.CalcModel;
import vista.CalcView;

public class CalcMVC {
    public static void main(String[] args) {
        CalcModel model = new CalcModel();
        CalcView view = new CalcView(model);
        CalcController controller = new CalcController(model, view);
        view.setVisible(true);
    }

}