package com.revature.servers.enumeration;

/***
 * Servers Status within the application are categorized within the following Status:
 *
 * <ul>
 *     <li>Server Up</li>
 *     <li>Server Down</li>
 * </ul>
 *
 */
public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
