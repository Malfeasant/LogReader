package us.malfeasant.logreader;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.Instant;

/* #Fields:
	0 date
	1 time
	2 s-ip
	3 cs-method
	4 cs-uri-stem
	5 cs-uri-query
	6 s-port
	7 cs-username
	8 c-ip
	9 cs(User-Agent)
	10 sc-status
	11 sc-substatus
	12 sc-win32-status
	13 time-taken
*/
public class LogEntry {
	final String source;
	
	final Instant timeStamp;
	final InetAddress serverIP;
	final String method;
	final String path;
	final String query;
	final int port;
	final String user;
	final InetAddress clientIP;
	final String agent;
	final int status;
	final int subStatus;
	final int win32stat;
	final Duration turnaround;
	
	LogEntry(String line) throws UnknownHostException {
		source = line;
		
		String[] parts = line.split("\\s");
		
		timeStamp = Instant.parse(parts[0]+"T"+parts[1]);
		serverIP = InetAddress.getByName(parts[2]);
		method = parts[3];
		path = parts[4];
		query = parts[5];
		port = Integer.parseInt(parts[6]);
		user = parts[7];
		clientIP = InetAddress.getByName(parts[8]);
		agent = parts[9];
		status = Integer.parseInt(parts[10]);
		subStatus = Integer.parseInt(parts[11]);
		win32stat = Integer.parseInt(parts[12]);
		turnaround = Duration.ofMillis(Long.parseLong(parts[4]));
	}
}
