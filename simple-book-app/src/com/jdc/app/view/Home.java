package com.jdc.app.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jdc.app.entity.Book;
import com.jdc.app.entity.Category;
import com.jdc.app.entity.Sale;
import com.jdc.app.entity.SaleDetail;
import com.jdc.app.service.BookService;
import com.jdc.app.service.CategoryService;
import com.jdc.app.service.SaleService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Home implements Initializable {
	@FXML
	private ComboBox<Category> category;
	@FXML
	private TextField bookName;
//	@FXML
//	private ComboBox<String> authorName;
//	@FXML
//	private TextField bookName;
//	@FXML
//	private DatePicker releasedDate;
	@FXML
	private TableView<Book> bookList;
	@FXML
	private TableView<SaleDetail> tblList;
	@FXML
	private Label headTotal;
	@FXML
	private Label subTotal;
	@FXML
	private Label tax;
	@FXML
	private Label total;
	
	private BookService bookService;
	private SaleService saleService;
	private Sale sale;
	
	public void search() {
		// clear table
		bookList.getItems().clear();
		
		// search
		List<Book> list = bookService.findByParams(category.getValue(), null, null, bookName.getText());
		
		//add results to table
		bookList.getItems().addAll(list);
	}
	
	public void clear(MouseEvent event) {
		tblList.getItems().clear();
		subTotal.setText("0");
		tax.setText("0");
		total.setText("0");
	}
	
	public void addToCart(MouseEvent event) {
		if (event.getClickCount() == 2) {
			Book book = bookList.getSelectionModel().getSelectedItem();
			System.out.println(book.getId());
			if (null != book) {
				SaleDetail sd = tblList.getItems().stream().filter(saleDetail -> saleDetail.getBookId() == book.getId())
						.findFirst().orElse(null);
				
				System.out.println(sd);
				if (null == sd) {
					sd = new SaleDetail();
					
					sd.setBookId(book.getId());
					sd.setBookName(book.getName());
					sd.setQuantity(1);
					sd.setCategory(book.getCategory());
					sd.setAuthor(book.getAuthor());
					sd.setUnitPrice(book.getPrice());
					tblList.getItems().add(sd);
				} else {
//					update 
					sd.setQuantity(sd.getQuantity() + 1);
					tblList.refresh();
					
				}	
				sd.setTax(sd.getSubTotal() * 10/100);
				calculate();
				
//				System.out.println(sd.getSubTotal());
//				System.out.println(sale.getTax());
//				System.out.println(sd.getSubTotal());
			}
		}
	}

	private void calculate() {
		subTotal.setText(String.valueOf(tblList.getItems().stream().mapToInt(saleDetail -> saleDetail.getSubTotal()).sum()));
		tax.setText(String.valueOf(tblList.getItems().stream().mapToInt(saleDetail -> saleDetail.getTax()).sum()));
		total.setText(String.valueOf(tblList.getItems().stream().mapToInt(saleDetail -> saleDetail.getTotal()).sum()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sale = new Sale();
		bookService = BookService.getInstance();
		saleService = SaleService.getInstance();
		CategoryService catService = CategoryService.getInstance();
		List<Category> catList = catService.findAll();
		category.getItems().addAll(catList);
		
		search();
	}
}
