package vista;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.CalcModel;

public class CalcView extends JFrame {
    private static final String INITIAL_VALUE = "1";

    private final JTextField m_userInputTf = new JTextField(10);
    private final JTextField m_totalTf     = new JTextField(20);
    private final JButton    m_addBtn      = new JButton("Add");
    private final JButton    m_subtractBtn = new JButton("Subtract");
    private final JButton    m_multiplyBtn = new JButton("Multiply");
    private final JButton    m_clearBtn    = new JButton("Clear");
    private final JComboBox<CalcModel.Tipo> m_tipoCb =
            new JComboBox<>(CalcModel.Tipo.values());

    public CalcView(CalcModel model) {
        m_totalTf.setText(model.getValue());
        m_totalTf.setEditable(false);

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Tipo"));
        content.add(m_tipoCb);
        content.add(new JLabel("Input"));
        content.add(m_userInputTf);
        content.add(m_addBtn);
        content.add(m_subtractBtn);
        content.add(m_multiplyBtn);
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Calc MVC - BigInteger / BigDecimal");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void reset() {
        m_totalTf.setText(INITIAL_VALUE);
    }

    public String getUserInput() {
        return m_userInputTf.getText().trim();
    }

    public void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public CalcModel.Tipo getTipoSeleccionado() {
        return (CalcModel.Tipo) m_tipoCb.getSelectedItem();
    }

    public void addAddListener(ActionListener l) {
        m_addBtn.addActionListener(l);
    }

    public void addSubtractListener(ActionListener l) {
        m_subtractBtn.addActionListener(l);
    }

    public void addMultiplyListener(ActionListener l) {
        m_multiplyBtn.addActionListener(l);
    }

    public void addClearListener(ActionListener l) {
        m_clearBtn.addActionListener(l);
    }

    public void addTipoListener(ActionListener l) {
        m_tipoCb.addActionListener(l);
    }
}