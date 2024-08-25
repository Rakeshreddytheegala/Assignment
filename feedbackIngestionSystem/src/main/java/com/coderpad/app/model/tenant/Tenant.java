package com.coderpad.app.model.tenant;

public class Tenant {
  int tenantId;
  String tenantName;

  public Tenant(int tenantId, String tenantName) {
    this.tenantId=tenantId;
    this.tenantName = tenantName;
  }

  public int getId() {
    return tenantId;
  }

  public String getTenantName() {
      return tenantName;
  }
}