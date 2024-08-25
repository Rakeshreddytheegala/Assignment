package com.coderpad.app.repository;

import java.util.*;
import com.coderpad.app.model.tenant.*;

public class TenantRepository {
  Map<Integer , Tenant> tenants;
  IdGenerator idGenerator;

  public TenantRepository() {
    tenants = new HashMap<Integer, Tenant>();
    idGenerator = new IdGenerator();
  }

  public IdGenerator getIdGenerator() {
      return idGenerator;
  }  

  public void addTenant(Tenant tenant) {
    tenants.put(tenant.getId() , tenant);
  }

  public Tenant getTenant(int tenantId) {
    if(!tenants.containsKey(tenantId)) {
      throw new NoSuchElementException("TenantId not present");
    }
    return tenants.get(tenantId);
  }

}