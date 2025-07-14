package nowipi.jgui.component.textinput;

import nowipi.jgui.component.interaction.TypeInteraction;

public final class DefaultTextInputInteraction implements TypeInteraction {


    private final TextInput textInput;

    public DefaultTextInputInteraction(TextInput textInput) {
        this.textInput = textInput;
    }

    @Override
    public void type(char character) {
        textInput.addChar(character);
    }

}
