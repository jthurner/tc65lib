/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javacint.demo;

import org.javacint.logging.Logger;
import org.javacint.sms.SMSConsumer;
import org.javacint.sms.SimpleSMS;

/**
 * Sample SMS handling code.
 */
public class SMSHandler implements SMSConsumer {

    public boolean smsReceived(String from, String content) {
        if (Logger.BUILD_NOTICE) {
            Logger.log("Demo: Received sms from \"" + from + "\": " + content);
        }

        // If we have something that we are supposed to handle
        if (content.toLowerCase().trim().equals("hello")) {
            // We handle it
            SimpleSMS.send(from, "Hello back !");

            // And we stop the consuming chain here
            return true;
        }
        return false;
    }
}
