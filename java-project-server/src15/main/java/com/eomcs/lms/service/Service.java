package com.eomcs.lms.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Service {

  void execute(String request, ObjectInputStream in, ObjectOutputStream out) throws Exception;
}







