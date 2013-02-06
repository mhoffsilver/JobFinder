package dk.aersoe.jobfinder.workers;

import java.util.Iterator;
import java.util.Set;

import dk.aersoe.jobfinder.crud.helpers.DataWriter;
import dk.aersoe.jobfinder.model.JobEntry;

/**
 * Batch loader that can load a list of job entries into the database
 * 
 * @author morten@aersoe.dk
 *
 */
public class BatchLoader {
	
	/**
	 * stores the Set of job entries into the database
	 * @param entries a Set<JobEntry> that contains all the job entries
	 * @return int with the number of stored records
	 * @throws Throwable
	 */
	public int storeSet(Set<JobEntry> entries) throws Throwable{
		DataWriter writer = new DataWriter();
		int result = 0;
		Iterator<JobEntry> it = entries.iterator();
		while (it.hasNext()){
			JobEntry entry = it.next();
			writer.writeJobEntry(entry, false);
			result++;
		}
		return result;
	}
}
