package edu.web.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PriceIncrease {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private int percentage;
	private String datefield;

	public void setPercentage(int i) {
		percentage = i;
		logger.info("Percentage set to " + i);
	}

	public int getPercentage() {
		return percentage;
	}

	/**
	 * @return the datefield
	 */
	public String getDatefield() {
		return datefield;
	}

	/**
	 * @param datefield the datefield to set
	 */
	public void setDatefield(String datefield) {
		this.datefield = datefield;
	}

}
