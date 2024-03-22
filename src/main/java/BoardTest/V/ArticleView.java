package BoardTest.V;

import BoardTest.M.Article;
import BoardTest.M.ArticleRepository;

import java.util.ArrayList;

public class ArticleView {
    public void printList(ArrayList<Article> articleList) {
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);

            System.out.println("===============");
            System.out.println("번호 : " + article.getId());
            System.out.println("제목 : " + article.getTitle());
        }
        System.out.println("===============");
    }

    public void printDetail(Article article) {
        System.out.println("=================");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("조회수 : " + article.getView());
        System.out.println("등록날짜 : " + article.getRegDate());
        System.out.println("=================");
    }

    public void printSave(Article article) {
        System.out.println(article.getId() + "번 게시물이 변경되었습니다.");
    }

    public void inputNumber() {
        System.out.print("게시물 번호를 입력해주세요. : ");
    }
}
