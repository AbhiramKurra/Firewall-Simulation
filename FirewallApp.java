import java.util.Scanner;

public class FirewallApp {
    private static Firewall firewall = new Firewall();

    public static void main(String[] args) {
        Thread packetGenerator = new Thread(new PacketGenerator(firewall));
        packetGenerator.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Rule");
            System.out.println("2. Remove Rule");
            System.out.println("3. Show Rules");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addRule(scanner);
                    break;
                case 2:
                    removeRule(scanner);
                    break;
                case 3:
                    showRules();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addRule(Scanner scanner) {
        System.out.println("Enter IP address (or * for any):");
        String ip = scanner.next();
        System.out.println("Enter port number (or -1 for any):");
        int port = scanner.nextInt();
        System.out.println("Enter protocol (or * for any):");
        String protocol = scanner.next();
        System.out.println("Allow or Block? (true/false):");
        boolean allow = scanner.nextBoolean();

        FirewallRule rule = new FirewallRule(ip, port, protocol, allow);
        firewall.addRule(rule);
    }

    private static void removeRule(Scanner scanner) {
        System.out.println("Enter IP address to remove (or * for any):");
        String ip = scanner.next();
        System.out.println("Enter port number to remove (or -1 for any):");
        int port = scanner.nextInt();
        System.out.println("Enter protocol to remove (or * for any):");
        String protocol = scanner.next();
        System.out.println("Allow or Block? (true/false):");
        boolean allow = scanner.nextBoolean();

        FirewallRule rule = new FirewallRule(ip, port, protocol, allow);
        firewall.removeRule(rule);
    }

    private static void showRules() {
        System.out.println("Firewall Rules:");
        for (FirewallRule rule : firewall.getRules()) {
            System.out.println("IP: " + rule.getIpAddress() + ", Port: " + rule.getPort() +
                               ", Protocol: " + rule.getProtocol() + ", Allow: " + rule.isAllow());
        }
    }
}

class PacketGenerator implements Runnable {
    private Firewall firewall;

    public PacketGenerator(Firewall firewall) {
        this.firewall = firewall;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Simulate packet generation
                Packet packet = new Packet("192.168.1.1", "192.168.1.2", 80, 8080, "TCP");
                boolean result = firewall.filterPacket(packet);
                System.out.println("Packet from " + packet.getSourceIP() + " to " + packet.getDestinationIP() +
                                   " on port " + packet.getDestinationPort() + " is " + (result ? "allowed" : "blocked"));

                Thread.sleep(5000); // Wait 5 seconds before generating the next packet
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
