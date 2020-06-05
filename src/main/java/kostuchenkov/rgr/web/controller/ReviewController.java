package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.data.model.user.User;
import kostuchenkov.rgr.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping("/review/create")
    public String reviewCreate(@AuthenticationPrincipal User user,
                               @RequestParam("productId") int productId,
                               @RequestParam("mark") int mark,
                               @RequestParam("description") String description,
                               HttpServletRequest request
    ){
        reviewService.addReviewToProduct(user, productId, description, mark);
        return "redirect:"+ request.getHeader("referer");
    }

}
