package dk.aersoe.jobfinder.testers;

import java.util.Set;

import dk.aersoe.jobfinder.model.JobEntry;
import dk.aersoe.jobfinder.workers.UrlBasedFetcher;

public class FetcherTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UrlBasedFetcher fetcher = new UrlBasedFetcher();
		String fetcherUrl = "http://www.jobindex.dk/cgi/jobsearch.cgi?q=java&regionid=20&regionid=21&xml=true&output=rss";
		Set<JobEntry> result = fetcher.getEntries(fetcherUrl);
		System.out.println(result);
		System.out.println("Finished");
	}

}
