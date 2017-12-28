package my.data.exercise;

public class Application {

    public static void main(String args[]) {
        ReviewAnalyzer analyzer = new ReviewAnalyzer(new DefaultReviewsProvider());
        System.out.println("++++++ MOST ACTIVE USERS ++++++");
        analyzer.getMostActiveUsers(1000).forEach(user -> System.out.println(user));
        System.out.println("\n++++++ MOST COMMENTED ITEMS ++++++");
        analyzer.getMostCommentedItems(1000).forEach(item -> System.out.println(item));
        System.out.println("\n++++++ MOST USED WORDS ++++++");
        analyzer.getMostUsedWords(1000).forEach(word -> System.out.println(word));
    }

}
