class DatabaseConnection {
    private static volatile DatabaseConnection instance;

    private DatabaseConnection() {
        // Simulate some resource-intensive initialization, e.g., establishing a database connection
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }

    public void disconnect() {
        System.out.println("Disconnected from the database.");
    }
}

class SingletonTest {
    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();

        if (connection1 == connection2) {
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }

        connection1.connect();
        connection1.disconnect();
    }
}
