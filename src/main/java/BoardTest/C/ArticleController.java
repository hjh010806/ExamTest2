package BoardTest.C;

import BoardTest.M.Article;
import BoardTest.M.ArticleRepository;
import BoardTest.V.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    Scanner scan = new Scanner(System.in);
    int WRONG = -1;

    public void add(){
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        articleRepository.saveArticle(title, body);
    }
    public void list(){
        ArrayList<Article> articleList = articleRepository.findAll();
        articleView.printList(articleList);
    }
    public void update(){
        articleView.inputNumber();
        int inputId = articleRepository.getParamInt(scan.nextLine(),WRONG);
        if(inputId == WRONG){
            return;
        }
        Article article = articleRepository.findById(inputId);
        if(article == null){
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        System.out.print("수정할 제목 : ");
        String newTitle = scan.nextLine();
        System.out.print("수정할 내용 : ");
        String newBody = scan.nextLine();

        articleRepository.updateArticle(article, newTitle, newBody);
        articleView.printSave(article);
    }
    public void delete(){
        articleView.inputNumber();
        int inputId = articleRepository.getParamInt(scan.nextLine(),WRONG);
        if(inputId == WRONG){
            return;
        }
        Article article = articleRepository.findById(inputId);
        if(article == null){
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        articleRepository.deleteAritlce(article);
        articleView.printSave(article);
    }
    public void detail(){
        articleView.inputNumber();
        int inputId = articleRepository.getParamInt(scan.nextLine(),WRONG);
        if(inputId == WRONG){
            return;
        }
        Article article = articleRepository.findById(inputId);
        if(article == null){
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        article.increaseView();
        articleView.printDetail(article);
    }
    public void search(){
        System.out.print("검색할 키워드 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchList = articleRepository.searchArticle(keyword);
        articleView.printList(searchList);

    }


}
