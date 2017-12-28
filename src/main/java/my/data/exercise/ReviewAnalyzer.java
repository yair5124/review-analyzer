package my.data.exercise;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ReviewAnalyzer {

    private ReviewsProvider reviewsProvider;

    public ReviewAnalyzer(ReviewsProvider reviewsProvider) {
        this.reviewsProvider = reviewsProvider;
    }

    // Finding 1000 most active users (profile names)
    List<String> getMostActiveUsers(int count) {
        List<String> activeUsers = new ArrayList<String>();
        try {
            activeUsers = reviewsProvider.getReviewStream()
                    .collect(Collectors.collectingAndThen(groupingBy(Review::getProfileName, Collectors.counting()),
                            map -> map.entrySet().stream()
                                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                    .limit(count)
                                    .sorted(Map.Entry.<String, Long>comparingByKey())
                                    .map(entry -> entry.getKey())
                                    .collect(toList())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activeUsers;
    }

    // Finding 1000 most commented food items (item ids).
    List<String> getMostCommentedItems(int count) {
        List<String> commentedItems = new ArrayList<String>();
        try {
            commentedItems = reviewsProvider.getReviewStream()
                    .collect(Collectors.collectingAndThen(groupingBy(Review::getProductId, Collectors.counting()),
                            map -> map.entrySet().stream()
                                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                    .limit(count)
                                    .sorted(Map.Entry.<String, Long>comparingByKey())
                                    .map(entry -> entry.getKey())
                                    .collect(toList())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commentedItems;
    }

    // Finding 1000 most used words in the reviews
    List<String> getMostUsedWords(int count) {
        List<String> usedWords = new ArrayList<String>();
        try {
            usedWords = reviewsProvider.getReviewStream()
                    .flatMap(review -> Arrays.stream(review.getText().split("\\s+")))
                    .map(word -> word.toLowerCase().trim())
                    .filter(word -> word.length() > 0)
                    .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                    .collect(Collectors.collectingAndThen(groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.counting()),
                            map -> map.entrySet().stream()
                                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                    .limit(count)
                                    .sorted(Map.Entry.<String, Long>comparingByKey())
                                    .map(entry -> entry.getKey())
                                    .collect(toList())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usedWords;
    }
}
