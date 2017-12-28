package my.data.exercise;

import java.io.IOException;
import java.util.stream.Stream;

public interface ReviewsProvider {
    Stream<Review> getReviewStream() throws IOException;
}
