# Firewall Simulation in Java

## Overview

This project is a basic firewall simulation built using Java. The application allows users to define firewall rules for allowing or blocking network traffic based on IP addresses, ports, and protocols. The simulation operates in real-time, where packets are generated and filtered based on the defined rules. This is a great project for learning about how firewalls work and for applying Java programming skills in a cybersecurity context.

## Features

- **Add Firewall Rules**: Define rules to allow or block network traffic based on IP addresses, ports, and protocols.
- **Remove Firewall Rules**: Remove existing rules from the firewall.
- **View Firewall Rules**: Display all currently defined rules.
- **Real-Time Packet Simulation**: Simulate incoming packets and filter them according to the firewall rules.
- **Default Deny Policy**: Any traffic that doesn't match a rule is blocked by default.

## Project Structure

The project consists of the following classes:

- **FirewallRule.java**: Represents a single firewall rule that contains details such as IP address, port, protocol, and whether the rule allows or blocks traffic.

- **Packet.java**: Represents a network packet with attributes such as source IP, destination IP, source port, destination port, and protocol.

- **Firewall.java**: Manages the list of rules, allowing users to add, remove, and filter packets based on the rules.

- **FirewallApp.java**: The main application class that handles user input, manages firewall rules, and runs the real-time packet simulation through a separate thread.

- **PacketGenerator.java**: A class that simulates packet generation in real-time and checks the packets against the firewall rules.

## How It Works

### Firewall Rule Management:

- Users can add or remove rules that specify which traffic is allowed or blocked based on IP addresses, ports, and protocols.
- The firewall uses a "default deny" policy, meaning any traffic that does not match an existing rule will be blocked.

### Real-Time Packet Filtering:

- The application runs a `PacketGenerator` thread that generates network packets every 5 seconds.
- Each packet is checked against the firewall rules, and the application prints whether the packet is allowed or blocked.

### User Interaction:

- The user interacts with the firewall by choosing options from a menu to add rules, remove rules, view existing rules, or exit the application.

## Getting Started

### Prerequisites

To run this project, you need the following:

- Java Development Kit (JDK) 8 or higher installed on your system.
- A Java-compatible IDE or a terminal to compile and run the code.

### Installation

1. **Clone the Repository**: Clone the project repository to your local machine or download the source code files.

2. **Compile the Code**: Navigate to the directory containing the source code and compile all the Java files using the following command:
   ```bash
   javac FirewallApp.java Firewall.java Packet.java FirewallRule.java
   ```

3. **Run the Application**: After successful compilation, run the application using:
   ```bash
   java FirewallApp
   ```

## Running the Application

Upon running the application, you will be presented with a menu with the following options:

1. **Add Rule**: 
   - Allows you to add a new firewall rule by specifying an IP address, port number, protocol, and whether the traffic should be allowed or blocked.

2. **Remove Rule**: 
   - Allows you to remove an existing firewall rule by specifying the IP address, port number, protocol, and whether the rule was set to allow or block traffic.

3. **Show Rules**: 
   - Displays all the current firewall rules.

4. **Exit**: 
   - Exits the application.

## Example Usage

Here’s an example of how you can interact with the application:

1. Start the application:
   ```bash
   java FirewallApp
   ```

2. Add a new rule to allow traffic from any IP address on port 80 using the TCP protocol:
   - Choose option 1 (Add Rule).
   - Enter `*` for the IP address.
   - Enter `80` for the port number.
   - Enter `TCP` for the protocol.
   - Enter `true` to allow the traffic.

3. Simulated packets will now be checked against the defined rules and either allowed or blocked accordingly.

4. To view the currently defined rules, choose option 3 (Show Rules).

5. To remove a rule, choose option 2 (Remove Rule) and provide the necessary details.

6. Exit the application by choosing option 4 (Exit).

## Code Explanation

### FirewallRule.java

- This class defines a firewall rule with the following attributes:
  - **ipAddress**: The IP address to match (can be specific or a wildcard `*`).
  - **port**: The port number to match (can be specific or `-1` for any port).
  - **protocol**: The protocol to match (e.g., TCP, UDP, or `*` for any protocol).
  - **allow**: A boolean value indicating whether the rule allows or blocks traffic.

### Packet.java

- This class represents a network packet with the following attributes:
  - **sourceIP**: The source IP address of the packet.
  - **destinationIP**: The destination IP address of the packet.
  - **sourcePort**: The source port number of the packet.
  - **destinationPort**: The destination port number of the packet.
  - **protocol**: The protocol used by the packet (e.g., TCP, UDP).

### Firewall.java

- This class manages a list of firewall rules and provides methods to:
  - **addRule(FirewallRule rule)**: Add a new rule to the firewall.
  - **removeRule(FirewallRule rule)**: Remove an existing rule from the firewall.
  - **filterPacket(Packet packet)**: Check whether a packet matches any rule and determine if it should be allowed or blocked.
  - **matchesRule(Packet packet, FirewallRule rule)**: Helper method to match a packet against a specific rule.

### FirewallApp.java

- The main application class that handles user input and interacts with the `Firewall` class.
- Provides a simple menu-driven interface for adding, removing, and displaying firewall rules.

### PacketGenerator.java

- This class is responsible for simulating real-time network traffic by generating packets periodically.
- The generated packets are checked against the firewall rules, and the result is printed to the console.

## Limitations

- **Simplified Simulation**: This project is a basic simulation and does not interact with real network traffic. It only simulates packet handling within the application.
- **Limited Protocol Support**: The current implementation only supports filtering based on a limited set of protocols (e.g., TCP, UDP). This can be extended as needed.
- **No Persistence**: Firewall rules are not persisted across application restarts. You would need to add file or database storage to persist the rules.

## Possible Enhancements

1. **Extend Protocols**: Add support for more network protocols.
2. **Persistent Storage**: Implement file or database storage to save and load firewall rules across sessions.
3. **Advanced Filtering**: Add more advanced filtering criteria, such as specific header fields or time-based rules.
4. **GUI**: Build a graphical user interface to make it easier to manage firewall rules.

## Conclusion

This project provides a foundation for understanding how firewalls work and allows you to explore firewall rule management and real-time packet filtering using Java. It's an excellent starting point for anyone interested in combining software engineering and cybersecurity concepts.
