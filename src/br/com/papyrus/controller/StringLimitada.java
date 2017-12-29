/**
 *
 * Esta classe cria um JTextfield com restrição na quantidade de caracteres
 * que o campo pode receber
 *
 */
package br.com.papyrus.controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Alexandre Luiz dos Santos
 */
public class StringLimitada extends PlainDocument {

    private int tamanhoMax = 10;

    public StringLimitada(int tamanhoMax) {
        this.tamanhoMax = tamanhoMax;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {

        if (str == null) {
            return;
        }

        String stringAntiga = getText(0, getLength());
        int tamanhoNovo = stringAntiga.length() + str.length();

        if (tamanhoNovo <= tamanhoMax) {
            super.insertString(offset, str, attr);
        } else {
            super.insertString(offset, "", attr);
        }
    }
}
