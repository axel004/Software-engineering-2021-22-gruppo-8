/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author HP115-CS0026
 */
public interface Command {
    boolean execute(String text) throws LessArgException, VariableException;
    void undo();
}
