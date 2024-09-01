import java.util.ArrayList;
import java.util.List;

public class Firewall {
    private List<FirewallRule> rules = new ArrayList<>();

    public void addRule(FirewallRule rule) {
        rules.add(rule);
    }

    public void removeRule(FirewallRule rule) {
        rules.remove(rule);
    }

    public boolean filterPacket(Packet packet) {
        for (FirewallRule rule : rules) {
            if (matchesRule(packet, rule)) {
                return rule.isAllow();
            }
        }
        return false; // Default deny
    }

    private boolean matchesRule(Packet packet, FirewallRule rule) {
        // Example match logic
        return (rule.getIpAddress().equals(packet.getDestinationIP()) || rule.getIpAddress().equals("*"))
                && (rule.getPort() == packet.getDestinationPort() || rule.getPort() == -1)
                && (rule.getProtocol().equals(packet.getProtocol()) || rule.getProtocol().equals("*"));
    }

    public List<FirewallRule> getRules() {
        return rules;
    }
}
