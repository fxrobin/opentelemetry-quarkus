package org.acme.opentelemetry;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import static java.text.MessageFormat.format;

import org.jboss.logging.Logger;

@Path("/")
public class TracedResource {

    private static final Logger LOG = Logger.getLogger(TracedResource.class);

    MyCustomClass customClass;

    public TracedResource(MyCustomClass customClass) {
        super();
        this.customClass = customClass;
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String message = format("hello : {0}", customClass.myCustomMethod());
        LOG.info(message);
        return message;
    }
}
