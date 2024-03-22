package BoardTest.M;

import BoardTest.base.Utill;

import java.util.ArrayList;

public class ArticleRepository {
    Utill utill = new Utill();
    ArrayList<Article> articleList = new ArrayList<>();
    int articleId = 1;

    public Article saveArticle(String title, String body) {
        Article article = new Article(articleId, title, body, 0, utill.getDateTime());

        articleList.add(article);
        articleId++;
        return article;
    }

    public Article findById(int id) {
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public ArrayList<Article> findAll() {
        return articleList;
    }

    public ArrayList<Article> searchArticle(String keyword) {
        ArrayList<Article> searchList = new ArrayList<>();
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (article.getTitle().contains(keyword)) {
                searchList.add(article);
            }
        }
        return searchList;
    }

    public int getParamInt(String param, int defaultWrong) {
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return defaultWrong;
        }
    }
    public void updateArticle(Article article, String newtitle, String newBody){
        article.setTitle(newtitle);
        article.setBody(newBody);
    }
    public void deleteAritlce(Article article){
        articleList.remove(article);
    }

}
