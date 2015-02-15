import java.util.ArrayList;
import java.util.HashMap;

public class FlowDatabase {
	
	private static HashMap<Flow, FlowProperties> flows = new 
		           HashMap<Flow, FlowProperties>();
	
	public static HashMap<Flow, FlowProperties> getFlows() {
		return flows;
	}

	public static void setFlows(HashMap<Flow, FlowProperties> flows) {
		FlowDatabase.flows = flows;
	}
	
	public static void addToDb(String srcHost, String dstHost, Integer srcPort, Integer dstPort, String transportProto, 
							   int length) {
		
		Flow f = new Flow(srcHost,dstHost, srcPort, dstPort, transportProto);
		
		if(flows.containsKey(f)) {
			
			FlowProperties fp = flows.get(f);
			Integer noOfPackets = fp.getNumberOfPackets();
			fp.setNumberOfPackets(noOfPackets + 1);
			
			if(noOfPackets < 10) {
				
				int temp = fp.getFirstTenPacketsLength();
				fp.setFirstTenPacketsLength(temp + length);
				
				ArrayList<Endpoint> topTenEndpoints = fp.getFirstTenEndpoints();
				topTenEndpoints.add(new Endpoint(srcHost, dstHost));
				fp.setFirstTenEndpoints(topTenEndpoints);
				
			}
			
			int allPacketsLenght = fp.getAllPacketsLength();
			fp.setAllPacketsLength(allPacketsLenght + length);
			
			ArrayList<Integer> packetsLength = fp.getPacketsLength();
			packetsLength.add(length);
			fp.setPacketsLength(packetsLength);
			
			int minLength = fp.getMinPacketLength();
			fp.setMinPacketLength(Math.min(minLength, length));
						
			int maxLength = fp.getMaxPacketLenght();
			fp.setMaxPacketLenght(Math.max(maxLength, length));
			
			fp.setAvgPacketLength(((noOfPackets * fp.getAvgPacketLength()) + length) / (noOfPackets + 1));
			fp.setStdDevLenght(fp.calculateStdDev());
			
			flows.put(f, fp);
			
		}else {
			
			ArrayList<Endpoint> topTenEndpoints = new ArrayList<Endpoint>();
			topTenEndpoints.add(new Endpoint(srcHost, dstHost));
			
			ArrayList<Integer> packetsLength = new ArrayList<Integer>();
			packetsLength.add(length);
			
			FlowProperties fp = new FlowProperties(1, length, 
												   topTenEndpoints, length,
												   packetsLength,
												   length,
												   length,
												   length,
												   0);
			fp.setStdDevLenght(fp.calculateStdDev());
			flows.put(f, fp);
			
		}
		
	}
}
