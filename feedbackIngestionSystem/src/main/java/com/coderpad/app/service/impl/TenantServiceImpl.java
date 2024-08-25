package com.coderpad.app.service.impl;

import com.coderpad.app.model.request.*;
import com.coderpad.app.repository.*;
import com.coderpad.app.service.TenantService;
import com.coderpad.app.model.tenant.*;

public class TenantServiceImpl implements TenantService {

  TenantRepository tenantRepository;

  public TenantServiceImpl(TenantRepository tenantRepository) {
    this.tenantRepository = tenantRepository;
  }

  public int addTenant(AddTenantRequest request) {
    Tenant tenant = new Tenant(tenantRepository.getIdGenerator().getNewId(), request.getTenantName());

    tenantRepository.addTenant(tenant);
    return tenant.getId();
  }

  public Tenant getTenant(int tenantId) {
    return tenantRepository.getTenant(tenantId);
  }

}