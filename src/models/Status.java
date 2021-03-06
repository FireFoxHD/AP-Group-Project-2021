package models;

import java.io.Serializable;

public enum Status implements Serializable {
		  PENDING, 	//order is being prepared
		  HOLD, 	//order is paused possible due to low stock
		  SUPPLIED,	//items supplied and awaiting return
		  OVERDUE,	//past date due for items to be returned
		  RETURNED,  //items have been returned but not Completed
		  COMPLETED
}
