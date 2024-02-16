package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import persistent.Item;

/**
 *	TODO: Complete the Purchase class
 */
public class Purchase {
    /**
     * Find the PurchasedItems for each of the given barcodes.
     *
     * @param itemBarcodeList A list of barcodes.
     * @return A list of PurchasedItems.
     */
    public static List<PurchasedItem> getPurchasedItemsList(List<String> itemBarcodeList) {
    	 try {
             // Construct HQL to select items for the given barcodes
             String hql = "FROM Item WHERE itemBarcode IN :barcodes";
             // Prepare named parameter for the list of barcodes
             HashMap<String, Object> namedParameters = new HashMap<>();
             namedParameters.put("barcodes", itemBarcodeList);
             // Execute query and return the list of Items
             return HibernateQueryRunner.getItemsList(hql, Optional.of(namedParameters));
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
    }

    /**
     * Find the total number of available items in the given category.
     *
     * @param category The item's category.
     * @return The number of available items in that category.
     */
    public static Boolean getNumberOfAvailableItemsInCategory(String category) {
    	// TODO: Complete the function.
    	  try {
              // Construct HQL to count available items in the given category
              String hql = "SELECT COUNT(*) FROM Item WHERE itemCategory = :category AND itemAvailability = true";
              // Prepare named parameter for the category
              HashMap<String, Object> namedParameters = new HashMap<>();
              namedParameters.put("category", category);
              // Execute query and return the count
              return HibernateQueryRunner.getSingleItem(hql, Optional.of(namedParameters)).getItemAvailability();
          } catch (Exception e) {
              e.printStackTrace();
              return null;
          }
    }

    /**
     * Find the total number of available items priced lower than upperLimit.
     *
     * @param upperLimit
     * @return available items with lower price than upperLimit
     */
    public static Boolean getTotalAvailableLowerPricedItemsWithoutDiscount(Float upperLimit) {
    	// TODO: Complete the function.
    	try {
            // Construct HQL to count available items priced lower than the limit
            String hql = "SELECT COUNT(*) FROM Item WHERE itemPrice < :upperLimit AND itemAvailability = true";
            // Prepare named parameter for the upper price limit
            HashMap<String, Object> namedParameters = new HashMap<>();
            namedParameters.put("upperLimit", upperLimit);
            // Execute query and return the count
            return HibernateQueryRunner.getSingleItem(hql, Optional.of(namedParameters)).getItemAvailability();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Find the total number of available items priced higher than lowerLimit.
     * @param lowerLimit
     * @return available items with higher price than lowerLimit
     */
    public static Boolean getTotalAvailableHigherPricedItemsWithoutDiscount(Float lowerLimit) {
    	// TODO: Complete the function.
    	 // TODO: Complete the function.
    	try {
            // Construct HQL to count available items priced higher than the limit
            String hql = "SELECT COUNT(*) FROM Item WHERE itemPrice > :lowerLimit AND itemAvailability = true";
            // Prepare named parameter for the lower price limit
            HashMap<String, Object> namedParameters = new HashMap<>();
            namedParameters.put("lowerLimit", lowerLimit);
            // Execute query and return the count
            return HibernateQueryRunner.getSingleItem(hql, Optional.of(namedParameters)).getItemAvailability();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Find whether the item with the given barcode is available.
     *
     * @param barcode The item's barcode.
     * @return true if the item is available and false if it is not.
     */
    public static boolean isAvailable(String barcode) {
    	// TODO: Complete the function.
    	try {
            // Construct HQL to check if the item with the given barcode is available
            String hql = "SELECT COUNT(*) FROM Item WHERE itemBarcode = :barcode AND itemAvailability = true";
            // Prepare named parameter for the barcode
            HashMap<String, Object> namedParameters = new HashMap<>();
            namedParameters.put("barcode", barcode);
            // Execute query and return true if count > 0
            return HibernateQueryRunner.getSingleItem(hql, Optional.of(namedParameters)).getItemAvailability();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Count the total number of available items.
     *
     * @return The total number of available items.
     */
    public static Boolean getTotalAvailableItems() {
    	// TODO: Complete the function.
    	 try {
             // Construct HQL to count total available items
             String hql = "SELECT COUNT(*) FROM Item WHERE itemAvailability = true";
             // Execute query and return the count
             return HibernateQueryRunner.getSingleItem(hql, Optional.empty()).getItemAvailability();
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
    }

    /**
     * Count the total number of unavailable items.
     *
     * @return The total number of unavailable items.
     */
    public static Boolean getTotalUnAvailableItems() {
    	// TODO: Complete the function.
    	  try {
              // Construct HQL to count total unavailable items
              String hql = "SELECT COUNT(*) FROM Item WHERE itemAvailability = false";
              // Execute query and return the count
              return HibernateQueryRunner.getSingleItem(hql, Optional.empty()).getItemAvailability();
          } catch (Exception e) {
              e.printStackTrace();
              return null;
          }
    }
}
