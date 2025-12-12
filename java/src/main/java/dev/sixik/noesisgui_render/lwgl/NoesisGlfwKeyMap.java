package dev.sixik.noesisgui_render.lwgl;

import dev.sixik.noesisgui.nsgui.NSGui_Key;

import static org.lwjgl.glfw.GLFW.*;

public final class NoesisGlfwKeyMap {

    private NoesisGlfwKeyMap() {}

    public static NSGui_Key toNoesisKey(int glfwKey) {
        // A..Z
        if (glfwKey >= GLFW_KEY_A && glfwKey <= GLFW_KEY_Z) {
            return NSGui_Key.values()[NSGui_Key.A.ordinal() + (glfwKey - GLFW_KEY_A)];
        }

        // 0..9
        if (glfwKey >= GLFW_KEY_0 && glfwKey <= GLFW_KEY_9) {
            return NSGui_Key.values()[NSGui_Key.D0.ordinal() + (glfwKey - GLFW_KEY_0)];
        }

        // F1..F24
        if (glfwKey >= GLFW_KEY_F1 && glfwKey <= GLFW_KEY_F24) {
            return NSGui_Key.values()[NSGui_Key.F1.ordinal() + (glfwKey - GLFW_KEY_F1)];
        }

        // Numpad 0..9
        if (glfwKey >= GLFW_KEY_KP_0 && glfwKey <= GLFW_KEY_KP_9) {
            return NSGui_Key.values()[NSGui_Key.NUMPAD0.ordinal() + (glfwKey - GLFW_KEY_KP_0)];
        }

        return switch (glfwKey) {
            case GLFW_KEY_ESCAPE -> NSGui_Key.ESCAPE;
            case GLFW_KEY_ENTER, GLFW_KEY_KP_ENTER -> NSGui_Key.RETURN;
            case GLFW_KEY_TAB -> NSGui_Key.TAB;
            case GLFW_KEY_BACKSPACE -> NSGui_Key.BACK;
            case GLFW_KEY_SPACE -> NSGui_Key.SPACE;

            case GLFW_KEY_LEFT -> NSGui_Key.LEFT;
            case GLFW_KEY_RIGHT -> NSGui_Key.RIGHT;
            case GLFW_KEY_UP -> NSGui_Key.UP;
            case GLFW_KEY_DOWN -> NSGui_Key.DOWN;

            case GLFW_KEY_HOME -> NSGui_Key.HOME;
            case GLFW_KEY_END -> NSGui_Key.END;
            case GLFW_KEY_PAGE_UP -> NSGui_Key.PAGE_UP;
            case GLFW_KEY_PAGE_DOWN -> NSGui_Key.PAGE_DOWN;
            case GLFW_KEY_INSERT -> NSGui_Key.INSERT;
            case GLFW_KEY_DELETE -> NSGui_Key.DELETE;

            case GLFW_KEY_LEFT_SHIFT -> NSGui_Key.LEFT_SHIFT;
            case GLFW_KEY_RIGHT_SHIFT -> NSGui_Key.RIGHT_SHIFT;
            case GLFW_KEY_LEFT_CONTROL -> NSGui_Key.LEFT_CTRL;
            case GLFW_KEY_RIGHT_CONTROL -> NSGui_Key.RIGHT_CTRL;
            case GLFW_KEY_LEFT_ALT -> NSGui_Key.LEFT_ALT;
            case GLFW_KEY_RIGHT_ALT -> NSGui_Key.RIGHT_ALT;

            case GLFW_KEY_CAPS_LOCK -> NSGui_Key.CAPS_LOCK;
            case GLFW_KEY_NUM_LOCK -> NSGui_Key.NUM_LOCK;
            case GLFW_KEY_SCROLL_LOCK -> NSGui_Key.SCROLL;

            // Win / Super
            case GLFW_KEY_LEFT_SUPER -> NSGui_Key.L_WIN;
            case GLFW_KEY_RIGHT_SUPER -> NSGui_Key.R_WIN;
            case GLFW_KEY_MENU -> NSGui_Key.APPS;

            // Numpad
            case GLFW_KEY_KP_MULTIPLY -> NSGui_Key.NUMPAD_MULTIPLY;
            case GLFW_KEY_KP_ADD -> NSGui_Key.NUMPAD_ADD;
            case GLFW_KEY_KP_SUBTRACT -> NSGui_Key.NUMPAD_SUBTRACT;
            case GLFW_KEY_KP_DECIMAL -> NSGui_Key.NUMPAD_DECIMAL;
            case GLFW_KEY_KP_DIVIDE -> NSGui_Key.NUMPAD_DIVIDE;

            case GLFW_KEY_SEMICOLON -> NSGui_Key.OEM_SEMICOLON;      // ;
            case GLFW_KEY_EQUAL -> NSGui_Key.OEM_PLUS;               // = / +
            case GLFW_KEY_COMMA -> NSGui_Key.OEM_COMMA;              // ,
            case GLFW_KEY_MINUS -> NSGui_Key.OEM_MINUS;              // -
            case GLFW_KEY_PERIOD -> NSGui_Key.OEM_PERIOD;            // .
            case GLFW_KEY_SLASH -> NSGui_Key.OEM_QUESTION;           // /
            case GLFW_KEY_GRAVE_ACCENT -> NSGui_Key.OEM_TILDE;       // `
            case GLFW_KEY_LEFT_BRACKET -> NSGui_Key.OEM_OPEN_BRACKETS;   // [
            case GLFW_KEY_BACKSLASH -> NSGui_Key.OEM_BACKSLASH;      // \
            case GLFW_KEY_RIGHT_BRACKET -> NSGui_Key.OEM_CLOSE_BRACKETS; // ]
            case GLFW_KEY_APOSTROPHE -> NSGui_Key.OEM_QUOTES;        // '

            case GLFW_KEY_PRINT_SCREEN -> NSGui_Key.PRINT_SCREEN;
            case GLFW_KEY_PAUSE -> NSGui_Key.PAUSE;

            default -> NSGui_Key.NONE;
        };
    }
}

