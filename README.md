# JGUI
A single-threaded Java GUI library using Java [FFM](https://docs.oracle.com/en/java/javase/23/core/foreign-function-and-memory-api.html) as a backend to access native OS GUI libraries.
## Goals
- Cross-platform
- Lightweight components
- Immediate mode GUI
- Minimal dependencies
- No magic
## Implementations
Currently, only Windows is supported via the [Win32 library](https://nl.wikipedia.org/wiki/Windows_API).
## Example
```Java
class TestApp {

    public static void main(String[] args) {
        Window window = new Win32Window("Hello, Window!", 1080, 650);

        while (!window.shouldClose()) {
            window.pollEvents();
        }
    }

}
````
As you can see, the architecture is based on [GLFW](https://www.glfw.org/).
