package BoardTest.M;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Article {
    int id;
    String title;
    String body;
    int view;
    String regDate;

    public void increaseView(){
        this.view++;
    }
}
