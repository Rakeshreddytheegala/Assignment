package com.coderpad.app.service;

import com.coderpad.app.model.request.*;
import com.coderpad.app.model.tenant.*;

public interface TenantService {

  int addTenant(AddTenantRequest request);

  Tenant getTenant(int tenantId);

}