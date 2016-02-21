/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcracker.EJB;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Иван
 */
@Stateful
public class InitializationTableBean {

    List<Action> listJspActions;

    public List<Action> getActionsTable() {
        listJspActions = new ArrayList();
        listJspActions.add(new Action("jsp:include", "Includes a file at the time the page is requested"));
        listJspActions.add(new Action("jsp:useBean", "Finds or instantiates a JavaBean"));
        listJspActions.add(new Action("jsp:setProperty", "Sets the property of a JavaBean"));
        listJspActions.add(new Action("jsp:getProperty", "Inserts the property of a JavaBean into the output"));
        listJspActions.add(new Action("jsp:forward", "Forwards the requester to a new page"));
        listJspActions.add(new Action("jsp:plugin", "Generates browser-specific code that makes an OBJECT or EMBED tag for the Java plugin"));
        return listJspActions;
    }

    public void removeTheIndex(int index) {
        if (index >= 0 && index < listJspActions.size()) {
            listJspActions.remove(index);
        }
    }
}
