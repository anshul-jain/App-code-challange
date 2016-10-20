package com.techsmart.billapp.util;

import java.util.Properties;

/**
 * <p>
 * The BillAppProperties class loads basic property requirements into Application
 * Context.
 * </p>
 * 
 * @author Anshul Jain
 *
 */
public class BillAppProperties
{

  /** The properties to be loaded by the object */
  private static Properties props;
    

  static String resourcePath = "/billapp.properties";
  
  /**
   * @param name the property value to be converted to int
   * @param defValue the default int value to be returned
   * @return the converted int value for the input string
   */
  public static int getIntProperty(String name, int defValue)
  {
    try
    {
      return Integer.parseInt(props.getProperty(name));
    }
    catch (Exception e)
    {
      return defValue;
    }
  }

  /**
   * @param name the property value to be converted to int
   * @return the converted int value for the input string
   */
  public static int getIntProperty(String name)
  {
    return getIntProperty(name, 0);
  }

  /**
   * @param name the property value to be converted to float
   * @param defValue the default float value to be returned
   * @return the converted float value for the input string
   */
  public static double getFloatProperty(String name, float defValue)
  {
    try
    {
      return Float.parseFloat(props.getProperty(name));
    }
    catch (Exception e)
    {
      return defValue;
    }
  }


  
  /**
   * @param name the property value to be converted to float
   * @return the converted float value for the input string
   */
  public static float getFloatProperty(String name)
  {
    return (float) getFloatProperty(name, 0);
  }
  
  /**
   * @param name the property value to be retrieved from the property file
   * @param site the site name for which the value is requested
   * @param defValue the default value to be returned
   * @return the value for the input string
   */
  public static String getProperty(String name, String site, String defValue)
  {
    String sResponse = "";

    if (site != null)
    {
      sResponse = getProperty("site." + site.toLowerCase() + "." + name, "");
    }

    if (sResponse == null || sResponse.length() == 0)
    {
      sResponse = getProperty("mall." + name, "");
    }

    if (sResponse == null || sResponse.length() == 0)
    {
      sResponse = defValue;
    }

    return sResponse;
  }

  /**
   * @param name the property value to be retrieved from the property file
   * @param defValue the default value to be returned
   * @return the value for the input string
   */
  public static String getProperty(String name, String defValue)
  {
    return props.getProperty(name, defValue);
  }


  /**
   * @param name the property value to be retrieved from the property file
   * @return the value for the input string
   */
  public static String getProperty(String name)
  {
    return getProperty(name, "");
  }

  /**
   * @param name the property value to be converted to boolean
   * @return the converted boolean value for the input string
   */
  public static boolean getBooleanProperty(String name)
  {
    return new Boolean(props.getProperty(name));
  }

  /**
   * Retrieves boolean property and substitutes missing property with the default one
   * @param name - the property value to be converted to boolean
   * @param defValue - the default boolean value to be returned
   * 
   * @return the converted boolean value for the input string or default value
   */
  public static boolean getBooleanProperty(String name, boolean defValue)
  {
    return new Boolean(props.getProperty(name, new Boolean(defValue).toString()));
  }
  
  /**
   * Getter for field: props
   * @return the props
   */
  public static Properties getProps() 
  {
    return props;
  }

  /**
   * Setter for field: props
   * @param props the props to set
   */
  public static void setProps(Properties props) 
  {
	  BillAppProperties.props = props;
  }

  /**
   * Getter for field: resourcePath
   * @return the resourcePath
   */
  public static String getResourcePath() 
  {
    return resourcePath;
  }

  /**
   * Setter for field: resourcePath
   * @param resourcePath the resourcePath to set
   */
  public static void setResourcePath(String resourcePath) 
  {
	  BillAppProperties.resourcePath = resourcePath;
  }


  static
  {
    try
    {             
      (props = new Properties()).load(BillAppProperties.class.getResourceAsStream(resourcePath));
                                                              
    }
    catch (Exception e)
    {
      props = System.getProperties();
    }
  }
}
