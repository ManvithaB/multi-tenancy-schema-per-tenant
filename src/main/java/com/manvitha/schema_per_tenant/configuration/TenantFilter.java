package com.manvitha.schema_per_tenant.configuration;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Objects;


public class TenantFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String tenantId = httpServletRequest.getHeader("X-Tenant-ID");  // Get tenant from the request header

        // Fallback to default schema
        TenantContext.setCurrentTenant(Objects.requireNonNullElse(tenantId, "default_schema"));

        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
