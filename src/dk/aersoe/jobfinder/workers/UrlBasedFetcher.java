/**
 * 
 */
package dk.aersoe.jobfinder.workers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dk.aersoe.jobfinder.interfaces.JobEntryFetcher;
import dk.aersoe.jobfinder.model.JobEntry;

/**
 * @author morten@aersoe.dk
 *
 */
public class UrlBasedFetcher implements JobEntryFetcher {
	SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);
	/**
	 * Simple constructor
	 */
	public UrlBasedFetcher(){
	}
	
	/* (non-Javadoc)
	 * @see dk.aersoe.jobfinder.interfaces.JobEntryFetcher#getEntries(java.lang.String)
	 */
	@Override
	public Set<JobEntry> getEntries(String source) {
		Set<JobEntry> result = new HashSet<JobEntry>();
		URLConnection uc = null;
		InputStream is = null;
		try{
			URL url = new URL("http://www.jobindex.dk/cgi/jobsearch.cgi?q=java&regionid=20&regionid=21&xml=true&output=rss");
			uc = url.openConnection();
			is = uc.getInputStream();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(is);
			if (doc != null){
				System.out.println("Vi har et doc");
				Element root = doc.getDocumentElement();
				System.out.println(root.getNodeName());
				NodeList nl = root.getElementsByTagName("item");
				System.out.println(nl.getLength());
				for (int i = 0; i < nl.getLength(); i++){
					JobEntry entry = new JobEntry();
					Element itemElement = (Element)nl.item(i);
					Node titleNode = itemElement.getElementsByTagName("title").item(0).getFirstChild();
					Node descrptionNode = itemElement.getElementsByTagName("description").item(0).getFirstChild();
					Node categoryNode = itemElement.getElementsByTagName("category").item(0).getFirstChild();
					Node pubdateNode = itemElement.getElementsByTagName("pubDate").item(0).getFirstChild();
					Node urlNode = itemElement.getElementsByTagName("link").item(0).getFirstChild();
					String title = titleNode.getNodeValue();
					String description = descrptionNode.getNodeValue();
					String category = categoryNode.getNodeValue();
					String pubdate = pubdateNode.getNodeValue();
					String urlString = urlNode.getNodeValue();
					if (title.indexOf(",")>0){
						String company = title.substring(title.lastIndexOf(",") + 1 , title.length());
						company = company.trim();
						entry.setCompany(company);
						title = title.substring(0,title.lastIndexOf(","));
						entry.setTitle(title);
					}
					else{
						entry.setCompany(title);
						entry.setTitle(title);
					}
					entry.setUrl(urlString);
					entry.setDescription(description);
					entry.setCategory(category);
					Date now = Calendar.getInstance().getTime();
					entry.setCreationDate(now);
					entry.setModifyDate(now);
					entry.setForeignDate(formatter.parse(pubdate));
					result.add(entry);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		    if (is != null) {
		        try {
		            is.close();
		        } catch (IOException e) {
		        	//System.out.print("Already closed");
		        }
		    }
		    if (uc != null) {
		        //uc.disconnect();
		    }
		}
		return result;
	}

}

/*
<title>
Developer/System Engineer for FX Algo Trading, Nordea
</title>
<link>
http://www.jobindex.dk/cgi/click.cgi?jobid=389834&jobtype=h&ctx=r
</link>
<description>
<div class="PaidJob"> <A HREF="http://www.jobindex.dk/cgi/click.cgi?jobid=389834&amp;jobtype=h&amp;ctx=r&amp;url=http%3A%2F%2Fwww.nordea.dk%2F" TARGET="_blank"><img src="http://www.jobindex.dk/img/logo/nordeamer20060303.gif" ALIGN="right" ALT="Nordea" style="border: 0px; margin: 5px 0px;"></A><A HREF="http://www.jobindex.dk/cgi/click.cgi?jobid=389834&amp;jobtype=h&amp;ctx=r&amp;url=http%3A%2F%2Fwww.nordea.com%2Fsitemod%2Fnordea_all%2Fmodules%2FJobModule%2Flookupjob.aspx%3Fshortid%3D167722%26lang%3DDA%26countryId%3D700a83fb-e796-482d-9ed6-e23dc4a28ada%26areaId%3D00000000-0000-0000-0000-000000000000%26categoryId%3D00000000-0000-0000-0000-000000000000" TARGET="_blank"><B>Developer/System Engineer for FX Algo Trading</B></A> <P class="jobtext"> <A CLASS="linkcompany" HREF="http://www.jobindex.dk/cgi/click.cgi?jobid=389834&amp;jobtype=h&amp;ctx=r&amp;url=http%3A%2F%2Fwww.nordea.dk%2F" TARGET="_blank"><B class="linkcompany">Nordea</B></A>, Copenhagen</p> <P class="jobtext">As part of the Algo Trading team, your main focus will be to implement software based solutions for the front office part of Foreign Exchange (FX) trading.</p> <P class="jobtext"> The candidate will have main focus on First Software development and maintenance of our Java/FIX based FX liquidity aggregator in corporation with the system owner. Focus will also be at assisting in setting up trading relationships via FIX in the interbank market together with the rest of the trading organization.</p> <P class="jobtext"> The tasks range broadly from implementing execution algorithms together with the quants, to tests and deployments of new releases, as well as operational support for the dealing desk and the algorithmic execution systems.</p> <BR clear="all"><CITE>Nordea, 28.&nbsp;januar</CITE> <div class="jix_toolbar jix_appetizer_toolbar" id="jix_toolbar_h389834"></div> <div style="clear:both;"></div> </div>
</description>
<category>Systemudvikling og programmering</category>
<guid isPermaLink="false">http://www.jobindex.dk/389834</guid>
<pubDate>Mon, 28 Jan 2013 00:00:00 +0100</pubDate>
</item> */

