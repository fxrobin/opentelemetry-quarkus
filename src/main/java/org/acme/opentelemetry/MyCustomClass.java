package org.acme.opentelemetry;

import java.time.LocalTime;

import org.jboss.logging.Logger;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyCustomClass {

    private static final Logger LOG = Logger.getLogger(MyCustomClass.class);

    @WithSpan("My Custom Method")
    public String myCustomMethod() {
        LOG.infov("inside myCustomMethod [{0}]", LocalTime.now());
        return "myCustomMethod " + LocalTime.now();
    }

}
