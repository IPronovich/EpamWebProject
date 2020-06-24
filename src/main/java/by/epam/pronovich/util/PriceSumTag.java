package by.epam.pronovich.util;

import by.epam.pronovich.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceSumTag extends TagSupport {

    private List<Product> products;

    public int doStartTag() throws JspException {
        try {
            double sum = 0;
            for (Product product : products) {
                sum = sum + product.getPrice();
            }
            String result = String.format("%.2f", sum);
            pageContext.getOut().print("" + result+ " р.");
        } catch (Exception ex) {
            throw new JspTagException("SimpleTag: " +
                    ex.getMessage());
        }
        return SKIP_BODY;
    }

    public int doEndTag() {
        return EVAL_PAGE;
    }
}
