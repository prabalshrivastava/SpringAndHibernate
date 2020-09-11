package demo01;

import java.util.List;

public class Jdbc02Main {
	public static void main(String[] args) {
//		try(BookDaoImpl dao = new BookDaoImpl()) {
//			dao.open();
//			List<Book> list = dao.findAllBooks();
//			for (Book b : list)
//				System.out.println(b);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		try(BookDaoImpl dao = new BookDaoImpl()) {
//			dao.open();
//			int cnt = dao.addBook(new Book(51, "Atlas Shrugged", "Ayn Rand", "Novell", 534.76));
//			System.out.println("Books inserted: " + cnt);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		try(BookDaoImpl dao = new BookDaoImpl()) {
//			dao.open();
//			int cnt = dao.updateBook(new Book(51, "Atlas Shrugged", "Ayn Rand", "Novell", 534.76));
//			System.out.println("Books updated: " + cnt);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try(BookDaoImpl dao = new BookDaoImpl()) {
			dao.open();
			int cnt = dao.deleteBook(51);
			System.out.println("Books Deleted: " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
