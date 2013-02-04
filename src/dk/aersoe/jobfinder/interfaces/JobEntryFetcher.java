package dk.aersoe.jobfinder.interfaces;

import java.util.Set;

import dk.aersoe.jobfinder.model.JobEntry;

public interface JobEntryFetcher {
	public Set<JobEntry> getEntries(String source);
}
