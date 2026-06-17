package com.onlinebookstore.repository;

import com.onlinebookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * 图书数据访问层。
 * <p>提供图书实体的 CRUD 及按分类、作者、书名关键字搜索的分页查询。</p>
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * 根据 ISBN 查找图书。
     * @param isbn ISBN 号
     * @return Optional 包装的图书
     */
    Optional<Book> findByIsbn(String isbn);

    /**
     * 按分类分页查询图书。
     * @param category 分类名称
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<Book> findByCategory(String category, Pageable pageable);

    /**
     * 按书名模糊搜索，忽略大小写。
     * @param title 书名关键字
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    /**
     * 按作者模糊搜索。
     * @param author 作者名关键字
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<Book> findByAuthorContainingIgnoreCase(String author, Pageable pageable);
}
