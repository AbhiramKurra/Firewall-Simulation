public class FirewallRule {
    private String ipAddress;
    private int port;
    private String protocol;
    private boolean allow;

    public FirewallRule(String ipAddress, int port, String protocol, boolean allow) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.protocol = protocol;
        this.allow = allow;
    }

    // Getters
    public String getIpAddress() { return ipAddress; }
    public int getPort() { return port; }
    public String getProtocol() { return protocol; }
    public boolean isAllow() { return allow; }
}
