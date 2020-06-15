package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.model.service.review.ReviewService;
import kostuchenkov.rgr.model.service.principal.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review/create")
    public String reviewCreate(@AuthenticationPrincipal UserDetailsImpl session,
                               @RequestParam("productId") int productId,
                               @RequestParam("mark") int mark,
                               @RequestParam("description") String description,
                               HttpServletRequest request) {

        reviewService.addReviewToProduct(session.getUser(), productId, description, mark);
        return "redirect:"+ request.getHeader("referer");
    }

}
