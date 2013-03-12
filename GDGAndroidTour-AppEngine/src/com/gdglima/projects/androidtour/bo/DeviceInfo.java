package com.gdglima.projects.androidtour.bo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class DeviceInfo {

  @Id
  private String deviceRegistrationID;

  private String deviceInformation;

  private long timestamp;

  public String getDeviceRegistrationID() {
    return deviceRegistrationID;
  }

  public String getDeviceInformation() {
    return this.deviceInformation;
  }

  public void setDeviceRegistrationID(String deviceRegistrationID) {
    this.deviceRegistrationID = deviceRegistrationID;
  }

  public void setDeviceInformation(String deviceInformation) {
    this.deviceInformation = deviceInformation;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
