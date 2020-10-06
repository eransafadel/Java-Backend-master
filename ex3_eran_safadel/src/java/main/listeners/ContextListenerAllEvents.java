package main.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

/*
   first method to implement a listener - using @Listener annotation
 */
@Component
public class ContextListenerAllEvents {
    @EventListener
    public void handleContextRefreshed (ContextRefreshedEvent event) {
        System.out.print(">>>>>>> ContextListenerAllEvents: context refreshed event fired: ");
        System.out.println(event);
    }

    @EventListener
    public void handleContextStarted (ContextStartedEvent event) {
        System.out.print(">>>>>>> ContextListenerAllEvents: context started event fired: ");
        System.out.println(event);
    }

    @EventListener
    public void handleContextStopped (ContextStoppedEvent event) {
        System.out.print(">>>>>>> ContextListenerAllEvents: context stopped event fired: ");
        System.out.println(event);
    }

    @EventListener
    public void handleContextClosed (ContextClosedEvent event) {
        System.out.print(">>>>>>> ContextListenerAllEvents: context  closed event fired: ");
        System.out.println(event);
    }
}
