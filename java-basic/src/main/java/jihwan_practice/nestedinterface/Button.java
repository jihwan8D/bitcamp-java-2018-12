package jihwan_practice.nestedinterface;

public class Button {
  OnclickListener listener;
  
  
  void touch() {
    listener.onClick();
  }
  
  public void setOnclickListener(OnclickListener listener) {
    this.listener = listener;
  }
  
  interface OnclickListener {
    void onClick();
  }
}
