package bitcamp.app1;

import java.util.Date;

public class Car {
  protected String model;
  protected String maker;
  protected boolean auto;
  protected int capacity;
  protected String createdDate;
  protected  Engine engine;
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public boolean isAuto() {
    return auto;
  }
  public void setAuto(boolean auto) {
    this.auto = auto;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  public String getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }
  public Engine getEngine() {
    return engine;
  }
  public void setEngine(Engine engine) {
    this.engine = engine;
  }
  @Override
  public String toString() {
    return "Car [model=" + model + ", maker=" + maker + ", auto=" + auto + ", capacity=" + capacity
        + ", createdDate=" + createdDate + ", engine=" + engine + "]";
  }
  
  
  
}
