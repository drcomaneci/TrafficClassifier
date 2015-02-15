import java.util.ArrayList;


public class FlowProperties {
	private int numberOfPackets;
	private int firstTenPacketsLength;
	private ArrayList<Endpoint> firstTenEndpoints;
	private int allPacketsLength;
	private ArrayList<Integer> packetsLength;
	private int minPacketLength;
	private int maxPacketLength;
	private float avgPacketLength;
	private double stdDevLenght;
	
	public FlowProperties(int numberOfPackets,
			   			  int firstTenPacketsLength,
			   			  ArrayList<Endpoint> firstTenEndpoints,
			   			  int allPacketsLength,
			   			  ArrayList<Integer> packetsLength,
			   			  int minPacketLength,
			   			  int maxPacketLenght,
						  float avgPacketLength,
						  double stdDevLenght) {
		
		this.setNumberOfPackets(numberOfPackets);
		this.firstTenPacketsLength = firstTenPacketsLength;
		this.setFirstTenEndpoints(firstTenEndpoints);
		this.setAllPacketsLength(allPacketsLength);
		this.setPacketsLength(packetsLength);
		this.minPacketLength = minPacketLength;
		this.maxPacketLength = maxPacketLenght;
		this.avgPacketLength = avgPacketLength;
		this.stdDevLenght = stdDevLenght;
		
	}
	
	private float sumArrayIntegerElements(ArrayList<Integer> ai) {
		
		int sum = 0;
		
		for (Integer item : ai) {
		    sum += item.floatValue();
		}
		
		return sum;
	}
	
	private float sumArrayFloatElements(ArrayList<Float> af) {
		
		float sum = 0;
		
		for (Float item : af) {
		    sum += item.floatValue();
		}
		
		return sum;
	}
	
	public double calculateStdDev() {
		float mean = sumArrayIntegerElements(packetsLength) / packetsLength.size();
		
		ArrayList<Float> temp = new ArrayList<Float>();
		for (Integer item : packetsLength) {
		    temp.add((item - mean) * (item - mean));
		}
		
		return Math.sqrt(sumArrayFloatElements(temp) / temp.size());
	}
	
	public int getFirstTenPacketsLength() {
		return firstTenPacketsLength;
	}

	public void setFirstTenPacketsLength(Integer firstTenPacketsLength) {
		this.firstTenPacketsLength = firstTenPacketsLength;
	}

	public int getMinPacketLength() {
		return minPacketLength;
	}

	public void setMinPacketLength(Integer minPacketLength) {
		this.minPacketLength = minPacketLength;
	}

	public int getMaxPacketLenght() {
		return maxPacketLength;
	}

	public void setMaxPacketLenght(Integer maxPacketLenght) {
		this.maxPacketLength = maxPacketLenght;
	}

	public float getAvgPacketLength() {
		return avgPacketLength;
	}

	public void setAvgPacketLength(float avgPacketLength) {
		this.avgPacketLength = avgPacketLength;
	}

	public double getStdDevLenght() {
		return stdDevLenght;
	}

	public void setStdDevLenght(double stdDevLenght) {
		this.stdDevLenght = stdDevLenght;
	}

	public int getNumberOfPackets() {
		return numberOfPackets;
	}

	public void setNumberOfPackets(int numberOfPackets) {
		this.numberOfPackets = numberOfPackets;
	}

	public int getAllPacketsLength() {
		return allPacketsLength;
	}

	public void setAllPacketsLength(int allPacketsLenght) {
		this.allPacketsLength = allPacketsLenght;
	}

	public ArrayList<Endpoint> getFirstTenEndpoints() {
		return firstTenEndpoints;
	}

	public void setFirstTenEndpoints(ArrayList<Endpoint> firstTenEndpoints) {
		this.firstTenEndpoints = firstTenEndpoints;
	}

	public ArrayList<Integer> getPacketsLength() {
		return packetsLength;
	}

	public void setPacketsLength(ArrayList<Integer> packetsLength) {
		this.packetsLength = packetsLength;
	}
}
