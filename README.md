<h1>yt24-sdk-java</h1>

<p>
Official Java SDK for the YourTransfer24 REST JSON API Platform.<br>
Provides clean access to authentication, profile data, bookings, booking confirmation, booking status, 
availability checks, quotes, vehicles, companies, coverage, and logs.<br>
Fully aligned with the official YourTransfer24 API documentation.
</p>

<hr>

<h2>Installation</h2>

<p>Using Maven:</p>

<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;com.yourtransfer24&lt;/groupId&gt;
    &lt;artifactId&gt;yt24-sdk-java&lt;/artifactId&gt;
    &lt;version&gt;1.0.0&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

<p>Using Gradle:</p>

<pre><code>implementation 'com.yourtransfer24:yt24-sdk-java:1.0.0'
</code></pre>

<hr>

<h2>Initialization</h2>

<pre><code>import com.yourtransfer24.sdk.*;

public class Example {

    public static void main(String[] args) throws Exception {

        // Initialize client: sandbox or production
        YT24Client client = new YT24Client("YOUR_API_KEY", "sandbox");

        // Instantiate endpoints
        YT24ProfileAPI profile = new YT24ProfileAPI(client);
        YT24BookingsAPI bookings = new YT24BookingsAPI(client);
        YT24AvailabilityAPI availability = new YT24AvailabilityAPI(client);
        YT24QuoteAPI quote = new YT24QuoteAPI(client);
        YT24VehiclesAPI vehicles = new YT24VehiclesAPI(client);
        YT24CompaniesAPI companies = new YT24CompaniesAPI(client);
        YT24CoverageAPI coverage = new YT24CoverageAPI(client);
        YT24LogsAPI logs = new YT24LogsAPI(client);
    }
}
</code></pre>

<hr>

<h2>API Usage</h2>

<h3>1. Profile</h3>

<pre><code>// Get profile
String data = profile.getProfile();

// Update profile
String updated = profile.updateProfile("{\"first_name\":\"John\",\"last_name\":\"Doe\"}");
</code></pre>

<h3>2. Bookings</h3>

<h4>List, Retrieve, Create, Confirm, Update Status</h4>

<pre><code>// List bookings
String list = bookings.list("limit=20&page=1");

// Retrieve booking
String booking = bookings.get(123);

// Create booking
String created = bookings.create("{
  \"pickup_location\": \"Airport\",
  \"dropoff_location\": \"Hotel\",
  \"date\": \"2025-01-20\",
  \"passengers\": 3
}");

// Confirm booking
String confirm = bookings.confirm(123);

// Update booking status
String status = bookings.updateStatus(123, "{\"status\":\"confirmed\"}");
</code></pre>

<h3>3. Availability</h3>

<pre><code>String result = availability.check("{
  \"pickup_location\": \"Airport\",
  \"dropoff_location\": \"Hotel\",
  \"date\": \"2025-01-20\"
}");
</code></pre>

<h3>4. Quote</h3>

<pre><code>String q = quote.getQuote("{
  \"pickup_location\": \"Airport\",
  \"dropoff_location\": \"Hotel\",
  \"passengers\": 2
}");
</code></pre>

<h3>5. Vehicles</h3>

<pre><code>String vehiclesList = vehicles.list();
String vehicleDetails = vehicles.get(5);
</code></pre>

<h3>6. Companies</h3>

<pre><code>String companiesList = companies.list();
String companyDetails = companies.get(12);
</code></pre>

<h3>7. Coverage</h3>

<pre><code>String zones = coverage.list();
</code></pre>

<h3>8. Logs</h3>

<pre><code>String logsData = logs.list("booking_id=123");
</code></pre>

<hr>

<h2>Error Handling</h2>

<p>YourTransfer24 API returns strict structured JSON errors:</p>

<pre><code>{
  "error": true,
  "type": "validation_error",
  "message": "Pickup location is required",
  "err_key": "YT24_400_01"
}
</code></pre>

<h3>Capturing Errors</h3>

<pre><code>
try {
    bookings.create("{}");
} catch (Exception err) {
    System.out.println(err.getMessage());
}
</code></pre>

<p>
The SDK does not modify, alter, wrap, or transform errors — they are returned exactly as provided by the YourTransfer24 API.
</p>

<hr>

<h2>Project Structure</h2>

<pre><code>
yt24-sdk-java/
│── README.md
│── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── yourtransfer24/
                    └── sdk/
                        YT24Client.java
                        YT24ProfileAPI.java
                        YT24BookingsAPI.java
                        YT24AvailabilityAPI.java
                        YT24QuoteAPI.java
                        YT24VehiclesAPI.java
                        YT24CompaniesAPI.java
                        YT24CoverageAPI.java
                        YT24LogsAPI.java
</code></pre>

<hr>

<h2>License</h2>

<p>MIT License © YourTransfer24</p>
