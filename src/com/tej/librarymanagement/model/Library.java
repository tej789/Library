package com.tej.librarymanagement.model;
public class Library {
    
   private String libName;
   private String city;

    public Library(String libName,String city){

 if(libName == null || libName.isBlank()){
throw new IllegalArgumentException("library Name should not be empty");
      }

      if (city == null || city.isBlank()) {
    throw new IllegalArgumentException("City should not be empty");
}

        this.libName=libName;
        this.city=city;
    
    }

public String getLibName(){
return libName;

}

public String getCity(){
    return city;
}



}
