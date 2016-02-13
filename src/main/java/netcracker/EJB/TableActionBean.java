/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcracker.EJB;

import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Иван
 */
@Stateless
public class TableActionBean {
    
    public String concatenateColumns(ArrayList<Action> jspActions){
        String concatenateString="";
        for(Action action: jspActions){
            concatenateString+=action.getSyntax()+" "+action.getPurpose()+"\n";
        }
        return concatenateString;
    }
}
