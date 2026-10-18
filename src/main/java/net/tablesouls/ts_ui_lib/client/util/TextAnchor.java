package net.tablesouls.ts_ui_lib.client.util;

public enum TextAnchor {
    CENTER,
    OUTSIDE_LEFT,
    OUTSIDE_RIGHT,
    INSIDE_LEFT,
    INSIDE_RIGHT;

    public static TextAnchor byKey(String key) {
        for (TextAnchor anchor : values()) {
            if (anchor.name().equalsIgnoreCase(key)) return anchor;
        }
        return null;
    }
}