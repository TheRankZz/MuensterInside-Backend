package de.muensterinside.output;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

/**
 * Message-Driven Bean implementation class for: OutputRequestProcessor
 */
@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/MuensterInsideOutput"), 
				@ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		})

public class OutputRequestProcessor implements MessageListener {

	private static final Logger logger = Logger.getLogger(OutputRequestProcessor.class);
	

	@Override
    public void onMessage(Message message) {
        try {
        	TextMessage msg = (TextMessage) message;
        	logger.info(msg.getText());
        }catch (JMSException e) {
        	throw new EJBException(e);
        }
    }

}
