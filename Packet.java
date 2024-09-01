public class Packet {
    private String sourceIP;
    private String destinationIP;
    private int sourcePort;
    private int destinationPort;
    private String protocol;

    public Packet(String sourceIP, String destinationIP, int sourcePort, int destinationPort, String protocol) {
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
        this.protocol = protocol;
    }

    // Getters
    public String getSourceIP() { return sourceIP; }
    public String getDestinationIP() { return destinationIP; }
    public int getSourcePort() { return sourcePort; }
    public int getDestinationPort() { return destinationPort; }
    public String getProtocol() { return protocol; }
}
