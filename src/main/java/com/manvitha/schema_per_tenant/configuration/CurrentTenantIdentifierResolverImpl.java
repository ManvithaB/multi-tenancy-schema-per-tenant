package com.manvitha.schema_per_tenant.configuration;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getCurrentTenant();
        return (tenantId != null) ? tenantId : "public";  // Default schema is "public"
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
