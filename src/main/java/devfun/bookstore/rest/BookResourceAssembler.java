package devfun.bookstore.rest;

import devfun.bookstore.common.domain.Book;
import devfun.bookstore.rest.controller.BookController;
import devfun.bookstore.rest.domain.BookResource;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BookResourceAssembler extends ResourceAssemblerSupport<Book, BookResource> {

    public BookResourceAssembler() {
        super(BookController.class, BookResource.class);
    }

    @Override
    public BookResource toResource(Book book) {

        BookResource resource = createResourceWithId(book.getId(), book);

        // 방법 1 : 원시적으로 값 옮기기
//        resource.setBookId(book.getId());
//        resource.setTitle(book.getTitle());
//        resource.setCreator(book.getCreator());
//        resource.setDate(book.getDate());
//        resource.setType(book.getType());

        // 방법 2 : BeanUtils 클래스를 사용하여 값 옮기기
        resource.setBookId(book.getId());
        BeanUtils.copyProperties(book, resource);


        return resource;
    }

}
