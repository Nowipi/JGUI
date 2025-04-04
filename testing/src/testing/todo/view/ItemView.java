package testing.todo.view;

import nowipi.jgui.components.Checkbox;
import nowipi.jgui.components.Container;
import nowipi.jgui.components.Text;

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
