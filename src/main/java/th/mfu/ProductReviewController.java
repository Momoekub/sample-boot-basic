package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productreviews")
public class ProductReviewController {

    @Autowired
    private ProductReviewRepo productReviewRepo;

    // ดึงรีวิวทั้งหมด
    @GetMapping
    public List<ProductReview> getAllReviews() {
        return (List<ProductReview>) productReviewRepo.findAll();
    }

    // ดึงรีวิวตาม id
    @GetMapping("/{id}")
    public ResponseEntity<ProductReview> getReviewById(@PathVariable Long id) {
        Optional<ProductReview> review = productReviewRepo.findById(id);
        return review.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // สร้างรีวิวใหม่
    @PostMapping
    public ResponseEntity<ProductReview> createReview(@RequestBody ProductReview review) {
        ProductReview savedReview = productReviewRepo.save(review);
        return ResponseEntity.ok(savedReview);
    }

    // ลบรีวิว (optional)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        if (productReviewRepo.existsById(id)) {
            productReviewRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
