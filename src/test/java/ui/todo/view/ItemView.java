package ui.todo.view;

import nowipi.ui.components.Checkbox;
import nowipi.ui.components.Container;
import nowipi.ui.components.Text;

public final class ItemView extends Container {

    public ItemView(ItemViewModel viewModel) {
        super(
                new Text(viewModel.itemName()),
                new Checkbox(viewModel.itemChecked()) {
                    @Override
                    protected void check() {
                        viewModel.checkItem(checked());
                    }
                }
        );
    }
}
