import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    static ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int articleID = 1;

        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("시스템을 종료합니다.");
                break;
            } else if (command.equals("add")) {

                System.out.print("게시물 제목을 입력해주세요. : ");
                String title = scan.nextLine();
                System.out.print("게시물 내용을 입력해주세요. : ");
                String content = scan.nextLine();

                Article article = new Article(title, content, articleID);
                articles.add(article);

                System.out.println("게시물이 등록되었습니다.");
                articleID++;

            } else if (command.equals("list")) {
                System.out.println("===========");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.println("===========");

                }

            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                boolean is = false;

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    if (targetId == article.getId()) {
                        System.out.print("제목 : ");
                        String newTitle = scan.nextLine();
                        System.out.print("내용 : ");
                        String newContent = scan.nextLine();

                        Article newArticle = new Article(newTitle, newContent, targetId);
                        articles.set(i, newArticle);

                        System.out.printf("%d번째 수정이 완료되었습니다.\n", targetId);
                        is = true;

                    }
                }
                if (is == false) {
                    System.out.println("없는 게시물입니다.");
                }
            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                boolean is = false;

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    if (targetId == article.getId()) {
                        articles.remove(i);
                        System.out.printf("%d번째 게시물이 삭제되었습니다.\n", targetId);
                        is = true;
                    }
                }
                if (is == false) {
                    System.out.println("없는 게시물입니다.");
                }

            } else if (command.equals("detail")) {

                System.out.print("상세보기 할 게시물 번호를 입력하세요 : ");
                int tagetId = scan.nextInt();
                Article article = byId(tagetId);

                if (article == null) {
                    System.out.println("존재하지 않는 게시물입니다.");
                    scan.nextLine();
                } else {
                    System.out.println("===========");
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.println("===========");
                    scan.nextLine();
                }
            }
        }
    }

    public static Article byId(int id) {
        Article target = null;

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }
        return target;
    }

}