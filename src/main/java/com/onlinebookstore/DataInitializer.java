package com.onlinebookstore;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.User;
import com.onlinebookstore.enums.UserRole;
import com.onlinebookstore.repository.BookRepository;
import com.onlinebookstore.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public DataInitializer(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() > 0) return;

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hash = HexFormat.of().formatHex(md.digest("123456".getBytes(StandardCharsets.UTF_8)));

        // Seed users
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(hash);
        admin.setEmail("admin@bookstore.com");
        admin.setPhone("13800000001");
        admin.setAddress("Beijing Haidian");
        admin.setRole(UserRole.ADMIN);
        userRepository.save(admin);

        User reader = new User();
        reader.setUsername("reader01");
        reader.setPassword(hash);
        reader.setEmail("reader01@example.com");
        reader.setPhone("13800000002");
        reader.setAddress("Shanghai Pudong");
        reader.setRole(UserRole.CUSTOMER);
        userRepository.save(reader);

        User lover = new User();
        lover.setUsername("booklover");
        lover.setPassword(hash);
        lover.setEmail("booklover@example.com");
        lover.setPhone("13800000003");
        lover.setAddress("Guangzhou Tianhe");
        lover.setRole(UserRole.CUSTOMER);
        userRepository.save(lover);

        // Seed 12 books
        String[][] bookData = {
            {"978-7-111-11111-1", "Software Engineering Intro", "Zhang Haifan", "Tsinghua UP", "Classic SE textbook", "59.00", "100", "CS"},
            {"978-7-111-22222-2", "Thinking in Java", "Bruce Eckel", "China Machine Press", "Java classic", "89.00", "80", "CS"},
            {"978-7-111-33333-3", "Spring in Action", "Craig Walls", "Posts Press", "Spring guide", "79.00", "60", "CS"},
            {"978-7-111-44444-4", "Mythical Man-Month", "F. Brooks", "Tsinghua UP", "SE management", "49.00", "120", "SE"},
            {"978-7-111-55555-5", "Intro to Algorithms", "T. Cormen", "China Machine Press", "Algorithm bible", "128.00", "50", "CS"},
            {"978-7-111-66666-6", "Understanding JVM", "Zhou Zhiming", "China Machine Press", "JVM deep dive", "79.00", "70", "CS"},
            {"978-7-111-77777-7", "Three-Body Problem", "Liu Cixin", "Chongqing Press", "Sci-fi novel", "45.00", "200", "Sci-Fi"},
            {"978-7-111-88888-8", "100 Years of Solitude", "G. Marquez", "Nanhai Pub", "Magical realism", "39.50", "150", "Fiction"},
            {"978-7-111-99999-1", "Design Patterns", "E. Gamma", "China Machine Press", "GoF patterns", "69.00", "85", "CS"},
            {"978-7-111-99999-2", "Refactoring", "M. Fowler", "Posts Press", "Code refactoring", "75.00", "90", "SE"},
            {"978-7-111-99999-3", "To Live", "Yu Hua", "Writer Press", "Life story", "35.00", "180", "Fiction"},
            {"978-7-111-99999-4", "AI Modern Approach", "S. Russell", "Tsinghua UP", "AI textbook", "158.00", "40", "CS"},
        };

        for (String[] d : bookData) {
            Book b = new Book();
            b.setIsbn(d[0]);
            b.setTitle(d[1]);
            b.setAuthor(d[2]);
            b.setPublisher(d[3]);
            b.setDescription(d[4]);
            b.setPrice(new BigDecimal(d[5]));
            b.setStock(Integer.parseInt(d[6]));
            b.setCategory(d[7]);
            bookRepository.save(b);
        }
    }
}