package dk.aersoe.jobfinder.interfaces;

import java.util.Set;

import dk.aersoe.jobfinder.model.JobEntry;

/**
 * Interface for fetching jobentries from various sources
 * 
 * @author Morten
 *
 */
public interface JobEntryFetcher {
	
	/**
	 * getEntries fetches a Set containing JobEntry objects  
	 * @param source the source from where the job entries can be collected. This could be an url or a resource name 
	 * @return Set<JobEntry> a Set that contains the resulting JobEntries
	 */
	public Set<JobEntry> getEntries(String source);
}
