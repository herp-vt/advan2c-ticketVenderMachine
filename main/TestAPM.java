import java.io.*;
import java.util.*;

import org.classes.*;
import org.util.*;

public class TestAPM{
  public static void main(String[] args){
    Product pd = new AccessProductMasterDB().execSelect("100007");
    System.out.println(pd.price);
  }
}


