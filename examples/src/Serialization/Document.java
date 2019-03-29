package Serialization;

import java.io.Serializable;


	public class Document implements Serializable{

		private String title;
		private String publisher;
		private String date;
		private String author;
		private int cp;
		
		public Document(String title, String publisher, String date,String author, int cp) {
			super();
			this.title = title;
			this.publisher = publisher;
			this.date = date;
			this.author = author;
			this.cp = cp;
		}

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public int getCp() {
			return cp;
		}
		public void setCp(int cp) {
			this.cp = cp;
		}
		public String display() {
			return (title + " " + publisher + " " + date+ " " + author + " " + cp);
			}
		
		
}
