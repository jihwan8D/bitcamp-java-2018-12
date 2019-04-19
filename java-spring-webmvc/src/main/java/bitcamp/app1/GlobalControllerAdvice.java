package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalControllerAdvice {

  @InitBinder
  public void initBinder(WebDataBinder binder) {

    DatePropertyEditor propEditor = new DatePropertyEditor();
    
    binder.registerCustomEditor(
        java.util.Date.class, // String을 Date 타입으로 바꾸는 에디터임을 지정한다. 
        propEditor  // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
    );
/*-------------------------------------------------------------------------------------*/
    binder.registerCustomEditor(
        Car.class, // String을 Car 타입으로 바꾸는 에디터임을 지정한다. 
        new CarPropertyEditor()  // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
    );
/*-------------------------------------------------------------------------------------*/
    
    binder.registerCustomEditor(
        Engine.class,
        new EnginePropertyEditor()
        );
  }

  class DatePropertyEditor extends  PropertyEditorSupport {
    
    SimpleDateFormat format;
    
    public DatePropertyEditor() {
      format = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      try {
        Date date = format.parse(text); // String ===> java.util.Date 
        setValue(date); // 내부에 저장
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }
  }
  /*-------------------------------------------------------------------------------------*/
  class CarPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      String[] values = text.split(",");
      
      Car car = new Car();
      car.setModel(values[0]);
      car.setCapacity(Integer.parseInt(values[1]));
      car.setAuto(Boolean.parseBoolean(values[2]));
      car.setCreatedDate(java.sql.Date.valueOf(values[3]));
      
      setValue(car);
    }
  }
  /*-------------------------------------------------------------------------------------*/
  
  class EnginePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      String[] values = text.split(",");
      
      Engine engine = new Engine();
      engine.setModel(values[0]);
      engine.setCc(Integer.parseInt(values[1]));
      engine.setValve(Integer.parseInt(values[2]));
      
      setValue(engine);
    }
  }
  
}












