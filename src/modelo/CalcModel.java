package modelo;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CalcModel {
    public enum Tipo { ENTERO, DECIMAL }

    private Tipo m_tipo = Tipo.ENTERO;
    private BigInteger m_totalEntero;
    private BigDecimal m_totalDecimal;

    public CalcModel() {
        reset();
    }

    public final void reset() {
        m_totalEntero = BigInteger.ONE;
        m_totalDecimal = BigDecimal.ONE;
    }

    public Tipo getTipo() {
        return m_tipo;
    }

    public void setTipo(Tipo tipo) {
        m_tipo = tipo;
        reset();
    }

    public void multiplyBy(String operand) {
        if (m_tipo == Tipo.ENTERO) {
            m_totalEntero = m_totalEntero.multiply(new BigInteger(operand));
        } else {
            m_totalDecimal = m_totalDecimal.multiply(new BigDecimal(operand));
        }
    }

    public void addBy(String operand) {
        if (m_tipo == Tipo.ENTERO) {
            m_totalEntero = m_totalEntero.add(new BigInteger(operand));
        } else {
            m_totalDecimal = m_totalDecimal.add(new BigDecimal(operand));
        }
    }

    public void subtractBy(String operand) {
        if (m_tipo == Tipo.ENTERO) {
            m_totalEntero = m_totalEntero.subtract(new BigInteger(operand));
        } else {
            m_totalDecimal = m_totalDecimal.subtract(new BigDecimal(operand));
        }
    }

    public void setValue(String value) {
        if (m_tipo == Tipo.ENTERO) {
            m_totalEntero = new BigInteger(value);
        } else {
            m_totalDecimal = new BigDecimal(value);
        }
    }

    public String getValue() {
        if (m_tipo == Tipo.ENTERO) {
            return m_totalEntero.toString();
        }
        return m_totalDecimal.toPlainString();
    }
}