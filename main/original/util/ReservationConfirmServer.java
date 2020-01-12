package original.util;

import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

import original.classes.*;

public class ReservationConfirmServer extends Thread{
  public void run(){
    int pos = 1;
    Reservation rv_search;

    while(true){
      while(true){
        System.out.println("pos: " + pos);
        if((rv_search = new JsonUtil().convertReservationObject("check-req", pos)) != null){
          rv = new AccessReservationDB().execSelect(rv_search.productID, rv_search.telNumber);
          String result = new JsonUtil().pushJsonOfReservation(rv);
          ++pos;
        }
        else break;
      }
      try{
        Thread.sleep(6000);
      }
      catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}
