package dk.aersoe.jobfinder.crud.helpers;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import dk.aersoe.jobfinder.model.JobEntry;

/**
 * Database helper that enables read functionality
 * 
 * @author morten@aersoe.dk
 *
 */
public class DataReader {
	
	
	/**
	 * Gets a JobEntry from the database based on the id of the JobEntry
	 * @param id the id of the requested JobEntry
	 * @return a JobEntry object or null if the id is not found in the table
	 */
	public JobEntry getEntry(int id){
		JobEntry result = null;
		
		
		return result;
	}
	
	/**
	 * Gets all the job entries in the database
	 * @return a Set containing all the job entries in the database or null if nothing is found
	 */
	public Set<JobEntry> getEntries(){
		Set<JobEntry> result = null;
		try{
			ResultSet rs = null;
			if (rs != null){
				// TODO Add search logic
				result = new HashSet<JobEntry>();
			}
		}
		catch(Exception e){
			// TODO add error handling
		}
		return result;
	}
	
	/**
	 * Gets all the job entries in the database that meet the search criterias
	 * @param fieldName the name of the requested column
	 * @param value the value to be searched for. This will be based on a SQL LIKE query
	 * @return a Set containing all the job entries in the database or null if nothing is found
	 */
	public Set<JobEntry> getEntriesFromString(String fieldName, String value){
		Set<JobEntry> result = null;
		try{
			// TODO Add search logic
			result = new HashSet<JobEntry>();
		}
		catch(Exception e){
			// TODO Add error handling
		}
		return result;
	}
	
	/**
	 * Gets all the job entries in the database that meet the specified date
	 * @param fieldName the name of the requested column
	 * @param date the specific date to be searched for
	 * @return a Set containing all the job entries in the database or null if nothing is found
	 */
	public Set<JobEntry> getEntriesFromDate(String fieldName, Date date){
		Set<JobEntry> result = null;
		try{
			// TODO Add search logic
			result = new HashSet<JobEntry>();
		}
		catch(Exception e){
			// TODO Add error handling
		}
		return result;
	}

	/**
	 * Gets all the job entries in the database that meet the search criterias based on a date range
	 * @param fieldName the name of the requested column
	 * @param startDate the Date that the search range starts with
	 * @param endDate the Date that the search range ends with
	 * @return a Set containing all the job entries in the database or null if nothing is found
	 */
	public Set<JobEntry> getEntriesFromDateRange(String fieldName, Date startDate, Date endDate){
		Set<JobEntry> result = null;
		try{
			ResultSet rs = null;
			if (rs != null){
				// TODO Add search logic
				result = new HashSet<JobEntry>();
			}
		}
		catch(Exception e){
			// TODO Add error handling
		}
		return result;
	}
}
