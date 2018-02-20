package com.mainpackage.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("foo")
public class FooResource {
    @GET
    public Response get() {
        return Response.accepted("foo").build();
    }
}
