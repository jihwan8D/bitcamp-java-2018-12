package com.eomcs.lms.context;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import com.eomcs.lms.handler.Command;

// Command 객체를 자동 생성하는 역할을 수행한다.
public class ApplicationContext {

  ArrayList<Class<?>> classes = new ArrayList<>();

  public ApplicationContext(String packageName) throws Exception {

    // 패키지명으로 디렉토리 경로를 알아낸다.                                   .을 /로 바꾸라는 뜻
    File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/"));

    // 2) 해당 패키지 폴더와 그 하위 폴더를 뒤져서 클래스 이름을 알아낸다.
    // => 인스턴스를 생성할 수 없는 인터페이스나 추상 클래스는 제외한다.
    // => 또한 중첩 클래스도 제외한다.
    findClasses(packageDir, packageName);

    // 3) Command 인터페이스를 구현한 클래스만 찾아서 인스턴스를 생성한다.
    prepareCommand();
  }

  private void findClasses(File dir, String packageName) throws Exception {
    // 디렉토리를 뒤져서 클래스 파일(.class)이나 하위 디렉토리 목록을 알아낸다.
    File[] files = dir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        if(pathname.isDirectory())
          return true;

        if(pathname.getName().endsWith(".class")/* 자바 클래스 파일 */ &&
            !pathname.getName().contains("$")/* 중첩 클래스가 아닌 경우 ($포함 되지 않았다면)*/) 
          // => 클래스 파일이면서 중첩 클래스가 아닌경우 true 리턴. $가 포함되면 중첩 클래스 이다. 
          return true;

        return false;
      }
    });

    for(File f : files) {
      if (f.isFile()) {
        // 클래스 파일일 경우,
        // => 파라미터로 받은 패키지 명과 파일 이름을 합쳐서 클래스 이름을 만든다.
        //    예) com.eomcs.lms(패키지명) + . + ServerApp(파일명) = com.eomcs.lms.ServerApp
        String filename = f.getName();                              // 0번째 글자부터 . 전까지만 남기고 리턴
        String className = packageName + "." + filename.substring(0, filename.indexOf('.'));
        // Helper.class => Helper
//System.out.println(className);
        // => 클래스 이름으로 클래스 파일(.class)을 로딩한다.
        Class<?> clazz = Class.forName(className);     // 앞에 class, interface가 붙어서 나옴
//System.out.println(clazz);
        // => 클래스 정보를 분석하여 중첩 클래스이거나 인터페이스, Enum이면 무시한다.
        if (clazz.isLocalClass() || clazz.isInterface() || clazz.isEnum()) 
          continue;

        // => 추상 클래스나 공개되지 않은 클래스(public이 아닌 클래스)도 무시한다.
        if (Modifier.isAbstract(clazz.getModifiers()) ||
            !Modifier.isPublic(clazz.getModifiers()))
          continue;
//System.out.println(clazz);
        // 즉 공개된(public) 일반 클래스인 경우 클래스 관리 목록에 추가한다.
        classes.add(clazz);

      } else {
        // 디렉토리일 경우, 그 하위 디렉토리에서 다시 클래스를 찾는다.
        // => 하위 디렉토리에서 클래스를 찾을 때 사용할 패키지명을 준비한다.
        // => 파라미터로 받은 패키지 일므에 하위 디렉토리 이름을 붙이면 전체 패키지명이 된다.
        // => com.eomcs.lms(현재 패키지 이름) + . + dao(디렉토리 이름) = com.eomcs.lms.dao
        findClasses(f, packageName + "." + f.getName());

      }
    }
  }

  private void prepareCommand() throws Exception {
    for (Class<?> clazz : classes) {
      // 클래스가 또는 조상 클래스가 구현한 인터페이스의 목록을 알아낸다.
      List<Class<?>> interfaces = getAllInterfaces(clazz);

      for (Class<?> i : interfaces) {
        if (i == Command.class) {
          // Command 인터페이스의 구현체인 경우에만 클래스 이름을 출력한다.
          System.out.println(clazz.getName());
          break;
        }
      }
    }
  }

  private List<Class<?>> getAllInterfaces(Class<?> clazz) {
    ArrayList<Class<?>> list = new ArrayList<>();
    
    while (clazz != Object.class) {
      Class<?>[] interfaces = clazz.getInterfaces(); // 참조중인 인터페이스 모두 담음
      for (Class<?> i : interfaces)
        list.add(i);
      clazz = clazz.getSuperclass();
    }
    return list;
  }
}
