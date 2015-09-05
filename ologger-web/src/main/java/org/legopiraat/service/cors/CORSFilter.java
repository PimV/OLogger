package org.legopiraat.service.cors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {

        setHeader(responseContext, "Access-Control-Allow-Origin", "*");
        setHeader(responseContext, "Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        setHeader(responseContext, "Access-Control-Allow-Credentials", "true");
        setHeader(responseContext, "Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        setHeader(responseContext, "Access-Control-Max-Age", "1209600");

    }

    private void setHeader(ContainerResponseContext responseContext, String headerKey, String headerValue) {
        responseContext.getHeaders().add(headerKey, headerValue);
    }
}
