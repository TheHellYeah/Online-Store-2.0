package kostuchenkov.rgr.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.util.HtmlUtils;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductJsonDTO {

    private int id;
    private String name;
    private int price;
    private Set<String> images = new HashSet<>();

    public void setName(String name) {
        this.name = HtmlUtils.htmlEscape(name);
    }
}
