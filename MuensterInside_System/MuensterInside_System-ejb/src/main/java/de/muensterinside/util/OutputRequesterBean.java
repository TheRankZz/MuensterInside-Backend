package de.muensterinside.util;


import javax.jms.*;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * 
 * @author Julius Wessing
 */
@Stateless
@LocalBean
public class OutputRequesterBean {

	@Resource(mappedName="java:/JmsXA")
	private ConnectionFactory jmsFactory;
	
	@Resource(mappedName="java:/jms/queue/Queue1")
	private Queue outputQueue;
	
    
    public void printLog(String log){
    	try(JMSContext context = jmsFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
    		TextMessage message = context.createTextMessage();
    		message.setStringProperty("DocType", "Letter");
    		message.setText(log);
    		context.createProducer().send(outputQueue, log);
    	} catch (JMSException e) {
    		throw new EJBException(e);
    	}
    }

}
