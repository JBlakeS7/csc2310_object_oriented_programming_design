package csc2310;

/**
 *  Represents a street address.
 */

public class Address
{
   /** The street */
   private String streetAddress;
   /** The city */
   private String city;
   /** The state */
   private String state;
   /** The zip code */
   private int zipCode;

   /**
    *  Sets up this Address object with the specified data.  
    */
   public Address (String street, String town, String st, int zip)
   {
      //No return type allowed.
      //Pass by copy (but the effect is different for reference variables)
      streetAddress = street;
      city = town;
      state = st;
      zipCode = zip;
   }

   /**
    *  Return the street address.  
    */
   public String getStreet() 
   {
      //returning refs to Strings is safe as Strings are immutable
      return streetAddress;
   }

   /**
    *  Return the city.  
    */
   public String getCity()
   {
      return city;
   }

   /**
    *  Return the state.  
    */
   public String getState()
   {
      return state;
   }

   /**
    *  Return the zip code.  
    */
   public int getZip()
   {
      return zipCode;
   }

   /**
    *  Set the city.  
    */
   public void setCity(String ct)
   {
      city = ct;
   }

   public boolean equals(Address other)
   {
      return getStreet().equals(other.getStreet()) && getCity().equals(other.getCity()) && getState().equals(other.getState());
   }

   /**
    *  Returns this Address object as a string.
    */
   public String toString()
   {
      String result;

      result = streetAddress + "\r\n";
      result += city + ", " + state + "  " + zipCode;

      return result;
   }
}
