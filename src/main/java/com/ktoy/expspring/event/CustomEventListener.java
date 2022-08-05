package com.ktoy.expspring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class CustomEventListener {

    @Async
    @EventListener
    public void handleEvent(CustomEvent event) {
        log.info("event = " + event.getMessage());
    }

    @Async
    @TransactionalEventListener
    public void handleTransactionalEvent(CustomEvent event) {
        log.info("transactional = " + event.getMessage());
    }
}
