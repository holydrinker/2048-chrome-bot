package com.example.setup;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class CrossDomainFilter implements ContainerResponseFilter {

    public void filter(ContainerRequestContext creq, ContainerResponseContext cres) {
        cres.getHeaders().add("Access-Control-Allow-Origin", "http://gabrielecirulli.github.io");
        cres.getHeaders().add("Access-Control-Allow-Headers", "Content-Type");
    }
  }