package pt.jorgenssen.defaultjul;

import java.util.logging.Level;

class CustomLevel extends Level {
    CustomLevel(String name, int value) {
        super(name, value);
    }
}
