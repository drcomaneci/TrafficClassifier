
public class Flow {
	private String sourceIp;
	private String destIp;
	private Integer sourcePort;
	private Integer destPort;
	private String transportProtocol;	
	
	public Flow(String sourceIp, String destIp, Integer sourcePort,
					   Integer destPort, String transportProtocol) {
		
		this.sourceIp = sourceIp;
		this.destIp = destIp;
		this.sourcePort = sourcePort;
		this.destPort = destPort;
		this.transportProtocol = transportProtocol;
	}
	
	public String toString() {
		return this.sourceIp + "," + this.destIp + "," + this.sourcePort + 
				"," + this.destPort + "," + this.transportProtocol;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getDestIp() {
		return destIp;
	}

	public void setDestIp(String destIp) {
		this.destIp = destIp;
	}

	public Integer getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(Integer sourcePort) {
		this.sourcePort = sourcePort;
	}

	public Integer getDestPort() {
		return destPort;
	}

	public void setDestPort(Integer destPort) {
		this.destPort = destPort;
	}

	public String getTransportProtocol() {
		return transportProtocol;
	}

	public void setTransportProtocol(String transportProtocol) {
		this.transportProtocol = transportProtocol;
	}
	
	public int hashCode() {
		return sourceIp.hashCode() ^ destIp.hashCode() ^ 
			   sourcePort.hashCode() ^ destPort.hashCode() ^
			   transportProtocol.hashCode();
	}
	
	public boolean equals(Object obj) {
		
		Flow f = (Flow)obj;
		if(sourceIp.equals(f.sourceIp) && destIp.endsWith(f.destIp) &&
		   sourcePort.equals(f.sourcePort) && destPort.equals(f.destPort) &&
		   transportProtocol.equals(f.transportProtocol)) {
			
			return true;
		}
		
		return false;
		
	}

}
