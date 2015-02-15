import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ResultsWriter {
	private String outputFile;
	
	public ResultsWriter(String outputFile) {
		this.outputFile = outputFile;
	}
	
	public void writeToFile(HashMap<Flow, FlowProperties> results) {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		for (Map.Entry<Flow, FlowProperties> entry : results.entrySet()) {
		    Flow key = entry.getKey();
		    FlowProperties value = entry.getValue();
		
		    writer.println(key.getSourceIp() + "," + key.getDestIp() + "," +
		    			   key.getSourcePort() + "," + key.getDestPort() + "," +
		    			   key.getTransportProtocol() + "," +
		    			   value.getFirstTenPacketsLength() + "," +
		    			   value.getAllPacketsLength() + ", " +
		    			   value.getMinPacketLength() + "," +
		    			   value.getMaxPacketLenght() + "," +
		    			   value.getAvgPacketLength() + "," +
		    			   value.getStdDevLenght()
		    );
		    
		    ArrayList<Endpoint> topTenEndpoints = value.getFirstTenEndpoints();
		    StringBuffer tenEndpoints = new StringBuffer();
		    tenEndpoints.append("[");
		    for(Endpoint e: topTenEndpoints) {
		    	tenEndpoints.append("(" + e.getSourceIp() + "," + e.getDestIp() + ")");
		    }
		    tenEndpoints.append("]");
		    
		    ArrayList<Integer> packetsLength = value.getPacketsLength();
		    StringBuffer pl = new StringBuffer();
		    pl.append("[");
		    
		    int len = packetsLength.size();
		    if(len > 10) {
		    	len = 10;
		    }
		    
		    for(int i = 0; i < len; ++i) {
		    	
		    	if(i == len - 1) {
		    		pl.append(packetsLength.get(i) + "");
		    	}else {
		    		pl.append(packetsLength.get(i) + ", ");
		    	}
		    	
		    }
		    pl.append("]");
		    
		    writer.println(tenEndpoints + ", " + pl );
		    
		}
		
		writer.close();
		
	}
}
