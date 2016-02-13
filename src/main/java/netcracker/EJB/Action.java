/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcracker.EJB;

/**
 *
 * @author Иван
 */
public class Action {

    private String syntax;
    private String purpose;

    public Action(String syntax, String purpose) {
        this.syntax = syntax;
        this.purpose = purpose;
    }

    public String getSyntax() {
        return syntax;
    }

    public String getPurpose() {
        return purpose;
    }
}
