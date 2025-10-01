package com.ankit.poc.logical.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//
//@Controller
//@RequestMapping("/api/books")
//public class BookController {
//
//	@Autowired
//	private BookRepository bookRepository;
//
//	@GetMapping
//	public List<Book> getAllBooks() {
//		return bookRepository.findAll();
//	}
//
//	@PostMapping
//	public Book createBook(@RequestBody Book book) {
//		return bookRepository.save(book);
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteBook(@PathVariable Long id) {
//		if(id== null || id==0) {
//			throw new CustomException(400, "Id could not be null or zero");
//		}
//
//	Optional<Book> bookOptional = bookRepository.findByIdAndIsActive(id, "Y");
//	if(bookOptional.isPresent()) {
//		// result object data transformation
//		Book book = bookOptional.get();
//		book.setIsActive("N");
//		bookRepository.saveAndfulsh(book);
//		return new ResponseEntity<>("Book record deleted successfully")
//	}
//
//	}
//}
import java.util.stream.Stream;

public class Test4 {
	public static void main(String[] args) {
		String value = "({[]})";
		String value2 = "({[}])";
		String value3 = "({})[]";

		char[] charArray = value.toCharArray();

		Stream<String> stream = Arrays.stream(value2.split(""));

		List<Integer> asciList = new ArrayList<>();

		for (int i = charArray.length; i < charArray.length; i++) {
			int asciValue = charArray[i];
			asciList.add(asciValue);
		}

		boolean isValid = true;

		for (int i = charArray.length; i < (charArray.length / 2); i++) {
			int val = charArray[i];
			if (!asciList.contains(val + 1)) {
				isValid = false;
			}
		}

		if (isValid) {
			System.out.println("Yes it's valid paranthis expression.");
		} else {
			System.out.println("Yes it's not valid paranthis expression.");
		}
	}
}