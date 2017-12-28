package my.data.exercise;

import org.apache.commons.csv.CSVRecord;

import java.util.Date;

public class Review {

    public static final String[] CSV_HEADERS = {"Id", "ProductId", "UserId", "ProfileName", "HelpfulnessNumerator", "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"};
    private long id;
    private String productId;
    private String userId;
    private String profileName;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private int score;
    private Date time;
    private String summary;
    private String text;

    public Review(CSVRecord record) {
        this(Long.parseLong(record.get(CSV_HEADERS[0])),
                record.get(CSV_HEADERS[1]),
                record.get(CSV_HEADERS[2]),
                record.get(CSV_HEADERS[3]),
                Integer.parseInt(record.get(CSV_HEADERS[4])),
                Integer.parseInt(record.get(CSV_HEADERS[5])),
                Integer.parseInt(record.get(CSV_HEADERS[6])),
                new Date(Long.parseLong(record.get(CSV_HEADERS[7]))),
                record.get(CSV_HEADERS[8]),
                record.get(CSV_HEADERS[9]));

    }

    public Review(long id, String productId, String userId, String profileName, int helpfulnessNumerator,
                  int helpfulnessDenominator, int score, Date time, String summary, String text) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.profileName = profileName;
        this.helpfulnessNumerator = helpfulnessNumerator;
        this.helpfulnessDenominator = helpfulnessDenominator;
        this.score = score;
        this.time = time;
        this.summary = summary;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public int getHelpfulnessNumerator() {
        return helpfulnessNumerator;
    }

    public int getHelpfulnessDenominator() {
        return helpfulnessDenominator;
    }

    public int getScore() {
        return score;
    }

    public Date getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getText() {
        return text;
    }
}
