package org.transfer.service.dao;


/**
 *
 * This is wrapper exception class to throw all the dao layer exceptions
 *
 * @author Vibha
 *
 */
public class TSDaoException extends Exception{



    /**
     * Associaction to the messages component that will handle error, warning and info messages.
     */
    private String message;
    /**
     * msg
     * @param msg msg
     */
    public TSDaoException(String msg) {
        super(msg);
    }
    /**
     * Default constructor
     */
    public TSDaoException() {
        super();
    }

    /**
     * @return messages messages
     */
    public String getMessages() {
        return message;
    }
    /**
     * @param messages the messages to set
     */
    public void setMessages(String message) {
        this.message = message;
    }


}
