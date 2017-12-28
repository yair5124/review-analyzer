package my.data.exercise;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DefaultReviewsProvider implements ReviewsProvider {

    private final static String REVIEWS_FILE = "/Reviews.csv";

    @Override
    public Stream<Review> getReviewStream() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(REVIEWS_FILE);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        CSVParser parser = CSVParser.parse(reader, CSVFormat.EXCEL.withHeader(Review.CSV_HEADERS));
        Set<Long> ids = new HashSet<Long>();
        // TODO consume parallel stream
        return StreamSupport.stream(parser.spliterator(), false)
                .skip(1)
                .map(record -> new Review(record))
                .filter(record -> ids.add(record.getId())); // avoid duplicates
    }

}
