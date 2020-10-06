package main.customevents;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/*
  this CLASS is UNDER WORK!!!  Please ignore and reload the code after 24/6/20
  see : https://www.baeldung.com/spring-events
  for explanations
 */
@Component
public class AnnotationDrivenEventListener {

    // for tests
    private boolean hitContextStartedHandler = false;
    private boolean hitSuccessfulEventHandler = false;
    private boolean hitCustomEventHandler = false;

    @EventListener
    public void handleContextStart(final ContextStartedEvent cse) {
        System.out.println("===== AnnotationDrivenEventListener: Handling context started event.");
        hitContextStartedHandler = true;
    }

    @EventListener(condition = "#event.success")
    public void handleSuccessful(final GenericSpringEvent<String> event) {
        System.out.println("===== AnnotationDrivenEventListener: Handling generic event (conditional): " + event.getWhat());
        hitSuccessfulEventHandler = true;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleCustom(final CustomSpringEvent event) {
        System.out.println("===== AnnotationDrivenEventListener: Handling event inside a transaction BEFORE COMMIT.");
        hitCustomEventHandler = true;
    }

    boolean isHitContextStartedHandler() {
        return hitContextStartedHandler;
    }

    boolean isHitSuccessfulEventHandler() {
        return hitSuccessfulEventHandler;
    }

    boolean isHitCustomEventHandler() {
        return hitCustomEventHandler;
    }
}