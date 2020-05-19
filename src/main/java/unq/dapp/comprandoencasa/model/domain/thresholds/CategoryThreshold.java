package unq.dapp.comprandoEnCasa.model.domain.thresholds;

import unq.dapp.comprandoEnCasa.model.domain.Category;

public class CategoryThreshold extends Threshold {

    private Category category;

    public CategoryThreshold() { }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
