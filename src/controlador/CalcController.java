package controlador;

import modelo.CalcModel;
import vista.CalcView;
import java.awt.event.*;

public class CalcController {
    private CalcModel m_model;
    private CalcView  m_view;

    public CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view  = view;

        view.addAddListener(new AddListener());
        view.addSubtractListener(new SubtractListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
        view.addTipoListener(new TipoListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.addBy(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException nfex) {
                m_view.showError("Dato inválido para el tipo "
                        + m_model.getTipo() + ": '" + userInput + "'");
            }
        }
    }

    class SubtractListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.subtractBy(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException nfex) {
                m_view.showError("Dato inválido para el tipo "
                        + m_model.getTipo() + ": '" + userInput + "'");
            }
        }
    }

    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.multiplyBy(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException nfex) {
                m_view.showError("Dato inválido para el tipo "
                        + m_model.getTipo() + ": '" + userInput + "'");
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }

    class TipoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.setTipo(m_view.getTipoSeleccionado());
            m_view.reset();
        }
    }
}