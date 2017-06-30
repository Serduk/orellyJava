package edu.examplesForRMIMiniServices;

import javax.swing.*;
import java.io.Serializable;

/**
 *Interface which describe one method
 * which must have universal method - getGUIPanel();
 * This Interface extends from Serializable
 * That's why, any implemented class we can serializable
 *
 * This is a prerequisite(must have)
 * service send by network
 * from server, in result call client
 * by method getService();
 * from remote object ServiceServer
 *
 * Created by sserdiuk on 6/30/17.
 */
public interface Service extends Serializable {
    public JPanel getGUIPanel();
}
