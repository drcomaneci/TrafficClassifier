import net.sourceforge.jpcap.capture.*;

public class Test {
	
	private static final String INPUT_FILE = "samples/FTP.pcap";
	private static final String OUTPUT_FILE = "output/FTP.out";
	private static final int INFINITE = -1;
	private static final int PACKET_COUNT = INFINITE; 
	private static final String FILTER = "";

	public Test() throws Exception {
		// Initialize jpcap
		PacketCapture pcap = new PacketCapture();
		pcap.openOffline(INPUT_FILE);
		
		pcap.setFilter(FILTER, true);
		pcap.addPacketListener(new PacketHandler());
		
		// Start capturing packets...
		pcap.capture(PACKET_COUNT);
	}

	public static void main(String[] args) {
		try {
			Test example = new Test();
			ResultsWriter rw = new ResultsWriter(OUTPUT_FILE);
			rw.writeToFile(FlowDatabase.getFlows());
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
