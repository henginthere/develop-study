package com.ssafy.day02.ws02.board;

import java.util.Scanner;

public class BoardController {

	private static Scanner input;

	public BoardController() {}

	public static void main(String[] args) {
		BoardController controller = new BoardController();

		input = new Scanner(System.in);

		while (true) {
			System.out.println("=== SSAFY 게시판 ===");
			System.out.println("1. 게시글 추가");
			System.out.println("2. 게시글 전체목록 출력");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴번호 입력 > ");

			int menu = -1;
			try {
				menu = Integer.parseInt(input.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요.");
				continue;	// 현재 반복문을 중단하지 않고 다시 처음으로 돌아간다.
			}

			switch (menu) {
			case 1:
				controller.menuAdd();
				break;

			case 2:
				controller.menuRead();
				break;

			case 3:
				controller.menuRemove();
				break;

			case 4:
				controller.menuModify();
				break;

			case 5:
				System.out.println("안녕히 가세요~");
				input.close();	// 표준 입출력 종료
				System.exit(0);	// 0: 정상종료
				break;

			default:
				System.out.println("메뉴번호를 다시 입력해주세요.");
			}
		}
	}

	public void menuAdd() {
		System.out.println("=== 게시글 추가 ===");

		System.out.print("글 제목: ");
		String title = input.nextLine();

		System.out.print("글 내용: ");
		String content = input.nextLine();

		System.out.print("작성자: ");
		String writer = input.nextLine();

		Board board = new Board(null, title, content, writer, null, null);

        // TODO: 1. 생성한 객체를 리스트에 저장한다.
		
		
		
		
		
		
		
		System.out.println("입력완료!");
	}

	public void menuRead() {
		System.out.println("=== 게시글 전체목록 출력 ===");

		// TODO: 2. 리스트에 저장된 글들을 출력한다.
		
		
		
		
		
		
	}

	public void menuRemove() {
		System.out.println("=== 게시글 삭제 ===");

		System.out.print("삭제할 글 번호를 입력하세요: ");

		Integer id = null;
		try {
			id = Integer.parseInt(input.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요.");
			return;
		}

		// TODO: 3. 입력받은 글 번호를 가지는 글을 리스트에서 삭제한다.
		
		
		
		
		
		
		
		System.out.println(id + "번의 게시글이 삭제되었습니다.");
	}

	public void menuModify() {
		System.out.println("=== 게시글 수정 ===");

		System.out.print("수정할 글 번호를 입력하세요: ");

		Integer id = null;
		try {
			id = Integer.parseInt(input.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요.");
			return;
		}

		System.out.print("글 제목: ");
		String title = input.nextLine();

		System.out.print("글 내용: ");
		String content = input.nextLine();

		// TODO: 4. 입력받은 글 번호를 가지는 글을 리스트에서 수정한다.

		
		
		
		

		System.out.println(id + "번 글이 수정되었습니다.");
	}
}