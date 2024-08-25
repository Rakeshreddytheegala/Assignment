package com.coderpad.app.model.request;

public class AddTenantRequest {
  String tenantName;

  public AddTenantRequest(String name) {
    this.tenantName = name;
  }

  public String getTenantName() {
      return tenantName;
  }

}